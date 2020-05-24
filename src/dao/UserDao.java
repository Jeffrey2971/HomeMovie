package dao;

/*
    用于操作数据库中User表的类
 */


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import domain.User;
import util.JDBCUtils;

public class UserDao {
    /*
        登录方法
     */

    /*
        声明JDBCTemplate对象公用
     */
    public JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public User login(User loginUser) {
        try {
            // 编写SQL
            String sql = "select * from user where username = ? and password = ?";
            // 调用query方法
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}




