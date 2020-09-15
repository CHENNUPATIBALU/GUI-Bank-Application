
package bankingMain;
import java.util.*;
import bankDAO.*;

public class Banking {

    static int saCount,caCount;
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    public static void main(String[] args) throws Exception{
        int ano;
        String name;
        float amount;
        BankDataBase bdb = new BankDataBase();
        SavingsDAO s = new SavingsDAO();
        CurrentDAO c = new CurrentDAO();
        AccountsDAO a = new AccountsDAO();
        
        bdb.createDB();
        bdb.createBankTB();
        
        System.out.println();
        
        System.out.println("--------------------------");
        System.out.println("|    WELCOME TO BANK    |");
        System.out.println("--------------------------");
        for(;;)
        {
            System.out.println("");
            System.out.println("1: Create Savings Account   2: Create Current Account   3:More options");
            System.out.println("Enter your choice");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1 : System.out.println("Enter the Account Holder Name");
                		 name = scan.next();
                		 System.out.println("Enter the amount for initial deposit");
                		 amount = scan.nextFloat();
                		 ano=rand.nextInt(999999999);
                		 s.insertSavingsTb(ano, name, amount);
                         break;
                                        
                case 2: System.out.println("Enter the Account Holder Name");
			       		 name = scan.next();
			       		 System.out.println("Enter the amount for initial deposit");
			       		 amount = scan.nextFloat();
			       		 ano=rand.nextInt(999999999);
			       		 c.insertCurrentTb(ano, name, amount);
                        break;
                                        
                case 3 : 
                            System.out.println("1: Balance Enquiry   2: Deposit   3: Withdraw   4: More  5:Back ");
                            int choice1=scan.nextInt();
                            switch(choice1)
                            {
                                case 1 : System.out.println("1: Savings Account   2:Current Account ");
                                         int choice2=scan.nextInt();
                                         if(choice2==1)
                                         {
                                             System.out.println("Enter your account number for Balance enquiry in your savings account");
                                             ano = scan.nextInt();
                                             s.savingsBalanceEnquiry(ano);
                                         }
                                         else if(choice2==2)
                                         {
                                             System.out.println("Enter your account number for Balance enquiry in your current account");
                                             ano = scan.nextInt();
                                             c.currentBalanceEnquiry(ano);
                                         }
                                         break;
                                case 2 : System.out.println("1: Savings Account   2:Current Account ");
                                         int choice3=scan.nextInt();
                                         if(choice3==1)
                                         {
                                             System.out.println("Enter your account number for Deposit in your savings account");
                                             ano = scan.nextInt();
                                             System.out.println("Enter the amount to deposit");
                                             float money = scan.nextFloat();
                                             s.savingsDeposit(ano, money);
                                         }
                                         else if(choice3==2)
                                         {
                                             System.out.println("Enter your account number for Deposit in your current account");
                                             ano = scan.nextInt();
                                             System.out.println("Enter the amount to deposit");
                                             float money = scan.nextFloat();
                                             c.currentDeposit(ano, money);
                                         }
                                         break;
                                case 3 : System.out.println("1: Savings Account   2:Current Account ");
                                         int choice4=scan.nextInt();
                                         if(choice4==1)
                                         {
                                             System.out.println("Enter your account number for Withdraw in your savings account");
                                             ano = scan.nextInt();
                                             System.out.println("Enter the amount to withdraw");
                                             float money = scan.nextFloat();
                                             s.savingsWithdraw(ano, money);
                                         }
                                         else if(choice4==2)
                                         {
                                             System.out.println("Enter your account number for Withdraw in your current account");
                                             ano = scan.nextInt();
                                             System.out.println("Enter the amount to withdraw");
                                             float money = scan.nextFloat();
                                             c.currentWithdraw(ano, money);
                                         }
                                         break;
                                case 4 :System.out.println("To Display All Acccounts (Savings & Current), Press (Y/N)");
                                		char ch = scan.next().charAt(0);
                                		if(ch == 'y' || ch == 'Y')
                                		{
                                			a.displayAllAccounts();
                                		}
                                		break;
                                case 5 : break;
                            }
                         
            }
        }
                         
                                        
    }

                         
                         

                
                                    
                
}
            
        
    

