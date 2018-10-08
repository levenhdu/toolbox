package xyz.leven.toolbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.leven.toolbox.entity.Tool;

@Configuration
public class AppConfig {

    @Bean
    Tool myTool() {
        Tool tool = new Tool();
        tool.setId(2);
        tool.setName("myTool");
        return tool;
    }

}
