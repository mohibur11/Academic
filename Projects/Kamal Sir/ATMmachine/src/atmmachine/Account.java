/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmmachine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Account {

    private long account_number;
    private String password;
    private FileAccount file_account;
    private int index;
    Scanner scanner = new Scanner(System.in);

    public Account(long account_number, String password, FileAccount file_account) {
        this.account_number = account_number;
        this.password = password;
        this.file_account = file_account;
    }

    public boolean testing() throws NumberFormatException {
        this.index = file_account.getAccountNumber().indexOf(account_number);
        if ( index != -1  && password.equals(file_account.getPassword().get(index))) {
            System.out.println("Login Successful\n");
            return true;
        } else {
            System.out.println("Login Unsuccessful");
            return false;
        }
    }

    public void getInfo() throws FileNotFoundException {
        boolean test = testing();
        if (test) {
            BalanceInfo balanceinfo = new BalanceInfo();
            while (test) {

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Your Current Balance is : " + balanceinfo.CheckBalance(index));
                        break;
                    case 2: {
                        System.out.println("Enter the Ammount");
                        Double balance = scanner.nextDouble();
                        boolean check = balanceinfo.withdraw(balance,index);
                        if(check)
                        System.out.println("After Withdraw " + balance + " Taka, Your Current Balance is : " + balanceinfo.CheckBalance(index));
                        else
                        System.out.println("Sorry. You do not have " + balance + " Taka to withdraw");
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the Ammount");
                        Double balance = scanner.nextDouble();
                        balanceinfo.deposit(balance,index);
                        System.out.println("After Deposit " + balance + " Taka, Your Current Balance is : " + balanceinfo.CheckBalance(index));
                        break;
                    }
                    default:
                        System.exit(0);
                }
            }
        }
        else
            System.exit(0);
    }
}
