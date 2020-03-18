class Point
{
	int x=10;
	int y=20;
   public Double pi=3.14;
   public Double d;
   Point(int x,int y)
   {
      this.x=x;
      this.y=y;
      d=pi;
      d=2.7;
   }
	public void Print()
	{
		System.out.println("x="+x+" y="+y);
	}
}
class Point3D extends Point
{
   int z=30;
   Point3D(int x,int y, int z)
   {
      super(x,y);
      this.z=z;
   }
   public void Print()
   {
      super.Print();
      System.out.println("z="+z);
   }
}
class Point4D extends Point3D
{
   double t=0;
   Point4D(int x,int y,int z,double t)
   {
      super(x,y,z);
      this.t=t;
   }
   public void Print()
   {
      super.Print();
      System.out.println("t="+t);
   }
   protected void Test()
   {
      System.out.println("!!!!!!!!!!!!");
   }
}
class TestNull
{
	public static void main(String args[])
	{
		Point p=new Point4D(10,20,30,5.0);
      System.out.println("PI="+p.pi+" D="+p.d);
	

		try
		{
		   p.Print();
		}
		catch(NullPointerException ex)
		{
			System.out.println("Null!");
		}
	}
}