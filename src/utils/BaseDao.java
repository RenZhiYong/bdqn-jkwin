package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import pojo.User;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class BaseDao {
    private static DataSource dataSource;
    private static QueryRunner queryRunner;
    static {
        Properties property=new Properties();
        try{
            InputStream inputStream= BaseDao.class.getClassLoader().getResourceAsStream("jdbc-druid-config.properties");
            property.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(property);
            /*queryRunner=new QueryRunner(dataSource);*/

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static QueryRunner getQueryRunner() {
        return new QueryRunner(dataSource);
    }

   /* public static void setQueryRunner(QueryRunner queryRunner) {
        baseDao.queryRunner = queryRunner;
    }*/
    @Test
    public void queryTest() throws SQLException {
        String sql="select * from user";
        List<User> users=getQueryRunner().query(sql, new BeanListHandler<>(User.class));
        System.out.println(users);

        List<User> users1=getQueryRunner().query(sql, new BeanListHandler<>(User.class));
        System.out.println(users1);

    }


}
