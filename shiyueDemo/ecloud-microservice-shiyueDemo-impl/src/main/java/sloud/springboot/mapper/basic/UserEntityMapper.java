package sloud.springboot.mapper.basic;

import sloud.springboot.entities.basic.UserEntity;

import java.util.List;

public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    List<UserEntity> selectAll();

    int updateByPrimaryKey(UserEntity record);
}
