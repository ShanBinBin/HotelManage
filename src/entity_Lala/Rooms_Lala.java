package entity_Lala;
/**
 * ������
 * @author lenovo
 *
 */
public class Rooms_Lala {
	public int number=0;//���
	public String type;//����
	public double price;//�۸�
	public int num;//��ס����
	public int  state=0;//״̬��0��ʾ������ס��1��ʾ������ס
	public Rooms_Lala(){
		
	}
	public Rooms_Lala(int number,String type,double price,int num,int state){
		this.number=number;
		this.type=type;
		this.price=price;
		this.num=num;
		this.state=state; 
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
