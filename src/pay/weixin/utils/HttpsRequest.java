package pay.weixin.utils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: bdqn
 * @Description: 发送https请求
 * @Date: created in 13:52 2018/3/10
 */

public class HttpsRequest {
    public static String sendHttpsRequest(String requestUrl, String requestMethod, String outStr) throws Exception {
        //创建	SSLContext
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        TrustManager[] tm = {new MyX509TrustManager()};
        //初始化
        sslContext.init(null, tm, new java.security.SecureRandom());
        //获取sslSOCKETfactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();

        //设置当前实例使用sslSOCKETfactory
        StringBuffer buffer = null;
        URL url = new URL(requestUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        conn.setRequestMethod(requestMethod);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setSSLSocketFactory(ssf);
        conn.connect();


        //向服务端发送数据
        if (outStr != null) {
            OutputStream os = conn.getOutputStream();
            os.write(outStr.getBytes("UTF-8"));
            os.close();

        }


        //读取服务端的内容
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        buffer = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }

        //打印返回的参数
        System.out.println(buffer.toString());

        //打印数据
        return buffer.toString();
    }


    /**
     * 测试方法
     * @return
     * @throws Exception
     */
    public static String httpsRequest() throws Exception {
        URL url = new URL("http://www.baidu.com/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.connect();


        //读取服务端内容
        InputStream inputStream = conn.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);

        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }

        System.out.println(sb.toString());
        return null;
    }




    public static void main(String[] args) throws Exception {
//        httpsRequest();

    }


}
