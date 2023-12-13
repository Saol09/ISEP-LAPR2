package app.domain.utils;

import java.io.File;
import java.util.Formatter;

public class DemoFile {

    static long counter=0;

    public static boolean writeFile (String file, String fileName)throws Exception{

        Formatter fileReport = new Formatter(new File("..\\lei-21-s2-1do-g64\\CreatedFiles\\" +
                fileName + ".txt"));


        fileReport.format(file);

        fileReport.close();
        return true;
    }

    public static String codeGenarator(){
        String temp = new String();
        for (int i = 0; i < 11; i++) {
            temp += (int)((Math.random() * 9));
        }
        return temp;
    }

    public static String codeGenarator1(){
        counter++;
        long number = 10000000000L + counter;
        return String.valueOf(number);
    }
}
