/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmmachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author hp
 */
public class BalanceInfo {

    private ArrayList<Double> balance = new ArrayList<Double>();
    
    public BalanceInfo() throws FileNotFoundException {
        System.out.println("Main Menu\n1: Check Balance\n2: Withdraw\n3: Deposit\n4: Exit\nEnetr Choice");
        //read csv balance from here

        Scanner scanner = new Scanner(new File("E:\\amount.csv"));
        
        scanner.useDelimiter("\n");
        while(scanner.hasNext())
        {this.balance.add(Double.parseDouble(scanner.next()));}
        
    }

    public Double CheckBalance(Integer index) {
        return balance.get(index);
    }

    public boolean withdraw(Double balance,Integer index) {
        FileWriter writer = null;
        if (balance > this.balance.get(index)) {
            return false;
        } else { 
            double temporary_balance = this.balance.get(index)- balance; 
            this.balance.set(index, temporary_balance);

            try {

                writer = new FileWriter("E:\\amount.csv");
                for(int i=0;i<this.balance.size();i++){
                    writer.append(Double.toString(this.balance.get(i)));
                    writer.append('\n');
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

    }

    public void deposit(Double balance,Integer index) {

        FileWriter writer = null;
        double temporary_balance = this.balance.get(index)+ balance; 
            //this.balance.remove(index);
            this.balance.set(index, temporary_balance);

            try {

                writer = new FileWriter("E:\\amount.csv");
                for(int i=0;i<this.balance.size();i++){
                    writer.append(Double.toString(this.balance.get(i)));
                    writer.append('\n');
                }
            }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
