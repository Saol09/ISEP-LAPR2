package app.domain.model.employee;

import org.junit.Test;

import static org.junit.Assert.*;


public class EmployeeTest {


    final Employee emp1 =  new Employee("123", new OrganizationRole("RECEPTIONIST"), "Augusto", "Rua da rua",
            "97012345226", "meo@meo.pt","5142");
    final Employee emp1Identical =  new Employee("123", new OrganizationRole("RECEPTIONIST"), "Augusto",
            "Rua da rua", "97012345226", "meo@meo.pt","5142");
    final Employee emp1Different =  new Employee("123", new OrganizationRole("RECEPTIONIST"), "Roberto",
            "Rua da rua", "97012345226", "meo@meo.pt","5142");
    final Employee empTotalDifferent = new Employee("4321",new OrganizationRole("LAB_COORDINATOR"), "Alberto",
            "Travessa das casas","12345678912", "nos@nos.pt","124");

    @Test
    public void getIdTest() {
        assertEquals("123",emp1.getID());
    }


    @Test
    public void getOrganizationRoleTest(){
        assertEquals(new OrganizationRole("RECEPTIONIST").toString(),emp1.getOrganizationRole().toString());
    }

    @Test
    public void getNameTest(){
        assertEquals("Augusto",emp1.getName());
    }

    @Test
    public void getAddressTest(){
        assertEquals("Rua da rua",emp1.getAddress());
    }

    @Test
    public void getPhoneNumberTest(){
        assertEquals("97012345226",emp1.getPhoneNumber());
    }

    @Test
    public void getEmailTest(){
        assertEquals("meo@meo.pt", emp1.getEmail());
    }

    @Test
    public void getSocCode(){
        assertEquals("5142",emp1.getSocCode());
    }

    @Test
    public void setIdTest(){
        emp1.setId("1841");
        assertEquals(emp1.getID(),"1841");
    }

    @Test
    public void setEmailTest(){
        emp1.setEmail("nos@nos.pt");
        assertEquals(emp1.getEmail(),"nos@nos.pt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIdEmployeeBigger(){
        emp1.setId("1111111111111111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIdBlank(){
        emp1.setId("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameEmployeeBigger(){
        emp1.setName("Teste12345678912345678912345678454854544544");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameEmployeeBlank(){
        emp1.setName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setAddressEmployeeBigger(){
        emp1.setAddress("Teste12345678912345678912345678454854544544");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setAddressEmployeeBlank(){
        emp1.setAddress("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPhoneNumberEmployeeBigger(){
        emp1.setPhoneNumber("1234567891234");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPhoneNumberEmployeeBlank(){
        emp1.setPhoneNumber("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setSocCodeEmployeeBigger(){
        emp1.setSocCode("145254");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setSocCodeEmployeeBlank(){
        emp1.setSocCode("");
    }

    @Test
    public void setOrganizationRole(){
        emp1.setOrganizationRole(new OrganizationRole("RECEPTIONIST"));
        assertEquals(emp1.getOrganizationRole().toString(),"RECEPTIONIST");
    }


    @Test
    public void setNameTest(){
        emp1.setName("Rodrigo");
        assertEquals(emp1.getName(),"Rodrigo");
    }

    @Test
    public void setAddressTest(){
        emp1.setAddress("Rua das casas");
        assertEquals(emp1.getAddress(),"Rua das casas");
    }

    @Test
    public void setPhoneNumberTest(){
        emp1.setPhoneNumber("98745612332");
        assertEquals(emp1.getPhoneNumber(),"98745612332");
    }

    @Test
    public void setSocCodeTest(){
        emp1.setSocCode("1421");
        assertEquals(emp1.getSocCode(),"1421");
    }



    @Test
    public void equalsTest(){
        assertEquals(emp1, emp1);
        assertEquals(emp1.toString(), emp1Identical.toString());
        assertNotEquals(emp1,null);
        assertNotEquals(emp1,emp1Different);
        assertNotEquals(emp1,empTotalDifferent);

    }
}
