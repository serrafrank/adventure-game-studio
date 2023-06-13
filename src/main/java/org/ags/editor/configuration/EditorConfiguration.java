package org.ags.editor.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:editor.properties")
@ConfigurationProperties
@Data
@NoArgsConstructor
public class EditorConfiguration {

    @Value("${application.title}")
    private String title;

    @Value("${application.version}")
    private String version;

    private Integer foregroundFPS;

}
