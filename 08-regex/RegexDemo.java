import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexDemo
{
   public static void main(String[] args)
   {
      Pattern p=Pattern.compile(".*(\\d)+ab.*");
      Matcher m=p.matcher("qq5abbb");
      System.out.println(m.matches());
      System.out.println(m.group(1));
   }
}