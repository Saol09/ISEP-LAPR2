package app.controller;

import app.domain.model.Company;
import app.domain.model.employee.Employee;
import app.domain.store.EmployeeStore;
import app.domain.model.employee.OrganizationRole;
import app.domain.shared.Constants;

public class RegisterEmployeeController {
    private EmployeeStore employeeStore;
    private Company company;
    private Employee e;
    String password;


    public RegisterEmployeeController() {
        this.company = App.getInstance().getCompany();
        this.employeeStore = company.getEmployeeStore();
        this.e = null;
    }

    public boolean createEmployee(String id, int index, String name, String address, String phoneNumber, String email, String socCode) {
        this.e = this.employeeStore.createEmployee(id, this.company.getRole(index-1), name, address, phoneNumber, email, socCode);
        return this.employeeStore.validateEmployee(e);
    }

    public boolean createSpecialistDoctor(String id, int index, String name, String address, String phoneNumber,
                                          String email, String socCode, String doctorIndexNumber) {
        this.e = this.employeeStore.createEmployee(id, this.company.getRole(index-1), name, address, phoneNumber,
                email, socCode);
        return this.employeeStore.validateEmployee(e);
    }

    public String getRoleList(){
        return this.company.getOrganizationRoleList().toString();
    }

    public String getRole(int index){
        return this.company.getRole(index-1).toString();
    }

    public void showRoleList(){
        int cont = 1;
        for (OrganizationRole o: this.company.getOrganizationRoleList()) {
            System.out.println(cont + " " + o.toString());
            cont++;
        }
    }

    public boolean saveEmployeeAndUser(String name,String email) {
        boolean d = this.employeeStore.saveEmployee(e);
        System.out.println(this.employeeStore.employeeList.toString());
        password= passwordGenerator();
        return (d && company.CreateAndAddUser(name,email,password));
    }

    private String passwordGenerator() {
        String AlphanumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(Constants.PASSWORD_LENGTH);
        for (int i = 0; i < Constants.PASSWORD_LENGTH; i++) {
            int index = (int) (AlphanumericString.length() * Math.random());
            sb.append(AlphanumericString.charAt(index));
        }
        return sb.toString();
    }
}