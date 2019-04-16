import java.awt.*;

public class PlayerBullet extends parentGameObject
{
	private int time = 0;
	
	private Sprite img = Resources.bullet;
	
	public PlayerBullet(int x , int y){
		this.x = x;
		this.y = y;
		colRight = img.getWidth();
		colBottom = img.getHeight();
	}

	
	public parentGameObject getCollision(int x, int y)
	{
		parentGameObject o;
		o = GameLogic.getCollisionObject(this, x, y, enemy1Class.class);
		if (o == null )
		{
			o = GameLogic.getCollisionObject(this, x, y, enemy2Class.class);
		}
		if (o == null) 
		{
			o = GameLogic.getCollisionObject(this, x, y, Enemy3Class.class);
		}
		return o;
	}
	
	public void update()
	{	time++;
		if(time >= 100)
		{
			Engine.deleteObject(this);
		}
		
		y-=4;
		parentGameObject o = getCollision(x,y);
		
		if( o !=null )
		{
			Engine.deleteObject(this);
			Engine.deleteObject(o);
			score.addToScore(12);
			Engine.add( new explosion(o.x,o.y) );
		}
	}
	
	public void draw()
	{
		img.draw(x , y);
	}
}
