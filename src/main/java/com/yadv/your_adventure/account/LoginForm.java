package com.yadv.your_adventure.account;

import java.util.Objects;

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

    public boolean equals(Object other) {
        return Objects.equals(this.handle, ((LoginForm)other).getHandle()) &&
                Objects.equals(this.password, ((LoginForm)other).getPassword());
    }

    private final String handle;
    private final String password;
}
