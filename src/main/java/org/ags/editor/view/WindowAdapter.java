package org.ags.editor.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.ags.editor.publisher.APIMessage;
import org.ags.editor.publisher.EventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WindowAdapter extends ApplicationAdapter {

	private final EventPublisher eventPublisher;

	private SpriteBatch batch;
	private Texture img;

	@Override
	public void create() {
		eventPublisher.publish(APIMessage.CREATE);

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
		ScreenUtils.clear(.25F, .25F, .25F, 1);
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
		eventPublisher.publish("APIMessage.DISPOSE");

		batch.dispose();
		img.dispose();
	}
}
