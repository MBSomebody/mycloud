package ryan.cloud.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ryan.cloud.myapp.dao.mapper.GoodsCusMapper;
import ryan.cloud.myapp.dao.mapper.GoodsMapper;
import ryan.cloud.myapp.dao.module.Goods;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsCusMapper goodsCusMapper;

    @Override
    public Goods queryGoodsById(int id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return goods;
    }

    @Override
    public boolean deductRemain(int id, int remain) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setRemain(remain);
        int i = goodsMapper.updateByPrimaryKeySelective(goods);
        return i == 1;
    }

    @Override
    public boolean deduct(int id, int delta) {
        return goodsCusMapper.updateGoodsRemain(id, delta) == 1;
    }


}
