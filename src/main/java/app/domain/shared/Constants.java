package app.domain.shared;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Constants {
    private Constants(){}

    public static final String ROLE_ADMIN = "ADMINISTRATOR";

    public static final String ROLE_RECEPTIONIST = "RECEPTIONIST";
    public static final String ROLE_SPECIALIST_DOCTOR = "SPECIALIST_DOCTOR";
    public static final String ROLE_LAB_COORDINATOR = "LAB_COORDINATOR";
    public static final String ROLE_MEDICAL_LAB_TECHNICIAN = "MEDICAL_LAB_TECHNICIAN";
    public static final String ROLE_CLINICAL_CHEMISTRY_TEC = "CLINICAL_CHEMISTRY_TEC";


    public static final String ROLE_CLIENT = "CLIENT";


    public static final String PARAMS_FILENAME = "config.properties";
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";
    
    public static final int PASSWORD_LENGTH = 10;
}
