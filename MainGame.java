
public class MainGame
{
	public static void init()
	{
		score.setScore(0);
		Engine.add( new playerClass(16, 0, 10) );
		Engine.add( new enemySpawn ());
		Engine.add( new backgroundClass(100000));
		score.start();
	}
	
	public static void main(String args[])
	{
		
		Engine.start();
		init();
		
		Engine.run();
	}
}