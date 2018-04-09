package biz_Lala;
/**
 * 退房类
 */
import java.util.Scanner;
import entity_Lala.Data_Lala;
import entity_Lala.Manager_Lala;
import entity_Lala.Rooms_Lala;
import entity_Lala.Customer_Lala;
import java.util.ArrayList;
import java.util.List;
public class Check_Out_Lala {
	/* 房间信息 */
	public Rooms_Lala rooms[] = new Rooms_Lala[50];
	/* 客户信息 */
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
	public void checkOut() {
		CustManagement_Lala cm = new CustManagement_Lala();//实例化一个CustManagement对象
		cm.setData(roomlist,customerlist);//传递客房和客户信息
		String curCustNumber; // 客户号
		int number = 0; // 房间编号
		double price = 0; // 房间价格
		String type;
		int count= 0; // 入住天
		String goodsList = ""; // 清单
		double finalPay = 0; // 需付款
		/* 进行入住结算系统 */
		Scanner input = new Scanner(System.in);
		System.out.print("请输入身份证号：");
		curCustNumber = input.next();
		if(curCustNumber.length()<18||curCustNumber.length()>18){
			System.out.println("身份证号输入错误");
			curCustNumber=input.next();
		}
		Menu_Lala menu = new Menu_Lala();
		menu.setData(roomlist, customerlist);
		Customer_Lala discount = getDiscount(curCustNumber, customerlist);//调用该方法根据身份证号返回该身份证号的对象
		if (discount == null&&discount.room.state==0) {//如果没有查到
			System.out.println("该身份证号客户未入住或输入错误。");
			menu.showMainMenu();
		} else {
				// 取出客户房间信息
				price = discount.getRoom().getPrice();
				type= discount.getRoom().getType();
				count=discount.room.getNum();
				finalPay =price*count;// 计算消费总金额
				number=discount.room.getNumber();
			    goodsList = goodsList+"\n"+type+"\t\t"+"￥"+price+"\t\t"+count+"\t\t"+"￥"+finalPay;				
			} 
			//显示客户信息
		System.out.println("  身份证号      \t\t\t姓名  \t \t性别     \t\t是否入住");
		System.out.println("|---------------------|----------------|---------------|---------------|");
			for (int i = 0; i < customerlist.size(); i++) {
				if (curCustNumber.equals(customerlist.get(i).custNumber)) {
					String sta="否";
					if(customerlist.get(i).room.state==1){
						sta="是";
					}
					System.out.println(customerlist.get(i).custNumber + "\t\t"
							+ customerlist.get(i).custName+ "\t\t"
							+ customerlist.get(i).custSex+"\t\t"+sta);
			// 打印消费清单		
		    System.out.println("\n");
			System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊消费清单＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
			System.out.println("房间类型\t\t" + "单价\t\t" + "天数\t\t" + "金额\t");
			System.out.println(goodsList);
			System.out.println("金额总计:\t" + "￥" + finalPay);
			System.out.print("返还300押金");
			discount.room.state=0;
			System.out.print("\n\n请按'n'返回上一级菜单:");
			boolean con = true;
			do {
				if (input.next().equals("n")) {
					
					menu.showMainMenu();
				} else {
					System.out.print("输入错误, 请重新'n'返回上一级菜单：");
					con = false;
				}
			} while (!con);
				}
			}
		}
	}

