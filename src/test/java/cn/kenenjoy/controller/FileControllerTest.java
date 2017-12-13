package cn.kenenjoy.controller;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by hefa on 2017/12/13.
 */
public class FileControllerTest {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://127.0.0.1:8080/file/uploadFiles");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        File file = new File("/Users/hefa/Downloads/abc.txt");
        builder.addBinaryBody("abc.txt", file);
        builder.addBinaryBody("abc2.txt", file);
        httppost.setEntity(builder.build());
        CloseableHttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            System.out.println("成功！");
            // 响应结果
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } else {
            System.out.println("失败！");
        }

        response.close();
        httpclient.close();
    }
}
