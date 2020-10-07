package TEXT;

import Tools.Connectiontool;
import Vo.download;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class text {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connectiontool tool=new Connectiontool();
        Connection con=tool.getConnection();
        PreparedStatement pst;

        download dwd=new download();
        List<download> list=new ArrayList<download>();
        String sql="select * from download ";
        try {
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                dwd.setId(rs.getString("id"));
                dwd.setName(rs.getString("name"));
                dwd.setPath(rs.getString("path"));
                dwd.setDescription(rs.getString("description"));
                dwd.setSize(rs.getInt("size"));
                dwd.setStar(rs.getInt("star"));
                dwd.setImag(rs.getString("img"));
                System.out.println(list.toString());
                list.add(dwd);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }

}
