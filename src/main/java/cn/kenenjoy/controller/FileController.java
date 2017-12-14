package cn.kenenjoy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by hefa on 2017/12/13.
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    /**
     * 处理文件上传
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    @ResponseBody
    public static Map<String, String> uploads(HttpServletRequest request) throws IOException {
        Map<String, String> result = new HashMap<String, String>();
        //文件上传的请求
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        //获取请求的参数
        Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
        Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, MultipartFile> entry = it.next();
            MultipartFile multipartFile = entry.getValue();
            log.info("文件名称：" + multipartFile.getName() + "\t 文件大小：" + multipartFile.getSize());
            if (multipartFile.getSize() != 0 && !"".equals(multipartFile.getName())) {
                // 文件保存路径和文件名称，默认为参数文件名
                File file = new File(multipartFile.getName());
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(multipartFile.getBytes());
                outputStream.close();
                result.put(multipartFile.getName(), multipartFile.getOriginalFilename());
            }
        }
        return result;
    }
}
