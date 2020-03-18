import java.util.Random;
import java.awt.Color;

enum Directions {LU,LD,RU,RD};

class Sprite extends Thread
{
	double x,y,xo,yo;
	Color color;
	Directions curDir;
	double step=0.01;
	Object stick;

	Sprite(double x,double y,Color color,Directions d,Object st)
	{
		  this.color=color;
		  this.x=x; this.y=y;
		  this.xo=x; this.yo=y;
		  curDir=d;	
		  stick=st;
	}
	void draw()
	{
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledCircle(xo,yo,.015);
		StdDraw.setPenColor(this.color);
        StdDraw.filledCircle(x,y,.015);
	}
	public void run()
	{
		while(true)
		{
		   xo=x; yo=y;	
		   if(curDir==Directions.LU) {
		   	 x-=step;
		   	 y+=step;
		   	 if(x<=0 && y>0)
		   	 	curDir=Directions.RU;
		   	 else if(y>=1 && x>0)
		   	 	curDir=Directions.LD;
		   } 
		   else if(curDir==Directions.RU) {
		   	 x+=step;
		   	 y+=step;
		   	 if(x>0 && y>=1)
		   	 	curDir=Directions.RD;
		   	 else if(y>0 && x>=1)
		   	 	curDir=Directions.LU;
		   }
		   else if(curDir==Directions.RD) {
		   	 x+=step;
		   	 y-=step;
		   	 if(x>=1 && y>0)
		   	 	curDir=Directions.LD;
		   	 else if(y<=0 && x>0)
		   	 	curDir=Directions.RU;
		   }		   		   
		   else if(curDir==Directions.LD) {
		   	 x-=step;
		   	 y-=step;
		   	 if(x<=0 && y>0)
		   	 	curDir=Directions.RD;
		   	 else if(y<=0 && x>0)
		   	 	curDir=Directions.LU;
		   }		   		   
		  synchronized(stick)
		  {
		  	 //StdDraw.clear();
		     draw();
		     StdDraw.show();    
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


public class Balls
{
    
	public static void main(String[] args) {                
      Object stick=new Object();
      // set size of window and sale
      StdDraw.setCanvasSize(700, 300);
      StdDraw.enableDoubleBuffering();
      //StdDraw.setXscale(-1, 3);
      //StdDraw.setYscale(0, 3);
      
      StdDraw.clear();
      (new Sprite(.13,.21,StdDraw.RED,Directions.LU,stick)).start();
      (new Sprite(.44,.37,StdDraw.BLUE,Directions.LU,stick)).start();
      (new Sprite(.69,.61,StdDraw.GREEN,Directions.LU,stick)).start();
      (new Sprite(.92,.81,StdDraw.BLACK,Directions.LU,stick)).start();
   }
}