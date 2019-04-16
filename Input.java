import java.awt.event.*;
public class Input
{
	private static boolean keyPressed[] = new boolean[255];
	private static boolean keyDown[] = new boolean[255];
	private static boolean keyUp[] = new boolean[255];
	
	public static final int KEY_UP_ARROW = 38;
	public static final int KEY_DOWN_ARROW = 39;
	public static final int KEY_RIGHT_ARROW = 40;
	public static final int KEY_LEFT_ARROW = 37;
	
	public static void onPress(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		
		if(keyDown[keyCode]==false)
			keyPressed[keyCode]=true;
		
		
		keyDown[keyCode]=true;
	}
	
	public static void onRelease(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		
		keyUp[keyCode]=true;
		keyDown[keyCode]=false;
		keyPressed[keyCode]=false;
	}
	
	public static void onTyped(KeyEvent e)
	{
		//Nothing
	}
	
	public static void processInputs()
	{
		for(int i=0; i<255; i++)
		{
			if(keyUp[i]==true)
				keyUp[i]=false;
			
			if(keyPressed[i]==true)
				keyPressed[i]=false;
		}
	}
	
	public static boolean getKeyDown(int key)
	{
		if(key>=0 && key<255)
			return keyDown[key];
		else
			return false;
	}
	
	public static boolean getKeyReleased(int key)
	{
		if(key>=0 && key<255)
			return keyUp[key];
		else
			return false;
	}
	
	public static boolean getKeyPressed(int key)
	{
		if(key>=0 && key<255)
			return keyPressed[key];
		else
			return false;
	}
	
}