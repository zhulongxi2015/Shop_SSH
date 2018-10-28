package com.shop.dao.impl;

import com.shop.dao.AccountDao;
import com.shop.po.Account;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {
}
