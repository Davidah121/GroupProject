import java.awt.*;

public class playerClass extends parentGameObject
{
	private int hp = 3;
	private int time=0;
	private int timeOver = 0;
	private int timeTillCanShoot = 20;
	
	private boolean invicible = false;
	private boolean ending = false;
	private boolean canShoot = true;
	
	private Sprite img = Resources.spaceShipFull;
	
	public playerClass(int x, int y, int depth)
	{
		this.x=x;
		this.y=y;
		this.depth=depth;
	}
	
	public boolean getCollision(int x, int y)
	{
		boolean col = false;
		col = GameLogic.getCollision(this, x, y, enemy1Class.class);
		if(col==false)
		{
			col = GameLogic.getCollision(this, x, y, enemy2Class.class);
		}
		if(col==false)
		{
			col = GameLogic.getCollision(this, x, y, Enemy3Class.class);
		}
		if(col==false)
		{
			col = GameLogic.getCollision(this, x, y, enemyBullet.class);
		}
		
		if(col==false)
		{
			//col = GameLogic.getCollision(this, x, y, enemy3Class.class);
		}
		if(col==false)
		{
			//col = GameLogic.getCollision(this, x, y, enemy4Class.class);
		}
		return col;
	}
	
	public void update()
	{
		if(Input.getKeyDown('W') || Input.getKeyDown(Input.KEY_UP_ARROW))
		{
			y-=4;
		}
		else if(Input.getKeyDown('S') || Input.getKeyDown(Input.KEY_DOWN_ARROW))
		{
			y+=4;
		}
		
		if(Input.getKeyDown('A') || Input.getKeyDown(Input.KEY_LEFT_ARROW))
		{
			x-=4;
		}
		else if(Input.getKeyDown('D') || Input.getKeyDown(Input.KEY_RIGHT_ARROW))
		{
			x+=4;
		}
		
		if(x<=0)
		{
			x=0;
		}
		else if(x>=Display.WIDTH-img.getWidth())
		{
			x=Display.WIDTH-img.getWidth();
		}
		
		if(y<=0)
		{
			y=0;
		}
		else if(y>=Display.HEIGHT-(img.getHeight()*2))
		{
			y=Display.HEIGHT-(img.getHeight()*2);
		}
		
		if(Input.getKeyDown(' ') && canShoot==true)
		{
			Engine.add( new PlayerBullet(x+8 , y));
			Resources.laserOne.start();
			canShoot=false;
		}
		
		if(canShoot==false)
		{
			timeTillCanShoot--;
			if(timeTillCanShoot==0)
			{
				canShoot=true;
				timeTillCanShoot=12;
			}
		}
		
		if(invicible==false)
		{
			if(getCollision(x,y))
			{
				hp-=1;
				invicible=true;
				score.deleteFromScore();
			}
		}
		
		if(invicible==true)
		{
			time++;
		}
		
		if(time>120)
		{
			invicible=false;
			time=0;
		}
		
		if(hp<=0)
		{
			gameOver();
		}
		
		switch(hp)
		{
			case 3:
				img = Resources.spaceShipFull;
				break;
			case 2:
				img = Resources.spaceShipHalf;
				break;
			case 1:
				img = Resources.spaceShipQuart;
				break;
			default:
				img = Resources.spaceShipQuart;
				break;
		}
	}
	
	public void gameOver()
	{
		x = -320;
		y = -320;
		timeOver++;
		
		if(timeOver>150)
		{
			score.resetGame();
		}
		
		ending = true;
	}
	
	public void draw()
	{
		if(ending==true)
		{
			Display.getImageGraphics().drawString( "GAME OVER", Display.WIDTH/2, Display.HEIGHT/2);
		}
		else
		{
			if(invicible==true)
			{
				Display.getImageGraphics().fillRect(x,y,img.getWidth(),img.getHeight());
			}
			
			img.draw(x,y);
		}
	}
}