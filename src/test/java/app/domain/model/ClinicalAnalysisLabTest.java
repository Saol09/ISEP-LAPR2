package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClinicalAnalysisLabTest {
    TypeOfTest tp1 = new TypeOfTest("1","teste1","teste2");
    List<TypeOfTest> tp = new ArrayList<>();
    ClinicalAnalysisLab cal = new ClinicalAnalysisLab("12345","testename","testeaddress","12345678901","12345",tp);

    @Test
    public void setIdLaboratory() {
        assertTrue(cal.setIdLaboratory("12345"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIdLaboratoryBiggerCAL(){
        cal.setName("111111111111111111111111111111111111");
    }

    /*@Test(expected = IllegalArgumentException.class)
    public void setIdLaboratorySmallerCAL(){
        cal.setName("1");
    }*/

    @Test(expected = IllegalArgumentException.class)
    public void setIdLaboratoryBlankCAL(){
        cal.setName("");
    }

    @Test
    public void getIdLaboratory() {
        assertEquals(cal.getIdLaboratory(),"12345");
    }

    @Test
    public void setName() {
        assertTrue(cal.setName("testename"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameBiggerCAL(){
        cal.setName("111111111111111111111111111111111111");
    }

    /*@Test(expected = IllegalArgumentException.class)
    public void setNameSmallerCAL(){
        cal.setName("1");
    }*/

    @Test(expected = IllegalArgumentException.class)
    public void setNameBlankCAL(){
        cal.setName("");
    }

    @Test
    public void getName() {
        assertEquals(cal.getName(),"testename");
    }

    @Test
    public void setAddress() {
        assertTrue(cal.setAddress("testeaddress"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setAddressBiggerCAL(){
        cal.setName("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setAddressBlankCAL(){
        cal.setName("");
    }

    @Test
    public void getAddress() {
        assertEquals(cal.getAddress(),"testeaddress");
    }

    @Test
    public void setPhoneNumber() {
        assertTrue(cal.setPhoneNumber("12345678901"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPhoneNumberBiggerCAL(){
        cal.setName("111111111111111111111111111111111111");
    }

    //@Test(expected = IllegalArgumentException.class)
    //public void setPhoneNumberSmallerCAL(){
    //    cal.setName("1");
    //}

    @Test(expected = IllegalArgumentException.class)
    public void setPhoneNumberBlankCAL(){
        cal.setName("");
    }

    @Test
    public void getPhoneNumber() {
        assertEquals(cal.getPhoneNumber(),"12345678901");
    }

    @Test
    public void setTin() {
        assertTrue(cal.setTin("12345"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTinBiggerCAL(){
        cal.setName("111111111111111111111111111111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTinBlankCAL(){
        cal.setName("");
    }

    @Test
    public void getTin() {
        assertEquals(cal.getTin(),"12345");
    }

}