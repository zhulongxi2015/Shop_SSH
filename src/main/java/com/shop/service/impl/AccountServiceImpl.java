package com.shop.service.impl;

import com.shop.dao.AccountDao;
import com.shop.po.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements com.shop.service.AccountService {
    @Resource
    private AccountDao accountDao;

    public List<Account> query() {
        return accountDao.query();
    }
}
