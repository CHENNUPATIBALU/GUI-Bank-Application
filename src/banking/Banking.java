
package banking;
import java.util.*;
import banking.pkgder.*;

public class Banking {

    static int saCount,caCount;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ano;
        SavingsAccount sa[] = new SavingsAccount[10];
        for(int i=0;i<10;i++)
        {
            sa[i]=new SavingsAccount();
        }
        CurrentAccount ca[] = new CurrentAccount[10];
        for(int i=0;i<10;i++)
        {
            ca[i]=new CurrentAccount();
        }
        System.out.println("------------------------------------");
        System.out.println("|    WELCOME TO PRESIDENCY BANK    |");
        System.out.println("------------------------------------");
        for(;;)
        {
            System.out.println("");
            System.out.println("1: Savings Account   2:Current Account   3:More options");
            System.out.println("Enter your choice");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1 : sa[saCount].createAccount();
                         saCount++;
                         break;
                                        
                case 2: ca[caCount].createAccount();
                        caCount++;
                        break;
                                        
                case 3 : 
                            System.out.println("1: Balance Enquiry   2: Deposit   3: Withdraw   4:Back ");
                            int choice1=scan.nextInt();
                            switch(choice1)
                            {
                                case 1 : System.out.println("1: Savings Account   2:Current Account ");
                                         int choice2=scan.nextInt();
                                         if(choice2==1)
                                         {
                                             System.out.println("Enter your account number for Balance enquiry in your savings account");
                                             ano = scan.nextInt();
                                             for(int i=0;i<saCount;i++)
                                               sa[i].balanceEnquiry(ano);
                                         }
                                         else if(choice2==2)
                                         {
                                             System.out.println("Enter your account number for Balance enquiry in your current account");
                                             ano = scan.nextInt();
                                             for(int i=0;i<caCount;i++)
                                               ca[i].balanceEnquiry(ano);
                                         }
                                         break;
                                case 2 : System.out.println("1: Savings Account   2:Current Account ");
                                         int choice3=scan.nextInt();
                                         if(choice3==1)
                                         {
                                             System.out.println("Enter your account number for Balance enquiry in your savings account");
                                             ano = scan.nextInt();
                                             for(int i=0;i<saCount;i++)
                                               sa[i].depositAmount(ano);
                                         }
                                         else if(choice3==2)
                                         {
                                             System.out.println("Enter your account number for Balance enquiry in your current account");
                                             ano = scan.nextInt();
                                             for(int i=0;i<caCount;i++)
                                               ca[i].depositAmount(ano);
                                         }
                                         break;
                                case 3 : System.out.println("1: Savings Account   2:Current Account ");
                                         int choice4=scan.nextInt();
                                         if(choice4==1)
                                         {
                                             System.out.println("Enter your account number for Balance enquiry in your savings account");
                                             ano = scan.nextInt();
                                             for(int i=0;i<saCount;i++)
                                               sa[i].withdrawAmount(ano);
                                         }
                                         else if(choice4==2)
                                         {
                                             System.out.println("Enter your account number for Balance enquiry in your current account");
                                             ano = scan.nextInt();
                                             for(int i=0;i<caCount;i++)
                                               ca[i].withdrawAmount(ano);
                                         }
                                         break;
                                case 4 : break;
                            }
                         
            }
        }
                         
                                        
    }

                         
                         

                
                                    
                
}
            
        
    

