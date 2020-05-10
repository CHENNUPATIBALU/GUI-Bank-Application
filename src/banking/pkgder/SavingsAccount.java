
package banking.pkgder;
import banking.pkgbase.Account1;
import java.util.Random;

public class SavingsAccount extends Account1{
    public SavingsAccount()
    {
        rateInterest=5.6;
        overdraft=false;
    }
    Random rand = new Random();
    public void create()
    {
            
            System.out.println("Your Account type is SAVINGS");
            System.out.println("Enter the account holder name");
            name = scan.next();
            accno=rand.nextInt(999999999);
            System.out.println("Your Account number is "+accno);
            System.out.println("Enter amount to deposit ");
            amount=scan.nextInt();
            System.out.println("");
            ShowAccountDetails();
            System.out.println("");
    }

}

