package ryan.cloud.myapp.service;

import ryan.cloud.myapp.dao.module.Orders;

public interface OrderService {

    boolean createOrder(Orders order);

    Orders handleBiz(Orders order);

}
