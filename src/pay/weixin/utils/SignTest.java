package pay.weixin.utils;

import java.util.*;

/**
 * @Author: bdqn
 * @Description: 生成参数传递的签名
 * @Date: created in 10:39 2018/3/10
 */

public class SignTest {

    public static String sign() {
        String appid = "wxd930ea5d5a258f4f";

        String mch_id = "10000100";

        String device_info = "1000";

        String body = "test";

        String nonce_str = "ibuaiVcKdpRxkhJA";


        SortedMap<Object, Object> params = new TreeMap<>();
        params.put("appid", appid);
        params.put("mch_id", mch_id);
        params.put("device_info", device_info);
        params.put("body", body);
        params.put("nonce_str", nonce_str);


        String key = "192006250b4c09247ec02edce69f6a2d";
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Object, Object>> entries = params.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key="+key);
        System.out.println(sb.toString());

        String sign = MD5.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        System.out.println(sign);
        return null;

    }


    public static void main(String[] args) {
        sign();
    }
}
