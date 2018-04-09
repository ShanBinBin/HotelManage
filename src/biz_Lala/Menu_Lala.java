package biz_Lala;
import entity_Lala.Data_Lala;
import entity_Lala.Manager_Lala;
import entity_Lala.Rooms_Lala;
import entity_Lala.Customer_Lala;
import java.util.ArrayList;
import java.util.List;
/**
 * �˵���
 * @author lenovo
 *
 */
import java.util.Scanner;
import entity_Lala.Data_Lala;
import entity_Lala.Manager_Lala;
import entity_Lala.Rooms_Lala;
import entity_Lala.Customer_Lala;
public class Menu_Lala {
    /* ������Ϣ */
	public Rooms_Lala rooms[] = new Rooms_Lala[50];
	/* �˿���Ϣ */
	public Customer_Lala customers[] = new Customer_Lala[100];
	public List<Customer_Lala> customerlist=new ArrayList<Customer_Lala>();
	public List<Rooms_Lala> roomlist=new ArrayList<Rooms_Lala>();
	Data_Lala initial = new Data_Lala();
    
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
	 * ��ʾ�ͷ�����ϵͳ�ĵ�¼�˵�
	 */
	public void showLoginMenu() {
		System.out.println("\n\n\t\t\t    ��ӭʹ�ÿͷ�����ϵͳ\n\n");
		System.out.println ("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. �� ¼ ϵ ͳ\n\n");
		System.out.println("\t\t\t\t 2. �� �� �� �� Ա �� ��\n\n");
		System.out.println("\t\t\t\t 3. �� ��\n\n");
		System.out.println ("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("��ѡ��,��������:");    
	}	
	/**
	 * ��ʾ�ͷ�����ϵͳ�����˵�
	 */
	public void showMainMenu() {
		System.out.println("\n\n\t\t\t\t��ӭʹ�ÿͷ�����ϵͳ\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. �� �� �� Ϣ �� ��\n");
		System.out.println("\t\t\t\t 2. �ͻ���ס���� \n");
		System.out.println("\t\t\t\t 3. �˷�\n");		
		System.out.println("\t\t\t\t 4. ע ��\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("��ѡ��,��������:");
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do{
			String num = input.next();
			  if(num.equals("1")){
                   //��ʾ�ͻ���Ϣ����˵�
				  setData(initial.rooms, initial.customers);
				  showCustMMenu();
				   break;
			  }else if(num.equals("2")){
				   //��ʾ��ס����˵�
				   Pay_Lala pay = new Pay_Lala();
				   pay.setData(roomlist,customerlist);
				   pay.calcPrice();
				   break;
			  }else if(num.equals("3")){
                   //��ʾ�˷��˵�
				   Check_Out_Lala checkout=new Check_Out_Lala();
				   checkout.setData(roomlist, customerlist);
				   checkout.checkOut();
				   break;
			  }else if(num.equals("4")){
				   setData(initial.rooms, initial.customers);
				   showLoginMenu(); 
				   break;
			  }else{
				   System.out.print("��������������������֣�");
				   con = false;
			  }
		}while(!con);
	}
	/**
	 * �ͻ���Ϣ����˵�
	 */
	public void showCustMMenu() {
		System.out.println("�Ƶ�ͷ�����ϵͳ > �ͻ���Ϣ����\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. �� ʾ �� �� �� �� �� Ϣ\n");
		System.out.println("\t\t\t\t 2. �� �� �� �� Ԥ�� \n");
		System.out.println("\t\t\t\t 3. �� �� �� �� �� Ϣ\n");
		System.out.println("\t\t\t\t 4. �� ѯ �� �� �� Ϣ\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("��ѡ��,�������ֻ�'n'������һ���˵�:");
		Scanner input = new Scanner(System.in);
		boolean con = true;  //�����������˵��Ŵ���
	    do{
	      CustManagement_Lala cm = new CustManagement_Lala();//ʵ����һ��CustManagement����
		  cm.setData(roomlist,customerlist);//���ݿͷ��Ϳͻ���Ϣ
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
			System.out.println("�������, �������������֣�");
			con = false;
		  }
	    }while(!con);
	}
	

}
