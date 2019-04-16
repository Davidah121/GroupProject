import java.util.*;
import java.awt.*;

public class Engine
{
	private static boolean running = false;
	public static final long NANOSECOND = 1000000000;
	public static final int FPS_CAP = 60;
	
	private static int fps = 0;
	
	private static ArrayList<parentGameObject> objectList = new ArrayList<parentGameObject>();
	private static ArrayList<parentGameObject> sortedList = new ArrayList<parentGameObject>();
	
	public static void start()
	{
		//initialize stuff
		
		setRunning(true);
		Display.init();
	}
	
	public static void end()
	{
		//de-initialize stuff
		setRunning(false);
		Resources.dispose();
		Display.dispose();
		
	}
	
	public static void updateObjects()
	{
		for(int i=0; i<objectList.size(); i++)
		{
			get(i).update();
		}
		
		sortByDepth();
	}
	
	public static void renderObjects()
	{
		Graphics2D g = (Graphics2D)Display.getImageGraphics();
		g.clearRect(0, 0, Display.WIDTH, Display.HEIGHT);
		
		for(int i=0; i<sortedList.size(); i++)
		{
			sortedList.get(i).draw();
		}
		
		g.setColor(Color.WHITE);
		g.drawString("FPS: "+getFps(), 0, 32);
		g.drawString("Score: "+score.getScore(), 0, 64);
		g.drawString("CHAIN: "+score.getChain(), 0, 96);
		Display.repaint();
	}
	
	public static void add(parentGameObject o)
	{
		objectList.add(o);
	}
	
	public static parentGameObject get(int i)
	{
		if(i>=0 && i<size())
			return objectList.get(i);
		else
			return null;
	}
	
	public static int size()
	{
		return objectList.size();
	}
	
	public static void clear()
	{
		objectList.clear();
	}
	
	public static void sortByDepth()
	{
		sortedList.clear();
		boolean[] hasBeenSorted = new boolean[objectList.size()];
		
		parentGameObject highestDepthObject = get(0);
		int maxDepth = 0;
		int objectID = 0;
		boolean isFirstTime = true;
		
		for(int i=0; i<objectList.size(); i++)
		{
			
			for(int i2=0; i2<objectList.size(); i2++)
			{
				if(hasBeenSorted[i2]==false)
				{
					parentGameObject obj2 = get(i2);
					
					int newDepth = obj2.getDepth();
					
					if(isFirstTime)
					{
						maxDepth=newDepth;
						isFirstTime=false;
					}
					
					if(newDepth>=maxDepth)
					{
						highestDepthObject = obj2;
						maxDepth=newDepth;
						objectID = i2;
					}
					
				}
			}
			
			sortedList.add(highestDepthObject);
			hasBeenSorted[objectID]=true;
			isFirstTime=true;
			
		}
		
	}
	
	public static void deleteObject(int i)
	{
		if(i>=0 && i<size())
			objectList.remove(i);
	}
	
	public static void deleteObject(parentGameObject i)
	{
		objectList.remove(i);
	}
	
	public static void setRunning(boolean value)
	{
		running=value;
	}
	
	public static boolean getRunning()
	{
		return running;
	}
	
	public static int getFps()
	{
		return fps;
	}
	
	public static void run()
	{
		long startTime=0;
		long endTime=0;
		long totalTime=0;
		int countingFPS=0;
		
		while(running)
		{
			startTime = System.nanoTime();
			updateObjects();
			renderObjects();
			endTime = System.nanoTime();
			
			soundEffect.processSounds();
			score.update();
			
			Input.processInputs();
			
			while( (endTime-startTime) <= NANOSECOND/FPS_CAP)
			{
				endTime = System.nanoTime();
			}
			
			countingFPS++;
			totalTime+= (endTime-startTime);
			
			if(totalTime>=NANOSECOND)
			{
				fps=countingFPS;
				countingFPS=0;
				totalTime=0;
			}
		}
	}
	
}