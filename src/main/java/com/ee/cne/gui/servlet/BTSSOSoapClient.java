package com.ee.cne.gui.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BTSSOSoapClient {
     
    public static void callService(String url) throws MalformedURLException, IOException {
        String urlString = url;
        URL urlForInfWebSvc = new URL(urlString);
        URLConnection UrlConnInfWebSvc = urlForInfWebSvc.openConnection();
        HttpURLConnection httpUrlConnInfWebSvc = (HttpURLConnection) UrlConnInfWebSvc;
        httpUrlConnInfWebSvc.setDoOutput(true);
        httpUrlConnInfWebSvc.setDoInput(true);
        httpUrlConnInfWebSvc.setAllowUserInteraction(true);
        httpUrlConnInfWebSvc.setRequestMethod("POST");
        httpUrlConnInfWebSvc.setRequestProperty("Host", "localhost");
        httpUrlConnInfWebSvc.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
        OutputStreamWriter infWebSvcReqWriter = new OutputStreamWriter(httpUrlConnInfWebSvc.getOutputStream());
        String infWebSvcRequestMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
            "<SOAP-ENV:Header xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
            "<v1:trackingHeader xmlns:v1=\"http://www.everythingeverywhere.com/common/message/SoapHeader/v1.0\">\r\n" + 
            "<requestId>3CDB0731-42F7-4C9B-8EDB-7634B02AD2CC</requestId>\r\n" + 
            "<timestamp>2019-01-15T07:09:21.805Z</timestamp>\r\n" + 
            "</v1:trackingHeader>\r\n" + 
            "</SOAP-ENV:Header>\r\n" + 
            "<soap:Body>\r\n" + 
            "<ns7:getContextWithOperations xmlns:ns1=\"http://messaging.ei.tmobile.net/datatypes\" xmlns:ns3=\"http://www.everythingeverywhere.com/common/message/Fault/v1.0\" xmlns:ns4=\"http://www.everythingeverywhere.com/common/message/BusinessException/v1.0\" xmlns:ns5=\"http://www.everythingeverywhere.com/common/message/TechnicalException/v1.0\" xmlns:ns6=\"http://www.everythingeverywhere.com/common/message/SoapHeader/v1.0\" xmlns:ns7=\"http://www.everythingeverywhere.com/crm/customer/service/GetContextWithOperations/GetContextWithOperationsRequest/v1.0\" xmlns:ns8=\"http://www.everythingeverywhere.com/crm/customer/service/GetContextWithOperations/GetContextWithOperationsResponse/v1.0\">\r\n" + 
            "<eiMessageContext2>\r\n" + 
            "<ns1:requestId>3CDB0731-42F7-4C9B-8EDB-7634B02AD2CC</ns1:requestId>\r\n" + 
            "<ns1:sender>eea</ns1:sender>\r\n" + 
            "<ns1:correlationId>3CDB0731-42F7-4C9B-8EDB-7634B02AD2CC</ns1:correlationId>\r\n" + 
            "</eiMessageContext2>\r\n" + 
            "<message>\r\n" + 
            "<contextToken>R4WKACCR5L5MSD5K6P5VZ2U6RQJ3DT5F</contextToken>\r\n" + 
            "</message>\r\n" + 
            "</ns7:getContextWithOperations>\r\n" + 
            "</soap:Body>\r\n" + 
            "</soap:Envelope>\r\n" + 
            "";
        
        infWebSvcReqWriter.write(infWebSvcRequestMessage);
        infWebSvcReqWriter.flush();
        BufferedReader infWebSvcReplyReader = new BufferedReader(new InputStreamReader(httpUrlConnInfWebSvc.getInputStream()));
        String line;
        String infWebSvcReplyString = "";
        while ((line = infWebSvcReplyReader.readLine()) != null) {
            infWebSvcReplyString = infWebSvcReplyString.concat(line);
            }
        infWebSvcReqWriter.close();
        infWebSvcReplyReader.close();
        httpUrlConnInfWebSvc.disconnect();
        System.out.println(infWebSvcReplyString);
    }
}