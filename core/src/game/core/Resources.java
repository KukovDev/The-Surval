package game.core;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.*;

//
// Класс ресурсов.
// В частности нужен для визуализации их существования.
//

public class Resources {
    public ArrayMap<String, Sprite> Resources;
    public final String Bonfire   = "bonfire-res";
    public final String Snowland  = "snowland-res";
    public final String Stoneland = "stoneland-res";
    public final String Iceland   = "iceland-res";
    public final String NullRes   = "nullres-res";

    public Resources() {
        Resources = new ArrayMap<>();

        Resources.put(Bonfire,   Core.AssetsData.Bonfire.get(0));
        Resources.put(Snowland,  Core.AssetsData.Snowland.get(0));
        Resources.put(Stoneland, Core.AssetsData.Stoneland.get(0));
        Resources.put(Iceland,   Core.AssetsData.Iceland.get(0));
        Resources.put(NullRes,   Core.AssetsData.NullBlock);
    }

    public void dispose() {
        Resources.clear();
    }
}
