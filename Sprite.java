import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class Sprite
{
	private BufferedImage img;
	private int width = 0;
	private int height = 0;
	
	public Sprite(BufferedImage img)
	{
		this.img = img;
		width = img.getWidth();
		height = img.getHeight();
		
	}
	public Sprite(String filename)
	{
		this.img = loadImage(filename);
		width = img.getWidth();
		height = img.getHeight();
		
	}
	
	public void dispose()
	{
		img.flush();
	}
	public BufferedImage loadImage(String filename)
	{
		try
		{
			return ImageIO.read( new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public BufferedImage getImage()
	{
		return img;
	}
	
	public void setImage(BufferedImage img)
	{
		this.img = img;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void draw(int x, int y)
	{
		Display.getImageGraphics().drawImage(img, x, y, null);
	}
	
	public void draw(int x, int y, double xScale, double yScale)
	{
		Display.getImageGraphics().drawImage(img, x, y, (int)(width*xScale), (int)(height*yScale), null);
	}
}