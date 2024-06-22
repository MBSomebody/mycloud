package ryan.cloud.myapp.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ryan.cloud.myapp.dao.module.Goods;

public interface GoodsService {

    Goods queryGoodsById(int id);

    boolean deductRemain(int id, int remain);

    boolean deduct(int id, int delta);
}
