/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.store;

import app.domain.model.Client;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author andre
 */
public class ClientStore {
    
     private List<Client> clientList = new ArrayList();


        public Client newClient(String name, String citizenCardNumber,String nhsNumber, String tinNumber, String birthDate, String sex, String phoneNumber, String email){
            return new Client(name, citizenCardNumber, nhsNumber, tinNumber, birthDate, sex, phoneNumber, email);
        }

        public boolean saveClient(Client ct){
            if(validateClient(ct)){
                addClient(ct);
                return true;
            }
            return false;
        }


        public boolean addClient(Client ct)
        {
            if (ct != null) {
                if (!validateClient(ct))
                    return this.clientList.add(ct);
            }
            return false;
        }

        public boolean validateClient(Client ct) {
            for (Client parCt : clientList){
                if(parCt.equals(ct)){
                    return true;
                }
            }
            return false;
        }

        public List<Client> getClientList() {
            return clientList;
        }

        public Client getClientByTin(String tin){
            for(Client e: clientList){
                if (e.getTinNumber().equals(tin)){
                    return e;
                }
            }
            return null;

        }

    public String getClientNameByTin(String tin){
        for(Client e: clientList){
            if (e.getTinNumber().equals(tin)){
                return e.getName();
            }
        }
        return null;

    }

    public Client getClientByEmail(String email){
        for(Client e: clientList){
            if (e.getEmail().equals(email)){
                return e;
            }
        }
        return null;

    }

    public List<Client> getClientOrder(String attribute){
            List<Client> tempList = clientList;

            if( attribute.equals("TinNumber")){
                tempList.sort(Comparator.comparing(Client::getTinNumber));
                return tempList;
            }
            else if (attribute.equals("Name")){
                tempList.sort(Comparator.comparing(Client::getName));
                return tempList;

            }else{
                return null;
            }


        }


     private int getIdade(String data){


         int ano = Integer.parseInt(data.substring(7));
         LocalDate today = LocalDate.now();
         return today.getYear()-ano;
     }

    public double getMediaIdades(String[] tinList) {
            double soma=0;
            int nr=tinList.length;
            double media;
            for (Client c: clientList) {
                for (String s: tinList) {
                   if(c.getTinNumber().equals(s)){
                        soma+=getIdade(c.getBirthDate());
                   }
                }
            }

            return (double)soma/nr;
    }
}
