import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.lang.*;
import java.io.*;

/**
 * Write a description of class creatApp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class createApp extends JFrame
{
   private JTextField title,time,dd,mm,place,desc;
   private JButton ok,cancel,reset;
   private JLabel l1,l2,l3,t1,t2,t3,t4;
   public String inputdate,inputplace,inputdesc;
   String empty="";
   RandomAccessFile raf;
   int flag;
   long position;
   long fileLength,ptr;
   public createApp()
   {
        super("createApp");
        title=new JTextField("Create new Appointment",20);
        title.setEditable(false);
        title.setBackground(Color.gray);
        title.setForeground(Color.white);
        title.setHorizontalAlignment(JTextField.CENTER );
        title.setFont(new Font("Georgia",Font.BOLD+Font.ITALIC,20));
        time=new JTextField(2);
        dd=new JTextField(2);
        mm=new JTextField(2);
        place=new JTextField(10);
        desc=new JTextField(10);
        ok=new JButton("OK");
        ok.setBackground(Color.green);
        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.red);
        reset=new JButton("RESET");
        reset.setBackground(Color.green);
        l1=new JLabel("Enter Time&Date of appmt");
        l1.setForeground(Color.blue);
        l2=new JLabel("Enter Place");
        l2.setForeground(Color.blue);
        l3=new JLabel("Write Decription");
        l3.setForeground(Color.blue);
        t1=new JLabel("");
        t2=new JLabel("");
        t3=new JLabel("");
        makeFrame();
        showFrame();
    }  

    private void makeFrame()
    {
        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
         
        BH ban=new BH();              // action listener class for button
        ok.addActionListener(ban);
        cancel.addActionListener(ban);
        reset.addActionListener(ban);
        time.addActionListener(ban);
        dd.addActionListener(ban);
        mm.addActionListener(ban);
        place.addActionListener(ban);
        desc.addActionListener(ban);
        c.add(title);
        c.add(time);
        c.add(dd);
        c.add(mm);
        c.add(place);
        c.add(desc);
        c.add(ok);
        c.add(cancel);
        c.add(reset);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel(); 
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel(); 
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        JPanel panelt1 = new JPanel();
        JPanel panelt2 = new JPanel();
        JPanel panelt3 = new JPanel();
        
        panel1.add(title);
        panel1.add(t1);
        panel1.setLayout( new GridLayout(2,1));
        add(panel1,BorderLayout.NORTH);
        panel2.add(l1);
        panel2.setLayout( new GridLayout(1,1));
        
        panel3.add(time);
        panel3.add(dd);
        panel3.add(mm);
        panel3.setLayout( new GridLayout(1,3));
       
        panelt1.add(panel3);
        panelt1.add(t1);
        panelt1.setLayout( new GridLayout(2,1));
       
        panel4.add(panel2);
        panel4.add(panelt1);
        panel4.setLayout( new GridLayout(1,2));
        
        panel5.add(l2);
        panel5.add(place);
        panel5.setLayout( new GridLayout(1,2));
        
        panelt2.add(panel5);
        panelt2.add(t1);
        panelt2.setLayout( new GridLayout(2,1));
        
        panel6.add(panel4);
        panel6.add(panelt2);
        panel6.setLayout( new GridLayout(2,1));
        
        panel7.add(l3);
        panel7.add(desc);
        panel7.setLayout( new GridLayout(1,2));

        panel8.add(panel6);
        panel8.add(panel7);

        panel8.setLayout( new GridLayout(2,1));
        add(panel8,BorderLayout.CENTER);
        
        panelt3.add(t1);
        panelt3.setLayout( new GridLayout(1,1));
        
        panel9.add(ok);
        panel9.add(cancel);
        panel9.add(reset);
        panel9.setLayout( new GridLayout(1,3));
        
        panel10.add(panelt3);
        panel10.add(panel9);
        panel10.setLayout( new GridLayout(2,1));
        add(panel10,BorderLayout.SOUTH);
        
    }
    private void showFrame()
    {
        setSize(350,500);
        setLocationRelativeTo( null);    
        setVisible( true ); 
        
     }
     
     private class BH implements ActionListener
     {
         public void actionPerformed(ActionEvent e)
         {
             if(e.getActionCommand()=="OK")
             {
                 if((empty.equals(time.getText()))||(empty.equals(dd.getText()))||(empty.equals(mm.getText())))
                 {
                     JOptionPane.showMessageDialog(null,"Enter Time & Date");
                 }
                 else if(empty.equals(place.getText()))
                 {
                     JOptionPane.showMessageDialog(null,"Enter Place");
                 }
                 else if(empty.equals(desc.getText()))
                 {
                     JOptionPane.showMessageDialog(null,"Enter Description");
                 }
                 else
                 {
                    inputdate=time.getText()+"-"+dd.getText()+"-"+mm.getText();
                    inputplace=place.getText();
                    inputdesc=desc.getText();
                    if(inputdate.length()>8)
                            JOptionPane.showMessageDialog(null,"Invalid time & Date");
                    else if(inputplace.length()>20)
                            JOptionPane.showMessageDialog(null,"U have to give place name in the range 0-20");
                    else if(inputdesc.length()>20)
                            JOptionPane.showMessageDialog(null,"U have to Write Description  in the range 0-20");
                    else
                    {
                        flag=0;
                        search sob=new search();
                        flag=sob.checking(inputdate);
                        if(flag==1)
                                JOptionPane.showMessageDialog(null,"U have Already An Appointment on that day");
                        else
                        {
                             writeInFile();
                             JOptionPane.showMessageDialog(null,"New Appointment Created Successfully");
                         }
                    }
                    time.setText("");
                    dd.setText("");
                    mm.setText("");
                    place.setText("");
                    desc.setText("");
                 }
             }
             if(e.getActionCommand()=="CANCEL")
             {
                 setVisible(false);
             }
             if(e.getActionCommand()=="RESET")
             {
                 time.setText("");
                 dd.setText("");
                 mm.setText("");
                 place.setText("");
                 desc.setText("");
             }
         }
     }
     
     public void writeInFile()
    {
      String s,empty1="                     ";
      try
       {    
           raf= new RandomAccessFile("APPDATABASE.dat","rw");
           raf.seek(0L);
           
            while(inputdate.length()<=20)
            { 
                inputdate=inputdate+" ";
            }
            while(inputplace.length()<=20)
            { 
                inputplace=inputplace+" ";
            }
            while(inputdesc.length()<=20)
            {
                inputdesc=inputdesc+" ";   
            }
       
            fileLength=raf.length();
            s=raf.readUTF();
            while(!(empty1.equals(s)))
            {
             
             ptr=raf.getFilePointer();
             s=raf.readUTF();
            }
            position=ptr-11;
            raf.seek(position);
            ptr=raf.getFilePointer();

            ptr=raf.getFilePointer();
            s=raf.readUTF();
            raf.writeUTF(inputdate);
            s=raf.readUTF();
            raf.writeUTF(inputplace);
            s=raf.readUTF();
            raf.writeUTF(inputdesc);
            ptr=raf.getFilePointer();         
            ptr=0;
            raf.close();
           
         }
        catch(Exception e)
          {
            System.out.println("Exception"+e.getMessage());
            
          } 
}
     
     public static void main(String arg[])
    {
        createApp CREobj=new createApp();
    }
}
