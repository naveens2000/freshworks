/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freshworks;

import static freshworks.Create.id;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Naveen
 */
public class Append {
    void append(String filename)
    {
        System.out.println("\n Enter the records to append to file");
        Scanner s=new Scanner(System.in);
        File fw = null;
        JSONArray arr1 = null;
        try {
            fw = new File(filename);
            if(fw.length()!=0){
            JSONParser p=new JSONParser();
            Object obj;
            obj=p.parse(new FileReader(filename));
            arr1=(JSONArray)obj;
                }
            else{
                arr1=new JSONArray();
            }
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
            System.out.println("\nId : "+o.get("Id")+"\nName : "+o.get("Name")+"\nAge : "+o.get("Age")+"\nAddress : "+o.get("Address"));
            arr1.add(o);
            System.out.println("Do you want to continue to add the data\n1 for yes\n0 for no:");
            flag=Integer.parseInt(s.nextLine());
            }
            while(flag==1);
            FileWriter cr;
            cr = new FileWriter(filename);
            cr.write(arr1.toJSONString());
            cr.close();
            System.out.println("Record inserted successfully"); 
        }   catch (IOException | ParseException ex) {
            Logger.getLogger(Append.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
