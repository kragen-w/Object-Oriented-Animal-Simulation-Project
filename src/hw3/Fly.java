package hw3;

import java.util.ArrayList;
import java.util.List;

import edu.du.dudraw.Draw;

public class Fly extends Avatar {
	
	public Fly(TerrainMap map, GridPoint location) {
		super(map, location);
	}
	public void move() {
		int randomInt = (int) (Math.random() * 2);
		if (randomInt == 0) {
			List<GridPoint> neighbors = location.getNeighbors(1);
			ArrayList<GridPoint> possibleSpots = new ArrayList<GridPoint>();
			for (GridPoint n:neighbors) {
				possibleSpots.add(n);
				}
			int randomNeighbor = (int) (Math.random() * possibleSpots.size());
			this.location = possibleSpots.get(randomNeighbor);	
			}

		
	}
	@Override
	public void draw(Draw duDwin) {
		duDwin.picture(location.getX()+.5, location.getY()+.5, "fly.png", 1, 1);
		
	}
}
