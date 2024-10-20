package hw3;

public class AvatarFactory {

	public static Avatar newAvatar(String aviName, TerrainMap tm, GridPoint loc) throws BadAvatarException{
		Avatar avatar = null;
		if (aviName.equals("lizard")) {
			avatar = new Lizard(tm, loc);
		}
		else if (aviName.equals("turtle")) {
			avatar = new Turtle(tm, loc);
		}
		else if (aviName.equals("human")) {
			avatar = new Human(tm, loc);
		}
		else if (aviName.equals("fly")) {
			avatar = new Fly(tm, loc);
		}
		else if (aviName.equals("goat")) {
			avatar = new Goat(tm, loc);
		}
		else {
			
			throw new BadAvatarException("There is no avatar with this name");
			
		}
		return avatar;
	}
}
