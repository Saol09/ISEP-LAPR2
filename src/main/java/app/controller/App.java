package app.controller;

import app.domain.model.Company;
import app.domain.shared.Constants;
import app.domain.store.TestStore;
import app.ui.console.Bootstrap;
import auth.AuthFacade;
import auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private TestStore testStore;
    private AuthFacade authFacade;

    private App() {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
        this.company.bootstrapRoles();
        this.bootstrap();


    }

    public Company getCompany() {
        return this.company;
    }

    public TestStore getTestStore() {
        return this.testStore;
    }


    public UserSession getCurrentUserSession() {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd) {
        return this.authFacade.doLogin(email, pwd).isLoggedIn();
    }

    public void doLogout() {
        this.authFacade.doLogout();
    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        } catch (IOException ex) {

        }
        return props;
    }


    private void bootstrap() {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN, Constants.ROLE_ADMIN);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456", Constants.ROLE_ADMIN);

        this.authFacade.addUserRole(Constants.ROLE_SPECIALIST_DOCTOR, Constants.ROLE_SPECIALIST_DOCTOR);

        this.authFacade.addUserWithRole("SpecialistDoctor 1", "sc001@lei.sem2.pt", "123456",
                Constants.ROLE_SPECIALIST_DOCTOR);

        this.authFacade.addUserRole(Constants.ROLE_MEDICAL_LAB_TECHNICIAN, Constants.ROLE_MEDICAL_LAB_TECHNICIAN);

        this.authFacade.addUserWithRole("Medical Lab Technician", "mlt1@lei.sem2.pt", "123456", Constants.ROLE_MEDICAL_LAB_TECHNICIAN);

        this.authFacade.addUserRole(Constants.ROLE_CLINICAL_CHEMISTRY_TEC, Constants.ROLE_CLINICAL_CHEMISTRY_TEC);

        this.authFacade.addUserWithRole("Clinical Chemistry Technologist", "cct001@lei.sem2.pt", "123456", Constants.ROLE_CLINICAL_CHEMISTRY_TEC);

        this.authFacade.addUserRole(Constants.ROLE_LAB_COORDINATOR, Constants.ROLE_LAB_COORDINATOR);

        this.authFacade.addUserWithRole("laboratory Coordinator", "lc001@lei.sem2.pt", "123456", Constants.ROLE_LAB_COORDINATOR);

        this.authFacade.addUserRole(Constants.ROLE_CLIENT, Constants.ROLE_CLIENT);

        this.authFacade.addUserWithRole("Sérgio Lopes", "client001@lei.sem2.pt", "123456", Constants.ROLE_CLIENT);

        this.authFacade.addUserWithRole("Tiago Silva", "client002@lei.sem2.pt", "123456", Constants.ROLE_CLIENT);

        this.authFacade.addUserWithRole("Paulo Couto", "client003@lei.sem2.pt", "123456", Constants.ROLE_CLIENT);

    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;

    public static App getInstance() {
        if (singleton == null) {
            synchronized (App.class) {
                singleton = new App();
            }
        }
        return singleton;
    }
}
