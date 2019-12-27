package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

    public void main()  {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-kk-mm-ss");
        String dateString = formatter.format(currentTime);
        System.out.println(dateString);
    }

}
