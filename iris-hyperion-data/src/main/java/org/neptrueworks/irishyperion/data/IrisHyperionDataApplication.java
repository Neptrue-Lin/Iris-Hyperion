package org.neptrueworks.irishyperion.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.neptrueworks.irishyperion.data.persistence.mapping")
public class IrisHyperionDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(IrisHyperionDataApplication.class, args);
    }

}
