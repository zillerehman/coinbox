package coinbox;
import java.io.*;
//import Math.*;
public class Main
{
   private static BufferedReader br =
      new BufferedReader (new InputStreamReader(System.in));
   private static int readln() throws NumberFormatException
   {
      String selection = "";
      try {
         selection = br.readLine();
      } catch (IOException e)
      {
         e.printStackTrace();
      }
      return Integer.parseInt(selection);
   }
   public static void main(String[] args)
   {
      VendingMachine vm = new VendingMachine();
      int selection = 0;
      while (true)
      {
         System.out.print(
            "Pls select: 0=insert 1=vend, 2=returnCoin, 3=exit: "
         );
         switch (readln())
         {
            case 0: System.out.print("enter amount: ");
                    int x=0;
                    try {
                       x=readln();
                    }catch(NumberFormatException e){}
                    vm.insertCoin(x);
               break;
            case 1: System.out.print("select item 0-4: ");
                    vm.vend(readln());
               break;
            case 2: vm.returnCoin();
               break;
            case 3: System.exit(0);
               break;
            default: System.out.println ("Invalid selection");
         }
      }
   }
}
