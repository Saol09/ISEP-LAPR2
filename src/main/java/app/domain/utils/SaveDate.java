package app.domain.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SaveDate {

    public static String dataCreation(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return formatter.format(calendar.getTime());
    }

}
