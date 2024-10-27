package com.ming.brocent.mapper;

import com.ming.brocent.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GateWayMapper {

    public List<User> selectUserInfo(User user);

    public int insertUserInfo(User user);

    public int updateUserInfo(User user);
}
