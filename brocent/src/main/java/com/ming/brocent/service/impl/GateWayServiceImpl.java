package com.ming.brocent.service.impl;

import com.ming.brocent.domain.User;
import com.ming.brocent.mapper.GateWayMapper;
import com.ming.brocent.service.IGateWayService;
import com.ming.brocent.utils.IdUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GateWayServiceImpl implements IGateWayService {

    @Resource
    GateWayMapper gateWayMapper;


    @Override
    public List<User> selectUserINfo(User user) {
        return gateWayMapper.selectUserInfo(user);
    }

    @Override
    public int insertUserInfo(User user) {
        user.setUserId(IdUtils.simpleUUID());
        return gateWayMapper.insertUserInfo(user);
    }

    @Override
    public int updateUserInfo(User user) {
        return gateWayMapper.updateUserInfo(user);
    }
}
