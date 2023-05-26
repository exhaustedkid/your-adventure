package com.yadv.your_adventure.account;

public class SignUpForm {
    public SignUpForm(String handle,
                      String name,
                      String surname,
                      String email,
                      String password,
                      String confirmed_password) {
        this.handle = handle;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.confirmed_password = confirmed_password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getConfirmedPassword() {
        return confirmed_password;
    }

    public String getHandle() {
        return handle;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    private final String handle;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final String confirmed_password;
}
