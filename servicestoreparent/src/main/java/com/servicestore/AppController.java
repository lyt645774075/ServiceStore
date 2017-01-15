package com.servicestore;

import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.omg.CORBA.Object;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Maps;

import javax.servlet.http.HttpSession;

/**
 * @author 天脉(yangtao.lyt)
 * @version 2017年01月12 14:19
 */
@RestController
@SpringBootApplication
public class AppController {

    private static RestTemplate  restTemplate = new RestTemplate();

    private static String appId        = "wxdf653ebffb699039";

    private static String appSecret    = "d382d76a0db18c6afbe798459a7d9a98";

    private static String grantType    = "authorization_code";




    @RequestMapping("/")
    String home(HttpSession session) {

        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    @RequestMapping("/author")
    Map<String, String> q() {
        Map<String, String> result = Maps.newHashMap();

        result.put("name", "李洋涛");

        return result;
    }

    @RequestMapping("/session/{code}")
    JSONObject getSession(@PathVariable String code) {

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&grant_type={grant_type}&js_code={js_code}";

        Map<String, String> paraMap = Maps.newHashMap();
        paraMap.put("appid", appId);
        paraMap.put("secret", appSecret);
        paraMap.put("grant_type", grantType);
        paraMap.put("js_code", code);

        restTemplate.setMessageConverters(Lists.newArrayList(fastJsonHttpMessageConverters()));

        JSONObject result = restTemplate.getForObject(url, JSONObject.class, paraMap);

        return result;
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppController.class, args);
    }
}
