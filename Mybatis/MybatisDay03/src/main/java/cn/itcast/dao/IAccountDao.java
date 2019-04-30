package cn.itcast.dao;

import cn.itcast.domain.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();
}
