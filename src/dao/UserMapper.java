package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserMapper {
    //获取所有的user
   List<User> getUser();
   //添加一个user
    int addUser( User user);
    //删除一个user
    int deleteUser(User user);
    //修改user
    int updateUser(User user);
    //根据手机号查找user
    User findBy (String number);
}