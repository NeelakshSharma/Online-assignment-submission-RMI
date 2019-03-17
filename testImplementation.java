import java.rmi.*;
import java.rmi.server.*;
import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.*;
class testRemote extends UnicastRemoteObject implements MarksEval
{
  testRemote() throws RemoteException
  {
    super();
  }
  public String eval (String fn)
  {
    System.out.println("----Welcome Intsructor server side----\n");
    Scanner sc=new Scanner(System.in);
    String rfn="";
    try
    {
      String s=readFile(fn);
      System.out.println("Assignment contents for file"+rfn+" : \n"+s);
      System.out.println("Enter the filename for writing the result : ");
      rfn=sc.nextLine();
      int n=1;
      while(n==1)
      {
        writeFile(rfn);
        System.out.println("\n----press 1 to enter again or any other to exit----");
        n=sc.nextInt();
      }
      System.out.println("\n....Waiting for new request....\n");
    }
    catch(Exception e)
    {
      System.out.println("error");
    }
    return rfn;
  }
  public static String readFile(String fileName) throws IOException
  {
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      try
      {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null)
        {
          sb.append(line);
          sb.append("\n");
          line = br.readLine();
        }
        return sb.toString();
      }
      finally
      {
        br.close();
      }
  }
  public static void writeFile(String fileName) throws IOException
  {
    try
    {
      FileWriter fstream = new FileWriter(fileName);
      BufferedWriter out = new BufferedWriter(fstream);
      System.out.println("Enter the marks please: ");
      Scanner sc=new Scanner(System.in);
      String marks=sc.nextLine();
      out.write(marks);
      //Close the output stream
      out.close();
    }
    catch (Exception e)
    {//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }
}
