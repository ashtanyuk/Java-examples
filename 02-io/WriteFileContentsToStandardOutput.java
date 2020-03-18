import java.io.File;
import java.io.FileInputStream;

public class WriteFileContentsToStandardOutput {

	public static void main(String[] args) throws Exception {

		File file = new File(args[0]);
		FileInputStream fis = new FileInputStream(file);

		int oneByte;
		while ((oneByte = fis.read()) != -1) {
			System.out.write(oneByte);
			// System.out.print((char)oneByte); 
		}
		System.out.flush();
	}
}