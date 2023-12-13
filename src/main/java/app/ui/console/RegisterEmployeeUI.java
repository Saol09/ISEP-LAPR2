package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.ui.console.utils.Utils;

public class  RegisterEmployeeUI implements Runnable {

    RegisterEmployeeController ctrl = new RegisterEmployeeController();

    public RegisterEmployeeUI() {
    }

    @Override
    public void run() {
        System.out.println("\nRegister Employee");

        String id;
        int index;
        String name;
        String address;
        String phoneNumber;
        String email;
        String socCode;
        String doctorIndexNumber = null;
        boolean success = false;

        do {
            id = Utils.readLineFromConsole("Enter Employee ID: ");
            do {

                //System.out.println(ctrl.getRoleList());

                ctrl.showRoleList();
                index = Utils.readIntegerFromConsole("Enter the role number ");

                if (index == 5){
                    doctorIndexNumber = Utils.readLineFromConsole("Enter doctor index number: ");
                }

                name = Utils.readLineFromConsole("Enter Employee Name: ");
                address = Utils.readLineFromConsole("Enter Employee Address: ");
                phoneNumber = Utils.readLineFromConsole("Enter Employee Phone Number: ");
                email = Utils.readLineFromConsole("Enter Employee Email: ");
                socCode = Utils.readLineFromConsole("Enter Employee SOC Code: ");


                if (index == 5) {
                    try {
                        success = ctrl.createSpecialistDoctor(id, index, name, address, phoneNumber, email, socCode, doctorIndexNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter numerical characters in the fields where is requested a number");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else {

                    try {
                        success = ctrl.createEmployee(id, index, name, address, phoneNumber, email, socCode);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter numerical characters in the fields where is requested a number");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } while (!success);

            success = false;


            System.out.printf("\n ID: %s \n Organization Role: %s \n Name: %s \n Address: %s \n Phone number: %s \n E-mail:" +
                    " %s \n SOC Code: %s%n", id, ctrl.getRole(index), name, address, phoneNumber, email, socCode);
            System.out.println("\n Do you confirm the information and want to proceed and register");
            System.out.println("\n 1-Yes");
            System.out.println(" 2-No");


            boolean check = true;

            do {
                switch (Utils.readIntegerFromConsole("Your Choice:")) {
                    case (1):
                        try {
                            success = ctrl.saveEmployeeAndUser(name, email);
                            check = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case (2):
                        check = false;
                        break;
                    default:
                        System.out.println("Please introduze the number 1 or 2");
                }

            } while (check);

            System.out.println("Successful operation");

        } while (!success);
    }
}