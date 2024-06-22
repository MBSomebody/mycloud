package ryan.cloud.myapp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"ryan.cloud.myapp.dao.mapper"})
public class MyBatisConfig {
}
