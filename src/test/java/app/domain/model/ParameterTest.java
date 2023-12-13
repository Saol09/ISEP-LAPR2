package app.domain.model;


import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterTest {
    ParameterCategory parameterCategory = new ParameterCategory("11112","abd");
    Parameter parameter = new Parameter("12345","test","test",parameterCategory);
    @Test
    public void getParameterCategory() {
        assertTrue(parameter.getParameterCategory().equals(parameterCategory));
    }

    @Test
    public void setParameterCategory() {
        assertTrue(parameter.getParameterCategory().equals(parameterCategory));
    }

    @Test
    public void getCode() {

        assertEquals(parameter.getCode(),"12345");
    }

    @Test
    public void getDesc() {
        assertEquals(parameter.getDesc(),"test");
    }

    @Test
    public void getName() {
        assertEquals(parameter.getName(),"test");
    }

    @Test
    public void setCode() {
        parameter.setCode("11111");
        assertEquals(parameter.getCode(),"11111");
    }
    @Test(expected = IllegalArgumentException.class)
    public void setCodeParameterbiggerthen(){
        parameter.setCode("1111111");
    }
    @Test(expected = IllegalArgumentException.class)
    public void setCodeParameterBlank(){
        parameter.setCode("");
    }
    @Test
    public void setDesc() {
        parameter.setDesc("testdesc");
        assertEquals(parameter.getDesc(),"testdesc");
    }
    @Test(expected = IllegalArgumentException.class)
    public void setDescParameterBlank(){
        parameter.setDesc("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void setDescParameterBiggerthen(){
        parameter.setDesc("Teste12345678912345678912345678");
    }
    @Test
    public void setName() {
        parameter.setName("TESTE");
        assertEquals(parameter.getName(),"TESTE");
    }
    @Test(expected = IllegalArgumentException.class)
    public void setNameParameterBiggerthen(){
        parameter.setName("Teste12345678912345678912345678");
    }
    @Test(expected = IllegalArgumentException.class)
    public void setNameParameterBlank(){
        parameter.setName("");
    }
}