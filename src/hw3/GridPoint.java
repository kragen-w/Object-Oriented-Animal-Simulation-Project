package hw3;

import java.util.ArrayList;
import java.util.List;


/*
 * Class to represent an x and y grid location.
 * 
 */
public class GridPoint implements Comparable<GridPoint>{
	private int x;
	private int y;
	public GridPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(GridPoint that)
	{
		return this.getX() - that.getX();

	}
	public boolean equals(Object that)
	{
		GridPoint gp = (GridPoint) that;
		if (this.getX() == that.getX() & this.getY() == that.getY()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "X Coordinate: "+ x +", Y Coordinate: " + y;
	}
	
	public int hashCode() {
		return this.toString().hashCode();
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public List<GridPoint> getNeighbors(int levels){
		List<GridPoint> list;
		list = new ArrayList<>();
		for (int i = x-levels; i < x + levels + 1; i++) {
			for (int j = y-levels; j < y + levels + 1; j++) {
				if (i < 0 || j < 0) {
					continue;
				}
				else if (i == x & j == y) {
					continue;
				}
				else if (TerrainMap.gridWidth-1 < i || TerrainMap.gridHeight-1 < j) {
					continue;
				}
				list.add(new GridPoint(i,j));	
			} 
		}
		return list;
	}
}
