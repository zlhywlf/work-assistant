package zlhywlf.work.assistant.models.systems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author zlhywlf
 */
public class UserTest {

    @Test
    void userTest() {
        User user = new User();
        String name = UUID.randomUUID().toString();
        String password = UUID.randomUUID().toString();
        user.setName(name);
        user.setPassword(password);
        Assertions.assertNull(user.getId());
        Assertions.assertEquals(name, user.getName());
        Assertions.assertEquals(password, user.getPassword());
    }

}
