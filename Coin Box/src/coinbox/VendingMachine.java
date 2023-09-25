package coinbox;
import java.io.*;
public class VendingMachine
{
   private CoinBox coinBox = new CoinBox();
   private Dispenser dispenser = new Dispenser();
   public void insertCoin(int amt)
   {  try {
         coinBox.insertCoin(amt);
      } catch (InvalidCoinException e)
      { coinBox.returnCoin();
        e.printStackTrace();
      }
   }
   public int getPrice(int item)
   {
      try {
	      return dispenser.getPrice(item);
      } catch (UnknownItemException e)
      {
	      e.printStackTrace();
      }
      return 0;
   }
   public int getQoh(int item)
   {
	   try { return dispenser.getQoh(item); }
	   catch (UnknownItemException e)
	   { e.printStackTrace(); }
	   return 0;
   }
   public void vend(int item)
   {  
      int c = coinBox.getCurAmt();
      try {
         int p = dispenser.getPrice(item);
         if (c<p)
            System.out.println ("inadequate payment");
         else
         {
            coinBox.makeChange(p);
            dispenser.dispense(item);
         }
      } catch (UnknownItemException uie)
      { uie.printStackTrace();
      } catch (ItemNotAvailableException inae)
      {  inae.printStackTrace();
         coinBox.returnCoin();
      } catch (InvalidPriceException ipe)
      {  ipe.printStackTrace();
         coinBox.returnCoin();
      }
   }
   public void returnCoin() { coinBox.returnCoin(); }
}
