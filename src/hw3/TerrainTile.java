package hw3;

import edu.du.dudraw.Draw;

// This is an abstract class
public abstract class TerrainTile implements Drawable {
	
	// Every tile has a location
	public GridPoint location;
//	public int vegetation;
	
	protected TerrainTile (GridPoint location) {
		this.location = location;
	}

	// Draws the tile on the given Window
	public void draw(Draw duDwin) {
		
		setColor(duDwin);
		
		duDwin.filledRectangle(location.getX()+.5, location.getY()+.5, .5, .5);
		// TODO: draw the tile in a standard way
	}
	
	public String toString() {
		return ("hi");
	}
	
	// Part of the draw template for concrete tiles to set the color
	public abstract void setColor(Draw duDwin);
		
	
	public int getVeg() {
		return 0;
	}
	public int getWet() {
		return 0;
	}
	public int getBumpy() {
		return 0;
	}
	
	public void lowerVeg() {
		
	}
	
	public void raiseVeg() {
	
	}
	
}
