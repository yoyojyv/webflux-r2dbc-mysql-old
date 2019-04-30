//package me.jerry.example.webflux;
//
//import com.github.jasync.r2dbc.mysql.JasyncConnectionFactory;
//import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory;
//import com.github.jasync.sql.db.mysql.util.URLParser;
//import io.r2dbc.spi.ConnectionFactory;
//import me.jerry.example.webflux.employee.EmployeeRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.r2dbc.function.DatabaseClient;
//import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
//import org.springframework.data.relational.core.mapping.RelationalMappingContext;
//
//import java.nio.charset.StandardCharsets;
//
//@Configuration
//public class MysqlApplicationConfiguration {
//
//    @Bean
//    public EmployeeRepository repository(R2dbcRepositoryFactory factory)  {
//        return factory.getRepository(EmployeeRepository.class);
//    }
//
//    @Bean
//    public DatabaseClient  databaseClient(ConnectionFactory factory)  {
//        return DatabaseClient.builder().connectionFactory(factory).build();
//    }
//
//    @Bean
//    public R2dbcRepositoryFactory factory(DatabaseClient client)  {
//        RelationalMappingContext context = new RelationalMappingContext();
//        context.afterPropertiesSet();
//        return new R2dbcRepositoryFactory(client, context);
//    }
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        String url = "mysql://test:test@127.0.0.1:3306/test";
//        return new JasyncConnectionFactory(new MySQLConnectionFactory(URLParser.INSTANCE.parseOrDie(url, StandardCharsets.UTF_8)));
//    }
//
//}
