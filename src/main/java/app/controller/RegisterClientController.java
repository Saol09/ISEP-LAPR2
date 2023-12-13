/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.domain.model.Client;
import app.domain.store.ClientStore;

/**
 *
 * @author andre
 */
public class RegisterClientController {
    
    private ClientStore ctStore;
    private Client ct;

    public RegisterClientController(ClientStore clientStore) {
        this.ctStore=ctStore;
        this.ct = null;
    }

    public RegisterClientController() {

    }

   public boolean newClient(String name, String citizenCardNumber,String nhsNumber, String tinNumber, String birthDate, String sex, String phoneNumber, String email){
        this.ct=this.ctStore.newClient(name, citizenCardNumber, nhsNumber,tinNumber,birthDate, sex, phoneNumber,email);
        return this.ctStore.validateClient(ct);
    }
    public boolean saveClient(){
        return this.ctStore.saveClient(ct);
    }

    
    
}
