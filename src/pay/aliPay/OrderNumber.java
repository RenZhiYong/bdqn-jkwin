package pay.aliPay;


import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNumber {

    public static String WIDout_trade_no(){

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str=sdf.format(new Date());

        return str;
    }
    
}
