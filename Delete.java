/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freshworks;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Naveen
 */
public class Delete {
    void delete(String filename)
    {
        int flag=0;
        Scanner s=new Scanner(System.in);
        JSONParser parser = new JSONParser();
        do{
        System.out.println("\n Enter the option to delete");    
        System.out.println("\n1 for delete entire data\n2 for delete data by ID");
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
                    System.out.println("\nFile is empty first insert the record to delete");
                else
                    {
                    switch(choice)
                    {
                        case 1:
                            for(int i=0;i<arr.size();i++)
                            {
                                arr.remove(i);
                            }
                            break;
                        case 2:
                            System.out.println("Enter the id to delete the particular details");
                            String id = s.next();
                            for(int i=0;i<arr.size();i++)
                            {
                                JSONObject ob=(JSONObject)arr.get(i);
                                String idd=ob.get("Id").toString();
                                if(id.equals(idd))
                                {
                                    arr.remove(i);
                                    System.out.println("\n\nData deleted is:");
                                    System.out.println("Id : "+ob.get("Id")+"\nName : "+ob.get("Name")+"\nAge : "+ob.get("Age")+"\nAddress : "+ob.get("Address"));
                                }
                            }
                            break;
                        default:
                            System.out.println("Wrong option");
                            flag=1;
                            break;
                    }
            try (FileWriter f = new FileWriter(filename)) {
                f.write(arr.toJSONString());
                f.close();
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
