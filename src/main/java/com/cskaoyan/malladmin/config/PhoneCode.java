package com.cskaoyan.malladmin.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * @Author: Qiu
 * @Date: 2019/5/28 16:21
 */
public class PhoneCode {


    public static String getPhoneMsg(String mobile, HttpServletRequest req) {

        mobile = mobile.substring(11, mobile.length() - 2);

        if (mobile == null || mobile == "") {
            System.out.printf(mobile);
            return "手机号为空";
        }
        System.setProperty(PhoneStaticParam.defaultConnectTimeout, PhoneStaticParam.Timeout);
        System.setProperty(PhoneStaticParam.defaultReadTimeout, PhoneStaticParam.Timeout);

        final String product = PhoneStaticParam.product;
        final String domain = PhoneStaticParam.domain;

        final String accessKeyId = PhoneStaticParam.accessKeyId;
        final String accessKeySecret = PhoneStaticParam.accessKeySecret;

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product,
                    domain);
        } catch (ClientException e1) {
            e1.printStackTrace();
        }

        String code = "";

        for (int i = 0; i < 6; i++) {

            Random random = new Random();
            int i1 = random.nextInt(9);
            code = code + i1;
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(mobile);
        request.setSignName(PhoneStaticParam.SignName);
        request.setTemplateCode(PhoneStaticParam.TemplateCode);

        request.setTemplateParam("{ \"code\":\"" + code + "\"}");

        request.setOutId("yourOutId");

        SendSmsResponse sendSmsResponse;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null
                    && sendSmsResponse.getCode().equals("OK")) {
                HttpSession session = req.getSession();
                session.setAttribute("code", code);
            } else {
                System.out.println(sendSmsResponse.getCode());
                System.out.println("获取验证码失败...");
                return "获取验证码失败...";
            }

        } catch (ServerException e) {
            e.printStackTrace();
            return "由于系统维护，暂时无法注册！！！";
        } catch (ClientException e) {
            e.printStackTrace();
            return "由于系统维护，暂时无法注册！！！";
        }


        return "true";


    }


}
