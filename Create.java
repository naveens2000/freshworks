/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freshworks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 *
 * @author Naveen
 */
public class Create {
    static int id=1;
    void create(String filename)
    {   System.out.println("\n Enter the records to insert"); 
        Scanner s=new Scanner(System.in);
        JSONArray arr1 = new JSONArray();
        int flag;
        do{
            JSONObject o=new JSONObject();
            String name,add;
            o.put("Id",id);
            System.out.print("Enter the name:");
            name=s.nextLine();
            System.out.print("Enter the age:");
            int age=Integer.parseInt(s.nextLine());
            System.out.print("Enter the address:");
            add=s.nextLine();
            o.put("Name",name);
            o.put("Age",age);
            o.put("Address",add);
            id+=1;
            System.out.println("\n\nData entered is:");
            System.out.println("Id : "+o.get("Id")+"\nName : "+o.get("Name")+"\nAge : "+o.get("Age")+"\nAddress : "+o.get("Address"));
            arr1.add(o);
            System.out.println("\n\nDo you want to continue to add the data\n1 for yes\n0 for no:");
            flag=Integer.parseInt(s.nextLine());
            }
            while(flag==1);
        try {
            FileWriter cr;
            cr = new FileWriter(filename);
            cr.write(arr1.toJSONString());
            cr.close();
            System.out.println("Record inserted successfully");
            } 
        catch(IOException ex) 
            {
            System.out.println("Error in creating the file and the error is "+ex);
            }
    }
}
