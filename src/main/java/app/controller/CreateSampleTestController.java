package app.controller;


import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.Test;
import app.domain.store.ClientStore;
import app.domain.store.TestStore;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateSampleTestController {

    Company company;
    TestStore testStore;
    List<Sample> tempList;
    ClientStore clientStore;
    public CreateSampleTestController() {
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.clientStore = company.getClientStore();
        this.tempList = new ArrayList<>();
    }

    public String getCreatedTestList(){
        List<Test> tempList;
        String tempString = new String();
        tempList = testStore.getNewTests();
        for(Test e : tempList){
            tempString +=e.testString();
            tempString +=" Client " + clientStore.getClientNameByTin(e.getClientTinNum()) + "\n";
        }
        return tempString;
    }

    public boolean createBarcode(String code) {
        try {
            Barcode barcode = BarcodeFactory.createUPCA(code);
            return true;
        } catch (BarcodeException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean printBarcode(String code){
        try{
            Barcode barcode = BarcodeFactory.createUPCA(code);
            barcode.setPreferredBarHeight(100);
            File path = new File("..\\lei-21-s2-1do-g64\\CreatedFiles\\barcodes\\"+barcode+".jpeg");
            BarcodeImageHandler.saveJPEG(barcode,path);
            tempList.add(new Sample(barcode));
            return true;
        }catch(OutputException | IOException | BarcodeException ioException){
            return false;
        }
    }

    public Test getTestById(String id){
        return testStore.getTest(id);
    }

    //add
    public boolean addSample(String id){
            testStore.getTest(id).setSampleList(tempList);
            return true;
    }

    public boolean getName(String id){
        String tempTin = testStore.getTest(id).getClientTinNum();

        return true;
    }



}
