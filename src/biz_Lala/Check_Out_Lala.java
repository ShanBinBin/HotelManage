package biz_Lala;
/**
 * �˷���
 */
import java.util.Scanner;
import entity_Lala.Data_Lala;
import entity_Lala.Manager_Lala;
import entity_Lala.Rooms_Lala;
import entity_Lala.Customer_Lala;
import java.util.ArrayList;
import java.util.List;
public class Check_Out_Lala {
	/* ������Ϣ */
	public Rooms_Lala rooms[] = new Rooms_Lala[50];
	/* �ͻ���Ϣ */
	public Customer_Lala customers[] = new Customer_Lala[100];
	public List<Customer_Lala> customerlist=new ArrayList<Customer_Lala>();
	public List<Rooms_Lala> roomlist=new ArrayList<Rooms_Lala>();
	/**
	 * ��������
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
		CustManagement_Lala cm = new CustManagement_Lala();//ʵ����һ��CustManagement����
		cm.setData(roomlist,customerlist);//���ݿͷ��Ϳͻ���Ϣ
		String curCustNumber; // �ͻ���
		int number = 0; // ������
		double price = 0; // ����۸�
		String type;
		int count= 0; // ��ס��
		String goodsList = ""; // �嵥
		double finalPay = 0; // �踶��
		/* ������ס����ϵͳ */
		Scanner input = new Scanner(System.in);
		System.out.print("���������֤�ţ�");
		curCustNumber = input.next();
		if(curCustNumber.length()<18||curCustNumber.length()>18){
			System.out.println("���֤���������");
			curCustNumber=input.next();
		}
		Menu_Lala menu = new Menu_Lala();
		menu.setData(roomlist, customerlist);
		Customer_Lala discount = getDiscount(curCustNumber, customerlist);//���ø÷����������֤�ŷ��ظ����֤�ŵĶ���
		if (discount == null&&discount.room.state==0) {//���û�в鵽
			System.out.println("�����֤�ſͻ�δ��ס���������");
			menu.showMainMenu();
		} else {
				// ȡ���ͻ�������Ϣ
				price = discount.getRoom().getPrice();
				type= discount.getRoom().getType();
				count=discount.room.getNum();
				finalPay =price*count;// ���������ܽ��
				number=discount.room.getNumber();
			    goodsList = goodsList+"\n"+type+"\t\t"+"��"+price+"\t\t"+count+"\t\t"+"��"+finalPay;				
			} 
			//��ʾ�ͻ���Ϣ
		System.out.println("  ���֤��      \t\t\t����  \t \t�Ա�     \t\t�Ƿ���ס");
		System.out.println("|---------------------|----------------|---------------|---------------|");
			for (int i = 0; i < customerlist.size(); i++) {
				if (curCustNumber.equals(customerlist.get(i).custNumber)) {
					String sta="��";
					if(customerlist.get(i).room.state==1){
						sta="��";
					}
					System.out.println(customerlist.get(i).custNumber + "\t\t"
							+ customerlist.get(i).custName+ "\t\t"
							+ customerlist.get(i).custSex+"\t\t"+sta);
			// ��ӡ�����嵥		
		    System.out.println("\n");
			System.out.println("���������������������������������������嵥������������������������������������������");
			System.out.println("��������\t\t" + "����\t\t" + "����\t\t" + "���\t");
			System.out.println(goodsList);
			System.out.println("����ܼ�:\t" + "��" + finalPay);
			System.out.print("����300Ѻ��");
			discount.room.state=0;
			System.out.print("\n\n�밴'n'������һ���˵�:");
			boolean con = true;
			do {
				if (input.next().equals("n")) {
					
					menu.showMainMenu();
				} else {
					System.out.print("�������, ������'n'������һ���˵���");
					con = false;
				}
			} while (!con);
				}
			}
		}
	}

