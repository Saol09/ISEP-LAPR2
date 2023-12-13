package app.domain.model.employee;

import app.domain.model.employee.OrganizationRole;
import app.domain.model.employee.SpecialistDoctor;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpecialistDoctorTest {

    final SpecialistDoctor doc = new SpecialistDoctor("1235", new OrganizationRole("SPECIALIST_DOCTOR"), "Alberto",
            "Rua das casas", "12345678912","meo@meo.pt", "125","1452241");


    @Test
    public void getDoctorIndexNumberTest(){
        assertEquals(doc.getDoctorIndexNumber(),"1452241");
    }

    @Test
    public void setDoctorIndexNumberTest(){
        doc.setDoctorIndexNumber("1848411");
        assertEquals(doc.getDoctorIndexNumber(),"1848411");
    }
}
