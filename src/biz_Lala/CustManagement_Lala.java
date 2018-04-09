package biz_Lala;
import java.util.ArrayList;
import java.util.List;
/**
 * 顾客管理类
 */
import java.util.Scanner;
import entity_Lala.Customer_Lala;
import entity_Lala.Data_Lala;
import entity_Lala.Manager_Lala;
import entity_Lala.Rooms_Lala;
public class CustManagement_Lala {
	/* 房间信息 */
	public Rooms_Lala rooms[] = new Rooms_Lala[50];
	/* 顾客信息 */
	public Customer_Lala customers[] = new Customer_Lala[100];
	public List<Customer_Lala> customerlist=new ArrayList<Customer_Lala>();
	public List<Rooms_Lala> roomlist=new ArrayList<Rooms_Lala>();
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
	 * 返回上一级菜单
	 */
	public void returnLastMenu() {
		System.out.print("\n\n请按'n'返回上一级菜单:");
		Scanner input = new Scanner(System.in);
		boolean con = true;
		do {
			if (input.next().equals("n")) {
				Menu_Lala menu = new Menu_Lala();
				menu.setData(roomlist, customerlist);
				menu.showCustMMenu();
			} else {
				System.out.print("输入错误, 请重新'n'返回上一级菜单：");
				con = false;
			}
		} while (!con);
	}
	/**
	 * 循环增加客户信息：MY
	 */
	public void add() {
		System.out.println("酒店客房管理系统 > 客户信息管理 > 添加客户信息\n\n");
		String con = "n";
		do { // 循环录入会员信息
			Scanner input = new Scanner(System.in);
			System.out.print("请输入身份证(<18位>)：");
			String number = input.next();
			System.out.print("请输入姓名）：");
			String name = input.next();
			System.out.print("请输入性别：1：男\t2:女");
			int ss= input.nextInt();
			String sex=null;
			switch (ss) {
			case 1:				
				sex="男";
				break;
			case 2:				
				sex="女";
				break;
				}
			// 身份证无效则跳出
			if (number.length()<18||number.length()>18) {
				System.out.println("客户号" + number + "是无效身份证！");
				System.out.println("录入信息失败\n");
				System.out.println("继续添加客户吗？（y/n）");
				con = input.next();
				continue;
			}
			customerlist.add(new Customer_Lala(number,name,sex,roomlist.get(0)));
			System.out.println("新客户添加成功！");
			System.out.println("继续添加客户吗？（y/n）");
			con = input.next();
		} while ("y".equals(con) || "Y".equals(con));
		    returnLastMenu();
	}
	/**
	 * 更改客户信息
	 */
	public void modify() {
		System.out.println("酒店客房管理系统 > 客户信息管理 > 修改客户信息\n\n");
		System.out.print("请输入身份证号：");
		Scanner input = new Scanner(System.in);
		String number = input.next();
		if(number.length()<18||number.length()>18){
			System.out.println("身份证号输入错误,请重新输入");
			number = input.next();
		}
		int index = -1;
		for (int i = 0; i < customerlist.size(); i++) {
			if (customerlist.get(i).custNumber.equals(number)) {
				String state="否";
				if(customerlist.get(i).room.state==1){
					state="是";
				}
				System.out.println("  身份证号      \t\t\t姓名  \t \t性别     \t\t是否入住");
				System.out.println("|---------------------|----------------|---------------|---------------|");
				System.out.println(customerlist.get(i).custNumber + "\t\t"
						+ customerlist.get(i).custName + "\t\t"
						+ customerlist.get(i).custSex+"\t\t"+state);
				index = i;
				break;
			}
		}
		if (index != -1) {
			while (true) {
				System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
				System.out.println("\t\t\t\t1.修 改 客户 身份证.\n");
				System.out.println("\t\t\t\t2.修 改 客户 名字.\n");
				System.out.println("\t\t\t\t3.修 改 会 员性别.\n");
				System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
				System.out.print("请选择，输入数字：");
				switch (input.nextInt()) {
				case 1:
					System.out.print("请输入修改后的身份证号：");
					customerlist.get(index).custNumber = input.next();
					System.out.println("会员身份证号已更改！");
					break;
				case 2:
					System.out.print("请输入修改后名字：");
					customerlist.get(index).custName = input.next();
					System.out.println("名字信息已更改！");
					break;
				case 3:
					System.out.print("请输入修改后的性别：1：男\t2:女");
					int ss= input.nextInt();
					String sex=null;
					switch (ss) {
					case 1:				
						sex="男";
						break;
					case 2:				
						sex="女";
						break;
						}
					customerlist.get(index).custSex =sex;
					System.out.println("会员性别已更改！");
					break;
				}

				System.out.println("是否修改其他属性(y/n):");
				String flag = input.next();
				;
				if("n".equalsIgnoreCase(flag)){
					break;
				}
					
			}
		} else {
			System.out.println("抱歉，没有你查询的客户。");
		}
		// 返回上一级菜单
		  returnLastMenu();
	}
	/**
	 * 查询客户的信息
	 */
	public void search() {
		
		System.out.println("酒店客房管理系统 > 客户信息管理 > 查询客户信息\n");
		String con = "y";
		Menu_Lala menu = new Menu_Lala();
		menu.setData(roomlist, customerlist);
		Scanner input = new Scanner(System.in);
		String sta="";
		while (con.equals("y")) {
			System.out.print("请输入身份证号：");
			String number = input.next();
			if(number.length()<18||number.length()>18){
				System.out.println("身份证号输入错误,请重新输入");
				number = input.next();
			}
			Customer_Lala discount = getDiscount(number, customerlist);//调用该方法根据身份证号返回该身份证号的对象
			if (discount == null) {//如果没有查到
				System.out.println("没有查询到该客户。");
			} else {
				System.out.println("  身份证号      \t\t\t姓名  \t \t性别     \t\t是否入住");
				System.out.println("|---------------------|----------------|---------------|---------------|");
				if(discount.room.state==0){
					sta="否";
				}else{
					sta="是";
				}
				System.out.println(discount.custNumber+"\t\t"+discount.custName+"\t\t"+discount.custSex+"\t\t"+sta);
			}
			System.out.print("\n要继续查询吗（y/n）:");
			con = input.next();
		}
		// 返回上一级菜单
		returnLastMenu();
	}
	/**
	 * 显示所有的会员信息
	 */
	public void show() {
		System.out.println("酒店客房管理系统 > 客户信息管理 > 显示客户信息\n\n");
		System.out.println("  身份证号      \t\t\t姓名  \t \t性别     \t\t是否入住");
		System.out.println("|---------------------|----------------|---------------|---------------|");
		for (int i = 0; i < customerlist.size(); i++) {
			if (customerlist.get(i).custNumber == null) {
				break; // 客户信息已经显示完毕
			}
			String sta="否";//记录状态，默认为否
			if(customerlist.get(i).room.state==1){
				sta="是";
			}
			System.out.println(customerlist.get(i).custNumber + "\t\t"
					+ customerlist.get(i).custName+ "\t\t"
					+ customerlist.get(i).custSex+"\t\t"+sta);
		}
		// 返回上一级菜单
		returnLastMenu();
	}
	public Customer_Lala getDiscount(String curCustNumber, List<Customer_Lala> customers) {
		Customer_Lala su=new Customer_Lala();
		int index = -1;		
		for (int i = 0; i < customers.size(); i++) {			
			if (curCustNumber.equals(customers.get(i).custNumber)) {
				index = i;
				return customers.get(i);
			}
		}
		if (index == -1) {
			return su;
		} 
		return su;
	}
}
