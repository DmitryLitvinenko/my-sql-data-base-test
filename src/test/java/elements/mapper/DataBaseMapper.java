package elements.mapper;

import org.apache.ibatis.annotations.Select;

public interface DataBaseMapper {

    @Select("CREATE DATABASE #{name}")
    void createDataBase(String name);
}
