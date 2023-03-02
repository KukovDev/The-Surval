package game.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.utils.*;
import game.screens.*;

//
// Ядро игры.
// Тут реализованы разные полезные функции.
// Этот класс - Первое, что исполняется при запуске игры.
//

public class Core extends Game {
	@Override public void create () {
		// Настройка окна:
		Gdx.graphics.setTitle(Config.WindowTitle + " • " + Config.Version);    // Заголовок окна.
		Gdx.graphics.setResizable(Config.WindowResiz);                         // Масштабируемость окна.
		Gdx.graphics.setForegroundFPS(Config.FPS);                             // Установить FPS.
		Gdx.graphics.setVSync(Config.VSync);                                   // Вертикальная синхронизация.

		setScreen(new GameScreen());    // Переключиться на другой скрин.
	}

	@Override public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
	}
	
	@Override public void dispose () {
		//
	}
}
