package com.myblog.dao.user;

import com.myblog.pojo.user.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User selectUser(int id);

    public User selectUserAll(int id);

    public int addUser(User user);

    @Select("Select email from b_user where email=#{email}")
    public String checkIsExsitEmail(@Param("email") String email);
}
