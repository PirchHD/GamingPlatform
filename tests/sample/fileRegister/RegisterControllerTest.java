package sample.fileRegister;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterControllerTest {

    RegisterController registerController;

    @BeforeEach
    void beforeEach(){
        registerController = new RegisterController();
    }

    @Test
    void checkPasswordTheSame() {
    }

    @Test
    void usernameTextFieldShouldNotBeEmpty() {
    }
}