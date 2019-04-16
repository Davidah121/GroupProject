import java.awt.*;

public class enemy1Class extends parentGameObject
{
	int time=0;
	public enemy1Class(int x, int y, int depth)
	{
		this.x=x;
		this.y=y;
		this.depth=depth;
		colRight = 40;
	    colBottom = 26;
	}
	
	public void update()
	{
		y+=2;
		time++;
		if(time>=300)
		{
			Engine.deleteObject(this);
		}
	}
	
	public void draw()
	{
		Resources.meany.draw(x,y);
	}
}