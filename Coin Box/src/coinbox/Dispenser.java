package coinbox;
import java.io.*;
public class Dispenser
{
   private int[] prices = new int[] {50, 50, 50, 50, 50};
   private int[] qoh = new int[] {0, 10, 10, 10, 10};
   public int getPrice (int item)
         throws UnknownItemException
   {
      if (item<0 || item > prices.length)
         throw new UnknownItemException();
      return prices[item];
   }
   public void setPrice(int item, int price)
   {
      prices[item]=price;
   }
   public void dispense (int item)
         throws ItemNotAvailableException
   {
      if (qoh[item]==0)
         throw new ItemNotAvailableException();
      release (item);
      qoh[item]--;
   }
   private void release (int item)
   {
      System.out.println ("Call dispenser driver to release item "+item);
   }
   public int getQoh(int item) throws UnknownItemException
   {
      if (item<0 || item > prices.length)
         throw new UnknownItemException();
      return qoh[item];
   }
   public void setQoh(int item, int qty)
   {
      qoh[item]=qty;
   }
}
