import java.awt.*;

public class Enemy3Class extends parentGameObject
{
	int time=0;
	private Sprite img = Resources.meany3;
	
	public Enemy3Class(int x, int y, int depth)
	{
		this.x=x;
		this.y=y;
		this.depth=depth;
		colRight = img.getWidth();
	    colBottom = img.getHeight();
	}
	
	public void update()
	{
		
		
		time++;
		if(time>=600)
		{
			Engine.deleteObject(this);
		}
		if(time >= 60 && time <=90)
		{
			y+=3;
			x-=2;
		}
		if (time >=91 && time <=120)
		{
			x+=3;
			y+=2;
		}
		if (time >=121 && time <=150)
		{
			x-=3;
			y+=2;
		}
		if (time >=151 && time <=180)
		{
			x+=3;
			y+=2;
		}
		if (time >=181 && time <=210)
		{
			x-=3;
			y+=2;
		}
		if (time >=211 && time <=240)
		{
			x+=3;
			y+=2;
		}
		if (time >= 241 && time <= 300)
		{
			y-=5;
		}
			if (time > 300 && time <=301)
		{
			Engine.add( new enemyBullet(x, y));
			Resources.laserTwo.start();
		}
		if (time >=301 && time <=345)
		{
			x+=3;
			y+=2;
		}
		if (time >=346 && time <=390)
		{
			x-=3;
			y+=2;
		}
		if (time >=391 && time <=435)
		{
			x+=3;
			y+=2;
		}
		if (time >=436 && time <=480)
		{
			x-=3;
			y+=2;
		}
		if (time >=481 && time <=525)
		{
			x+=3;
			y+=2;
		}
		if (time >=526 && time <=570)
		{
			x-=3;
			y+=2;
		}
		if (time >=571 && time <=600)
		{
			x+=3;
			y+=2;
		}
	}
	
	public void draw()
	{
		img.draw(x,y);
	}
}