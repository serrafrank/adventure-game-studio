package org.ags.editor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.kotcrab.vis.ui.VisUI;

public class WindowAdapter extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture img;

	@Override
	public void create() {

		VisUI.load();

		batch = new SpriteBatch();
		img = new Texture("assets/badlogic.jpg");
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
