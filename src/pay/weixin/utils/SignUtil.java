package pay.weixin.utils;

import java.util.*;

/**
 * @Author: bdqn
 * @Description: 生成参数传递的签名
 * @Date: created in 10:39 2018/3/10
 */

public class SignUtil {

    public static String sign( SortedMap<Object, Object> params,String key) {
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
        return sign;

    }


}
