package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
}
