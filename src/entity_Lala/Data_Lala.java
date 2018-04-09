package entity_Lala;
/**
 * 初始化数据
 */
import java.util.ArrayList;
import java.util.List;
public class Data_Lala {
	/**
	 * 新建顾客集合和房间集合
	 */
	public List<Rooms_Lala> rooms=new ArrayList<Rooms_Lala>();
	public List<Customer_Lala> customers=new ArrayList<Customer_Lala>();
	public Manager_Lala manager = new Manager_Lala();
	public void ini() {
		Rooms_Lala room0=new Rooms_Lala(101,"空",0,0,0);
		Rooms_Lala room1=new Rooms_Lala(102,"普通单人间",100,2,1);
		Rooms_Lala room2=new Rooms_Lala(103,"普通双人间",170,0,0);
		Rooms_Lala room3=new Rooms_Lala(104,"标准单人间",200,0,0);
		Rooms_Lala room4=new Rooms_Lala(105,"标准双人间",350,0,0);
		Rooms_Lala room5=new Rooms_Lala(106,"豪华单人间",450,0,0);
		Rooms_Lala room6=new Rooms_Lala(107,"豪华双人间",800,0,0);
		rooms.add(room0);
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);
		rooms.add(room5);
		rooms.add(room6);
        Customer_Lala customer0=new Customer_Lala("230229199512162219","罗晋","男",room1);
        Customer_Lala customer1=new Customer_Lala("230229199511162218","刘晓东","女",room2);
		customers.add(customer0);
		customers.add(customer1);



	}

}
