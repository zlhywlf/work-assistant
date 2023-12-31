package zlhywlf.work.assistant.mappers;

import java.util.List;

/**
 * @author zlhywlf
 */
public interface BaseMapper<T> {

    T selectByName(String name);

    List<T> selectAll();

}
