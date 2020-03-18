import java.io.*;

class Random2FileWriter
{
	public static void main(String[] args) throws Exception {
		Writer file = new FileWriter("random.txt");
		int n=(int)(Math.random()*10);
		String outstr="Number:"+n;
		file.write(outstr);
		file.close();
	}

}