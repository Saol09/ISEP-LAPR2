package app.controller;

import app.domain.model.Parameter;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateParameterControllerTest {
    CreateParameterController createParameterController = new CreateParameterController();
    Parameter parameter= new Parameter("12345","test","teste desc",null);
    @Test
    public void createParameter() {
        assertTrue(createParameterController.createParameter("12345","test","teste desc",""));
    }

    @Test
    public void saveParameter() {
        createParameterController.createParameter("12345","test","teste desc","");
        assertTrue(createParameterController.saveParameter());
    }

    @Test
    public void testSaveParameter() {
        assertTrue(createParameterController.saveParameter(parameter));
    }
}