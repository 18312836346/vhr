package com.niit.vhr.controller;

import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RestController
@Api(value = "验证码")
public class VerifyCodeController {
    @Resource
    Producer defaultKaptcha;
    @GetMapping("/verifyCode")
    @ApiOperation(value = "生成验证码")
    public  void verify(HttpServletRequest request, HttpServletResponse response)
    throws Exception{
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control","no-store,no-cache,must-revalidate");
        response.addHeader("Cache-Control","post-check=0,pre-check=0");
        response.setHeader("Pragma","no-cache");
        response.setContentType("image/jpeg");

        String  code = defaultKaptcha.createText();
        request.getSession().setAttribute("verify_code",code);

        ServletOutputStream out = response.getOutputStream();
        BufferedImage image = defaultKaptcha.createImage(code);
        ImageIO.write(image,"JPEG",out);
        out.flush();
        out.close();
    }
}
