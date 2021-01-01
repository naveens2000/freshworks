/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freshworks;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Naveen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice,flag,i=1,f_no=1;
        String files="";
        Scanner s=new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println(" WELCOME TO FILE BASED KEY VALUE DATA STORE");
        System.out.println("---------------------------------------------");
        do{
        System.out.println("1 for create\n2 for append in existing file\n3 for read\n4 for delete");
        System.out.print("Enter your choice:");
        choice=s.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("--------");
                System.out.println(" CREATE ");
                System.out.println("--------");
                String filename;
                System.out.println("1 for Default Location\n2 for User Location and enter the FileName");
                int cho=s.nextInt();
                if(cho==2)
                {
                    System.out.println("Enter the file:");
                    filename=s.nextLine()+s.nextLine();
                }
                else
                {
                    filename="default"+i+".json";
                    i+=1;
                } 
                files+="\n"+f_no+")"+filename;
                f_no+=1;
                Create c=new Create();
                File file=new File(filename);
                try {           
                    file.createNewFile();
                    System.out.println("File created and the file name is "+filename);
                    } 
                catch (IOException ex) 
                    {
                        ex.getStackTrace();
                    }
                c.create(filename);
                break;
            case 2:
                System.out.println("-------------------------");
                System.out.println(" APPEND TO EXISTING FILE ");
                System.out.println("-------------------------");
                String filename1;
                System.out.println("File created are:"+files);
                System.out.println("Enter the file:");
                filename=s.nextLine()+s.nextLine();
                Append ap=new Append();
                File file_ap=new File(filename);
                try {           
                    file_ap.createNewFile();
                    System.out.println("File created and the file name is "+filename);
                    } 
                catch (IOException ex) 
                    {
                        ex.getStackTrace();
                    }
                ap.append(filename);
                break;
            case 3:
                System.out.println("--------");
                System.out.println("  READ  ");
                System.out.println("--------");
                System.out.println("Files created are:"+files);
                System.out.println("Enter the file name to read:");
                String f=s.next();
                Read r=new Read();
                r.read(f);
                break;
            case 4:
                System.out.println("--------");
                System.out.println(" DELETE ");
                System.out.println("--------");
                System.out.println("Files created are:"+files);
                System.out.println("Enter the file name to read:");
                String f1=s.next();
                Delete d=new Delete();
                d.delete(f1);
                break;
            default:
                System.out.println("Invalid choice");
        }
        System.out.print("\n1 for continue\n0 for exit\nDo you want to continue:");
        flag=s.nextInt();
        }
        while(flag==1);
    }    
}
