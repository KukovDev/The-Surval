package game.core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.freetype.*;
import com.badlogic.gdx.utils.*;

//
// Класс содержащий игровые ресурсы по типу спрайтов, звуков, и тд.
//

public class Assets {
    public Resources resources;

    // Атлас живых существ:
    public TextureAtlas actors_atlas;

    // Атлас блоков:
    public TextureAtlas blocks_atlas;

    // Атлас окружающей среды:
    public TextureAtlas env_atlas;

    // Атлас ресурсов:
    public TextureAtlas resources_atlas;

    // Атлас ui:
    public TextureAtlas ui_atlas;

    // ------------------------ Списки спрайтов: ------------------------

    // Живые существа:
    public Array<Sprite> Player;    // Игрок.

    // Блоки:
    public Array<Sprite> Snowland;     // Снежная поверхность.
    public Array<Sprite> Stoneland;    // Каменная поверхность.
    public Array<Sprite> Iceland;      // Ледяная поверхность.
    public Array<Sprite> Bonfire;      // Костёр.
    public Sprite        NullBlock;    // Неизвестно.

    // Окружающая среда:
    public Array<Sprite> Tree;       // Дерево.
    public Array<Sprite> FirTree;    // Ёлка.

    // Ресурсы:
    public Array<Sprite> Resources;

    // Интерфейс:
    public Array<Sprite> UI;      // Интерфейс.
    public Sprite BorderChunk;    // Граница чанка.

    // Шрифты:
    public BitmapFont PixelFont;    // Пиксельный шрифт (рус-анг символы).

    public Assets() {
        // Атлас живых существ:
        actors_atlas = new TextureAtlas(Gdx.files.internal("sprites/atlases/actors.atlas"));

        // Атлас блоков:
        blocks_atlas = new TextureAtlas(Gdx.files.internal("sprites/atlases/blocks.atlas"));

        // Атлас окружающей среды:
        env_atlas = new TextureAtlas(Gdx.files.internal("sprites/atlases/env.atlas"));

        // Атлас ресурсов:
        resources_atlas = new TextureAtlas(Gdx.files.internal("sprites/atlases/resources.atlas"));

        // Атлас интерфейса:
        ui_atlas = new TextureAtlas(Gdx.files.internal("sprites/atlases/ui.atlas"));

        // Живые существа:
        Player = new Array<>();    // Игрок.

        // Блоки:
        Snowland = new Array<>();     // Снежная поверхность.
        Stoneland = new Array<>();    // Каменная поверхность.
        Iceland = new Array<>();      // Ледяная поверхность.
        Bonfire = new Array<>();      // Костёр.

        // Окружающая среда:
        Tree = new Array<>();       // Дерево.
        FirTree = new Array<>();    // Ёлка.

        // Ресурсы:
        Resources = new Array<>();

        // Интерфейс:
        UI = new Array<>();    // Интерфейс.
    }

    // Загружает ассеты:
    public void AssetsLoad() {
        LoadActors();
        LoadBlocks();
        LoadEnv();
        LoadResources();
        LoadUI();
        LoadFonts();
        resources = new Resources();    // Ресурсы.
    }

    // Удаляет всё что было загружено:
    public void dispose() {
        actors_atlas.dispose();
        blocks_atlas.dispose();
        env_atlas.dispose();
        resources_atlas.dispose();
        ui_atlas.dispose();
        PixelFont.dispose();
        resources.dispose();

        // Не забудьте добавить сюда всё то, что загрузили!

        System.gc();    // Вызвать сборщик мусора JVM.
    }

    // Загрузка живых существ:
    void LoadActors() {
        Player.addAll(
                actors_atlas.createSprite("player-stand"),
                actors_atlas.createSprite("player-run1"),
                actors_atlas.createSprite("player-run2"));
    }

    // Загрузить текстуры блоков:
    void LoadBlocks() {
        Snowland.addAll(
                blocks_atlas.createSprite("snowland1"),
                blocks_atlas.createSprite("snowland2"),
                blocks_atlas.createSprite("snowland3"),
                blocks_atlas.createSprite("snowland-mask1"),
                blocks_atlas.createSprite("snowland-mask2"),
                blocks_atlas.createSprite("snowland-mask3"),
                blocks_atlas.createSprite("snowland-mask4"));
        Stoneland.addAll(
                blocks_atlas.createSprite("stoneland1"),
                blocks_atlas.createSprite("stoneland2"),
                blocks_atlas.createSprite("stoneland3"));
        Iceland.addAll(
                blocks_atlas.createSprite("iceland1"),
                blocks_atlas.createSprite("iceland2"),
                blocks_atlas.createSprite("iceland3"),
                blocks_atlas.createSprite("iceland-mask1"),
                blocks_atlas.createSprite("iceland-mask2"),
                blocks_atlas.createSprite("iceland-mask3"),
                blocks_atlas.createSprite("iceland-mask4"));
        Bonfire.addAll(
                blocks_atlas.createSprite("bonfire1"),
                blocks_atlas.createSprite("bonfire2"),
                blocks_atlas.createSprite("bonfire3"),
                blocks_atlas.createSprite("bonfire4"),
                blocks_atlas.createSprite("bonfire5"),
                blocks_atlas.createSprite("bonfire6"),
                blocks_atlas.createSprite("bonfire7"),
                blocks_atlas.createSprite("bonfire8"),
                blocks_atlas.createSprite("bonfire-new"),
                blocks_atlas.createSprite("bonfire-old"));
        NullBlock = blocks_atlas.createSprite("nullblock");
        BorderChunk = blocks_atlas.createSprite("border-chunk");
    }

    // Загрузить объекты окружающей среды:
    void LoadEnv() {
        Tree.addAll(
                env_atlas.createSprite("tree1"),
                env_atlas.createSprite("tree2"));
        FirTree.addAll(
                env_atlas.createSprite("fir-tree1"),
                env_atlas.createSprite("fir-tree2"));
    }

    // Загрузить ресурсы:
    void LoadResources() {
        Resources.addAll(
                resources_atlas.createSprite("stick"));
    }

    // Загрузить интерфейс:
    void LoadUI() {
        UI.addAll(
                ui_atlas.createSprite("hotbarcell"),
                ui_atlas.createSprite("hotbartargetcell"));
    }

    // Загрузить шрифты:
    void LoadFonts() {
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.size = 14;
        parameters.color = new Color(1f, 1f, 1f, 1f);
        parameters.shadowColor = new Color(0f, 0f, 0f, 1f);
        parameters.shadowOffsetX = 2;
        parameters.shadowOffsetY = 2;
        PixelFont = Core.FontUpdateParameters("fonts/pixel.ttf", parameters);
    }
}
