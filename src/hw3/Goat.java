package hw3;

import java.util.ArrayList;
import java.util.List;

import edu.du.dudraw.Draw;

public class Goat extends Avatar {
	
	public Goat(TerrainMap map, GridPoint location) {
		super(map, location);
	}
	public void move() {
		int randomInt = (int) (Math.random() * 2);
		if (randomInt == 0) {
			List<GridPoint> neighbors = location.getNeighbors(1);
			ArrayList<GridPoint> possibleSpots = new ArrayList<GridPoint>();
			for (GridPoint n:neighbors) {
				if (theMap.theTiles.get(theMap.getGridPoint(n)).getBumpy() > 0) {
					possibleSpots.add(n);
				}
				}
			int randomNeighbor = (int) (Math.random() * possibleSpots.size());
			this.location = possibleSpots.get(randomNeighbor);	
			}

		
	}
	@Override
	public void draw(Draw duDwin) {
		duDwin.picture(location.getX()+.5, location.getY()+.5, "goat.png", 1, 1);
		
	}
}
