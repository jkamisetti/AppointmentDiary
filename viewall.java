import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
/**
 * Write a description of class stable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class viewall extends JFrame
{
   String titles[] = new String[]{"Time & Date","Place","Description"};
   private JLabel t1;
   private JButton close;
   private JTextField title;
   String s1,s2,s3,s4,s5,s6;
   int i=0;
   long ptr;
   public viewall(){
        
        super("ViewAllApps");
        title=new JTextField("All Appointments",20);
        title.setEditable(false);
        title.setBackground(Color.gray);
        title.setForeground(Color.white);
        title.setHorizontalAlignment(JTextField.CENTER );
        title.setFont(new Font("Georgia",Font.BOLD+Font.ITALIC,20));
        t1=new JLabel("                                                   ");
        close=new JButton("CLOSE");
        close.setBackground(Color.green);
        CHandler ban=new CHandler();
        close.addActionListener(ban);
        setSize(500, 600);
        setVisible(true);
        Object[][] stats = new Object[50][3];
        try
       {
        RandomAccessFile raf =new RandomAccessFile("APPDATABASE.dat","rw");
        raf.seek(0L);
        do
        {          
	       s1=raf.readUTF();
           s2=raf.readUTF();
           s3=raf.readUTF();
           s4=raf.readUTF();
           s5=raf.readUTF();
           s6=raf.readUTF();
           stats[i][0]=s2;
           stats[i][1]=s4;
           stats[i][2]=s6;
           ptr=raf.getFilePointer();
           if(ptr==raf.length())
            {
                raf.close();
                break;
            }
            i++;
          }while(ptr<raf.length());
 
           raf.close();
         }
       
     catch(Exception e)
       { 
        System.out.println("Exception"+e);
       }
        
        JTable jt = new JTable(stats, titles);
        jt.setColumnSelectionAllowed(true);

       JScrollPane jsp = new JScrollPane(jt);
       JPanel panel1 = new JPanel();
       getContentPane( ).add(title,BorderLayout.NORTH);
       panel1.add(t1);
       panel1.add(jsp);
       getContentPane( ).add(panel1, BorderLayout.CENTER);
       
       JPanel panel2 = new JPanel();
       panel2.add(close);
       getContentPane( ).add(panel2, BorderLayout.SOUTH);
    }
    
    private class CHandler implements ActionListener
     {
         public void actionPerformed(ActionEvent e)
         {
             if(e.getActionCommand()=="CLOSE")
             {
                 setVisible(false);
             }
          }
      }
    public static void main(String args[]) {
    viewall tf = new viewall();
    
  }

}
