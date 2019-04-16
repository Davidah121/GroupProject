
public class backgroundClass extends parentGameObject
{
	private Sprite img = Resources.background;
	
	public backgroundClass(int depth)
	{
		this.depth = depth;
	}
	
	public void update()
	{
		y+=4;
		if(y>=256)
		{
			y=0;
		}
	}
	
	public void draw()
	{
		
		
		for(int k=-2;k<2;k++)
		{
			Resources.background.draw( 0, ((k*img.getHeight())+y));
			Resources.background.draw( img.getWidth(), ((k*img.getHeight())+y));
			Resources.background.draw( img.getWidth()*2, ((k*img.getHeight())+y));
			
		}
		
	}
}