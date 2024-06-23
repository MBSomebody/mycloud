package ryan.cloud.myapp.dao.mapper;


import ryan.cloud.myapp.dao.module.Orders;

public interface OrdersCusMapper extends OrdersMapper {

    int updateByOrderNo(Orders orders);
}
