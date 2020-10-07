package Dao.UserDao;

import Dao.UserDao.IUserDao;
import Tools.Connectiontool;
import Vo.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaofinsh implements IUserDao {
    Connectiontool tool;

    {
        try {
            tool = new Connectiontool();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    Connection con= tool.getConnection();
    PreparedStatement ps;





    public  User findAll(String userName) throws SQLException {
        User use = new User();
        String sql = "select * from user where userName=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                use.setUserName(rs.getString("userName"));
                use.setPassword(rs.getString("password"));
                use.setRole(rs.getString("role"));
                use.setChrName(rs.getString("chrName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return use;
    }


}
