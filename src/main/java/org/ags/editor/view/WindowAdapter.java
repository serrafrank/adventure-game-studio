package org.ags.editor.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.kotcrab.vis.ui.VisUI;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.ags.editor.events.APIMessage;
import org.ags.editor.events.publisher.EventPublisher;
import org.ags.editor.managers.AssetsManager;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class WindowAdapter extends ApplicationAdapter {

    private final AssetsManager assetsManager;
    private final EventPublisher eventPublisher;

    private SpriteBatch batch;
    private Texture img;

    @SneakyThrows
    @Override
    public void create() {
        eventPublisher.publish(APIMessage.CREATE);
        VisUI.load(assetsManager.uiSkin());
        VisUI.setDefaultTitleAlign(Align.center);


        batch = new SpriteBatch();
        img = new Texture("assets/badlogic.jpg");

    }

    @Override
    public void pause() {
        eventPublisher.publish(APIMessage.PAUSE);
    }

    @Override
    public void resume() {
        eventPublisher.publish(APIMessage.RESUME);
    }

    @Override
    public void render() {
        // ScreenUtils.clear(.25F, .25F, .25F, 1);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        eventPublisher.publish(APIMessage.RESIZE, Map.of("width", width, "height", height));
    }

    @Override
    public void dispose() {
        eventPublisher.publish(APIMessage.DISPOSE);
        VisUI.dispose();
        eventPublisher.publish(APIMessage.CHECK_EDITS_ACTION, (Runnable) () -> Gdx.app.exit());
    }
}
