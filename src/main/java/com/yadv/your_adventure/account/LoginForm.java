package com.yadv.your_adventure.account;

public class LoginForm {
    public LoginForm(String handle,
                     String password) {
        this.handle = handle;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getHandle() {
        return handle;
    }

    private final String handle;
    private final String password;
}
