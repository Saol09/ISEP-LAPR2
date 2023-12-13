package app.controller;

import app.domain.model.Company;
import app.domain.model.TypeOfTest;
import app.domain.model.TypeOfTestTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterTypeOfTestControllerTest {

    Company company ;
    RegisterTypeOfTestController registerTypeOfTestController = new RegisterTypeOfTestController();
    TypeOfTest typeOfTest = new TypeOfTest("1111", "sangue", "tubo");

    @Test
    public void registerTypeOfTest() {
        assertTrue(registerTypeOfTestController.registerTypeOfTest("1111", "sangue", "tubo"));
    }

    @Test
    public void saveTypeOfTest() {
        registerTypeOfTestController.registerTypeOfTest("1111", "sangue", "tubo");
        assertTrue(registerTypeOfTestController.saveTypeOfTest(new TypeOfTest("1111", "sangue", "tubo"), "1234"));
    }
    
}