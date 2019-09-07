package cn.azzhu.myo2o;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("cn.azzhu.myo2o.mapper")
@ImportResource(locations = {"classpath:kaptcha.xml"})
public class Myo2oApplication {

    public static void main(String[] args) {
        SpringApplication.run(Myo2oApplication.class, args);
    }

}
