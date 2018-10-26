package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

@Action("linkgo")
public class LinkGoAction extends ActionSupport {
    public String execute(){
        return "linkgo";
    }
}
