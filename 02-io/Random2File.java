import java.io.*;

class Random2File
{
	public static void main(String[] args) throws Exception {
		OutputStream file = new FileOutputStream("random.txt");
		int n=(int)(Math.random()*10);
		String outstr="Number:"+n;
		file.write(outstr.getBytes());
		file.close();
	}

}