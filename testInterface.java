import java.rmi.*;
interface MarksEval extends Remote
{
  public String eval(String fn) throws RemoteException;
}
