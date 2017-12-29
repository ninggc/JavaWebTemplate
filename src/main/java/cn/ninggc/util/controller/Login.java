package cn.ninggc.util.controller;

import java.io.IOException;

/**
 * Created by ning on 2017/7/4.
 */
public class Login extends BaseController {

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        return "Hello world";
    }

    public String login() throws IOException {
        ready();

        return ERROR;
    }

    public String exit() throws IOException {
        ready();

        System.out.println("exit:name" + session.getAttribute("name"));
        System.out.println("exit:teacher_id" + session.getAttribute("teacher_id"));

        session.removeAttribute("name");
        session.removeAttribute("teacher_id");

        return SUCCESS;
    }
}
