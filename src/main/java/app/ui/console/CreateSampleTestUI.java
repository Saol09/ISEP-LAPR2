package app.ui.console;

import app.controller.CreateSampleTestController;
import app.domain.utils.DemoFile;
import app.ui.console.utils.Utils;

public class CreateSampleTestUI implements Runnable{

    CreateSampleTestController createSampleTestController = new CreateSampleTestController();


    @Override
    public void run() {
        String op = null;
        String n;
        int c = 0;


        do {
            if (createSampleTestController.getCreatedTestList().length()>0) {
                System.out.println(createSampleTestController.getCreatedTestList());
            }else{
                System.out.println("No tests available.");
            }
            if (c!=0) System.out.println("If you want to leave insert 0 \nor \n");
            try {
                op = Utils.readLineFromConsole("Select the Test");
                if (createSampleTestController.getTestById(op)==null) throw new Exception();
                if (!op.equals("0")){
                    createSampleTestController.getTestById(op);
                    n = Utils.readLineFromConsole("How many samples");
                    for (int i = 0; i < Integer.parseInt(n); i++) {
                        //String tempCode = DemoFile.codeGenarator();
                        String tempCode = DemoFile.codeGenarator1();
                        System.out.println(tempCode);
                        if(createSampleTestController.createBarcode(tempCode)) {
                            createSampleTestController.printBarcode(tempCode);
                        }
                    }
                    createSampleTestController.addSample(createSampleTestController.getTestById(op).getCode());
                }
            }catch(Exception e){
                System.out.println("This test does not exist!");
            }



            c++;
        }while (!op.equals("0"));

    }
}
