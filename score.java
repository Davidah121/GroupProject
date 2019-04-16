
public class score
{
	private static int score = 0;
	private static int chain = 0;
	private static int previousChain = chain;
	
	private static float maxVolume = 0f;
	private static float minVolume = -60f;
	private static int timeTillMax = 60; //one second;
	
	private static float changeAmount = -minVolume/timeTillMax;
	private static boolean goingUp = false;
	private static int time = 61;
	
	private static int killsTillChain = 5;
	
	public static final int ADD_SCORE = 12;
	public static final int SUBTRACT_SCORE = 120;
	
	public static void start()
	{
		setAllZero();
		Resources.song1.start();
		Resources.song1.setVolume(maxVolume);
		Resources.song1.loopContinuosly();
		
		Resources.song2.start();
		Resources.song2.loopContinuosly();
		
		Resources.song3.start();
		Resources.song3.loopContinuosly();
		
		Resources.song4.start();
		Resources.song4.loopContinuosly();
		
		Resources.song5.start();
		Resources.song5.loopContinuosly();
		
		Resources.song6.start();
		Resources.song6.loopContinuosly();
		
		Resources.song7.start();
		Resources.song7.loopContinuosly();
		
		resetKills();
	}
	
	public static void stopAllSounds()
	{
		Resources.song1.stop();
		Resources.song2.stop();
		Resources.song3.stop();
		Resources.song4.stop();
		Resources.song5.stop();
		Resources.song6.stop();
		Resources.song7.stop();
	}
	
	public static void resetGame()
	{
		Engine.clear();
		
		stopAllSounds();
		MainGame.init();
	}
	
	public static void resetKills()
	{
		killsTillChain = 5 + (5*chain);
	}
	
	public static void subtractFromKills()
	{
		killsTillChain-=1;
	}
	
	public static void addToScore()
	{
		score+=ADD_SCORE*(chain+1);
		
		subtractFromKills();
		if(killsTillChain<=0)
		{
			addToChain();
			resetKills();
		}
	}
	
	public static void addToScore(int points)
	{
		score+=points*(chain+1);
		
		subtractFromKills();
		if(killsTillChain<=0)
		{
			addToChain();
			resetKills();
		}
	}
	
	public static void deleteFromScore()
	{
		score-=SUBTRACT_SCORE;
		
		resetKills();
		subtractFromChain();
	}
	
	public static void deleteFromScore(int points)
	{
		score-=points;
		
		resetKills();
		subtractFromChain();
	}
	
	public static int getScore()
	{
		return score;
	}
	
	public static void setScore(int value)
	{
		score=value;
	}
	
	public static void addToChain()
	{
		if(chain!=6)
		{
			switch(chain)
			{
				case 0:
					Resources.chainOneSound.start();
					break;
				case 1:
					Resources.chainTwoSound.start();
					break;
				case 2:
					Resources.chainThreeSound.start();
					break;
				case 3:
					Resources.chainFourSound.start();
					break;
				case 4:
					Resources.chainFiveSound.start();
					break;
				case 5:
					Resources.chainSixSound.start();
					break;
				default:
					break;
			}
			chain++;
			goingUp = true;
			time=0;
			
			
		}
	}
	
	public static void subtractFromChain()
	{
		if(chain!=0)
		{
			chain--;
			goingUp = false;
			time=0;
		}
	}
	
	public static int getChain()
	{
		return chain;
	}
	
	public static void setAllZero()
	{
		
		Resources.song1.setVolume(minVolume);
		
		Resources.song2.setVolume(minVolume);
		
		Resources.song3.setVolume(minVolume);
		
		Resources.song4.setVolume(minVolume);
		
		Resources.song5.setVolume(minVolume);
		
		Resources.song6.setVolume(minVolume);
		
		Resources.song7.setVolume(minVolume);
		
		
	}
	public static void update()
	{
		previousChain=chain-1;
		if(time<=60)
		{
			setAllZero();
			switch(previousChain)
			{
				case 0:
					Resources.song1.setVolume( maxVolume - changeAmount*time );
					Resources.song2.setVolume( minVolume + changeAmount*time );
					break;
				case 1:
					Resources.song2.setVolume( maxVolume - changeAmount*time );
					Resources.song3.setVolume( minVolume + changeAmount*time );
					break;
				case 2:
					Resources.song3.setVolume( maxVolume - changeAmount*time );
					Resources.song4.setVolume( minVolume + changeAmount*time );
					break;
				case 3:
					Resources.song4.setVolume( maxVolume - changeAmount*time );
					Resources.song5.setVolume( minVolume + changeAmount*time );
					break;
				case 4:
					Resources.song5.setVolume( maxVolume - changeAmount*time );
					Resources.song6.setVolume( minVolume + changeAmount*time );
					break;
				case 5:
					Resources.song6.setVolume( maxVolume - changeAmount*time );
					Resources.song7.setVolume( minVolume + changeAmount*time );
					break;
				default:
					break;
			}
			
			
			time++;
		}
	}
}