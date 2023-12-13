/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import auth.domain.model.*;
import app.domain.shared.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author andre
 */
public class Client {
    
    private String name;
    private String citizenCardNumber;
    private String nhsNumber;
    private String tinNumber;
    private String birthDate;
    private String sex;
    private String phoneNumber;
    private String email;
    private User user;

    static final int CITIZEN_CARD_DIGITS = 16;
    static final int MAX_CHAR_NAME = 35;
    static final int NHSTIN_NUMBER_DIGITS = 10;
    static final int PHONE_NUMBER_DIGITS = 11;
    

    /***
     * Constructor for class Client, complete
     * @param nhsNumber
     * @param citizenCardNumber
     * @param name
     * @param tinNumber
     * @param birthDate
     * @param sex
     * @param phoneNumber
     * @param email
     */
    public Client(String name, String citizenCardNumber, String nhsNumber, String tinNumber, String birthDate, String sex, String phoneNumber, String email) {
        checkNameRules(name);
        checkCitizenCardNumberRules(citizenCardNumber);
        checkNhsRules(nhsNumber);
        checkTinRules(tinNumber);
        checkbirthDayRules(birthDate);
        checkSexRules(sex);
        checkPhoneNumberRules(phoneNumber);
        this.name = name;
        this.citizenCardNumber=citizenCardNumber;
        this.nhsNumber=nhsNumber;
        this.tinNumber=tinNumber;
        this.birthDate=birthDate;
        this.sex=sex;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.user= new User(new Email (email),new Password(passwordGenerator()),name);
    }
    
    private String passwordGenerator() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(Constants.PASSWORD_LENGTH);
        for (int i = 0; i < Constants.PASSWORD_LENGTH; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    public void setCitizenCardNumber(String citizenCardNumber) {
        this.citizenCardNumber = citizenCardNumber;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", citizenCardNumber="
                + citizenCardNumber + ", nhsNumber=" + nhsNumber 
                + ", tinNumber=" + tinNumber + ", birthDate=" + birthDate 
                + ", sex=" + sex + ", phoneNumber=" + phoneNumber + ", email=" 
                + email + ", user=" + user + '}';
    }

    public String toShortString() {
        return "" + "name=" + name + ", tinNumber=" + tinNumber ;
    }
    private void checkNameRules(String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (name.length() > 35)
            throw new IllegalArgumentException("Name must have less than 35 characters.");
    }

    private void checkCitizenCardNumberRules(String citizenCardNumber) {
        if (StringUtils.isBlank(citizenCardNumber))
            throw new IllegalArgumentException("Citizen card number cannot be blank.");
        if (citizenCardNumber.length() > 16)
            throw new IllegalArgumentException("Citizen card number must have 16 digits.");
    }

    private void checkNhsRules(String nhsNumber) {
       if (StringUtils.isBlank(nhsNumber))
            throw new IllegalArgumentException("NHS cannot be blank.");
        if (nhsNumber.length() > 10)
            throw new IllegalArgumentException("NHS must have 10 digits."); 
    }

    private void checkTinRules(String tinNumber) {
        if (StringUtils.isBlank(tinNumber))
            throw new IllegalArgumentException("TIN cannot be blank.");
        if (tinNumber.length() > 10)
            throw new IllegalArgumentException("TIN must have 10 digits.");
    }

    private boolean checkbirthDayRules(String birthDate) {
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        sdf.setLenient(false);
        try {
            Date javaDate = sdf.parse(birthDate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private void checkSexRules(String sex) {
        if (!StringUtils.isBlank(sex)) {
            if (!(sex.equalsIgnoreCase("Male") || sex.equalsIgnoreCase("Female"))) {
                throw new IllegalArgumentException("Sex can only be Male or Female or blank");
            }
        }
    }


    private void checkPhoneNumberRules(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Phone number cannot be blank.");
        if (phoneNumber.length() != 11)
            throw new IllegalArgumentException("Phone number must have 11 digits.");
    }
    
    
}
