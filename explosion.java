import java.awt.*;

public class explosion extends parentGameObject
{
	private int time = 0;
	private double scale = 0;
	private Sprite randomSprite;
	
	public explosion(int x, int y)
	{
		this.x=x;
		this.y=y;
		
		int randomNum = (int) Math.round(Math.random()*3);
		switch(randomNum)
		{
			case 0:
				randomSprite=Resources.splosion1;
				break;
			case 1:
				randomSprite=Resources.splosion2;
				break;
			case 2:
				randomSprite=Resources.splosion3;
				break;
			default:
				randomSprite=Resources.splosion1;
				break;
		}
	}
	
	public void update()
	{
		scale+=0.1;
		time++;
		y++;
		if(time>30)
		{
			Engine.deleteObject(this);
		}
		
	}
	
	public void draw()
	{
		randomSprite.draw(x,y,scale,scale);
	}
}