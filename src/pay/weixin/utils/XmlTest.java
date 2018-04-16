package pay.weixin.utils;



import pay.weixin.entity.Pay;
import pay.weixin.entity.PayTest;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: bdqn
 * @Description:
 * @Date: created in 12:33 2018/3/10
 */

public class XmlTest {

    public static void test2(){
        String Key = "javastruts2springhibernate2016tr";
        String appid = "wx2537437d11cdec0b";
        String mch_id = "1381483602";
        String spbill_create_ip = "49.221.62.131";
        String body = "测试微商城";
        String trade_type = "NATIVE";
        String notify_url = "http://zhuzuohua.oicp.net/ercodePay/pay-huidao.action";
        int total_fee = 1;

        String nonce_str = Util.getRandomString(20);
        String out_trade_no = Util.getCurrTime() + Util.getRandomString(4);

        SortedMap<Object, Object> params = new TreeMap<>();
        params.put("appid", appid);
        params.put("mch_id", mch_id);
        params.put("spbill_create_ip", spbill_create_ip);
        params.put("body", body);
        params.put("nonce_str", nonce_str);
        params.put("trade_type", trade_type);
        params.put("notify_url", notify_url);
        params.put("total_fee", total_fee);
        params.put("out_trade_no", out_trade_no);

        //生成签名
        String sign = SignUtil.sign(params, Key);
        System.out.println("====" + sign);

        //产省生成xml的实体类
        Pay pay = new Pay();
        pay.setAppid(appid);
        pay.setMch_id(mch_id);
        pay.setSpbill_create_ip(spbill_create_ip);
        pay.setBody(body);
        pay.setNonce_str(nonce_str);
        pay.setTrade_type(trade_type);
        pay.setNotify_url(notify_url);
        pay.setOut_trade_no(out_trade_no);
        pay.setTotal_fee(total_fee);
        pay.setSign(sign);


        XStreamUtil.xstream.alias("xml", Pay.class);
        //对象转换为xml
        String xml = XStreamUtil.xstream.toXML(pay).replace("__","_");
        System.out.println(xml);
    }




    public static void test() {
        String appid = "wxd930ea5d5a258f4f";

        String mch_id = "10000100";

        String device_info = "1000";

        String body = "test";

        String nonce_str = "ibuaiVcKdpRxkhJA";

        PayTest payTest = new PayTest();

        payTest.setAppid(appid);
        payTest.setBody(body);
        payTest.setDevice_info(device_info);
        payTest.setMch_id(mch_id);
        payTest.setNonce_str(nonce_str);

        //xstream初始化
        //XStream xStream = new XStream();
        //设置别名
        //xStream.alias("xml",PayTest.class);

        //使用加了CDATA的xstream
        XStreamUtil.xstream.alias("xml", PayTest.class);
        //对象转换为xml
        String xml = XStreamUtil.xstream.toXML(payTest).replace("__","_");
        System.out.println(xml);


    }

    public static void main(String[] args) {
        test2();
    }


}
