import java.rmi.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class MyClient
{
  public static void main(String[] args)
  {
    System.out.println("----HELLO STUDENT CLIENT SIDE----");
    String temp="";
    try
    {
      MarksEval stub=(MarksEval)Naming.lookup("rmi://localhost:8080/Neelaksh");
      Scanner sc=new Scanner(System.in);
      System.out.println("\nEnter the file name for assignment submission: ");
      String s=sc.nextLine();
      String rfn=stub.eval(s);
      System.out.println("Marks evaluated: "+ readFile(rfn));
      temp=readFile(rfn);
      int n=1;
      while(n==1)
      {
        System.out.println("Obtain marks again? Press 1 to continue any other key to exit");
        n=sc.nextInt();
        if(n==1)
        {
          rfn=stub.eval(s);
          System.out.println("Marks evaluated : "+ readFile(rfn));
          if(!(temp.equals(readFile(rfn))))
          {
            System.out.println("----READ WRITE CONFLICT----");
          }
        }
      }
        System.out.println("*****Thank you!******\n");
        System.exit(0);
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
  public static String readFile(String fileName) throws IOException
  {
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      try {
          StringBuilder sb = new StringBuilder();
          String line = br.readLine();

          while (line != null) {
              sb.append(line);
              sb.append("\n");
              line = br.readLine();
          }
          return sb.toString();
      } finally {
          br.close();
      }
  }
}
