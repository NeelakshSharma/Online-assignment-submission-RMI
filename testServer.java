import java.rmi.*;
import java.rmi.registry.*;
class MyServer
{
  public static void main(String[] args)
  {
    try
    {
      MarksEval stub =new testRemote();
      Naming.rebind("rmi://localhost:8080/Neelaksh",stub);
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
