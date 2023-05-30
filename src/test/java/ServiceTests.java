import com.yadv.your_adventure.Controller;
import com.yadv.your_adventure.account.LoginForm;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ServiceTests {

    @ParameterizedTest
    @CsvSource(value = {
            "handlertester, password",
            "handle, password",
            "artisom, 228228"
    })
    void TestLoginFormGetterCorrectData(String handle, String password) {
        Assertions.assertEquals(new LoginForm(handle, password), Controller.GetLoginForm(handle));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "handle, wrong_password",
            "artisom, 229229"
    })
    void TestLoginFormGetterWrongPassword(String handle, String password) {
        Assertions.assertNotEquals(new LoginForm(handle, password), Controller.GetLoginForm(handle));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "no_such_user, password",
            ", password"
    })
    void TestLoginFormGetterNoSuchUser(String handle, String password) {
        Assertions.assertNotEquals(new LoginForm(handle, password), Controller.GetLoginForm(handle));
    }


    @ParameterizedTest
    @CsvSource(value = {
            "egor, 111",
            "handle, password"
    })
    void TestVerifyLoginFormExistingData(String handle, String password) {
        Assertions.assertTrue(Controller.VerifyLoginForm(new LoginForm(handle, password)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "egor, 123",
            "handle, wrong_password"
    })
    void TestVerifyLoginFormNotWrongPassword(String handle, String password) {
        Assertions.assertFalse(Controller.VerifyLoginForm(new LoginForm(handle, password)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "no_such_handle, 123"
    })
    void TestVerifyLoginFormNotExistingData(String handle, String password) {
        Assertions.assertFalse(Controller.VerifyLoginForm(new LoginForm(handle, password)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "egor, 8",
            "handle, 4",
            "handlertester, 0"
    })
    void TestPicturesCountGetter(String handle, int count) {
        Assertions.assertEquals(count, Controller.GetPicturesCount(handle));
    }

}
