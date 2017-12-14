package cn.kenenjoy.controller;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by hefa on 2017/12/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileControllerTests {

    private MockMvc mvc;

    @Autowired
    private FileController fileController;


    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(fileController).build();
    }


    @Test
    public void uploadFiles() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("abc.txt", "Downloads/abc.txt", null, "hello world!".getBytes());
        MockMultipartHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.fileUpload("/file/uploads");
        MvcResult mvcResult = mvc.perform(requestBuilder.file(mockMultipartFile)).andDo(MockMvcResultHandlers.print()).andReturn();
        assertEquals(MockHttpServletResponse.SC_OK, mvcResult.getResponse().getStatus());

    }


    /**
     * 使用HttpClient模拟客户端文件上传
     *
     * @param args
     * @throws IOException
     */
    public void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://127.0.0.1:8080/file/uploads");
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
