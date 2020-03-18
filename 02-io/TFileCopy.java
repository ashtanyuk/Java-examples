import java.io.*;
// это просто комментарий
class TFileCopy
{
	public static void main(String[] args)
	{
		Reader reader;
		Writer writer;
		try
		{
		   reader = new FileReader(args[0]);
       writer = new FileWriter(args[1]);
       int c = 0;
       while ((c = reader.read()) >= 0) {
          writer.write(Character.toUpperCase((char) c));
       }
       reader.close();
        writer.close();
       }
       catch(FileNotFoundException ex)
       {

       }
       catch(IOException ex)
       {

       }       

	}
}