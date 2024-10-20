package hw3;

import java.util.HashMap;
import edu.du.dudraw.Draw;

public abstract class Avatar {

	public TerrainMap theMap;
	public GridPoint location;
	
	public Avatar(TerrainMap map, GridPoint location) {
		this.theMap = map;
		this.location = location;
		;
	}
	
	public abstract void draw(Draw duDwin);
	public abstract void move();
}
