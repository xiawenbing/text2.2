package Dao.UserDao;

import Vo.User;

import java.sql.SQLException;

//T:数据对象  K：数据对象的组件类型
public interface UserDao<T,K> {
   public User findAll(String userName ) throws SQLException;//查找
}
