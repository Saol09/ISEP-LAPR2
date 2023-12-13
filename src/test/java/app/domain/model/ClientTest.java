/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;


import java.text.ParseException;

import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre
 */
public class ClientTest {
    
    final Client client1 = new Client("Sérgio", "123456", "987654", "123456",
            "30/10/2000", "Male", "12345678912", "email@email.com");

    
   @Test(expected = IllegalArgumentException.class)
    public void garanteeNullClientIsntCreated() {
        Client client = new Client(null, null, null, null, null, null, null, null);
    }

    @Test
    public void getCitizensCardNumberTest() throws ParseException {
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "1234567890", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
        String expected = "1234567890123456";
        assertEquals(expected, client.getCitizenCardNumber());
    }

    @Test
    public void setNameTest(){
       client1.setName("Tomás");
       assertEquals(client1.getName(),"Tomás");
    }

    @Test
    public void setCitizenCardNumberTest(){
       client1.setCitizenCardNumber("456789");
       assertEquals(client1.getCitizenCardNumber(), "456789");
    }

    @Test
    public void getNhsNumberTest(){
       assertEquals("987654",client1.getNhsNumber());
    }

    @Test
    public void setNhsNumberTest(){
       client1.setNhsNumber("123456");
       assertEquals(client1.getNhsNumber(),"123456");
    }

    @Test
    public void setTinNumberTest(){
       client1.setTinNumber("546123");
       assertEquals(client1.getTinNumber(),"546123");
    }

    @Test
    public void setBirthdayDateTest(){
       client1.setBirthDate("20/05/2001");
       assertEquals(client1.getBirthDate(), "20/05/2001");
    }

    @Test
    public void getSexTest(){
       assertEquals("Male",client1.getSex());
    }

    @Test
    public void setSexTest(){
       client1.setSex("Female");
       assertEquals(client1.getSex(),"Female");
    }

    @Test
    public void setPhoneNumberTest(){
       client1.setPhoneNumber("98745632112");
       assertEquals(client1.getPhoneNumber(),"98745632112");
    }

    @Test
    public void setEmailTest(){
       client1.setEmail("meo@meo.pt");
       assertEquals(client1.getEmail(),"meo@meo.pt");
    }

    @Test
    public void getUserTest(){
       assertEquals("email@email.com - Sérgio", client1.getUser().toString());
    }

    @Test
    public void setUserTest(){
       client1.setUser(new User(new Email("meo@meo.pt"),new Password("123"),"Meo"));
       assertEquals(client1.getUser().toString(),"meo@meo.pt - Meo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNhsFail(){
        Client client = new Client("Andre Rangel Leite Marques", "1234567890123456", "1234567891234", "1234567890", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNhsFail2(){
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "", "1234567890", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
    }


    @Test(expected = IllegalArgumentException.class)
    public void getCitizenCardNumber(){
        Client client = new Client("\"Andre Rangel Leite Marques Ferreir\"", "1234561234147890123456", "1234567891", "1234567890", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCitizenCardNumber1(){
        Client client = new Client("\"Andre Rangel Leite Marques Ferreir\"", "", "1234567891", "1234567890", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTinFail2(){
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "12345655780", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTinFail3(){
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setSexFail(){
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "1234567890", "20/10/2000", "jwdiuawd", "12345678901", "andre1234569@gmail.com");
    }

    @Test
    public void getNameTest() throws ParseException {
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "1234567890", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
        String expected = "Andre Rangel Leite Marques Ferreir";
        assertEquals(expected, client.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setphoneNumberFail(){
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "", "20/10/2000", "male", "12345678901124345", "andre1234569@gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setphoneNumberFai1(){
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "", "20/10/2000", "male", "", "andre1234569@gmail.com");
    }

    @Test
    public void toStringTest(){
       try{
           assertEquals(client1.toString(), "Client{name=Sérgio, citizenCardNumber=123456, nhsNumber=987654, tinNumber=123456, birthDate=30/10/2000, sex=Male, phoneNumber=12345678912, email=email@email.com, user=email@email.com - Sérgio}");
       }catch (Exception e) {
           assertFalse(true);
       }
    }
    

    
    /**
     * Test of getEmail method, of class Client.
     */
    @Test
    public void getEmailTest() throws ParseException {
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "1234567890", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
        String expected = "andre1234569@gmail.com";
        assertEquals(expected, client.getEmail());
    }


    /**
     * Test of getPassword method, of class Client.
     */
   @Test
    public void getBirthDateTest() throws ParseException {
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "1234567890", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
        String expected = "20/10/2000";
        assertEquals(expected, client.getBirthDate());
    }


    /**
     * Test of getAddress method, of class Client.
     */
    
    @Test
    public void getPhoneNumberTest() throws ParseException {
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "1234567890", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
        String expected = "12345678901";
        assertEquals(expected, client.getPhoneNumber());
    }

    /**
     * Test of getCreditCardNumber method, of class Client.
     */
    @Test
    public void getTinNumberTest() throws ParseException {
        Client client = new Client("Andre Rangel Leite Marques Ferreir", "1234567890123456", "1234567891", "1234567890", "20/10/2000", "male", "12345678901", "andre1234569@gmail.com");
        String expected = "1234567890";
        assertEquals(expected, client.getTinNumber());
    }
    
}
