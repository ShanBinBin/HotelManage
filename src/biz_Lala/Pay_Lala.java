package biz_Lala;
/**
 * 支付类
 */
import java.util.*;
import entity_Lala.Customer_Lala;
import entity_Lala.Data_Lala;
import entity_Lala.Rooms_Lala;
import entity_Lala.Manager_Lala;
public class Pay_Lala {
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
	/**
	 * 
	 * @param curCustNo
	 * @param customers
	 * @return  查找到的客户对象
	 */
	public Customer_Lala getDiscount(String curCustNumber, List<Customer_Lala> customers) {
		Customer_Lala su=new Customer_Lala();
		int index = -1;	
		su=null;
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

	/*
	 * 　实现住房结算以及输出小票
	 */
	public void calcPrice() {
		String curCustNumber; // 客户号
		int goodsNo = 0; // 房间编号
		double price; // 房间价格
		String name;
		int count; // 入住天数
		String choice = null;
		String goodsList = ""; // 清单
		double total = 0; // 总金额
		double finalPay = 0; // 需付款
		double payment; // 实际交费金额

		System.out.println("酒店客房管理系统 > 住房结算\n\n");

		// 打印产品清单
		System.out.println("*************************************");
		System.out.println("请选择入住的房间编号：");
		System.out.println(" 房间编号 \t 类型"+"\t\t"+"价格"+"\t"+"状态");
		for (int i = 0, p = 0; i < roomlist.size() && null != roomlist.get(i).type; i++) {
			p++;
			String zhuangtai;
			if(roomlist.get(i).state==0){//表示房间为空，可以入住
				zhuangtai="为空";
			}
			else{
				zhuangtai="已入住";
			}
			System.out.println(p + ":\t " + roomlist.get(i).type + "\t\t"+ roomlist.get(i).price+"\t"+ zhuangtai);
		}
		System.out.println("*************************************\n");

		/* 进行入住结算系统 */
		Scanner input = new Scanner(System.in);
		System.out.print("\t请输入身份证号：");
		curCustNumber = input.next();
		if(curCustNumber.length()<18||curCustNumber.length()>18){
			System.out.println("身份证号输入错误,重新输入");
			curCustNumber = input.next();
		}
		Customer_Lala discount = getDiscount(curCustNumber, customerlist);//调用该方法根据身份证号返回该身份证号的对象
		if (discount == null||discount.room.state==1) {//如果没有查到
			System.out.println("没有查询到该客户或该用户已经入住");
		} else {
			do {
				System.out.print("\t请输入房间编号："); // 数组下标+1即产品编号
				goodsNo = input.nextInt();
				System.out.print("\t请输入入住天数：");
				count = input.nextInt();
				if(roomlist.get(goodsNo-1).state==1){
					System.out.println("该房屋已有客人");
					break;
				}

				// 查询单价
				price = roomlist.get(goodsNo - 1).price;
				name =  roomlist.get(goodsNo - 1).type;
				 roomlist.get(goodsNo - 1).state=1;
				total = total + price * count;
				discount.room= roomlist.get(goodsNo - 1);
				discount.room.num=count;
				discount.room.state=1;

				// 连接购物清单
				goodsList = goodsList + "\n" + name + "\t\t" + "￥" + price
						+ "\t\t" + count + "\t\t" + "￥" + (price * count)
						+ "\t";
				// 计算消费总金额
				finalPay = total ;

				// 打印消费清单
				System.out.println("\n");
				System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊消费清单＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
				System.out.println("房间类型\t\t" + "单价\t\t" + "天数\t\t" + "金额\t");
				System.out.println(goodsList);
				System.out.println("金额总计:\t" + "￥" + (finalPay+300)+"(包含三百押金,退房时返还)");
				System.out.print("实际交费:\t￥");
				payment = input.nextDouble();
				System.out.println("找钱:\t" + "￥" + (payment - finalPay-300));

				System.out.print("\t是否继续（y/n）");
				choice = input.next();
				
			} while (choice.equals("y"));

			
			
		}
		// 返回上一级菜单
		System.out.print("\n请'n'返回上一级菜单:");
		if (input.next().equals("n")) {
			Menu_Lala menu = new Menu_Lala();
			menu.setData(roomlist, customerlist);
			menu.showMainMenu();
		}

	}

}
