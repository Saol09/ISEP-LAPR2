package app.domain.store;

import app.domain.model.employee.Employee;
import app.domain.model.employee.OrganizationRole;

import java.util.ArrayList;

public class EmployeeStore {
    public ArrayList<Employee> employeeList;

    public EmployeeStore(){
        employeeList = new ArrayList<>();
    }

    public Employee createEmployee(String id, OrganizationRole role, String name, String address, String phoneNumber, String email, String socCode) {
        return new Employee(id, role, name, address,phoneNumber,email, socCode);
    }

    public boolean validateEmployee(Employee e) {
        if (e == null)
            return false;
        return ! this.employeeList.contains(e);
    }

    public boolean saveEmployee(Employee e) {
        if (!validateEmployee(e))
            return false;
        return this.employeeList.add(e);
    }

}
