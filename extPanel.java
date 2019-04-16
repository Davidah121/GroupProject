import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class extPanel extends JPanel
{
	private BufferedImage img = new BufferedImage(320,320,BufferedImage.TYPE_INT_ARGB);
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D gg = (Graphics2D)g;
		gg.drawImage(img, 0, 0, null);
	}
	
	public void setImage(BufferedImage img)
	{
		this.img = img;
	}
}