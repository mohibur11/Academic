/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmmachine;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author hp
 */
public class FileAccount {
    
    private ArrayList<Long> account_number = new ArrayList<Long>();
    private ArrayList<String> password = new ArrayList<String>();

    public FileAccount() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("E:\\account.csv"));
        
        while (scanner.hasNext()) {
            String line = scanner.next();
            String[] value = line.split(",");
            this.account_number.add(Long.parseLong(value[0]));
            //scanner.hasNext();
            this.password.add(value[1]);
        }
        //int sz = account_number.size();
        
        
            //System.out.println(password);
        
        scanner.close();
    }

    public ArrayList<Long> getAccountNumber() {
        return this.account_number;
    }

    public ArrayList<String> getPassword() {
        return this.password;
    }
}
