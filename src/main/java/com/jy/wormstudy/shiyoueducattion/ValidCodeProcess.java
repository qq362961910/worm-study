package com.jy.wormstudy.shiyoueducattion;

import com.jy.util.io.FileUtil;
import com.jy.util.media.code.ValidCodeHelper;
import net.sourceforge.tess4j.TesseractException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ValidCodeProcess {

    private static final Logger logger = LoggerFactory.getLogger(ValidCodeProcess.class);

    private ValidCodeHelper validCodeHelper;
    private String url;

    public void requestValidateCode(AuthenticationHolder authenticationHolder) throws TesseractException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).GET().build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        //1.save jsessionid
        String cookieStr = response.headers().firstValue("set-cookie").orElse("");
        String[] cookieStrs = cookieStr.split(",");
        for(String str: cookieStrs) {
            String[] elements = str.trim().split(";");
            if(elements[0].startsWith("JSESSIONID")) {
                logger.info("load image response jsessionid: {}", str);
                String[] entry = elements[0].split("=");
                if(entry.length > 1) {
                    authenticationHolder.setCenterSessionId(entry[1]);
                } else {
                    logger.error("no JSESSIONID found in load image response");
                }
            }
        }
        //save image to tmp
        String imagePath = FileUtil.saveToTempDir(response.body(), response.headers().firstValue("Content-Type").orElse("null"));
        logger.info("image path: {}", imagePath);
        authenticationHolder.setValidateCode(validCodeHelper.analyseImageCode(new File(imagePath)));
        logger.info("auth: {}", authenticationHolder);
    }

    public ValidCodeProcess(ValidCodeHelper validCodeHelper, String url) {
        this.validCodeHelper = validCodeHelper;
        this.url = url;
    }
}
