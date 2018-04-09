package entity_Lala;
/**
 * 顾客类
 * @author lenovo
 *
 */
public class Customer_Lala {
	 public String  custNumber; //顾客身份证号  
	 public String  custName; //顾客姓名
	 public String  custSex ; //顾客性别
	 public Rooms_Lala room;//房间信息
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
