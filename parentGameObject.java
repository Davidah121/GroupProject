
public abstract class parentGameObject
{
	protected int x = 0;
	protected int y = 0;
	
	protected int depth = 10;
	
	protected int colLeft = 0;
	protected int colRight = 32;
	protected int colUp = 0;
	protected int colBottom = 32;
	
	protected int getX()
	{
		return x;
	}
	protected int getY()
	{
		return y;
	}
	protected int getDepth()
	{
		return depth;
	}
	
	public abstract void update();
	public abstract void draw();
	
}