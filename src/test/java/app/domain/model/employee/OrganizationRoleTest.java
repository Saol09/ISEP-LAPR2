package app.domain.model.employee;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrganizationRoleTest {

    final OrganizationRole role = new OrganizationRole("Receptionist");

    @Test
    public void getRoleTest(){
        assertEquals("Receptionist",role.getRole());
    }

    @Test
    public void setRoleTest(){
        role.setRole("Specialist Doctor");
        assertEquals(role.getRole(),"Specialist Doctor");
    }

    @Test
    public void testOrganizationRoleToString(){
        OrganizationRole role = new OrganizationRole("Specialist Doctor");
        String expected = "Specialist Doctor";
        Assert.assertEquals(expected, role.toString());

    }

}