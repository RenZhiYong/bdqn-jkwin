package pay.weixin.action;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 微信回调函数
 */

@WebServlet("/PayHuiDiaoServlet")
public class PayHuiDiaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("回调函数");
        //接收微信的调用
        InputStream inputStream = request.getInputStream();
        StringBuffer sb = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }

        bufferedReader.close();
        inputStream.close();
        String respXml = sb.toString();
        System.out.println(respXml + "respons");


        //回复消息给微信
        //1.解析xml
        try {
            String code = "";
            Document document = DocumentHelper.parseText(respXml);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                if (element.getName().equals("result_code")) {
                    code = element.getTextTrim();
                    System.out.println("成功code" + code);

                    //第三步:返回信件涵
                    if ("SUCCESS".equals(code)) {
                        String resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                                + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                        OutputStream outputStream = response.getOutputStream();
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                        bufferedOutputStream.write(respXml.getBytes());
                        bufferedOutputStream.close();
                        outputStream.close();
                        System.out.println("回复成功");
                        request.getRequestDispatcher("/index.jsp").forward(request,response);

                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
