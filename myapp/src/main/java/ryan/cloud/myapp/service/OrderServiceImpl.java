package ryan.cloud.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ryan.cloud.myapp.OrderNoUtil;
import ryan.cloud.myapp.dao.mapper.OrdersMapper;
import ryan.cloud.myapp.dao.module.Goods;
import ryan.cloud.myapp.dao.module.Orders;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper orderMapper;

    @Autowired
    private GoodsService goodsService;

    @Override
    public boolean createOrder(Orders order) {
        int c = orderMapper.insertSelective(order);
        return c == 1;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Orders handleBiz(int goodId) {
        Orders res = null;
        boolean b = goodsService.deduct(goodId, -1);

        if (b) {
            Orders order = new Orders();
            order.setCreatetime(new Date());
            order.setGoodid(goodId);
            order.setOrderno(OrderNoUtil.generateOrderNumber());
            if (!createOrder(order)) {
                throw new RuntimeException("createOrder fail");
            }
            res = order;
        } else {
            throw new RuntimeException("deductRemain fail");
        }
        if (res.getOrderno().endsWith("1") || res.getOrderno().endsWith("2")) {
            throw new RuntimeException("Simulated Exception");
        }
        return res;
    }
}
