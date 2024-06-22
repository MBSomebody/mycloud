package ryan.cloud.myapp.dao.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsCusMapper extends GoodsMapper {

    int updateGoodsRemain(@Param("id") int id, @Param("delta") int delta);
}
