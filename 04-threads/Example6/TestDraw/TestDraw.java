import java.util.Random;
import java.awt.Color;

class Sprite extends Thread
{
	double x,y;
	Color color;
	int count=500;
	Object stick;
	Random r=new Random();
	Sprite(double x,double y,Color color,Object stick)
	{
		  this.stick=stick;
		  this.color=color;
		  this.x=x; this.y=y;

	}
	void draw()
	{
		StdDraw.setPenColor(this.color);
		//System.out.println("Thread:"+getId()+" "+color);
        StdDraw.filledCircle(x,y,.015);
	}
	public void run()
	{
	
		while(true)
		{
		   x+=r.nextDouble()/20-0.005;
		   y+=r.nextDouble()/20-0.005;
		   if(x<0)
		   	x+=1;
		   if(y<0)
		   	y+=1;
		   if(x>1)
		   	x-=1;
		   if(y>1)
		   	y-=1;
		  //synchronized(stick)
		  {
		     draw();    
          }
             try
             {  
               Thread.sleep(100);
             }
             catch(InterruptedException e) {
           	   return;
             }
          
       }
	
  }
}


public class TestDraw
{
    
	public static void main(String[] args) {                
      Object stick=new Object();
      // set size of window and sale
      StdDraw.setCanvasSize(500, 500);
      //StdDraw.setXscale(-1, 3);
      //StdDraw.setYscale(0, N+3);
      
      StdDraw.clear();
      (new Sprite(.2,.2,StdDraw.RED,stick)).start();
      (new Sprite(.2,.8,StdDraw.BLUE,stick)).start();
      (new Sprite(.5,.5,StdDraw.GREEN,stick)).start();
      (new Sprite(.9,.2,StdDraw.BLACK,stick)).start();
   }
}