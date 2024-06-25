package ryan.cloud.myaccout.dao.mapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ryan.cloud.myaccout.dao.model.Myusers;

/**
*  @author author
*/
public interface MyusersBaseMapper {

    int insertMyusers(Myusers object);

    int updateMyusers(Myusers object);

    int update(Myusers object);

    List<Myusers> queryMyusers(Myusers object);

    Myusers queryMyusersLimit1(Myusers object);

}