package app.domain.model.employee;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private OrganizationRole role;
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String socCode;

    public Employee(String id, OrganizationRole role, String name, String address, String phoneNumber, String email, String socCode) {
        checkEmployeeID(id);
        checkEmployeeName(name);
        checkEmployeeAddress(address);
        checkEmployeePhoneNumber(phoneNumber);
        checkEmployeeSOCCode(socCode);
        this.id = id;
        this.role = role;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
    }

    private void checkEmployeeID(String id) {
        if (StringUtils.isBlank(id))
            throw new IllegalArgumentException("Employee's ID cannot be blank.");
        if (id.length() > 20)
            throw new IllegalArgumentException("Employee's ID cannot have more than 20 digits.");
        Long.parseLong(id);
    }

    private void checkEmployeeName(String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Employee's Name cannot be blank.");
        if (name.length() > 35)
            throw new IllegalArgumentException("Employee's Name cannot have more than 35 digits.");
    }

    private void checkEmployeeAddress(String address) {
        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException("Employee's Address cannot be blank.");
        if (address.length() > 30)
            throw new IllegalArgumentException("Employee's Address cannot have more than 30 digits.");
    }

    private void checkEmployeePhoneNumber(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Employee's Phone Number cannot be blank.");
        if (phoneNumber.length() != 11)
            throw new IllegalArgumentException("Employee's Phone Number should have 11 digits.");
        Long.parseLong(phoneNumber);
    }

    private void checkEmployeeSOCCode(String socCode) {
        if (StringUtils.isBlank(socCode))
            throw new IllegalArgumentException("Employee's SOC Code cannot be blank.");
        if (socCode.length() > 4)
            throw new IllegalArgumentException("Employee's SOC Code cannot have more than 4 digits.");
        Long.parseLong(socCode);
    }

    public void setId(String id) {
        checkEmployeeID(id);
        this.id = id;
    }

    public void setOrganizationRole(OrganizationRole role) {
        this.role = role;
    }

    public void setName(String name) {
        checkEmployeeName(name);
        this.name = name;
    }

    public void setAddress(String address) {
        checkEmployeeAddress(address);
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        checkEmployeePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSocCode(String socCode) {
        checkEmployeeSOCCode(socCode);
        this.socCode = socCode;
    }

    public String getID() {
        return id;
    }

    public OrganizationRole getOrganizationRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSocCode() {
        return socCode;
    }

    public String toString() {
        return String.format("ID: %s \n Organization Role: %s \n Name: %s \n Address: %s \n Phone Number: %s \n " +
                        "E-Mail: %s \n SOC Code: \n", this.getID(), this.getOrganizationRole(), this.getName(),
                this.getAddress(), this.getPhoneNumber(), this.getEmail(), this.getSocCode());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return (this.getID().equals(e.id) && this.getOrganizationRole().equals(e.getOrganizationRole()) && this.getName().equals(e.getName())
                && this.getAddress().equals(e.getAddress()) && this.getPhoneNumber().equals(e.getPhoneNumber())
                && this.getEmail().equals(e.getEmail()) && this.getSocCode().equals(e.getSocCode()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, name, address, phoneNumber, email, socCode);
    }


}


