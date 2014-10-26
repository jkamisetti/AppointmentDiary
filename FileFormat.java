import java.io.*;
/**
 * Write a description of class FileFormat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileFormat
 {
    public static void main(String args[]) throws IOException
      {
        String s=" ",empty="",s1;
        long ptr;
        int i=0,j=0; 
        float k=0;  
        
        while(i<20)
         {
          s=s+" ";
          i++;
     }  
       
       try
       {
        RandomAccessFile raf =new RandomAccessFile("APPDATABASE.dat","rw");
        ptr=raf.getFilePointer();
        raf.seek(0L);
        s1=raf.readUTF();
        ptr=raf.getFilePointer();
        if(empty.equals(s1))
        {
        raf.seek(0L);
        for(i=0;i<5;i++)
         {
           raf.writeUTF("Time&Date");
           raf.writeUTF(s);
           raf.writeUTF("PLACE");
           raf.writeUTF(s);
           raf.writeUTF("Description ");
           raf.writeUTF(s);
           
           raf.writeUTF("Time&Date");
           raf.writeUTF(s);
           raf.writeUTF("PLACE");
           raf.writeUTF(s);
           raf.writeUTF("Description ");
           raf.writeUTF(s);
           
           raf.writeUTF("Time&Date");
           raf.writeUTF(s);
           raf.writeUTF("PLACE");
           raf.writeUTF(s);
           raf.writeUTF("Description ");
           raf.writeUTF(s);
           
           raf.writeUTF("Time&Date");
           raf.writeUTF(s);
           raf.writeUTF("PLACE");
           raf.writeUTF(s);
           raf.writeUTF("Description ");
           raf.writeUTF(s);
           
           raf.writeUTF("Time&Date");
           raf.writeUTF(s);
           raf.writeUTF("PLACE");
           raf.writeUTF(s);
           raf.writeUTF("Description ");
           raf.writeUTF(s);
           
           raf.writeUTF("Time&Date");
           raf.writeUTF(s);
           raf.writeUTF("PLACE");
           raf.writeUTF(s);
           raf.writeUTF("Description ");
           raf.writeUTF(s);
           
           raf.writeUTF("Time&Date");
           raf.writeUTF(s);
           raf.writeUTF("PLACE");
           raf.writeUTF(s);
           raf.writeUTF("Description ");
           raf.writeUTF(s);
           
           raf.writeUTF("Time&Date");
           raf.writeUTF(s);
           raf.writeUTF("PLACE");
           raf.writeUTF(s);
           raf.writeUTF("Description ");
           raf.writeUTF(s);
           
           raf.writeUTF("Time&Date");
           raf.writeUTF(s);
           raf.writeUTF("PLACE");
           raf.writeUTF(s);
           raf.writeUTF("Description ");
           raf.writeUTF(s);
           
           raf.writeUTF("Time&Date");
           raf.writeUTF(s);
           raf.writeUTF("PLACE");
           raf.writeUTF(s);
           raf.writeUTF("Description ");
           raf.writeUTF(s);
           System.out.println("Tested");
           }
          }
          else 
            raf.seek(0L);
           raf.close(); 
           start gm=new start();
       }
    
     catch(Exception e)
       { 
        System.out.println("Exception");
       }
     
     }
  }  
