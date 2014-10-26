import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
/**
 * Write a description of class start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class start extends JFrame 
{
    private JTextField title;
    private JButton newapp,cancel,view,check;
    private JTextField tf,max;
    Random ran=new Random();
    private Label lb1,lb2,lb3;
    private int fm=0,uin,rno;
    String store,stcomp="";
    private JTextField d1,d2,d3,d4,d5,d6,d7,d8;
    /**
     * Constructor for objects of class start
     */
    public start()
    {
        super("AppDiary");
        title=new JTextField("Appointments Diary",35);
        title.setEditable(false);
        title.setBackground(Color.gray);
        title.setForeground(Color.white);
        title.setHorizontalAlignment(JTextField.CENTER );
        title.setFont(new Font("Georgia",Font.BOLD+Font.ITALIC,35));
        lb1=new Label("             Welcome");

        lb1.setFont(new Font("Georgia",Font.ITALIC,20));

        newapp=new JButton(">>        CREATE AN APPOINTMENT         <<");
        newapp.setBackground(Color.green);
        
        cancel=new JButton(">>        CANCEL AN APPOINTMENT        <<");
        cancel.setBackground(Color.green);
        
        check=new JButton(">>             CHECK SCHEDULE                <<");
        check.setBackground(Color.green);
        
        view=new JButton(">>        VIEW ALL APPOINTMENTS      <<");
        view.setBackground(Color.green);
        d1=new JTextField(10);
        d1.setVisible(false);
        d2=new JTextField(10);
        d2.setVisible(false);
        d3=new JTextField(10);
        d3.setVisible(false);
        d4=new JTextField(10);
        d4.setVisible(false);
        d5=new JTextField(10);
        d5.setVisible(false);
        d6=new JTextField(10);
        d7=new JTextField(10);
        Date date = new Date(); 
        String str=date.toString();
        lb2=new Label(str);
        lb2.setFont(new Font("Georgia",Font.BOLD,15));
        lb2.setForeground(Color.blue);
        makeFrame();
        showFrame();
        
    }
      private void makeFrame()
    {
        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        c.add(title);
        c.add(lb1);
        
        BH ban=new BH();              // action listener class for button
        newapp.addActionListener(ban);
        cancel.addActionListener(ban);
        check.addActionListener(ban);
        view.addActionListener(ban);
        
        c.add(newapp);
        c.add(cancel);
        c.add(check);
        c.add(view);
        c.add(d1);
        c.add(d2);
        c.add(d3);
        c.add(d4);
        c.add(d5);
        c.add(lb2);


        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel(); 
        JPanel panel3=new JPanel();

        panel1.add(title);
        add(panel1,BorderLayout.NORTH);
        panel2.add(lb1);
        panel2.add(d1);
        panel2.add(newapp);
        panel2.add(d2);
        panel2.add(cancel);
        panel2.add(d3);
        panel2.add(check);
        panel2.add(d4);
        panel2.add(view);
        panel2.add(d5);
        panel2.setLayout( new GridLayout(10,1));
        add(panel2,BorderLayout.CENTER);
        panel3.add(lb2);
  
        panel3.setLayout( new GridLayout(1,1));
        add(panel3,BorderLayout.SOUTH);

    }
     private void showFrame()
    {
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,600);
        setLocationRelativeTo( null);    
        setVisible( true ); 
        
     }  
     private class BH implements ActionListener
     {
         public void actionPerformed(ActionEvent e)
         {
             if(e.getActionCommand()==">>        CREATE AN APPOINTMENT         <<")
             {
       
                    createApp CREobj=new createApp();
                    
             }
             if(e.getActionCommand()==">>        CANCEL AN APPOINTMENT        <<")
             {
       
                    cancelApp CANobj=new cancelApp();
                   
             }
             if(e.getActionCommand()==">>             CHECK SCHEDULE                <<")
             {
                    
                    checkApp CHKobj=new checkApp();
                    
             }
             if(e.getActionCommand()==">>        VIEW ALL APPOINTMENTS      <<")
             {
       
                    viewall tf = new viewall();
             }
          }
      }
    public static void main(String arg[])
    {
        start gm=new start();
    }
 
    
}