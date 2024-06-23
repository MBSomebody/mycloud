package ryan.cloud.myapp.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ryan.cloud.myapp.OrderNoUtil;
import ryan.cloud.myapp.common.enums.OrderStatusEnum;
import ryan.cloud.myapp.dao.module.Goods;
import ryan.cloud.myapp.dao.module.Orders;
import ryan.cloud.myapp.integretion.msg.KafkaProducerService;
import ryan.cloud.myapp.service.GoodsService;
import ryan.cloud.myapp.service.OrderService;

import java.util.Date;
import java.util.Objects;

@RestController
public class OrderController implements InitializingBean {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    KafkaProducerService producerService;


    private static final String GOODS_KEY = "goodsRemain";

    @GetMapping("/order")
    public CreateOrderResp createOrder(@RequestParam(value = "goodsId", defaultValue = "1")
                                               int goodsId) {

        System.out.println(goodsId + " begin");
        CreateOrderResp resp = new CreateOrderResp();
        resp.setSuccess(true);

        try {
            int remainCount = Integer.parseInt((String) Objects.requireNonNull(redisTemplate.opsForValue().get(GOODS_KEY)));

            if (remainCount > 0) {
                Long increment = redisTemplate.opsForValue().increment(GOODS_KEY, -1);

                if (increment != null && increment >= 0) {
                    Orders order = new Orders();
                    order.setCreatetime(new Date());
                    order.setGoodid(goodsId);
                    order.setOrderno(OrderNoUtil.generateOrderNumber());
                    order.setOrderstatus(OrderStatusEnum.SENT.getStatus());
                    producerService.sendOrder(order);
                    orderService.createOrder(order);
                    resp.setOrder(order);
                    System.out.println("createOrder end" + resp.getOrder().toString());
                }
            } else {
                resp.setMessage("sell out.");
            }

        } catch (Exception e) {
            resp.setSuccess(false);
            redisTemplate.opsForValue().increment(GOODS_KEY, 1);
            System.out.println(e);
        }

        return resp;
    }


    @Override
    public void afterPropertiesSet() {
        Goods goods = goodsService.queryGoodsById(1);
        redisTemplate.opsForValue().set(GOODS_KEY, "" + goods.getRemain());
    }
}
