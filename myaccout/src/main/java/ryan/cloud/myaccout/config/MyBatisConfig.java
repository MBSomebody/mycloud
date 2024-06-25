package ryan.cloud.myaccout.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"ryan.cloud.myaccount.dao.mapper"})
public class MyBatisConfig {
}
