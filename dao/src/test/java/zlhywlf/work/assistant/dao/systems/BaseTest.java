package zlhywlf.work.assistant.dao.systems;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import javax.sql.DataSource;
import java.util.function.Consumer;

/**
 * @author zlhywlf
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    void beforeAll() {
        DataSource dataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://192.168.50.54:3306/work_assistant", "assistant", "assistant");
        Configuration configuration = new Configuration();
        configuration.getTypeAliasRegistry().registerAliases("zlhywlf.work.assistant.models");
        configuration.setEnvironment(new Environment("development", new JdbcTransactionFactory(), dataSource));
        configuration.addMappers("zlhywlf.work.assistant.dao");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    protected void run(Consumer<SqlSession> consumer) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        consumer.accept(sqlSession);
        sqlSession.close();
    }

}
