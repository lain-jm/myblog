package com.myblog.service.user;

import com.myblog.pojo.user.User;

public interface UserService {

    public User selectUser(int userId);

    public User addUser(User user) throws Exception;

}
