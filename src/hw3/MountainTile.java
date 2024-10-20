package hw3;

import edu.du.dudraw.Draw;

public class MountainTile extends TerrainTile{
	public int vegetation;
	public int bumpyness;
	protected MountainTile (GridPoint location) {
		super(location);
		this.vegetation = (int)(Math.random()*50);
		bumpyness = 5;
	}
	public void setColor(Draw duDwin) {
		int G = vegetation;
		duDwin.setPenColor(100, 50+G, 100);
	}
	
	public void lowerVeg() {
		vegetation -= 0;
	}
	public int getBumpy() {
		return bumpyness;
	}	
		
	
}

