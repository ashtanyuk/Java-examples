// SortDemo
// =======
// Работа с процессами
//
import java.io.*;
import java.util.*;

// объект этого класса будет запускать процесс

class MySort implements Runnable
{
 
 private Thread t; // процесс
 int arr[];
 int N;

 // обмен двух элементов массива
 public static void swap (int A[], int x, int y)
 {
      int temp = A[x];
      A[x] = A[y];
      A[y] = temp;
 }
 
void BubbleSort(int[] a,int N)
{
	int i,j;
	for(i=N-1;i>0;i--)
	  for(j=0;j<i;j++)
	    if(a[j]>a[j+1])
		  swap(a,j,j+1);
}
void FoolSort(int[] a,int N)
{
	int i,j;
	for(i=0;i<N;i++)
	  for(j=0;j<N;j++)
	    if(a[i]>a[j])
		  swap(a,i,j);
}

void QuickSort (int[] a, int lo, int hi)
{
    int i=lo, j=hi, h;
    int x=a[(lo+hi)/2];
    do
    {    
        while (a[i]<x) i++; 
        while (a[j]>x) j--;
        if (i<=j)
        {
            h=a[i]; a[i]=a[j]; a[j]=h;
            i++; j--;
        }
    } while (i<=j);

    if (lo<j) QuickSort(a, lo, j);
    if (i<hi) QuickSort(a, i, hi);
}

 // конструктор 
 public MySort(String name, int arr[],int N) 
 {
        this.arr=arr;
        this.N=N;      
		t=new Thread(this);	   	
	    t.setName(name);     	
 } 
 // этот метод будет телом процесса 
 public void run()     
 {
       System.out.println("Starting: "+t);
	   if(t.getName().equals("Quick"))
          QuickSort(arr,0,N-1);            
	   else if(t.getName().equals("Bubble"))
	      BubbleSort(arr,N);
	   else
		  FoolSort(arr,N); 
       System.out.println("Terminated:"+t);
}
 public void start()
 {
	   t.start();
 }
}

// Отсюда начинается программа
class SortDemo
{
    public int arr[];
    public int N;
    public SortDemo(int N)
    {
       this.N=N;
    }
    public void makeArr()
    {       
       Random rand=new Random();
       arr=new int[N];
       for(int i=0;i<N;i++)  {
          arr[i]=rand.nextInt(100);
       }
    }
	public static void main(String args[])
	{
		System.out.println("Start sorting..");
	    SortDemo sd=new SortDemo(70000);
	    sd.makeArr();	
	    
        MySort sort1=new  MySort("Bubble",sd.arr,sd.N);		
		MySort sort2=new  MySort("Quick",sd.arr,sd.N);        
		MySort sort3=new  MySort("Fool",sd.arr,sd.N);        
		sort1.start();		
        sort2.start();        
		sort3.start();        

	    /*for(int i=0;i<sd.N;i++)
	       System.out.println(sd.arr[i]);*/


	}
}
