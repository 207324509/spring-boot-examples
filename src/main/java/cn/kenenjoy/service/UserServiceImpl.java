package cn.kenenjoy.service;

import cn.kenenjoy.controller.UserController;
import cn.kenenjoy.domain.User;
import cn.kenenjoy.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by hefa on 2017/7/28.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "users")
    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Cacheable(value = "users")
    @Override
    public List<User> getUsers() {
        log.debug("getUsers查询数据库");
        return userMapper.getUsers();
    }


    @CacheEvict(value = {"users"},allEntries = true)
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @CacheEvict(value = {"users"},allEntries = true)
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    // @CachePut 更新缓存策略 根据实际情况清理
    // @CacheEvict 清理所有
    @CacheEvict(value = {"users"},allEntries = true)
    @Override
    public void deleteUser(String id) {
        userMapper.deleteUser(id);
    }
}
