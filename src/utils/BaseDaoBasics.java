package utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import pojo.City;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDaoBasics {

    private static DataSource dataSource;
    private static String driver;
    private static String url;
    private static String user;
    private static String password;


    //获取jdbc连接所需要的参数
    static {
        Properties property = new Properties();
        try {
            InputStream inputStream = BaseDaoBasics.class.getClassLoader().getResourceAsStream("jdbc-druid-config.properties");

            property.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(property);
            /*driver= property.getProperty("driver");
            url=property.getProperty("url");
            password=property.getProperty("password");
*/

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public City query(String sql, Object... param) {
        City city = new City();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);

        ) {
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                city.setId(rs.getInt(1));
                city.setName(rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Test
   public void a() {
        String sql = "select * FROM city where id=?";
        City city = query(sql, 1);
        System.out.println(city);
    }
}
