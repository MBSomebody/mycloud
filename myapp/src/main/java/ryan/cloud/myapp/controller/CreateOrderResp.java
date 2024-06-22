package ryan.cloud.myapp.controller;

import lombok.Data;
import ryan.cloud.myapp.dao.module.Orders;

import java.io.Serializable;

@Data
public class CreateOrderResp extends CommonResp implements Serializable {

    private Orders order;

}
