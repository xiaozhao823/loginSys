package com.ming.brocent.service;

import com.ming.brocent.domain.User;

import java.util.List;

public interface IGateWayService {

    public List<User> selectUserINfo(User user);
    public int insertUserInfo(User user);

    public int updateUserInfo(User user);
}
