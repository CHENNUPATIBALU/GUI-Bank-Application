/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.pkgintf;

/**
 *
 * @author chenn
 */
public interface IAccount {
    public void balanceEnquiry(int ano);
    public void depositAmount(int ano);
    public void withdrawAmount(int ano);
}
