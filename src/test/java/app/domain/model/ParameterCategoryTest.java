package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterCategoryTest {
    private final ParameterCategory parameterCategory = new ParameterCategory("12345","abcd");

    @Test
    public void getCode() {
        assertEquals(parameterCategory.getCode(),"12345");
    }

    @Test
    public void setCode() {
        assertEquals(parameterCategory.getName(),"abcd");
    }

    @Test
    public void setName() {
        parameterCategory.setCode("12346");
        assertEquals(parameterCategory.getCode(),"12346");
    }

    @Test
    public void getName() {
        parameterCategory.setName("TESTE");
        assertEquals(parameterCategory.getName(),"TESTE");
    }

    @Test
    public void toStringTest(){
        try {
            assertEquals(parameterCategory.toString(), "ParameterCategory{code='12345', name='abcd'}");
        }catch (Exception e) {
            assertFalse(true);
        }
    }

}