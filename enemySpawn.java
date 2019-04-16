import java.awt.*;
import java.util.*;

public class enemySpawn extends parentGameObject
{
	int time = 0;
	
	public enemySpawn()
	{
		y = -64;
	}
	
	public void update()
	{
		time++;
		
		
		if(time == 45)
		{
			x = (int)(Math.random() * 544)+32;
			Engine.add( new enemy1Class(x , y, 15) );
		}
		
		if(time == 84)
		{
			x = (int)(Math.random() * 544)+24;
			Engine.add( new enemy2Class(x, y, 15) );
			
			//enemy1Class
			x = (int)(Math.random() * 544)+32;
			Engine.add( new enemy1Class(x , y, 15) );
		}
		
		if(time>=192)
		{
			x = (int) (Math.random() *544)+40;
			Engine.add( new Enemy3Class(x, y, 15) );
			
			//enemy1Class
			x = (int)(Math.random() * 544)+32;
			Engine.add( new enemy1Class(x , y, 15) );
			time=0;
		}
		
	}
	
	public void draw()
	{
		
	}
}