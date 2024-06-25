package ryan.cloud.myaccout.dao.mapper;

import org.apache.ibatis.annotations.Param;
import ryan.cloud.myaccout.dao.model.Myusers;

public interface MyusersCusMapper extends MyusersMapper {

    Myusers queryByUsername(@Param("username") String usernanme);
}
