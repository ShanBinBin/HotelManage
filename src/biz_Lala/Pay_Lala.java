package biz_Lala;
/**
 * ֧����
 */
import java.util.*;
import entity_Lala.Customer_Lala;
import entity_Lala.Data_Lala;
import entity_Lala.Rooms_Lala;
import entity_Lala.Manager_Lala;
public class Pay_Lala {
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
	/**
	 * 
	 * @param curCustNo
	 * @param customers
	 * @return  ���ҵ��Ŀͻ�����
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
	 * ��ʵ��ס�������Լ����СƱ
	 */
	public void calcPrice() {
		String curCustNumber; // �ͻ���
		int goodsNo = 0; // ������
		double price; // ����۸�
		String name;
		int count; // ��ס����
		String choice = null;
		String goodsList = ""; // �嵥
		double total = 0; // �ܽ��
		double finalPay = 0; // �踶��
		double payment; // ʵ�ʽ��ѽ��

		System.out.println("�Ƶ�ͷ�����ϵͳ > ס������\n\n");

		// ��ӡ��Ʒ�嵥
		System.out.println("*************************************");
		System.out.println("��ѡ����ס�ķ����ţ�");
		System.out.println(" ������ \t ����"+"\t\t"+"�۸�"+"\t"+"״̬");
		for (int i = 0, p = 0; i < roomlist.size() && null != roomlist.get(i).type; i++) {
			p++;
			String zhuangtai;
			if(roomlist.get(i).state==0){//��ʾ����Ϊ�գ�������ס
				zhuangtai="Ϊ��";
			}
			else{
				zhuangtai="����ס";
			}
			System.out.println(p + ":\t " + roomlist.get(i).type + "\t\t"+ roomlist.get(i).price+"\t"+ zhuangtai);
		}
		System.out.println("*************************************\n");

		/* ������ס����ϵͳ */
		Scanner input = new Scanner(System.in);
		System.out.print("\t���������֤�ţ�");
		curCustNumber = input.next();
		if(curCustNumber.length()<18||curCustNumber.length()>18){
			System.out.println("���֤���������,��������");
			curCustNumber = input.next();
		}
		Customer_Lala discount = getDiscount(curCustNumber, customerlist);//���ø÷����������֤�ŷ��ظ����֤�ŵĶ���
		if (discount == null||discount.room.state==1) {//���û�в鵽
			System.out.println("û�в�ѯ���ÿͻ�����û��Ѿ���ס");
		} else {
			do {
				System.out.print("\t�����뷿���ţ�"); // �����±�+1����Ʒ���
				goodsNo = input.nextInt();
				System.out.print("\t��������ס������");
				count = input.nextInt();
				if(roomlist.get(goodsNo-1).state==1){
					System.out.println("�÷������п���");
					break;
				}

				// ��ѯ����
				price = roomlist.get(goodsNo - 1).price;
				name =  roomlist.get(goodsNo - 1).type;
				 roomlist.get(goodsNo - 1).state=1;
				total = total + price * count;
				discount.room= roomlist.get(goodsNo - 1);
				discount.room.num=count;
				discount.room.state=1;

				// ���ӹ����嵥
				goodsList = goodsList + "\n" + name + "\t\t" + "��" + price
						+ "\t\t" + count + "\t\t" + "��" + (price * count)
						+ "\t";
				// ���������ܽ��
				finalPay = total ;

				// ��ӡ�����嵥
				System.out.println("\n");
				System.out.println("���������������������������������������嵥������������������������������������������");
				System.out.println("��������\t\t" + "����\t\t" + "����\t\t" + "���\t");
				System.out.println(goodsList);
				System.out.println("����ܼ�:\t" + "��" + (finalPay+300)+"(��������Ѻ��,�˷�ʱ����)");
				System.out.print("ʵ�ʽ���:\t��");
				payment = input.nextDouble();
				System.out.println("��Ǯ:\t" + "��" + (payment - finalPay-300));

				System.out.print("\t�Ƿ������y/n��");
				choice = input.next();
				
			} while (choice.equals("y"));

			
			
		}
		// ������һ���˵�
		System.out.print("\n��'n'������һ���˵�:");
		if (input.next().equals("n")) {
			Menu_Lala menu = new Menu_Lala();
			menu.setData(roomlist, customerlist);
			menu.showMainMenu();
		}

	}

}
