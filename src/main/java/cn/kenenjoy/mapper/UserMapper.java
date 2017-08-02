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

    // #代表传值，$代表列
    @Select("select * from users order by ${sort} ${order} limit #{page}, #{rows}")
    List<User> getUsers(@Param("sort") String sort, @Param("order") String order, @Param("page") int page, @Param("rows") int rows);

    @Select("select count(id) from users ")
    @ResultType(value = Integer.class)
    Integer countUsers();

    @Insert({"insert into users (id,firstname,lastname,phone,email) values (#{id}, #{firstname}, #{lastname}, #{phone}, #{email})"})
    void saveUser(User user);

    @Update("update users set firstname = #{firstnme} ,lastname = #{lastname} ,phone = #{phone} ,email = #{email} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from users where id = #{id}")
    void deleteUser(@Param("id") String id);
}
