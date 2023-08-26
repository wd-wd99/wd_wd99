package com.tencent.wxcloudrun;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import com.tencent.unity.oConvertUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
@Slf4j
@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
//@MapperScan(basePackages = {"com.tencent.wxcloudrun.dao"})
public class WxCloudRunApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(WxCloudRunApplication.class);
  }

  public static void main(String[] args) throws UnknownHostException {
//    SpringApplication.run(WxCloudRunApplication.class, args);
    ConfigurableApplicationContext application = SpringApplication.run(WxCloudRunApplication.class, args);
    Environment env = application.getEnvironment();
    String ip = InetAddress.getLocalHost().getHostAddress();
    String port = env.getProperty("server.port");
    String path = oConvertUtils.getString(env.getProperty("server.servlet.context-path"));
    log.info("\n----------------------------------------------------------\n\t" +
            "Application Jeecg-Boot is running! Access URLs:\n\t" +
            "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
            "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
            "Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
            "----------------------------------------------------------");

  }
}
