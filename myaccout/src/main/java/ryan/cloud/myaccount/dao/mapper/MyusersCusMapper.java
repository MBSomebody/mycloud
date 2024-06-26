package ryan.cloud.myaccount.dao.mapper;

import org.apache.ibatis.annotations.Param;
import ryan.cloud.myaccount.dao.model.Myusers;

public interface MyusersCusMapper extends MyusersMapper {
    Myusers queryByUsername(@Param("username") String usernanme);
}
