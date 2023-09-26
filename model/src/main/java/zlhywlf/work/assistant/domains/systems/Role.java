package zlhywlf.work.assistant.domains.systems;

import lombok.Data;

import java.util.List;

/**
 * @author zlhywlf
 */
@Data
public class Role {

    private Integer id;
    private String name;
    private List<Privilege> privileges;

}
