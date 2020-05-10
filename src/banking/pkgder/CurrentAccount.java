/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.pkgder;
import banking.pkgbase.Account1;
import java.util.Random;

public class CurrentAccount extends Account1{
    public CurrentAccount()
    {
        rateInterest=0;
        overdraft=true;
    }
    Random rand = new Random();
    public void create()
    {
            
            System.out.println("Your Account type is CURRENT");
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
