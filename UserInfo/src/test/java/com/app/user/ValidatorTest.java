package com.app.user;

import com.app.user.model.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    Validator validator;
    @BeforeEach
    void initiate(){
         validator = new Validator();
    }

    @Test
    void isValidEmail() {
        assertEquals(validator.isValidEmail("wicked.avinash@gmail.com"),true);
    }

    @Test
    void isValidPassword() {
        assertEquals(validator.isValidPassword("Avinash#1$"),true);
    }
}