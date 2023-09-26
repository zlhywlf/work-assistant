package zlhywlf.work.assistant.mappers.systems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zlhywlf.work.assistant.domains.systems.User;
import zlhywlf.work.assistant.test.Constant;

import java.util.List;

/**
 * @author zlhywlf
 */
public class UserMapperTest extends BaseTest {

    @Test
    void selectAllTest() {
        run(sqlSession -> {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectAll();
            Assertions.assertNotNull(users);
            Assertions.assertFalse(users.isEmpty());
        });
    }

    @Test
    void selectByNameTest() {
        run(sqlSession -> {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectByName(Constant.T_USER_NAME);
            Assertions.assertEquals(Constant.T_USER_NAME, user.getName());
        });
    }

}
