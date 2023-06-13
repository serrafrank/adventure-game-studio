package org.ags.editor;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ags.editor.configuration.EditorConfiguration;
import org.ags.editor.view.WindowAdapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class Main implements CommandLineRunner {

    private final EditorConfiguration editorConfiguration;
    private final WindowAdapter windowAdapter;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("Starting application with configuration: {}", editorConfiguration);

        new Lwjgl3Application(windowAdapter, createConfig());
    }


    private Lwjgl3ApplicationConfiguration createConfig() {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle(editorConfiguration.getWindowTitle() + " - V" + editorConfiguration.getVersion());
        config.setWindowedMode(editorConfiguration.getWindowWidth(), editorConfiguration.getWindowHeight());
        config.setIdleFPS(60);
        config.setForegroundFPS(editorConfiguration.getForegroundFPS());
        config.useVsync(false);
        config.useVsync(false);
        //  config.setInitialVisible(false);
        //  config.setMaximized(true);
        return config;
    }
}
