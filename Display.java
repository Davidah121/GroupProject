import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

public class Display
{
	private static JFrame window;
	private static BufferedImage finalImage;
	private static extPanel panel;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final String TITLE = "GALAGA";
	
	private static KeyListener k = new KeyListener(){
		@Override
		public void keyPressed(KeyEvent e)
		{
			Input.onPress(e);
		}
		
		@Override
		public void keyTyped(KeyEvent e)
		{
			Input.onTyped(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e)
		{
			Input.onRelease(e);
		}
	};
	
	private static WindowAdapter w = new WindowAdapter(){
		
		public void windowClosing(WindowEvent e)
		{
			Engine.end();
		}
		
		public void windowClose(WindowEvent e)
		{
			System.exit(0);
		}
	};
	
	public static void init()
	{
		window = new JFrame(TITLE);
		window.setSize(WIDTH, HEIGHT);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new extPanel();
		panel.setSize(WIDTH, HEIGHT);
		panel.addKeyListener(k);
		
		finalImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		
		window.add(panel);
		window.addWindowListener(w);
		
		window.setFocusable(true);
		panel.setFocusable(true);
		
		window.setAutoRequestFocus(true);
		panel.requestFocusInWindow();
		
	}
	
	public static BufferedImage getImage()
	{
		return finalImage;
	}
	
	public static Graphics2D getImageGraphics()
	{
		return (Graphics2D)finalImage.getGraphics();
	}
	
	public static void repaint()
	{
		panel.setImage(finalImage);
		panel.repaint();
		panel.invalidate();
	}
	public static void dispose()
	{
		// i don't know, do stuff.
	}
}