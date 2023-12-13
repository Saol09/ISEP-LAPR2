package app.domain.model.employee;

public class SpecialistDoctor extends Employee {
    private String doctorIndexNumber;

    public SpecialistDoctor(String id, OrganizationRole role, String name, String address, String phoneNumber, String email, String socCode, String doctorIndexNumber){
        super(id,role,name,address,phoneNumber,email,socCode);
        this.doctorIndexNumber = doctorIndexNumber;
    }
    public void setDoctorIndexNumber(String doctorIndexNumber) {this.doctorIndexNumber = doctorIndexNumber;}

    public String getDoctorIndexNumber(){return doctorIndexNumber;}

    @Override
    public String toString(){
        return super.toString() + " Doctor Index Number: " + doctorIndexNumber;
    }

}