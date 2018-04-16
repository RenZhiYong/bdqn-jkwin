package pay.aliPay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091500519460";


    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQD01nL7sLPPZYAomnEExouKSMdR6JvOyzgPDFI6hn7xv+PLsh4NsdphoTTgOZh7/6H66YnbDXlLNaKebBeltEPgniydbILPWYlc3ysprRh7XVMwqoizv9WkwGVyrlhzY3bc9Fs/GjwKbSUd+/8rCGom+CaGHaboNOlWCoPh5tnvKl41dIwlRWHNKD6MbiSairZplXHf1oPhoakDuq7kfYqT/O5y36H9WC/XjA1EYufYKsGKNo/6m0dG76jB9xm2HkAEZKLMkdmxCLJ4iT1cd3lpIWLRYLKuP2o5xRsPOmYJ0uiAqr35+CkUIHGrTKLPwjMWjuW92Aq0tIkW8/LWZ8L7AgMBAAECggEBANH9T9cg4cdihb3NYFu5Mhsjeph8yY1ebLEzXx9FFYGgk+6z0OTsAqIzklcx7t+DC9lZDdxrvPlNgjEgAlQjvQfcgeVvGO5gG9kkqy9uf43nKB+YU/De+oz4Wso2UDR/PYYaqlv/0zkaDXifFmZBLFJKCTiEHBASuYILOLu6tHZTkb33RJ57xljLnMTljdYKvMk5UETKf805UbWQEaae250v6hG9IzkKc/mxbFgnZnEHHqm5kmpD4KvNrQJqXqa68zz7ZJatmElTP8D+/fEfT1ZXIQFZhwRBdR0Iz7K36WuBfMEXNF1IUOChHILjXZOH+BDkq6SXvXU74d/5sJAYy5ECgYEA/uT4GxwGtwbY7m+nTsp8x44a38zzwXgYvvfHhSa2eMFoAbJqau80Kf7QtYwXOQcF5DgYwnmyxwu+cralRR1L9erh8CVwhbgG75YTH1RGUgNRSsV83Q0ehZPieE7IGchwPieStbxsXsqiPwV7BRIrXWQWi5GQyZYpm8dgovV/1aMCgYEA9eZQK3kN5Ptze03nZDj1ZQEGaq1urY3g7c37uEhihTfOXTdHCIa/gah8ItcgMJ3FoylRFu0f7I9PnN+tZ/WsqAV8g9CUSDH+ePzkVIxKyL1xSriuwpHySAvT1Jx6NCfwst8Mig7E2hdZRkEqnLiKWAJXpiPBWEKvYnzmCB2HQskCgYAb6OZh0YfKsq0+LmubbQCMuTqoFsD6BjRvdKIcKkkAn+zLgsW0P8zubEBeIKDKVcKHYr0TTlANC3QnC2i9UJ/opXdn3DGd8rCPu1cMryWkBUj5bvZlHfKhnbfGhJnUeOYRaDPgQml7V6S8UdVOkNa+ux7c2WuJJzAXJpWmQktlEQKBgQDESTaRnS4ELNw//y3ICNeJ6smOeiaxD2IPMa/PqKhMIwHt0uQ24CkafL2qqgKeDDLpTV/XZy1mjfdFCB/JrohGDysXpXXYM2Aof+ZbvykrGF3JAacu1YWLETXkr4u0+nTes8G0qplkZeLze61iMMTt/+CrVDtQEtshSQXuUHPaUQKBgQDvQIr0f8mM/NabgehAlNRXtbTvA4ryOn/gp55Zl5LtRbBAn/upGRvOBvXvb2j9MUnl36JmWgMMLJTy33E9RwWVaAHi3gkLvSwjladVG6dqEEK/7vsQyhGVQouaI2gUK2GEEfubib0U3XHd4e3l1nkpTWhfxAcvVs+2MsYflR7VMw==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo+x0ilmXOX728AwGAbE02UPq8FnGN+Mu9WZyMEtIjzt9JXmDPB9o0Xphoj5/8Xi6BOzxU0dTktDktXuxD2szYD4VnFNoQiYUviSZqR1bIHuX03Tc1JUqM6qzzjhtjRSjQb2p1Q1To8P8TtRy3bHa3DaEolfUueof3FnAeBkp/4NhZtaxt6S0rdcH7TcpWtJha9WyxymXjlqZm7jmDRZMKufVbQbqUs7PJfwqJ958gg1YKe5ssRFOOn/xlTOczmfM2EKikPEmyNv5bGpUTbKE1ckljuHtRTygHzEa3gDZkKqa5hRT3I15/Du4Sgj+XXL/BXTJjBUFKi3XLGDYaYqx1QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://127.0.0.1:8080/test.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8080/test.jsp";
    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

