package com.xrk.service.user;

import com.xrk.dao.UserMapper;
import com.xrk.entity.Role;
import com.xrk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<Map<String, Object>> findAllByPage(Map<String, Object> params) {
        List<Map<String, Object>> list = null;
        try {
            list = userMapper.findAllByPage(params);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public int add(User user) {
        int result = userMapper.add(user);
        return result;
    }

    public int deleteById(String id) {
        int result = userMapper.deleteById(id);
        return result;
    }

    public User getById(String id) {
        return userMapper.getById(id);
    }

    public int update(User user) {
        int result = userMapper.update(user);
        return result;
    }

    public int countUser(String userName, String userPassword) {
        return userMapper.countUser(userName, userPassword);
    }

    public User queryUserName(String userName) {
        return userMapper.queryUserName(userName);
    }

    public Role findbyUserRole(String userId) {
        return userMapper.findbyUserRole(userId);
    }
}
