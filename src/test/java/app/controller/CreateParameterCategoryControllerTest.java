package app.controller;

import app.domain.model.ParameterCategory;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateParameterCategoryControllerTest {
    CreateParameterCategoryController createParameterCategoryController = new CreateParameterCategoryController();
    ParameterCategory parameterCategory = new ParameterCategory("12345","test");
    @Test
    public void createParameterCategory() {
        assertTrue(createParameterCategoryController.createParameterCategory("12945","abc"));
    }
    /*


    @Test
    public void saveParameterCategory() {
        assertTrue(createParameterCategoryController.saveParameterCategory(parameterCategory));
    }
    */


    @Test
    public void testSaveParameterCategory() {
        createParameterCategoryController.createParameterCategory("12345","abc");
        assertTrue(createParameterCategoryController.saveParameterCategory());
    }
}