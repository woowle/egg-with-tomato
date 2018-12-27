package com.woowle.eggwithtomato;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.woowle.eggwithtomato.common.globalSource.GlobalGson;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@EnableEurekaClient
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.woowle.eggwithtomato.mapper")
public class EggWithTomatoApplication {

  public static void main(String[] args) {
    SpringApplication.run(EggWithTomatoApplication.class, args);
  }

  @Bean
  public HttpMessageConverters fastJsonHttpMessageConverters() {
    // 1.定义一个converters转换消息的对象
    GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
//    Gson gson = new Gson().newBuilder().enableComplexMapKeySerialization().serializeNulls()
//        .setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting() //对结果进行格式化，增加换行
//        .disableHtmlEscaping().create(); //防止特殊字符出现乱码;
    // 3.在converter中添加配置信息
    gsonHttpMessageConverter.setGson(GlobalGson.Gson());
    // 4.将converter赋值给HttpMessageConverter
    HttpMessageConverter<?> converter = gsonHttpMessageConverter;
    // 5.返回HttpMessageConverters对象
    return new HttpMessageConverters(converter);
  }


}

