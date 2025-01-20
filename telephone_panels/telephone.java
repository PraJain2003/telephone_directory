
package telephone_panels;


import java.awt.CardLayout;
import java.awt.*;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
import telephone_models.MyLib;


public class telephone extends JFrame {

    CardLayout cl1,cl2;
    MenuBar bar;
    Menu f1,f2,f3;
    MenuItem t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    
    Container CT;
    
    Panel Welcome;
    homepage p1;
    Login p2;
    
    Registrationform usreg;
    Edituserdata useredt;
    
    AdminRegistration admreg;
    ShowAdmin admedt;
    
    SearchBy s;
    SearchBy1 s1;
    SearchBy2 s2;
    
    public telephone()
    {
      cl1=new CardLayout();
      cl2=new CardLayout();
      
      CT=getContentPane();
      bar=new MenuBar();
      f1=new Menu("Home");
      f2=new Menu("Admin");
      f3=new Menu("Customer");
      
      //for menuitems
      t1=new MenuItem("Go To Home");
      t2=new MenuItem("Login");
      t3=new MenuItem("Exit");
      t4=new MenuItem("Admin Reg");
      t5=new MenuItem("Admin Update");
      t6=new MenuItem("Show Admin");
      t7=new MenuItem("Register User");
      t8=new MenuItem("Update User");
      t9=new MenuItem("Search By Contact");
      t10=new MenuItem("Search By ID");
      t11=new MenuItem("Search By Email");
      
      Welcome=new Panel();
      p1=new homepage();
      p2=new Login();
      usreg=new Registrationform();
      useredt=new Edituserdata();
      admreg=new AdminRegistration();
      admedt=new ShowAdmin();
      s=new SearchBy();
      s1=new SearchBy1();
      s2=new SearchBy2();
      
      //setting layout
        setLayout(cl1);
        Welcome.setLayout(cl2);
        
        Welcome.add(p1,"Card1");
        Welcome.add(p2,"Card2");
        
        setMenuBar(bar);
        
        //adding the menu's to the bar 
        bar.add(f1);
        bar.add(f2);
        bar.add(f3);
        
        //adding menuitems to the menu
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f2.add(t4);
        f2.add(t5);
        f2.add(t6);
        f3.add(t7);
        f3.add(t8);
        f3.add(t9);
        f3.add(t10);
        f3.add(t11);
        
        //adding cards for all panels
        add(Welcome,"wel_card");  //string name is declared which will be used in else if
        add(admreg,"adm_reg");
        add(admedt,"adm_edt");
        add(usreg,"user_reg");
        add(useredt,"user_edt");
        add(s,"search_by_contact");
        add(s1,"search_by_id");
        add(s2,"search_by_email");
        
        //intially disabling all the menu's except Home
        f2.setEnabled(false);
        f3.setEnabled(false);
        //initially disabling all the menuitems
        t1.setEnabled(true);
        t2.setEnabled(true);
        t3.setEnabled(true);
        t4.setEnabled(false);
        t5.setEnabled(false);
        t6.setEnabled(false);
        t7.setEnabled(false);
        t8.setEnabled(false);
        t9.setEnabled(false);
        t10.setEnabled(false);
        t11.setEnabled(false);
        
        //adding ActionListener for both the buttons of Homepage and login
        //if buttons not made default from private then it'll not recommend jButtons
        p1.jButton1.addActionListener(new A());
        p1.jButton2.addActionListener(new A());
        p2.jButton1.addActionListener(new A());
        p2.jButton2.addActionListener(new A());
        
        //adding ActionListener to all the menuItems
        t1.addActionListener(new A());
        t2.addActionListener(new A());
        t3.addActionListener(new A());
        t4.addActionListener(new A());
        t5.addActionListener(new A());
        t6.addActionListener(new A());
        t7.addActionListener(new A());
        t8.addActionListener(new A());
        t9.addActionListener(new A());
        t10.addActionListener(new A());
        t11.addActionListener(new A());
        
        setVisible(true);
        setSize(1000,900);
    }
    
    //cl2 which is CardLayout2 is used to show buttons and content of Welcome and Login page
    //cl1 is used to show all menu items using container parent i.e. CT 
    //@Override
    class A implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)  //this function contains action of all the menu's and menuitem
    {
        String s=e.getActionCommand();
        if(s.equalsIgnoreCase("Enter"))
        {
            cl2.show(Welcome, "Card2");
        }
        else if(s.equalsIgnoreCase("Exit"))
        {
            System.exit(0);
        }
        else if(s.equalsIgnoreCase("Back"))
        {
            cl2.show(Welcome, "Card1");
        }
        else if(s.equalsIgnoreCase("Login"))
        {
            javax.swing.JOptionPane.showMessageDialog(null, "Hello");
            String email=p2.jTextField1.getText().trim(); //getting email using object of login
            //javax.swing.JOptionPane.showMessageDialog(null, "Email:"+email);
            String pass=p2.jTextField2.getText().trim();  //getting password
            //javax.swing.JOptionPane.showMessageDialog(null, "Password:"+pass);
            //javax.swing.JOptionPane.showMessageDialog(null, "Hello0");
            String usertype=check_login(email, pass);
            //javax.swing.JOptionPane.showMessageDialog(null, "Hello5");
            //javax.swing.JOptionPane.showMessageDialog(null, "Usertype"+usertype);
            if(usertype!=null)
            {
                //javax.swing.JOptionPane.showMessageDialog(null, "Hello1");
                //setting welcome and login page false
                p1.setVisible(false);
                p2.setVisible(false);
                p1.jButton1.setVisible(false);
                p1.jButton2.setVisible(false);
                
                 if(usertype.equalsIgnoreCase("admin"))
                 {
                     //javax.swing.JOptionPane.showMessageDialog(null, "Hello2");
                     //setting all menu's menuitems as visible
                     f1.setEnabled(true);
                     f2.setEnabled(true);
                     f3.setEnabled(true);
                     t1.setEnabled(true);
                     t2.setEnabled(true);
                     t3.setEnabled(true);
                     t4.setEnabled(true);
                     t5.setEnabled(true);
                     t6.setEnabled(true);
                     t7.setEnabled(true);
                     t8.setEnabled(true);
                     t9.setEnabled(true);
                     t10.setEnabled(true);
                     t11.setEnabled(true);
                 }
                 else if(usertype.equalsIgnoreCase("user"))
                 {
                     t1.setEnabled(true);
                     t2.setEnabled(true);
                     t3.setEnabled(true);
                 }
            }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(null, "Either email or password is incorrect");
            }
        }
        else if(s.equalsIgnoreCase("Admin Reg"))
        {
            cl1.show(CT, "adm_reg");
        }
        else if(s.equalsIgnoreCase("Admin update"))
        {
            cl1.show(CT, "adm_edt");
        }
        else if(s.equalsIgnoreCase("Show Admin"))
        {
            cl1.show(CT, "adm_edt");
        }
        else if(s.equalsIgnoreCase("Register User"))
        {
            cl1.show(CT, "user_reg");
        }
        else if(s.equalsIgnoreCase("Update User"))
        {
            cl1.show(CT, "user_edt");
        }
        else if(s.equalsIgnoreCase("Search By Contact"))
        {
            cl1.show(CT, "search_by_contact");
        }
        else if(s.equalsIgnoreCase("Search By Id"))
        {
            cl1.show(CT, "search_by_id");
        }
        else if(s.equalsIgnoreCase("Search By Email"))
        {
            cl1.show(CT, "search_by_email");
        }
    }
    }
    
    public static void main(String []args)
    {
        telephone obj=new telephone();
        obj.setVisible(true);
        obj.setSize(1000,1000);
    }
    
    
    //below function returns usertype only when email and pass are passed as an argument
    private String check_login(String email,String password)
    {
        String usertype=null;
        try
        {
            MyLib obj=new MyLib();
            Connection cn=obj.create_connection();
            String sql="select usertype from logindata where email=? and password=?";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next())
            {
                usertype=rs.getString("usertype");
            }
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, ""+e);
        }
        return usertype;
    }
    
}
