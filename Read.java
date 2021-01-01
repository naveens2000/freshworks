/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freshworks;

import java.io.File;
import java.io.FileReader;
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
public class Read {
    void read(String filename)
    {
       System.out.println("\n Enter the option to read"); 
        int flag=0;
        Scanner s=new Scanner(System.in);
        JSONParser parser = new JSONParser();
        do{
        System.out.println("\n1 for view entire data\n2 for view by ID\n3 for view by Name");
        int choice=s.nextInt();
        try {
            File fw=new File(filename);
                if(fw.length()==0)
                    System.out.println("\nFile is either empty nor yet not created");
                else{
                Object obj;
                obj = parser.parse(new FileReader(filename));
                JSONArray arr=(JSONArray)obj;
                if(arr.toString().equals("[]"))
                    System.out.println("\nFile is empty first insert the record to read");
                else
                    {
                    switch(choice)
                    {
                        case 1:
                            for(int i=0;i<arr.size();i++)
                            {
                                JSONObject ob=(JSONObject)arr.get(i);
                                System.out.println("\nId : "+ob.get("Id")+"\nName : "+ob.get("Name")+"\nAge : "+ob.get("Age")+"\nAddress : "+ob.get("Address"));
                            }
                            break;
                        case 2:
                            System.out.println("Enter the id to view to details");
                            String id = s.next();
                            for(int i=0;i<arr.size();i++)
                            {
                                JSONObject ob=(JSONObject)arr.get(i);
                                String idd=ob.get("Id").toString();
                                if(id.equals(idd))
                                {
                                    System.out.println("\nId : "+ob.get("Id")+"\nName : "+ob.get("Name")+"\nAge : "+ob.get("Age")+"\nAddress : "+ob.get("Address"));
                                } else {
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Enter the Name to view the details");
                            String name=s.nextLine()+s.nextLine();
                            for(int i=0;i<arr.size();i++)
                            {
                                JSONObject ob=(JSONObject)arr.get(i);
                                if(ob.get("Name").equals(name))
                                {
                                    System.out.println("\nId : "+ob.get("Id")+"\nName : "+ob.get("Name")+"\nAge : "+ob.get("Age")+"\nAddress : "+ob.get("Address"));
                                }
                            }
                            break;
                        default:
                            System.out.println("Wrong option");
                            flag=1;
                            break;
                    } 
            }
        }
        }
          catch (IOException | ParseException ex ) {
                Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(flag==1);
    }
}
