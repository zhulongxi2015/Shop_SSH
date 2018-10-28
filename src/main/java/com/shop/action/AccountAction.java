package com.shop.action;

import com.shop.po.Account;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("accountAction")
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
    public String query(){
        jsonList=accountService.query();
        return "jsonList";
    }
}
