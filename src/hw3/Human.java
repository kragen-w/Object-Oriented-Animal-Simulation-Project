package hw3;

import java.util.List;
import java.util.ArrayList;

import edu.du.dudraw.Draw;

public class Human extends Avatar {
	List<GridPoint> path;
	boolean atlocation;

	public Human(TerrainMap map, GridPoint location) {
		super(map, location);
		path = new ArrayList<GridPoint>();
		atlocation = true;
		
	}
	
	public void startMove(PathFinder thePath, double x, double y) {
		GridPoint destination = new GridPoint((int) x, (int) y);
		path = thePath.findPath(location, destination);
		atlocation = false;
	
	}
	
	public void move() {
		if(!atlocation) {
			GridPoint nextLocation = path.remove(0);
			location = nextLocation;
			if (path.size() == 0) {
				atlocation = true;
			}
			
		}
//		SimWindow.mouseClicked(arg1, arg2);
//		List<GridPoint> list = PathFinder.findPath(location, location);
	}
	
	public void draw(Draw duDwin) {
		duDwin.picture(location.getX()+.5, location.getY()+.5, "human.png", 1, 1);
	}
	
}

