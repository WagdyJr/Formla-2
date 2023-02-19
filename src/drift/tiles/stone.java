package drift.tiles;
import drift.gfx.Assests;

public class stone extends Tile {

    public stone(int id) {
        super(Assests.stone2, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}