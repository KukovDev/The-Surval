package game.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;

//
// Нужен для получения данных о вводе по типу нажатий, перемещения мыши и тд.
//

public class InputHandler implements InputProcessor {
    public static float scroll;
    public static boolean touchdrag;
    public static Vector2 touchdown = new Vector2();
    public static int touchdownbutton = -1;

    @Override public boolean keyDown (int keycode) {
        return false;
    }

    @Override public boolean keyUp (int keycode) {
        return false;
    }

    @Override public boolean keyTyped (char character) {
        return false;
    }

    @Override public boolean touchDown (int x, int y, int pointer, int button) {
        touchdown.x = x; touchdown.y = y;
        touchdownbutton = button;
        return false;
    }

    @Override public boolean touchUp (int x, int y, int pointer, int button) {
        touchdownbutton = -1;
        return false;
    }

    @Override public boolean touchDragged (int x, int y, int pointer) {
        touchdrag = true;
        return false;
    }

    @Override public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override public boolean scrolled(float amountX, float amountY) {
        scroll = amountY;
        return false;
    }
}
