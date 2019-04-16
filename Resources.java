
public class Resources{
	
	public static Sprite spaceShipFull = new Sprite("SpaceShip Uno.png");
	public static Sprite spaceShipHalf = new Sprite("SpaceShip Uno Yellow.png");
	public static Sprite spaceShipQuart = new Sprite("SpaceShip Uno Red.png");
	
	public static Sprite bullet = new Sprite("Fire Blast.png");
	public static Sprite enemyBulletSprite = new Sprite("toast bullet.png");
	
	public static Sprite meany = new Sprite("Enemy.png");
	public static Sprite meany2 = new Sprite("Enemy 2.png");
	public static Sprite meany3 = new Sprite("Toaster Player 2.png");
	
	public static Sprite background = new Sprite("TileBackground.png");
	
	public static soundEffect laserOne = new soundEffect("Laser_Shoot1.wav");
	public static soundEffect laserTwo = new soundEffect("Laser_Shoot5.wav");
	
	public static soundEffect chainOneSound = new soundEffect("play.wav");
	public static soundEffect chainTwoSound = new soundEffect("wickedsick.wav");
	public static soundEffect chainThreeSound = new soundEffect("ownage.wav");
	public static soundEffect chainFourSound = new soundEffect("monsterkill.wav");
	public static soundEffect chainFiveSound = new soundEffect("killingspree.wav");
	public static soundEffect chainSixSound = new soundEffect("unstoppable2.wav");
	
	public static Sprite splosion1 = new Sprite("Explosion1.png");
	public static Sprite splosion2 = new Sprite("Explosion2.png");
	public static Sprite splosion3 = new Sprite("Explosion3.png");
	
	public static soundEffect song1 = new soundEffect("Beat1.wav");
	public static soundEffect song2 = new soundEffect("Beat2.wav");
	public static soundEffect song3 = new soundEffect("Beat3.wav");
	public static soundEffect song4 = new soundEffect("Beat4.wav");
	public static soundEffect song5 = new soundEffect("Beat5.wav");
	public static soundEffect song6 = new soundEffect("Beat6.wav");
	public static soundEffect song7 = new soundEffect("Beat7.wav");
	
	public static void dispose()
	{
		spaceShipFull.dispose();
		spaceShipHalf.dispose();
		spaceShipQuart.dispose();
		
		bullet.dispose();
		meany.dispose();
		meany2.dispose();
		
		background.dispose();
		
		splosion1.dispose();
		splosion2.dispose();
		splosion3.dispose();
		
		laserOne.dispose();
		laserTwo.dispose();
		
		chainOneSound.dispose();
		chainTwoSound.dispose();
		chainThreeSound.dispose();
		chainFourSound.dispose();
		chainFiveSound.dispose();
		chainSixSound.dispose();
		
		song1.dispose();
		song2.dispose();
		song3.dispose();
		song4.dispose();
		song5.dispose();
		song6.dispose();
		song7.dispose();
		
	}
}