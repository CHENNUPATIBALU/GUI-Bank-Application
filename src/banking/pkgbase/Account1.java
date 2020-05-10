
package banking.pkgbase;
import banking.pkgintf.IAccount;
import java.util.Scanner;


public class Account1 implements IAccount{
    public Scanner scan = new Scanner(System.in);
    protected int amount;
    protected int accno;
    protected double rateInterest;
    protected String name;
    protected boolean overdraft;
    
    public void ShowAccountDetails()
    {
              System.out.println("Account Holder Name = "+name);
              System.out.println("Account number is = "+accno);
              System.out.println("Account Balance is = "+amount);
              System.out.println("Rate of Interest = "+rateInterest);
              if(overdraft)
                  System.out.println("Overdraft is Allowed");
              else
                  System.out.println("Overdraft not Allowed");
              
    }
    public void balanceEnquiry(int ano) {
                if(accno==ano)
                {
                    System.out.println("Account balance is "+amount);
                }
                else
                    System.out.println("Account not found");
                
    }

    
    public void depositAmount(int ano) {
                if(accno==ano)
                    {
                        System.out.println("Enter the amount to deposit");
                        int price=scan.nextInt();
                        amount=amount+price;
                        System.out.println("₹ "+price+" " +"deposited successfully in your account");
                    }
                    else
                    System.out.println("Account not found");
                
    }
                

    
    public void withdrawAmount(int ano) 
    {
                if(accno==ano)
                    {
                        System.out.println("Enter the amount to withdraw");
                        int price=scan.nextInt();
                        amount=amount - price;
                        if(amount<0)
                        {
                            System.out.println("₹ "+price+" " +"is debited from ur account");
                            System.out.println("Remaining balance is ₹ "+amount);
                            System.out.println("OverDraft balance will be updated, when you do deposit in the mean while.... ");
                        }
                        else
                        {
                            System.out.println("₹ "+price+"" +"is debited from ur account");
                            System.out.println("Remaining balance is ₹ "+amount);
                        }
                        
                    }
                    else
                    System.out.println("Account not found");
                
    }
}

