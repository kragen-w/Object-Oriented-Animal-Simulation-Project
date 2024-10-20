package hw3;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

import java.util.ArrayList;
import java.util.HashMap;


public class SimWindow implements DrawListener {

	// Some static constants that everyone can use
	//   the represent the window size
	public final static int windowWidth = 1050;
	public final static int windowHeight = 700;
	
	private TerrainMap tm;
	private Draw duDwin;
	private ArrayList<Avatar> avatars;
	private ArrayList<Human> humanAvatar;

	

	public SimWindow(TerrainMap tm) {
		this.avatars = new ArrayList<>();
		humanAvatar = new ArrayList<Human>();
		

		// Setup the DuDraw window
		duDwin = new Draw("COMP2381 Animal Simulation"); // The OO version of DUDraw
		duDwin.setCanvasSize(SimWindow.windowWidth, SimWindow.windowHeight);
		duDwin.enableDoubleBuffering(); // Too slow otherwise -- need to use .show() later
		// Set the scale of the window
		// Right now it is set to match the pixels
		duDwin.setXscale(0, tm.gridWidth);
		duDwin.setYscale(0, tm.gridHeight);
		
		duDwin.addListener(this);
		
		this.tm = tm;
		try {
			avatars.add(AvatarFactory.newAvatar("lizard", tm, new GridPoint(9,11)));
			avatars.add(AvatarFactory.newAvatar("turtle", tm, new GridPoint(12,15)));
			avatars.add(AvatarFactory.newAvatar("fly", tm, new GridPoint(15,20)));
			avatars.add(AvatarFactory.newAvatar("goat", tm, new GridPoint(8,0)));
			Avatar Human = AvatarFactory.newAvatar("human", tm, new GridPoint(15,15));
			avatars.add(Human);
			humanAvatar.add((Human) Human);
			




		}
		catch(BadAvatarException B) {
			System.out.println(B);
			
		}
	}

	public void update() {
		
		duDwin.clear();
		tm.draw(duDwin);
		for (Avatar a:avatars) {
			a.draw(duDwin);
			a.move();
		}
		int randomInt = (int) (Math.random() * 100);
		if (randomInt == 1) {
			tm.regrow();
		}
		duDwin.show();  // used in double buffering
	}

	public void runSimulation() {
		// This is the main game loop
		update(); // Initial positing
		while(true) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			update();
		}	
	}

	
	public void mouseDragged(Double d, Double p) {
		
	}

	@Override
	public void keyPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(char arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {

		
	}

	@Override
	public void mouseDragged(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(double arg0, double arg1) {
		for (Human a:humanAvatar) {
			a.startMove(new PathFinder(tm), arg0, arg1);
		}
		
	}

	@Override
	public void mouseReleased(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}
	
}