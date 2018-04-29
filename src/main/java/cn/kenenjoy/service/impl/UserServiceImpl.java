package cn.kenenjoy.service.impl;

import cn.kenenjoy.domain.User;
import cn.kenenjoy.mapper.UserMapper;
import cn.kenenjoy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by hefa on 2017/7/28.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    @Cacheable(value = "users")
    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    @Cacheable(value = "users")
    @Override
    public List<User> getUsers(String sort, String order, int page, int rows) {
        log.debug("getUsers查询数据库");
        return userMapper.getUsers(sort, order, (page-1)*rows, rows);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    @Cacheable(value = "users")
    @Override
    public Integer countUsers() {
        return userMapper.countUsers();
    }


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @CacheEvict(value = {"users"}, allEntries = true)
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @CacheEvict(value = {"users"}, allEntries = true)
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    // @CachePut 更新缓存策略 根据实际情况清理
    // @CacheEvict 清理所有
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @CacheEvict(value = {"users"}, allEntries = true)
    @Override
    public void deleteUser(String id) {
        userMapper.deleteUser(id);
    }
}
