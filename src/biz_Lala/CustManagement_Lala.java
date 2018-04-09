package biz_Lala;
import java.util.ArrayList;
import java.util.List;
/**
 * �˿͹�����
 */
import java.util.Scanner;
import entity_Lala.Customer_Lala;
import entity_Lala.Data_Lala;
import entity_Lala.Manager_Lala;
import entity_Lala.Rooms_Lala;
public class CustManagement_Lala {
	/* ������Ϣ */
	public Rooms_Lala rooms[] = new Rooms_Lala[50];
	/* �˿���Ϣ */
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
	/**
	 * ������һ���˵�
	 */
	public void returnLastMenu() {
		System.out.print("\n\n�밴'n'������һ���˵�:");
		Scanner input = new Scanner(System.in);
		boolean con = true;
		do {
			if (input.next().equals("n")) {
				Menu_Lala menu = new Menu_Lala();
				menu.setData(roomlist, customerlist);
				menu.showCustMMenu();
			} else {
				System.out.print("�������, ������'n'������һ���˵���");
				con = false;
			}
		} while (!con);
	}
	/**
	 * ѭ�����ӿͻ���Ϣ��MY
	 */
	public void add() {
		System.out.println("�Ƶ�ͷ�����ϵͳ > �ͻ���Ϣ���� > ��ӿͻ���Ϣ\n\n");
		String con = "n";
		do { // ѭ��¼���Ա��Ϣ
			Scanner input = new Scanner(System.in);
			System.out.print("���������֤(<18λ>)��");
			String number = input.next();
			System.out.print("��������������");
			String name = input.next();
			System.out.print("�������Ա�1����\t2:Ů");
			int ss= input.nextInt();
			String sex=null;
			switch (ss) {
			case 1:				
				sex="��";
				break;
			case 2:				
				sex="Ů";
				break;
				}
			// ���֤��Ч������
			if (number.length()<18||number.length()>18) {
				System.out.println("�ͻ���" + number + "����Ч���֤��");
				System.out.println("¼����Ϣʧ��\n");
				System.out.println("������ӿͻ��𣿣�y/n��");
				con = input.next();
				continue;
			}
			customerlist.add(new Customer_Lala(number,name,sex,roomlist.get(0)));
			System.out.println("�¿ͻ���ӳɹ���");
			System.out.println("������ӿͻ��𣿣�y/n��");
			con = input.next();
		} while ("y".equals(con) || "Y".equals(con));
		    returnLastMenu();
	}
	/**
	 * ���Ŀͻ���Ϣ
	 */
	public void modify() {
		System.out.println("�Ƶ�ͷ�����ϵͳ > �ͻ���Ϣ���� > �޸Ŀͻ���Ϣ\n\n");
		System.out.print("���������֤�ţ�");
		Scanner input = new Scanner(System.in);
		String number = input.next();
		if(number.length()<18||number.length()>18){
			System.out.println("���֤���������,����������");
			number = input.next();
		}
		int index = -1;
		for (int i = 0; i < customerlist.size(); i++) {
			if (customerlist.get(i).custNumber.equals(number)) {
				String state="��";
				if(customerlist.get(i).room.state==1){
					state="��";
				}
				System.out.println("  ���֤��      \t\t\t����  \t \t�Ա�     \t\t�Ƿ���ס");
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
				System.out.println("\t\t\t\t1.�� �� �ͻ� ���֤.\n");
				System.out.println("\t\t\t\t2.�� �� �ͻ� ����.\n");
				System.out.println("\t\t\t\t3.�� �� �� Ա�Ա�.\n");
				System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
				System.out.print("��ѡ���������֣�");
				switch (input.nextInt()) {
				case 1:
					System.out.print("�������޸ĺ�����֤�ţ�");
					customerlist.get(index).custNumber = input.next();
					System.out.println("��Ա���֤���Ѹ��ģ�");
					break;
				case 2:
					System.out.print("�������޸ĺ����֣�");
					customerlist.get(index).custName = input.next();
					System.out.println("������Ϣ�Ѹ��ģ�");
					break;
				case 3:
					System.out.print("�������޸ĺ���Ա�1����\t2:Ů");
					int ss= input.nextInt();
					String sex=null;
					switch (ss) {
					case 1:				
						sex="��";
						break;
					case 2:				
						sex="Ů";
						break;
						}
					customerlist.get(index).custSex =sex;
					System.out.println("��Ա�Ա��Ѹ��ģ�");
					break;
				}

				System.out.println("�Ƿ��޸���������(y/n):");
				String flag = input.next();
				;
				if("n".equalsIgnoreCase(flag)){
					break;
				}
					
			}
		} else {
			System.out.println("��Ǹ��û�����ѯ�Ŀͻ���");
		}
		// ������һ���˵�
		  returnLastMenu();
	}
	/**
	 * ��ѯ�ͻ�����Ϣ
	 */
	public void search() {
		
		System.out.println("�Ƶ�ͷ�����ϵͳ > �ͻ���Ϣ���� > ��ѯ�ͻ���Ϣ\n");
		String con = "y";
		Menu_Lala menu = new Menu_Lala();
		menu.setData(roomlist, customerlist);
		Scanner input = new Scanner(System.in);
		String sta="";
		while (con.equals("y")) {
			System.out.print("���������֤�ţ�");
			String number = input.next();
			if(number.length()<18||number.length()>18){
				System.out.println("���֤���������,����������");
				number = input.next();
			}
			Customer_Lala discount = getDiscount(number, customerlist);//���ø÷����������֤�ŷ��ظ����֤�ŵĶ���
			if (discount == null) {//���û�в鵽
				System.out.println("û�в�ѯ���ÿͻ���");
			} else {
				System.out.println("  ���֤��      \t\t\t����  \t \t�Ա�     \t\t�Ƿ���ס");
				System.out.println("|---------------------|----------------|---------------|---------------|");
				if(discount.room.state==0){
					sta="��";
				}else{
					sta="��";
				}
				System.out.println(discount.custNumber+"\t\t"+discount.custName+"\t\t"+discount.custSex+"\t\t"+sta);
			}
			System.out.print("\nҪ������ѯ��y/n��:");
			con = input.next();
		}
		// ������һ���˵�
		returnLastMenu();
	}
	/**
	 * ��ʾ���еĻ�Ա��Ϣ
	 */
	public void show() {
		System.out.println("�Ƶ�ͷ�����ϵͳ > �ͻ���Ϣ���� > ��ʾ�ͻ���Ϣ\n\n");
		System.out.println("  ���֤��      \t\t\t����  \t \t�Ա�     \t\t�Ƿ���ס");
		System.out.println("|---------------------|----------------|---------------|---------------|");
		for (int i = 0; i < customerlist.size(); i++) {
			if (customerlist.get(i).custNumber == null) {
				break; // �ͻ���Ϣ�Ѿ���ʾ���
			}
			String sta="��";//��¼״̬��Ĭ��Ϊ��
			if(customerlist.get(i).room.state==1){
				sta="��";
			}
			System.out.println(customerlist.get(i).custNumber + "\t\t"
					+ customerlist.get(i).custName+ "\t\t"
					+ customerlist.get(i).custSex+"\t\t"+sta);
		}
		// ������һ���˵�
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
