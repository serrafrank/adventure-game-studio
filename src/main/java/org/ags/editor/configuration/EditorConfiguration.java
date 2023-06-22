package org.ags.editor.configuration;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
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
    private String windowTitle;

    @Value("${application.version}")
    private String version;

    private Integer foregroundFPS;
    private String uiSkinFile;
    private String uiSkinAtlasFile;

    private Integer windowWidth = Math.max((int) (Lwjgl3ApplicationConfiguration.getDisplayMode().width * 0.75),
            1920 / 2);
    private Integer windowHeight = Math.max((int) (Lwjgl3ApplicationConfiguration.getDisplayMode().height * 0.75),
            1080 / 2);

}
