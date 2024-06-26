package ryan.cloud.myaccount.dao.mapper.base;

import java.util.List;

import ryan.cloud.myaccount.dao.model.Myusers;

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