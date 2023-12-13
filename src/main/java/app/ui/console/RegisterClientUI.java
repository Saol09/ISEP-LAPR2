/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.console;

import app.controller.RegisterClientController;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class RegisterClientUI  implements Runnable {
    
    public static Scanner scanner = new Scanner(System.in);

    private RegisterClientController rcController;

    public RegisterClientUI() {
        this.rcController = new RegisterClientController();
    }

    /**
     * Basic UI to get the correct inputs to register a Client.
     *
     * @return boolean
     * @throws Exception
     */
    public void run(){
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Citizen card number: ");
        String citizenCardNumber = scanner.nextLine();
        System.out.print("NHS: ");
        String nhsNumber = scanner.nextLine();
        System.out.print("TIN: ");
        String tinNumber = scanner.nextLine();
        System.out.print("Birth date: ");
        String birthDate = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Sex: ");
        String sex = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        boolean state = false;
        try {
            state = rcController.newClient(name, citizenCardNumber, nhsNumber,tinNumber,birthDate, sex, phoneNumber,email);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getStackTrace());
        }

        if (state) {
            System.out.println("Client is valid! Do you confirm the operation (Y/N)?");
            String answer = scanner.nextLine();
            while (!answer.equals("Y") && !answer.equals("N")){
                System.out.println("Answer not valid! Use (Y/N)");
                answer = scanner.nextLine();
                if (answer.equals("Y")) {
                    rcController.saveClient();
                }
            }
        } else {
            System.out.println("Client is invalid!");
        }
    }
}
    

