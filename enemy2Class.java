import java.awt.*;

public class enemy2Class extends parentGameObject
{
	int time=0;
	public enemy2Class(int x, int y, int depth)
	{
		this.x=x;
		this.y=y;
		this.depth=depth;
		colRight = 40;
	    colBottom = 26;
	}
	
	public void update()
	{
		
		
		time++;
		if(time>=420)
		{
			Engine.deleteObject(this);
		}
		if(time >= 60 && time <=180)
		{
			x-=2;
		}
		else {
			x+=2;
		}
		if (time >=181 && time <=240)
		{
			y-=3;
			x-=1;
		}
		else {
			y+=2;
		}
		if (time >= 241)
		{
			y+=5;
			x+=0;
		}
	}
	
	public void draw()
	{
		Resources.meany2.draw(x,y);
	}
}