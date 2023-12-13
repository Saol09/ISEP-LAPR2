package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ClinicalAnalysisLab {
    private String idLaboratory;
    private String name;
    private String address;
    private String phoneNumber;
    private String tin;
    private List<TypeOfTest> typeoftest;

    public ClinicalAnalysisLab(String idLaboratory, String name, String address, String phoneNumber, String tin, List<TypeOfTest> typeoftest) {
        checkIdLaboratoryRules(idLaboratory);
        checkNameRules(name);
        checkAddressRules(address);
        checkPhoneNumberRules(phoneNumber);
        checkTinRules(tin);
        this.idLaboratory = idLaboratory;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tin = tin;
        this.typeoftest=typeoftest;
    }

    public boolean setIdLaboratory(String idLaboratory) {
        checkIdLaboratoryRules(idLaboratory);
        this.idLaboratory = idLaboratory;
        return true;
    }
    public String getIdLaboratory() {
        return idLaboratory;
    }

    public boolean setName(String name) {
        checkNameRules(name);
        this.name = name;
        return true;
    }
    public String getName() {
        return name;
    }

    public boolean setAddress(String address) {
        checkAddressRules(address);
        this.address = address;
        return true;
    }
    public String getAddress() {
        return address;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        checkPhoneNumberRules(phoneNumber);
        this.phoneNumber = phoneNumber;
        return true;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setTin(String tin) {
        checkTinRules(tin);
        this.tin = tin;
        return true;
    }
    public String getTin() {
        return tin;
    }

    private void checkNameRules(String name){
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if ( name.length() > 21)
            throw new IllegalArgumentException("Name shall not pass 20 characters.");
    }

    private void checkIdLaboratoryRules(String idLaboratory){
        if (StringUtils.isBlank(idLaboratory))
            throw new IllegalArgumentException("ID Laboratory cannot be blank.");
        if (idLaboratory.length() != 5)
            throw new IllegalArgumentException("ID Laboratory shall have 5 alphanumeric characters.");
    }

    private void checkAddressRules(String address){
        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException("Address cannot be blank.");
        if ( address.length() > 31)
            throw new IllegalArgumentException("Address shall not pass 30 characters.");
    }

    private void checkPhoneNumberRules(String phoneNumber){
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Address cannot be blank.");
        if ( phoneNumber.length() != 11)
            throw new IllegalArgumentException("Address shall not pass 11 characters.");
        Long.parseLong(phoneNumber);
    }

    private void checkTinRules(String tin){
        if (StringUtils.isBlank(tin))
            throw new IllegalArgumentException("Address cannot be blank.");
        if ( tin.length() > 10)
            throw new IllegalArgumentException("Address shall not pass 10 characters.");
        Long.parseLong(tin);
    }

    @Override
    public String toString() {
        return "ClinicalAnalysisLab{" +
                "ID Laboratory='" + idLaboratory + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone number='" + phoneNumber + '\'' +
                ", tin='" + tin + '\'' +
                ", type of tests='" + typeoftest.toString() + '\'' +
                '}';
    }

}
