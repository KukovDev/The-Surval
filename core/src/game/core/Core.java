package game.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.graphics.g2d.freetype.*;
import game.screens.*;

//
// Ядро игры.
// Тут реализованы разные полезные функции.
// Этот класс - Первое, что исполняется при запуске игры.
//

public class Core extends Game {
	public static Assets AssetsData;    // Класс ассетов.

	@Override public void create () {
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(new InputHandler());
		Gdx.input.setInputProcessor(multiplexer);

		// Настройка окна:
		Gdx.graphics.setTitle(Config.WindowTitle + " • " + Config.Version);    // Заголовок окна.
		Gdx.graphics.setResizable(Config.WindowResiz);                         // Масштабируемость окна.
		Gdx.graphics.setForegroundFPS(Config.FPS);                             // Установить FPS.
		Gdx.graphics.setVSync(Config.VSync);                                   // Вертикальная синхронизация.

		AssetsData = new Assets();    // Создать экземпляр класса ассетов.
		AssetsData.AssetsLoad();      // Загрузить ассеты.

		setScreen(new GameScreen());    // Переключиться на другой скрин.
	}

	@Override public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
	}
	
	@Override public void dispose () {
		AssetsData.dispose();
	}

	// Функция для получения текущего FPS:
	public static int GetFPS() { return Gdx.graphics.getFramesPerSecond(); }

	// Передвигается ли мышь/палец:
	public static boolean IsTouchDrag() {
		boolean istouchdrag = InputHandler.touchdrag;
		InputHandler.touchdrag = false;
		return istouchdrag;
	}

	// Функция для получения скролла на PC:
	public static float GetScroll() {
		float scroll = InputHandler.scroll;
		if(scroll != 0f) InputHandler.scroll = 0f;
		return scroll;
	}

	// Получить новый шрифт:
	public static BitmapFont FontUpdateParameters(String FontLink, FreeTypeFontGenerator.FreeTypeFontParameter parameters) {
		return new FreeTypeFontGenerator(Gdx.files.internal(FontLink)).generateFont(parameters);
	}

	// Получить платформу (пк или мобильное устройство):
	public static String GetPlatform() {
		if(Gdx.app.getType() == Application.ApplicationType.Android ||
				Gdx.app.getType() == Application.ApplicationType.iOS) return "mobile";
		return "desktop";
	}
}
