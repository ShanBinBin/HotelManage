package biz_Lala;
import entity_Lala.Data_Lala;
import entity_Lala.Manager_Lala;
import entity_Lala.Rooms_Lala;
import entity_Lala.Customer_Lala;
import java.util.ArrayList;
import java.util.List;
/**
 * 菜单类
 * @author lenovo
 *
 */
import java.util.Scanner;
import entity_Lala.Data_Lala;
import entity_Lala.Manager_Lala;
import entity_Lala.Rooms_Lala;
import entity_Lala.Customer_Lala;
public class Menu_Lala {
    /* 房间信息 */
	public Rooms_Lala rooms[] = new Rooms_Lala[50];
	/* 顾客信息 */
	public Customer_Lala customers[] = new Customer_Lala[100];
	public List<Customer_Lala> customerlist=new ArrayList<Customer_Lala>();
	public List<Rooms_Lala> roomlist=new ArrayList<Rooms_Lala>();
	Data_Lala initial = new Data_Lala();
    
	/**
	 * 传递数据
	 */
	public void setData(List<Rooms_Lala> rooms, List<Customer_Lala> customers) {
		for(int i=0;i<rooms.size();i++){
			this.roomlist.add(rooms.get(i));
		}
		for(int j=0;j<customers.size();j++){
			this.customerlist.add(customers.get(j));
		}
	}
	/**
	 * 显示客房管理系统的登录菜单
	 */
	public void showLoginMenu() {
		System.out.println("\n\n\t\t\t    欢迎使用客房管理系统\n\n");
		System.out.println ("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 登 录 系 统\n\n");
		System.out.println("\t\t\t\t 2. 更 改 管 理 员 密 码\n\n");
		System.out.println("\t\t\t\t 3. 退 出\n\n");
		System.out.println ("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字:");    
	}	
	/**
	 * 显示客房管理系统的主菜单
	 */
	public void showMainMenu() {
		System.out.println("\n\n\t\t\t\t欢迎使用客房管理系统\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 客 户 信 息 管 理\n");
		System.out.println("\t\t\t\t 2. 客户入住管理 \n");
		System.out.println("\t\t\t\t 3. 退房\n");		
		System.out.println("\t\t\t\t 4. 注 销\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字:");
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do{
			String num = input.next();
			  if(num.equals("1")){
                   //显示客户信息管理菜单
				  setData(initial.rooms, initial.customers);
				  showCustMMenu();
				   break;
			  }else if(num.equals("2")){
				   //显示入住结算菜单
				   Pay_Lala pay = new Pay_Lala();
				   pay.setData(roomlist,customerlist);
				   pay.calcPrice();
				   break;
			  }else if(num.equals("3")){
                   //显示退房菜单
				   Check_Out_Lala checkout=new Check_Out_Lala();
				   checkout.setData(roomlist, customerlist);
				   checkout.checkOut();
				   break;
			  }else if(num.equals("4")){
				   setData(initial.rooms, initial.customers);
				   showLoginMenu(); 
				   break;
			  }else{
				   System.out.print("输入错误，请重新输入数字：");
				   con = false;
			  }
		}while(!con);
	}
	/**
	 * 客户信息管理菜单
	 */
	public void showCustMMenu() {
		System.out.println("酒店客房管理系统 > 客户信息管理\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 显 示 所 有 客 户 信 息\n");
		System.out.println("\t\t\t\t 2. 办 理 客 户 预订 \n");
		System.out.println("\t\t\t\t 3. 修 改 客 户 信 息\n");
		System.out.println("\t\t\t\t 4. 查 询 客 户 信 息\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
		Scanner input = new Scanner(System.in);
		boolean con = true;  //处理如果输入菜单号错误
	    do{
	      CustManagement_Lala cm = new CustManagement_Lala();//实例化一个CustManagement对象
		  cm.setData(roomlist,customerlist);//传递客房和客户信息
		  String num = input.next();
		  if(num.equals("1")){
			  cm.show();
			  break;
		  }else if(num.equals("2")){
			  cm.add();
			  break;
		  }else if(num.equals("3")){
			  cm.modify();
			  break;
		  }else if(num.equals("4")){
			  cm.search();
			  break;
		  }else if(num.equals("n")){
              showMainMenu();
        	  break;
		  }else{
			System.out.println("输入错误, 请重新输入数字：");
			con = false;
		  }
	    }while(!con);
	}
	

}
