package entity_Lala;
/**
 * ��ʼ������
 */
import java.util.ArrayList;
import java.util.List;
public class Data_Lala {
	/**
	 * �½��˿ͼ��Ϻͷ��伯��
	 */
	public List<Rooms_Lala> rooms=new ArrayList<Rooms_Lala>();
	public List<Customer_Lala> customers=new ArrayList<Customer_Lala>();
	public Manager_Lala manager = new Manager_Lala();
	public void ini() {
		Rooms_Lala room0=new Rooms_Lala(101,"��",0,0,0);
		Rooms_Lala room1=new Rooms_Lala(102,"��ͨ���˼�",100,2,1);
		Rooms_Lala room2=new Rooms_Lala(103,"��ͨ˫�˼�",170,0,0);
		Rooms_Lala room3=new Rooms_Lala(104,"��׼���˼�",200,0,0);
		Rooms_Lala room4=new Rooms_Lala(105,"��׼˫�˼�",350,0,0);
		Rooms_Lala room5=new Rooms_Lala(106,"�������˼�",450,0,0);
		Rooms_Lala room6=new Rooms_Lala(107,"����˫�˼�",800,0,0);
		rooms.add(room0);
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);
		rooms.add(room5);
		rooms.add(room6);
        Customer_Lala customer0=new Customer_Lala("230229199512162219","�޽�","��",room1);
        Customer_Lala customer1=new Customer_Lala("230229199511162218","������","Ů",room2);
		customers.add(customer0);
		customers.add(customer1);



	}

}
