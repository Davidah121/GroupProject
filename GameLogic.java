
public class GameLogic
{
	public static boolean getCollision(parentGameObject thisObject, int x, int y, Class c)
	{
		for(int i=0; i<Engine.size(); i++)
		{
			parentGameObject o = Engine.get(i);
			
			if(o.getClass().equals(c))
			{
				if(x+thisObject.colLeft <= o.x+o.colRight && x+thisObject.colRight >= o.x+o.colLeft)
				{
					if(y+thisObject.colUp <= o.y+o.colBottom && y+thisObject.colBottom >= o.y+o.colUp)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static parentGameObject getCollisionObject(parentGameObject thisObject, int x, int y, Class c)
	{
		for(int i=0; i<Engine.size(); i++)
		{
			parentGameObject o = Engine.get(i);
			if(o.getClass().equals(c))
			{
				if(x+thisObject.colLeft <= o.x+o.colRight && x+thisObject.colRight >= o.x+o.colLeft)
				{
					if(y+thisObject.colUp <= o.y+o.colBottom && y+thisObject.colBottom >= o.y+o.colUp)
					{
						return o;
					}
				}
			}
		}
		return null;
	}
}