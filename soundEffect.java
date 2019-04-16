import javax.sound.sampled.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.net.URL;

public class soundEffect
{
	private Clip clip;
	private static ArrayList<soundEffect> list = new ArrayList<soundEffect>();
	private float volume = 0f;
	public boolean looping = false;
	
	public static void processSounds()
	{
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).shouldStop()==true)
			{
				if(list.get(i).looping==false)
				{
					list.get(i).stop();
				}
				
				list.get(i).setMicrosecondPosition(0);
			}
		}
	}
	
	public soundEffect(String filename)
	{
		try
		{
			URL url = new File(filename).toURL();
			
			AudioInputStream audioInputStuff = AudioSystem.getAudioInputStream(url);
			
			clip = AudioSystem.getClip();
			clip.open(audioInputStuff);
			
			list.add(this);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void start()
	{
		if(isRunning())
			stop();
		
		clip.start();
	}
	
	public void stop()
	{
		clip.stop();
		clip.setMicrosecondPosition(0);
	}
	
	public void setVolume(float value)
	{
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(value);
		volume = value;
	}
	public boolean isRunning()
	{
		return clip.isRunning();
	}
	
	public void loopContinuosly()
	{
		looping=true;
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void loop(int times)
	{
		clip.loop(times);
	}
	
	public boolean shouldStop()
	{
		return (clip.getMicrosecondPosition() >= clip.getMicrosecondLength());
	}
	
	public void setMicrosecondPosition(int x)
	{
		clip.setMicrosecondPosition(x);
	}
	
	public float getVolume()
	{
		return volume;
	}
	
	public void dispose()
	{
		clip.stop();
		clip.flush();
	}
}