class Point
{
    protected int x,y;
    Point(int x,int y) {
        this.x=x;
        this.y=y;
    }

    public void print() {
        System.out.println("x="+x+" y="+y);
    }
}

class Point3D extends Point
{
    protected int z;
    Point3D(int x,int y,int z) {
        super(x,y);
        this.z=z;
    }
    @Override
    public void print() {
        System.out.println("x="+x+" y="+y+" z="+z);
    }
    @Override
    public boolean equals(Object obj) {
        Point3D p=(Point3D)obj;
        return (x==p.x &&
                y==p.y && 
                z==p.z);
    }
}

public class TestPoint
{
    public static void main(String[] args) {
        Point3D p3=new Point3D(1,2,3);
        Point3D p4=new Point3D(1,2,3);
        System.out.println(p3.equals(p4));
    }
}
