package app.domain.model.employee;

import app.domain.store.EmployeeStore;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeStoreTest {


    @Test
    public void validateEmployeeStoreTest(){
        EmployeeStore emp = new EmployeeStore();
        Employee emp1 = new Employee("123", new OrganizationRole("RECEPTIONIST"), "Augusto", "Rua da rua",
                "97012345226", "meo@meo.pt","5142");
        boolean result = emp.saveEmployee(emp1);

        Assert.assertTrue(result);
    }
}
