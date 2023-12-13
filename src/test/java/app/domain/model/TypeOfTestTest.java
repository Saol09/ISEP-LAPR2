package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeOfTestTest {

    TypeOfTest typeOfTest = new TypeOfTest("1111", "sangue", "tubo");
    ParameterCategory parameterCategory = new ParameterCategory("abcde", "a");

    @Test
    public void getCode() {
        assertEquals(typeOfTest.getCode(),"1111");
    }

    @Test
    public void getDescription() {
        assertEquals(typeOfTest.getDescription(),"sangue");
    }

    @Test
    public void getCollectingMethods() {
        assertEquals(typeOfTest.getCollectingMethods(),"tubo");
    }

    @Test
    public void getParameterCategory() {
        typeOfTest.setParameterCategory(parameterCategory);
        assertEquals(typeOfTest.getParameterCategory(), parameterCategory);
    }

    @Test
    public void setCode() {
        typeOfTest.setCode("1111");
        assertEquals(typeOfTest.getCode(), "1111");
    }

    @Test
    public void setDescription() {
        typeOfTest.setDescription("sangue");
        assertEquals(typeOfTest.getDescription(), "sangue");
    }

    @Test
    public void setCollectingMethods() {
        typeOfTest.setCollectingMethods("tubo");
        assertEquals(typeOfTest.getCollectingMethods(), "tubo");
    }

    @Test
    public void setParameterCategory() {
        typeOfTest.setParameterCategory(parameterCategory);
        assertEquals(typeOfTest.getParameterCategory(), parameterCategory);
    }

}