/*********************************
Author: Ariel Fevry
Class: COP3330, 0V05
Assignment 10: Ordering System, FoodOrderRunner.java, FoodOrder.java, DineInOrder.java
               TakeoutOrder.java, DeliveryOrder.java
Date: 11/10/2025
Purpose: Create an abstract class FoodOrder implementing Comparable. Create 3 child classes
         extending the abstract class. Read in 1 file with 2 alternate options if file DNE.
         Utilize Priroity Queues, File error/exception handeling;
*********************************/

import java.util.*;
import java.io.*;

public class FoodOrderRunner{
    public static FoodOrder createOrder(Scanner fp){
        String type = fp.next();
        String name = fp.next();
        String item = fp.next();
        int priority = fp.nextInt();

        fp.nextLine(); //consume nextLine

        FoodOrder order = new DineInOrder(name, item, priority);

        switch(type){
            case "TAKEOUT":
                order = new TakeoutOrder(name, item ,priority);
                break;

            case "DELIVERY":
                order = new DeliveryOrder(name, item, priority);
                break;

            case "DINEIN":
                order = new DineInOrder(name, item, priority);
                break;

            default:
                //return NULL; //unrecognizeable order type
        }

        return order; 
    }

    public static void main(String[] args){
        String files[] = {"a7a.txt", "a7b.txt", "a7c.txt"};
        File file;
        int i = 0; // iteration counter if the files do not exist

        // open file using files array
        do{
            file = new File(files[i]);
            i++;
        }while(!file.exists() && i < files.length); //file DNE or no more to open

        //if do while ended because ran out of filesr
        if(i >= files.length && !file.exists()){
            System.out.println("Input files do not exist");
            return;
        }

        //if do while ended without running out of files can try opening
        try{
            PriorityQueue<FoodOrder> orders = new PriorityQueue<FoodOrder>();
            Scanner fp = new Scanner(file);

            int lines = fp.nextInt();
            fp.nextLine(); // consume new line char

            for(int j = 0; j < lines; j++){
                String command = fp.next();

                if(command.equals("PREPARE")){
                    if(!orders.isEmpty()){
                        orders.poll().prepareOrder(); //poll and prepare
                        //fp.nextLine(); //consumer line;
                    }
                }
                else orders.add(createOrder(fp)); // create order and add to queue
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}