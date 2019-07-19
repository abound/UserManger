package come.hust.Dao;

import come.hust.pojo.User;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

/**
 * @create 2019-07-18 15:22
 */
public class daoImp implements Dao {

    @Override
    public User CheckLoginDao(String name, String pwd) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String sql;
        try {
            //注册JDbc驱动器
            Class.forName("com.mysql.jdbc.Driver");
            //建立一个连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet",
                    "root", "1234");
            sql = "select * from t_ser where name=? and pwd=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);

            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setUid(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPwd(resultSet.getString("pwd"));
                user.setAge(resultSet.getInt("age"));
                user.setSex(resultSet.getString("sex"));
                user.setBirth(resultSet.getString("birth"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return user;
    }

    @Override
    public int ChangePwdDao(String name, String NewPwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        int index = -1;
        String sql;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet",
                    "root", "1234");
            sql = "update  t_ser set pwd=? where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, NewPwd);
            ps.setString(2, name);

            index = ps.executeUpdate();
//               index=ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return index;
    }

    @Override
    public List<User> ShowUserDao() {
        List<User> lu = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        String sql;
        try {
            //注册JDbc驱动器
            Class.forName("com.mysql.jdbc.Driver");
            //建立一个连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet",
                    "root", "1234");
            sql = "select * from t_ser ";
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            lu = new ArrayList<>();
            while (resultSet.next()) {
                User u = new User();
                u.setUid(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setPwd(resultSet.getString("pwd"));
                u.setAge(resultSet.getInt("age"));
                u.setSex(resultSet.getString("sex"));
                u.setBirth(resultSet.getString("birth"));
                lu.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return lu;
    }

    @Override
    public int SubmitUserDao(User u) {

        Connection conn = null;
        PreparedStatement ps = null;

        String sql;
        int index=-1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet",
                    "root", "1234");
            sql = "insert into t_ser values (default,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getPwd());
            ps.setString(3, u.getSex());
            ps.setInt(4, u.getAge());
            ps.setString(5,u.getBirth());

            index=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }



        }
        return index;
    }
}