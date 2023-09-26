package zlhywlf.work.assistant.mappers.systems;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import zlhywlf.work.assistant.test.Constant;

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
        DataSource dataSource = new PooledDataSource(
                Constant.DB_DRIVER,
                Constant.DB_URL,
                Constant.DB_USERNAME,
                Constant.DB_PASSWORD
        );
        Configuration configuration = new Configuration();
        configuration.getTypeAliasRegistry().registerAliases(Constant.P_DOMAIN);
        configuration.setEnvironment(new Environment("development", new JdbcTransactionFactory(), dataSource));
        configuration.addMappers(Constant.P_MAPPER);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    protected void run(Consumer<SqlSession> consumer) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        consumer.accept(sqlSession);
        sqlSession.close();
    }

}
