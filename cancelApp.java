import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.io.*;
/**
 * Write a description of class cancelApp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cancelApp extends JFrame
{
    private JTextField title,time,dd,mm,place;
    private JButton ok,cancel,reset;
    private JLabel l1,t1;
    String empty="",inputdate,empty1="                     ";
    String s1,s2,s3,s4,s5,s6;
    int flag=0;
    long ptr;
    public cancelApp()
    {
        super("CancelApp");
        title=new JTextField("Cancel Appointment",20);
        title.setEditable(false);
        title.setBackground(Color.gray);
        title.setForeground(Color.white);
        title.setHorizontalAlignment(JTextField.CENTER );
        title.setFont(new Font("Georgia",Font.BOLD+Font.ITALIC,20));
        time=new JTextField(2);
        dd=new JTextField(2);
        mm=new JTextField(2);
        ok=new JButton("OK");
        ok.setBackground(Color.green);
        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.red);
        reset=new JButton("RESET");
        reset.setBackground(Color.green);
        l1=new JLabel("Enter Time&Date of appmt");
        l1.setForeground(Color.blue);
        t1=new JLabel("");
        makeFrame();
        showFrame();
    }
    private void makeFrame()
    {
        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        
        BHandler ban=new BHandler();              // action listener class for button
        ok.addActionListener(ban);
        cancel.addActionListener(ban);
        reset.addActionListener(ban);
        time.addActionListener(ban);
        dd.addActionListener(ban);
        mm.addActionListener(ban);
        
        c.add(l1);
        c.add(time);
        c.add(dd);
        //max.addActionListener(ban);
        c.add(mm);
        c.add(t1);
        c.add(ok);
        c.add(cancel);
        c.add(reset);
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel(); 
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel(); 
        JPanel panel6 = new JPanel();
        
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
        
        panel4.add(panel2);
        panel4.add(panel3);
        panel4.setLayout( new GridLayout(1,2));
        
        panel5.add(panel4);
        panel5.add(t1);
        panel5.setLayout( new GridLayout(2,1));
        add(panel5,BorderLayout.CENTER);
        
        panel6.add(ok);
        panel6.add(cancel);
        panel6.add(reset);
        panel6.setLayout( new GridLayout(1,3));
        add(panel6,BorderLayout.SOUTH);
    }
    private void showFrame()
    {
    
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,500);
        setLocationRelativeTo( null);    
        setVisible( true ); 
        
     }
     
     private class BHandler implements ActionListener
     {
         public void actionPerformed(ActionEvent e)
         {
             if(e.getActionCommand()=="OK")
             {
                 if((empty.equals(time.getText()))||(empty.equals(dd.getText()))||(empty.equals(mm.getText())))
                 {
                     JOptionPane.showMessageDialog(null,"Enter Time & Date");
                 }
                 
                 else
                 {
                    
                    inputdate=time.getText()+"-"+dd.getText()+"-"+mm.getText();
                    if(inputdate.length()>8)
                            JOptionPane.showMessageDialog(null,"Invalid time & Date");
                    else
                        {
                            checking();
                            if(flag==0)
                                JOptionPane.showMessageDialog(null,"U  Don't have Any Appointment on that day to Cancel");
                        }
                    time.setText("");
                    dd.setText("");
                    mm.setText("");

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

             }
         }
     }
    
     public void checking()
     {
         String s,info="U have Appointment\n";
         try
       {
        RandomAccessFile raf =new RandomAccessFile("APPDATABASE.dat","rw");
        raf.seek(0L);
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
           ptr=raf.getFilePointer();
           if(s2.equals(inputdate))
           {
                info=info+s2+"    "+s4+"   "+s6+"\n"+ "This Appointment Deleted Success fully";
                JOptionPane.showMessageDialog(null,info);
                flag=1;
                raf.seek(ptr-101);
                s=raf.readUTF();
                raf.writeUTF(empty1);
                s=raf.readUTF();
                raf.writeUTF(empty1);
                s=raf.readUTF();
                raf.writeUTF(empty1);
                break;
            }
           
           ptr=raf.getFilePointer();
           
           if(ptr==raf.length())
            {
                raf.close();
                break;
            }

          }while(ptr<raf.length());
 
           raf.close();
           System.out.println("job done!"+ptr); 
         }
     catch(Exception e)
       { 
        System.out.println("Exception"+e);
       }
     }
     public static void main(String arg[])
    {
        cancelApp CANobj=new cancelApp();
    }
    
}
