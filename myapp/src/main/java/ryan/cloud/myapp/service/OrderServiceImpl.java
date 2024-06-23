package ryan.cloud.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ryan.cloud.myapp.OrderNoUtil;
import ryan.cloud.myapp.common.enums.OrderStatusEnum;
import ryan.cloud.myapp.dao.mapper.OrdersCusMapper;
import ryan.cloud.myapp.dao.module.Orders;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersCusMapper orderMapper;

    @Autowired
    private GoodsService goodsService;

    @Override
    public boolean createOrder(Orders order) {
        int c = orderMapper.insertSelective(order);
        return c == 1;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Orders handleBiz(Orders order) {
        Orders res = null;
        boolean b = goodsService.deduct(order.getGoodid(), -1);
        if (b) {
            order.setOrderstatus(OrderStatusEnum.SUCCESS.getStatus());
//            if (!createOrder(order)) {
//                throw new RuntimeException("createOrder fail");
//            }
            orderMapper.updateByOrderNo(order);
            res = order;
        } else {
            throw new RuntimeException("deductRemain fail");
        }
//        if (res.getOrderno().endsWith("1") || res.getOrderno().endsWith("2")) {
//            throw new RuntimeException("Simulated Exception");
//        }
        return res;
    }
}
