package game.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.backends.lwjgl3.*;
import com.badlogic.gdx.tools.texturepacker.*;

//
// Модуль для запуска игры под пк.
//

public class DesktopLauncher {
	public static void main (String[] arg) {
		try { // Обработчик ошибок нужен затем что если игра скомпилирована, он не пытался создать новые атласы.
			GeneratingAtlases();
		} catch(Exception ignored) { }

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowIcon(Files.FileType.Internal, "sprites/icons/icon.png"); // Установить иконку окна (кроме MacOS).
		config.setWindowedMode(960, 540);                                     // Установить размер окна.
		new Lwjgl3Application(new Core(), config);                                        // Применить конфигурацию.
	}

	// Эта функция создаёт атласы:
	public static void GeneratingAtlases() {
		// Атлас существ:
		TexturePacker.process(
				"core/assets/sprites/actors/",
				"core/assets/sprites/atlases/",
				"actors");

		// Атлас блоков:
		TexturePacker.process(
				"core/assets/sprites/blocks/",
				"core/assets/sprites/atlases/",
				"blocks");

		// Атлас окружающей среды:
		TexturePacker.process(
				"core/assets/sprites/env/",
				"core/assets/sprites/atlases/",
				"env");

		// Атлас ресурсов:
		TexturePacker.process(
				"core/assets/sprites/resources/",
				"core/assets/sprites/atlases/",
				"resources");

		// Атлас интерфейса:
		TexturePacker.process(
				"core/assets/sprites/ui/",
				"core/assets/sprites/atlases/",
				"ui");
	}
}
