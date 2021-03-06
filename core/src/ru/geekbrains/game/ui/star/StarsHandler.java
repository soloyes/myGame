package ru.geekbrains.game.ui.star;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.stargame.engine.Rect;
import ru.geekbrains.stargame.engine.utils.math.Rnd;

/**
 * Created by sol on 2/6/18.
 * Class for store and manipulate with Star
 */

public class StarsHandler {
    private final int STARS = 80;
    private Star[] stars = new Star[STARS];
    private TextureRegion starTexture;

    public StarsHandler(TextureAtlas atlas) {
        starTexture = atlas.findRegion("star");
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(
                    starTexture,
                    Rnd.nextFloat(-0.05f, 0.05f),
                    Rnd.nextFloat(-0.3f, -0.1f),
                    0.005f);
        }
    }

    public void setVAngle(float angle) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].setV(stars[i].getV().setAngle(angle - 180));
        }
    }

    public void draw(SpriteBatch batch){
        for (int i = 0; i < stars.length; i++) {
            stars[i].draw(batch);
        }
    }

    public void update(float delta){
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(delta);
        }
    }

    public void resize(Rect worldBounds) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].resize(worldBounds);
        }
    }

    public void dispose(){
        starTexture.getTexture().dispose();
    }
}