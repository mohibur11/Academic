/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmmachine;

/**
 *
 * @author hp
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class ATMmachine {

    
    public static void main(String[] args) throws FileNotFoundException {
        
        System.out.println("Enter your account no:");
        Scanner  scanner = new Scanner(System.in);
        long account_no = scanner.nextLong();
        System.out.println("Enter your password:");
        String password = scanner.next();
        FileAccount fileaccount = new FileAccount();
        Account account = new Account(account_no,password,fileaccount);
        account.getInfo();
    }
    
}
