package entity_Lala;
/**
 * �˿���
 * @author lenovo
 *
 */
public class Customer_Lala {
	 public String  custNumber; //�˿����֤��  
	 public String  custName; //�˿�����
	 public String  custSex ; //�˿��Ա�
	 public Rooms_Lala room;//������Ϣ
	 public Customer_Lala(){
		 
	 }
	 public Customer_Lala(String custNumber,String custName,String custSex,Rooms_Lala room){
		 this.custNumber=custNumber;
		 this.custName=custName;
		 this.custSex=custSex;
		 this.room=room;
	 }
	 public String getCustNumber() {
		return custNumber;
	}
	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSex() {
		return custSex;
	}
	public void setCustSex(String custSex) {
		this.custSex = custSex;
	}
	public Rooms_Lala getRoom() {
		return room;
	}
	public void setRoom(Rooms_Lala room) {
		this.room = room;
	}
	public void getDiscount(){
		
	}
	public void getDiscount(String curCustNumber, Customer_Lala[] customers){
		
	}
	  
}
