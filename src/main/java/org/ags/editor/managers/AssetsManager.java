package org.ags.editor.managers;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import lombok.RequiredArgsConstructor;
import org.ags.editor.configuration.EditorConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AssetsManager {

    private final EditorConfiguration editorConfiguration;
    private final ResourceLoader resourceLoader;

    public Skin uiSkin() throws IOException {

        final FileHandle uiSkinHandler = this.handleFile(editorConfiguration.getUiSkinFile());
        final FileHandle uiSkinAtlasHandler = this.handleFile(editorConfiguration.getUiSkinAtlasFile());

        final TextureAtlas uiSkinTextureAtlas = new TextureAtlas(uiSkinAtlasHandler);
        return new Skin(uiSkinHandler, uiSkinTextureAtlas);
    }


    public FileHandle handleFile(String fileName) throws IOException {
        final Resource resource = resourceLoader.getResource(fileName);
        return new FileHandle(resource.getFile());
    }

}
