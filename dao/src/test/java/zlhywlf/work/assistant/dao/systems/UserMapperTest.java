package zlhywlf.work.assistant.dao.systems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zlhywlf.work.assistant.models.systems.User;

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
            String name = "foo";
            User user = mapper.selectByName(name);
            Assertions.assertEquals(name, user.getName());
        });
    }

}
