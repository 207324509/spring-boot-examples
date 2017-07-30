package cn.kenenjoy.mapper;

import cn.kenenjoy.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hefa on 2017/7/28.
 */
@Repository
@Mapper
public interface UserMapper {
    @Select("select * from users where id = #{id}")
    User findUserById(@Param("id") String id);

    @Select("select * from users")
    List<User> getUsers();

    @Insert({"insert into users (id,firstname,lastname,phone,email) values (#{id}, #{firstname}, #{lastname}, #{phone}, #{email})"})
    void saveUser(User user);

    @Update("update users set firstname = #{firstname} ,lastname = #{lastname} ,phone = #{phone} ,email = #{email} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from users where id = #{id}")
    void deleteUser(@Param("id") String id);
}
