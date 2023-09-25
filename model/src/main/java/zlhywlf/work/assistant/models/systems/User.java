package zlhywlf.work.assistant.models.systems;

import lombok.Data;

import java.util.List;

/**
 * @author zlhywlf
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String password;
    private List<Role> roles;

}
