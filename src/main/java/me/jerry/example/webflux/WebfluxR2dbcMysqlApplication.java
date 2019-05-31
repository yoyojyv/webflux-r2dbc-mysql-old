package me.jerry.example.webflux;

import com.github.jasync.r2dbc.mysql.JasyncConnectionFactory;
import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory;
import com.github.jasync.sql.db.mysql.util.URLParser;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class WebfluxR2dbcMysqlApplication {

    public static void main(String[] args) {
        // lazy init
        // System.setProperty("spring.main.lazy-initialization", "true");
        SpringApplication.run(WebfluxR2dbcMysqlApplication.class, args);
    }

}

// 분리하면 repository 가 등록이 안됨
@Configuration
@EnableR2dbcRepositories
class MysqlApplicationConfiguration extends AbstractR2dbcConfiguration {

    @Override
    public ConnectionFactory connectionFactory() {
        String url = "mysql://test:test@127.0.0.1:3306/test";
         return new JasyncConnectionFactory(new MySQLConnectionFactory(URLParser.INSTANCE.parseOrDie(url, StandardCharsets.UTF_8)));
    }

}
