package dengzhenzhang.top.unibook_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("dengzhenzhang.top.unibook_back.mapper")
public class UnibookBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnibookBackApplication.class, args);
    }

}
