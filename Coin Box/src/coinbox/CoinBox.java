package coinbox;

public class CoinBox
{
   private int curAmt;
   private int total;
   public int getCurAmt () { return curAmt; }
   public void insertCoin (int amt)
        throws InvalidCoinException
   { if (amt!=5&&amt!=10&&amt!=25)
     {
        throw new InvalidCoinException();
     }
     this.curAmt += amt;
     System.out.println ("Current Amount is "+curAmt);
   }
   public int getTotal () { return total; }
   public void makeChange (int price )
        throws InvalidPriceException
   { if (price<=0)
     {
        throw new InvalidPriceException();
     }
     release(curAmt-price);
     curAmt = 0;
     total += price;
   }
   private void release (int amt)
   { System.out.println ("Release "+amt); }
   public void returnCoin ()
   { release (curAmt); curAmt=0; }
}
