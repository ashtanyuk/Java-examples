import java.io.*;

class TFileCopyCoding
{
	public static void main(String[] args)
	{
		Reader reader;
		Writer writer;
		try
		{
		   reader = new InputStreamReader(
        new FileInputStream(args[0]), "Cp1251");
       writer = new OutputStreamWriter(
        new FileOutputStream(args[1]), "Cp866");
       int c = 0;
       while ((c = reader.read()) >= 0) {
          writer.write(c);
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