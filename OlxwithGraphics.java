package Gautam;
import java.util.*;
import java.io.*;
import java.applet.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class OlxwithGraphics extends Applet implements ActionListener
{
    String name;
    int cost;
    int category;
    int subcategory;
    String description;
    String city;
    int phonenumber;
   
    JFrame jp;
    JPanel  container;
    CardLayout cl;
    JButton  b1, b2, b3;
   
    public OlxwithGraphics()
    {
        name="";
        cost=0;
        category=0;
        subcategory=0;
        description="";
        city="";
        phonenumber=0;
    }

   
    public void inputdataforselling()
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        char c;
       
        Scanner sc=new Scanner(System.in);
        System.out.println("Name of the product:");
        name=sc.nextLine();
        System.out.println("Cost:");
        cost=sc.nextInt();
        sc.nextLine();
        System.out.println("Product Description :");
        description=sc.nextLine();
        System.out.println("City:");
        city=sc.nextLine();
        System.out.println("Phone Number: ");
        phonenumber=sc.nextInt();
        System.out.println("Enter the number of the corresponding category of your product:");
        System.out.println("1)Electronics\n2)Sport Products\n3)Books\n4)Kitchen Appliances\n5)Vehicles\n6)Toys\n7)Furniture");
        category=sc.nextInt();
       
    }
    public static int getsubcategory(int category)
    {
        Scanner sc = new Scanner(System.in);
        int subcategory=0;
        switch(category)
        {
                        case 1: System.out.println("Enter the number of the corresponding subcategory of the product:\n1)TV\n2)Laptops\n3)Mobile Phones\n4)Dishwashers\n5)Washing Machines\n6)Audio Products\n7)Tablets");
                        subcategory=sc.nextInt();
                        break;
                        case 2:System.out.println("Enter the number of the corresponding subcategory of the product:\n1)Basketball\n2)Football\n3)Tennis\n4)Swimming\n5)Badminton\n6)Hockey\n7)Cricket");
                        subcategory=sc.nextInt();
                        break;
                        case 3:System.out.println("Enter the number of the corresponding genre of book:\n1)Horror\n2)Fiction\n3)Non-Fiction\n4)Thriller\n5)Children's Books\n6)Biographies\n7)Educational");
                        subcategory=sc.nextInt();
                        break;
                        case 4:System.out.println("Enter the number of the corresponding subcategory of the product:\n1)Toaster\n2)Blender\n3)Mixer\n4)Microwave\n5)Refrigerator\n6)Coffee Maker\n7)Fryer");
                        subcategory=sc.nextInt();
                        break;
                        case 5:System.out.println("Enter the number of the corresponding subcategory of the product:\n1)Cars\n2)Motorbikes\n3)Bicycles\n4)Boats\n5)Segways\n6)Scooters\n7)Trucks");
                        subcategory=sc.nextInt();
                        break;
                        case 6:System.out.println("Enter the number of the corresponding subcategory of the product:\n1)Board Games\n2)Collectible Cards\n3)Nerf Guns\n4)Dolls\n5)Lego\n6)Action Figures\n7)Remote Controlled Toys");
                        subcategory=sc.nextInt();
                        break;
                        case 7:System.out.println("Enter the number of the corresponding subcategory of the product:\n1)Sofas\n2)Tables\n3)Chairs\n4)Desks\n5)Recliners\n6)Beds\n7)Cupboards");
                        subcategory=sc.nextInt();
                        break;
                        default:System.out.println("Invalid category number");
         }
        return subcategory;
    }
    public static int getmatchingproducts(String buyercity,int buyercategory,int buyersubcategory, OlxwithGraphics [] product)
    {
      int count;int foundmatch=0;
        for(count=0;count<50;count++)
        {
         if((product[count].city.equals(buyercity))&&(product[count].category==buyercategory)&&(product[count].subcategory==buyersubcategory))
         {
             foundmatch=1;
             System.out.println("match found");
             System.out.println("Name of the product - "+product[count].name);
             System.out.println("Cost - "+product[count].cost);
             System.out.println("Description - "+product[count].description);
             System.out.println("Seller's Phone Number - "+product[count].phonenumber);
             System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            }
    }
    return foundmatch;
    }
    public static void buyproduct(String buyercity, int buyercategory, int buyersubcategory, OlxwithGraphics [] product)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the product which you would like to purchase");
        String buyerchoice = sc.nextLine();
        int i;
        for(i=0;i<50;i++)
        {
            if((product[i].city.equals(buyercity))&&(product[i].category==buyercategory)&&(product[i].subcategory==buyersubcategory)&&(product[i].name.equals(buyerchoice)))
         {
             System.out.println("You have successfully purchased your product!");
             System.out.println("Total Cost - "+(1.1*product[i].cost));
             System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
             product[i].name="";
             product[i].cost=0;
             product[i].category=0;
             product[i].description="";
             product[i].city="";
             product[i].phonenumber=0;
             return;
            }
        }
        System.out.println(buyerchoice+" could not be found");
    }
    public static void sellproduct(OlxwithGraphics [] product)
    {
       int position=0;
       for(position=0;position<50;position++)
       {
           if(product[position].cost==0)
           {
               product[position].inputdataforselling();
               product[position].subcategory = getsubcategory(product[position].category);
               return;
            }
        }
        System.out.println("There are no empty slots to post your product. Please wait until an ad has been taken down or someone has puchased a product");
    }  
    public static void displayinventory(OlxwithGraphics [] product)
    {
        int i; int flag=0;String selldispcategory=""; String selldispsubcategory="";
         System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Current Inventory of our Products:");
        for(i=0;i<50;i++)
        {
            if(product[i].cost!=0)
            {
                if(flag==0)
                {
                    System.out.println("Product Name \t\t Cost \t\t Product Category \t\t Product Subcategory");
                    flag=1;
                }
                switch(product[i].category)
                {
                    case 1: selldispcategory="Electronics";
                    break;
                    case 2: selldispcategory="Sports Products";
                    break;
                    case 3: selldispcategory="Books";
                    break;
                    case 4: selldispcategory="Kitchen Appliances";
                    break;
                    case 5: selldispcategory="Vehicles";
                    break;
                    case 6: selldispcategory="Toys";
                    break;
                    case 7: selldispcategory="Furniture";
                    break;
                    default:System.out.println("Error category-"+product[i].category);
                }
                switch(product[i].category)
                {
                    case 1: switch(product[i].subcategory)
                            {
                                case 1: selldispsubcategory="TV";
                                break;
                                case 2: selldispsubcategory="Laptops";
                                break;
                                case 3: selldispsubcategory="Mobile Phones";
                                break;
                                case 4: selldispsubcategory="Dishwashers";
                                break;
                                case 5: selldispsubcategory="Washing Machines";
                                break;
                                case 6: selldispsubcategory="Audio Products";
                                break;
                                case 7: selldispsubcategory="Tablets";
                                break;
                                default:System.out.println("Error subcategory-"+product[i].subcategory);
                            }
                            break;
                    case 2:switch(product[i].subcategory)
                            {
                                case 1: selldispsubcategory="Basketball";
                                break;
                                case 2: selldispsubcategory="Football";
                                break;
                                case 3: selldispsubcategory="Tennis";
                                break;
                                case 4: selldispsubcategory="Swimming";
                                break;
                                case 5: selldispsubcategory="Badminton";
                                break;
                                case 6: selldispsubcategory="Hockey";
                                break;
                                case 7: selldispsubcategory="Cricket";
                                break;
                                default:System.out.println("Error subcategory-"+product[i].subcategory);
                            }
                            break;
                    case 3:switch(product[i].subcategory)
                            {
                                case 1: selldispsubcategory="Horror";
                                break;
                                case 2: selldispsubcategory="Fiction";
                                break;
                                case 3: selldispsubcategory="Non-Fiction";
                                break;
                                case 4: selldispsubcategory="Thriller";
                                break;
                                case 5: selldispsubcategory="Children's Books";
                                break;
                                case 6: selldispsubcategory="Biographies";
                                break;
                                case 7: selldispsubcategory="Educational";
                                break;
                                default:System.out.println("Error subcategory-"+product[i].subcategory);
                            }
                            break;
                    case 4:switch(product[i].subcategory)
                            {
                                case 1: selldispsubcategory="Toaster";
                                break;
                                case 2: selldispsubcategory="Blender";
                                break;
                                case 3: selldispsubcategory="Mixer";
                                break;
                                case 4: selldispsubcategory="Microwave";
                                break;
                                case 5: selldispsubcategory="Refrigerator";
                                break;
                                case 6: selldispsubcategory="Coffee Maker";
                                break;
                                case 7: selldispsubcategory="Fryer";
                                break;
                                default:System.out.println("Error subcategory-"+product[i].subcategory);
                            }
                            break;
                    case 5:switch(product[i].subcategory)
                            {
                                case 1: selldispsubcategory="Cars";
                                break;
                                case 2: selldispsubcategory="Motorbikes";
                                break;
                                case 3: selldispsubcategory="Bicycles";
                                break;
                                case 4: selldispsubcategory="Boats";
                                break;
                                case 5: selldispsubcategory="Segways";
                                break;
                                case 6: selldispsubcategory="Scooters";
                                break;
                                case 7: selldispsubcategory="Trucks";
                                break;
                                default:System.out.println("Error subcategory-"+product[i].subcategory);
                            }
                            break;
                    case 6:switch(product[i].subcategory)
                            {
                                case 1: selldispsubcategory="Board Games";
                                break;
                                case 2: selldispsubcategory="Collectible Cards";
                                break;
                                case 3: selldispsubcategory="Nerf Guns";
                                break;
                                case 4: selldispsubcategory="Dolls";
                                break;
                                case 5: selldispsubcategory="Lego";
                                break;
                                case 6: selldispsubcategory="Action Figures";
                                break;
                                case 7: selldispsubcategory="Remote Controlled Toys";
                                break;
                                default:System.out.println("Error subcategory-"+product[i].subcategory);
                            }
                            break;
                    case 7:switch(product[i].subcategory)
                            {
                                case 1: selldispsubcategory="Sofas";
                                break;
                                case 2: selldispsubcategory="Tables";
                                break;
                                case 3: selldispsubcategory="Chairs";
                                break;
                                case 4: selldispsubcategory="Desks";
                                break;
                                case 5: selldispsubcategory="Recliners";
                                break;
                                case 6: selldispsubcategory="Beds";
                                break;
                                case 7: selldispsubcategory="Cupboards";
                                break;
                                default:System.out.println("Error subcategory-"+product[i].subcategory);
                            }
                    default:System.out.println("Error");
                }
                System.out.println(product[i].name+"\t\t\t"+product[i].cost+"\t\t\t"+selldispcategory+"\t\t\t"+selldispsubcategory);
                 System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                selldispcategory="";
                selldispsubcategory="";
            }
        }
        if(flag==0)
        {
            System.out.println("We are out of stock of our products and our inventory is empty. Please come again at another time");
        }
    }
    public void create_main_menu (JPanel P)
    {
       
        P.setBackground(Color.blue);
       
        b1 = new JButton("Buy ");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("Buy");

        b2 = new JButton("Sell ");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand("Sell");

        b3 = new JButton("Exit ");
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("Exit");

        //Listen for actions on the buttons
        b1.addActionListener(e -> cl.show(container,"Buy Menu"));
        b2.addActionListener(e -> cl.show(container,"Sell Menu"));
        b3.addActionListener(this);

        b1.setToolTipText("Buy stuff");
        b2.setToolTipText("Sell stuff");
        b3.setToolTipText("Get out of here");

        //Add Components to this container, using the default FlowLayout.
        P.add(b1);
        P.add(b2);
        P.add(b3);
    }
    public void create_buy_menu (JPanel P)
    {
        JButton backtoMain = new JButton ("Back to Main Menu");
       
        P.setBackground(Color.yellow);
       
        b1 = new JButton("Books ");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("Books");

        b2 = new JButton("Electronics ");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand("Electronics");
       
        backtoMain.addActionListener(e -> cl.show(container,"Main Menu"));

        b1.setToolTipText("Books stuff");
        b2.setToolTipText("Groceries stuff");

        //Add Components to this container, using the default FlowLayout.
        P.add(b1);
        P.add(b2);
        P.add(backtoMain);
    }
    public void create_sell_menu (JPanel P)
    {
        JButton backtoMain = new JButton ("Back to Main Menu");
       
        P.setBackground(Color.red);
       
        b1 = new JButton("Category ");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("Category");

        b2 = new JButton("SubCategory ");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand("SubCateogry");

        b1.setToolTipText("Category stuff");
        b2.setToolTipText("SubCategory stuff");

        backtoMain.addActionListener(e -> cl.show(container,"Main Menu"));
       
        //Add Components to this container, using the default FlowLayout.
        P.add(b1);
        P.add(b2);
        P.add(backtoMain);
    }
       
    public void actionPerformed(ActionEvent e)
    {
        if ("Buy".equals(e.getActionCommand())) {
            cl.show(container,"Buy Menu");
        } else {
            if ("Sell".equals(e.getActionCommand())) {
                cl.show(container,"Sell Menu");
            } else {
                // Delete the frame displaying the options as we are exiting
                jp.dispose();
            }
        }
    }
   
    public void draw_panels ()
    {
        JPanel  mainP = new JPanel ();
        JPanel  buyP = new JPanel ();
        JPanel  sellP = new JPanel ();
       
        create_main_menu(mainP);
        create_buy_menu(buyP);
        create_sell_menu(sellP);
       
        //Initialize card Layout and container
        cl = new CardLayout(5,5);
        container = new JPanel(cl);
        container.setBackground(Color.black);

        // Add the panels to the container
        container.add(mainP, "Main Menu");
        container.add(buyP, "Buy Menu");
        container.add(sellP, "Sell Menu");
       
        jp.add(container);
        cl.show(container,"Main Menu");
        jp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
        jp.pack();
        jp.setVisible(true);
    }
   
    public void init_graphics ()
    {
        jp = new JFrame("Olx Project");
        OlxwithGraphics a=new OlxwithGraphics ();
       
               
        jp.getContentPane().add(a, BorderLayout.CENTER);
        jp.setSize(new Dimension(1000,1000));
        draw_panels();
    }
    public static void main()
    {
        int count =0; int buyercategory; int buyersubcategory;int i;
       
        OlxwithGraphics[] product= new OlxwithGraphics[50];
       
        OlxwithGraphics g = new OlxwithGraphics();
       
        g.init_graphics();
       
        for(i=0;i<50;i++)
        {
            product[i] = new OlxwithGraphics();
        }
        
       
        while(true)
        {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the number of the respective option that you want to do");
         System.out.println("1)Buy\n2)Sell\n3)Exit\n4)Clear the screen");
         int choice=sc.nextInt();
         sc.nextLine();
         switch(choice)
         {
            case 1:displayinventory(product);
                   System.out.println("Enter the name of your city");
                   String buyercity=sc.nextLine();
                   System.out.println("Enter the number of the corresponding category of the product you want to buy:\n1)Electronics\n2)Sport Products\n3)Books\n4)Kitchen Appliances\n5)Vehicles\n6)Toys\n7)Furniture\n");
                   buyercategory=sc.nextInt();
                   buyersubcategory = getsubcategory(buyercategory);
                   int gotmatch = getmatchingproducts(buyercity,buyercategory,buyersubcategory,product);
                   if(gotmatch!=0)
                   {
                     buyproduct(buyercity,buyercategory,buyersubcategory,product);
                    }
                    else
                    {
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Product could not be found");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                    }
                   
                   break;
           
            case 2: sellproduct(product);
            System.out.print('\u000C');
            break;
           
            case 3: System.exit(0);
            break;
           
            case 4: System.out.print('\u000C');
            break;
        } 
    } 
  }
}

