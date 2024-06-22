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
import ryan.cloud.myapp.dao.module.Goods;
import ryan.cloud.myapp.dao.module.Orders;
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
                    System.out.println(increment + " redis 库存");
                    Orders order = orderService.handleBiz(goodsId);
                    resp.setOrder(order);
                    System.out.println("handleBiz end");
                }
            } else {
                resp.setMessage("sell out.");
            }
        } catch (Exception e) {
            resp.setSuccess(false);
            redisTemplate.opsForValue().increment(GOODS_KEY, 1);
            System.out.println(e);
        } finally {
            System.out.println("createOrder end");
        }

        return resp;
    }


    @Override
    public void afterPropertiesSet() {
        Goods goods = goodsService.queryGoodsById(1);
        redisTemplate.opsForValue().set(GOODS_KEY, "" + goods.getRemain());
    }
}
