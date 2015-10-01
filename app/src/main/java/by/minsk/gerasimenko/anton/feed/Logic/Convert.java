package by.minsk.gerasimenko.anton.feed.Logic;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class Convert {

    private static Calendar calendar = Calendar.getInstance();

    public static String date(long date) {

        long now = Calendar.getInstance().getTimeInMillis();
        long diff = date - now;

        //String years = String.valueOf(diff/1000/60/60/24/365);

        calendar.setTime(new Date(date));

        int year = calendar.get(Calendar.MONTH)+1;

        return "("+ year+"."+ calendar.get(Calendar.YEAR) + ")";
    }

}
