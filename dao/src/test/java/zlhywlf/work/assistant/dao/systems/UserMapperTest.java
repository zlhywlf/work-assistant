package zlhywlf.work.assistant.dao.systems;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import zlhywlf.work.assistant.models.systems.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author zlhywlf
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserMapperTest {

    SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    void beforeAll() {
        DataSource dataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://192.168.50.54:3306/work_assistant", "assistant", "assistant");
        Configuration configuration = new Configuration();
        configuration.getTypeAliasRegistry().registerAliases("zlhywlf.work.assistant.models");
        configuration.setEnvironment(new Environment("development", new JdbcTransactionFactory(), dataSource));
        configuration.addMappers("zlhywlf.work.assistant.dao");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Test
    void selectAllTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        Assertions.assertNotNull(users);
        Assertions.assertFalse(users.isEmpty());
        sqlSession.close();
    }

    @Test
    void selectByNameTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String name = "foo";
        User user = mapper.selectByName(name);
        Assertions.assertEquals(name, user.getName());
        sqlSession.close();
    }

}
