package hw3;

import java.util.ArrayList;
import java.util.List;
import edu.du.dudraw.Draw;

public class Lizard extends VegetationAvatar {

	public Lizard(TerrainMap map, GridPoint location) {
		super(map, location);
	}
	
	public void move() {
		int randomInt = (int) (Math.random() * 2);
		if (randomInt == 0) {
			List<GridPoint> neighbors = location.getNeighbors(3);
			ArrayList<GridPoint> possibleSpots = new ArrayList<GridPoint>();
			GridPoint wettest = theMap.theTiles.get(theMap.getGridPoint(location)).location;
			for (GridPoint n:neighbors) {
				if (theMap.theTiles.get(theMap.getGridPoint(n)).getVeg() > 0) {
					possibleSpots.add(n);
					int nInfo = theMap.theTiles.get(theMap.getGridPoint(n)).getVeg();
					int wetInfo = theMap.theTiles.get(theMap.getGridPoint(wettest)).getVeg();
					
					if (nInfo > wetInfo) {
						wettest = n;
					}
				}
			}
			if (location.equals(wettest)){
				int randomNeighbor = (int) (Math.random() * possibleSpots.size());
				this.location = possibleSpots.get(randomNeighbor);
			}
			this.location = wettest;
			
			lowerVeg();
		}
		return;
		
		
		
//		this.location = neighbors.get(0);
		
	}
	
	public void draw(Draw duDwin) {
		duDwin.picture(location.getX()+.5, location.getY()+.5, "lizard.png", 1, 1);
	}
}
