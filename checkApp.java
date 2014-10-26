import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.io.*;
/**
 * Write a description of class checkApp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class checkApp extends JFrame
{
  private JTextField title,time,dd,mm,place;
    private JButton ok,cancel,reset;
    private JLabel l1,t1;
    String empty="",inputdate;
    String s1,s2,s3,s4,s5,s6;
    int flag=0;
    long ptr;
    public checkApp()
    {
        super("CheckApp");
        title=new JTextField("Check Appointment",20);
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
        
        ActionHandler ban=new ActionHandler();              // action listener class for button
        ok.addActionListener(ban);
        cancel.addActionListener(ban);
        reset.addActionListener(ban);
        time.addActionListener(ban);
        dd.addActionListener(ban);
        mm.addActionListener(ban);
        
        c.add(l1);
        c.add(time);
        c.add(dd);
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
    

        setSize(350,500);
        setLocationRelativeTo( null);    
        setVisible( true ); 
        
     }
     
     private class ActionHandler implements ActionListener
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
                            flag=0;
                            search sob=new search();
                            flag=sob.checking(inputdate);
                            
                            if(flag==0)
                                JOptionPane.showMessageDialog(null,"U  Don't have Any Appointment on that day");
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
    
     public static void main(String arg[])
    {
        checkApp CHKobj=new checkApp();
    }  
}
