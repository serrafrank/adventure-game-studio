package org.ags.editor;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.ags.editor.configuration.EditorConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Main implements CommandLineRunner {

    private static final int WIDTH = Math.max((int) (Lwjgl3ApplicationConfiguration.getDisplayMode().width * 0.75),
        1920 / 2);
    private static final int HEIGHT = Math.max((int) (Lwjgl3ApplicationConfiguration.getDisplayMode().height * 0.75),
        1080 / 2);

    private final EditorConfiguration editorConfiguration;

    public Main(EditorConfiguration editorConfiguration) {
        this.editorConfiguration = editorConfiguration;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("Starting application with configuration: {}", editorConfiguration);

        Lwjgl3ApplicationConfiguration config = getLwjgl3ApplicationConfiguration();
        log.debug("Application configuration: width={}, height={}", WIDTH, HEIGHT);
        new Lwjgl3Application(new WindowAdapter(), config);
    }

    private Lwjgl3ApplicationConfiguration getLwjgl3ApplicationConfiguration() {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle(editorConfiguration.getTitle() + " - " + editorConfiguration.getVersion());
        config.setResizable(true);
        config.useVsync(true);
        config.setWindowedMode(WIDTH, HEIGHT);
        return config;
    }
}