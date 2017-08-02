package cn.kenenjoy.service;

import cn.kenenjoy.domain.User;

import java.util.List;

/**
 * Created by hefa on 2017/7/28.
 */

public interface UserService {
    User findUserById(String id);

    List<User> getUsers(String sort, String order, int page, int rows);

    Integer countUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(String id);
}
