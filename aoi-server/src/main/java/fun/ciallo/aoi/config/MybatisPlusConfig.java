package fun.ciallo.aoi.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("fun.ciallo.aoi.mapper")
public class MybatisPlusConfig {
}
