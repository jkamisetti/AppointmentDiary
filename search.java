import java.io.*;
import javax.swing.*;

/**
 * Write a description of class search here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class search
{
   public String inputdate;
   public int flag=0;
   String s1,s2,s3,s4,s5,s6;
   long ptr;
    public search()
    {
       
    }

   public int checking(String inputdate)
     {
         String info="U have Appointment\n";
         try
       {
        RandomAccessFile raf =new RandomAccessFile("APPDATABASE.dat","rw");
        raf.seek(0L);
        flag=0;
        while(inputdate.length()<=20)
            { 
                inputdate=inputdate+" ";
            }
        do
        {          
           s1=raf.readUTF();
           s2=raf.readUTF();
           s3=raf.readUTF();
           s4=raf.readUTF();
           s5=raf.readUTF();
           s6=raf.readUTF();
           
           if(s2.equals(inputdate))
           {
                info=info+s2+"    "+s4+"   "+s6+"\n";
                JOptionPane.showMessageDialog(null,info);
                flag=1;
            }
           
           ptr=raf.getFilePointer();
           if(ptr==raf.length())
            {
                raf.close();
                break;
            }

          }while(ptr<raf.length());
 
           raf.close();
         }
       
     catch(Exception e)
       { 
        System.out.println("Exception"+e);
       }
       return flag;
     }
}
