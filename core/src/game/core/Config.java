package game.core;

//
// Конфигурационный класс.
// Хранит конфигурацию игры.
//

public class Config {
    // Конфигурация окна:
    public static final String  WindowTitle = "The Surval";    // Заголовок окна.
    public static final boolean WindowResiz = true;            // Изменение размера окна.
    public static boolean       VSync       = false;           // Вертикальная синхронизация.
    public static int           FPS         = 1024;            // Кол-во кадров в секунды.

    // Конфигурация игрового процесса:
    public static final int ChunkWidth  = 16; // Ширина чанка.
    public static final int ChunkHeight = 16; // Высота чанка.

    // Прочее:
    public static final String Version = "alpha-v0.1"; // Версия игры.
}
