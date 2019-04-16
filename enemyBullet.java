import java.awt.*;

public class enemyBullet extends parentGameObject
{
	int time = 0;
	private Sprite img = Resources.enemyBulletSprite;
	
	public void update()
	{	time++;
		if(time >= 100)
		{
			Engine.deleteObject(this);
		}
		
		y+=8;
		
		parentGameObject o = GameLogic.getCollisionObject(this, x, y, playerClass.class);
		if(o!=null)
		{
			Engine.deleteObject(this);
		//	Engine.deleteObject(o);
			score.addToScore(-120);
			Engine.add( new explosion(x,y));
		}
	}
	
	public void draw()
	{
		img.draw(x , y);
	}
	
 public enemyBullet(int x , int y){
	 this.x = x;
	 this.y = y;
	 colRight = 15;
	 colBottom = 24;
 }
}
