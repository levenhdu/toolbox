package xyz.leven.toolbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.leven.toolbox.entity.ToolEntity;

@Configuration
public class AppConfig {

    @Bean
    ToolEntity myTool() {
        ToolEntity tool = new ToolEntity();
        tool.setId(2);
        tool.setName("myTool");
        return tool;
    }

}
