package hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.du.dudraw.Draw;

public class Turtle extends VegetationAvatar {
	public Turtle(TerrainMap map, GridPoint location) {
		super(map, location);
	}
	
	public void move() {
	
		//in water
		if (theMap.theTiles.get(theMap.getGridPoint(location)).getWet() == 1) {
			int randomInt = (int) (Math.random() * 2);
			if (randomInt == 1) {
				List<GridPoint> neighbors = location.getNeighbors(1);
				ArrayList<GridPoint> possibleSpots = new ArrayList<GridPoint>();
				for (GridPoint n:neighbors) {
					if (theMap.theTiles.get(theMap.getGridPoint(n)).getWet() == 1 || theMap.theTiles.get(theMap.getGridPoint(n)).getVeg() > 0) {
						possibleSpots.add(n);
						
						
					}
				}
				int randomNeighbor = (int) (Math.random() * possibleSpots.size());
				this.location = possibleSpots.get(randomNeighbor);
				if(theMap.theTiles.get(theMap.getGridPoint(location)).getVeg() > 0) {
					lowerVeg();
				}
			}
		}
				
			
		
		//on land
		else if (theMap.theTiles.get(theMap.getGridPoint(location)).getVeg() > -20) {
			int randomInt = (int) (Math.random() * 10);
			if (randomInt == 0) {
				List<GridPoint> neighbors = location.getNeighbors(1);
				ArrayList<GridPoint> possibleSpots = new ArrayList<GridPoint>();
				for (GridPoint n:neighbors) {
					if (theMap.theTiles.get(theMap.getGridPoint(n)).getWet() == 1) {
						possibleSpots.add(n);
					}
					else if (theMap.theTiles.get(theMap.getGridPoint(n)).getVeg() > 0 ){
						int nInfo = theMap.theTiles.get(theMap.getGridPoint(n)).getVeg();
						int hereInfo = theMap.theTiles.get(theMap.getGridPoint(location)).getVeg();
						
						if (nInfo >= hereInfo) {
							possibleSpots.add(n);;
						}
					}
				}
			
				int randomNeighbor = (int) (Math.random() * possibleSpots.size());
				this.location = possibleSpots.get(randomNeighbor);
				if(theMap.theTiles.get(theMap.getGridPoint(location)).getVeg() > 0) {
					lowerVeg();
	
				}
			}
		}
			

		
//		
	
		}
		
		
//		this.location = neighbors.get(0);
		
	
	public void draw(Draw duDwin) {
		if (theMap.theTiles.get(theMap.getGridPoint(location)).getWet() == 1) {
			duDwin.picture(location.getX()+.5, location.getY()+.5, "seaturtle.png", 1, 1);
		}
		else{
			duDwin.picture(location.getX()+.5, location.getY()+.5, "turtle.png", 1, 1);
		}
	}
}
