package biz_Lala;
/**
 * �Ƶ�ͷ��������
 * @author lenovo
 *
 */
import java.util.*;
import entity_Lala.Data_Lala;
public class StartSMS_Lala {
	  public static void main(String[] args){
    	   /*��ʼ���ͷ��Ϳͻ���Ϣ*/
           Data_Lala initial = new Data_Lala();
           initial.ini();
           /*����ϵͳ*/
           Menu_Lala menu = new Menu_Lala();//ʵ����һ��Menu����
     	   menu.setData(initial.rooms, initial.customers); //���� menu.setData�ѳ�ʼ���ͷ��Ϳͻ���Ϣ����ȥ
           menu.showLoginMenu();//��ʾ��½����
           /*�˵�ѡ��*/
           boolean con = true;
           while(con){
             Scanner input = new Scanner(System.in);
             int choice = input.nextInt();
             VerifyEqual_Lala pv = new VerifyEqual_Lala();
             switch(choice){
               case 1: 
            	  /*������֤��ֻ��3�λ���*/
            	  for(int i = 3; i>=1; i--){
            		  if(pv.verify(initial.manager.username, initial.manager.password)){
                    	  menu.showMainMenu();
                    	  break;
            		  }else if(i!=1){
            			  System.out.println("\n�û��������벻ƥ�䣬���������룺"); //����3�����룬�˳�
            		  }else{
            			  System.out.println("\n��û��Ȩ�޽���ϵͳ��лл��");
            			  con = false;
            		  }
            	  }
            	  break;
               case 2: 
            	  if(pv.verify(initial.manager.username, initial.manager.password)){
            		  System.out.print("�������µ��û�����");
            		  String name = input.next();
            		  System.out.print("�������µ����룺");
            		  String pwd = input.next();
            		  System.out.print("���ٴ������µ����룺");
            		  String repwd = input.next();
            		  if(pwd.equals(repwd)){
            			  initial.manager.username = name;
            			  initial.manager.password = pwd;
            			  System.out.println("�û����������Ѹ��ģ�");  
            		  }
            		  else{
            			  System.out.println("�������벻һ�¡�");
            		  }
            			  
            		  System.out.println("\n��ѡ���������֣�");
            	  }else{
            		  System.out.println("��Ǹ����û��Ȩ���޸ģ�");
            		  con = false;
            	  }
            	  break;
               case  3: 
            	  System.out.println("лл����ʹ�ã�");
            	  con = false;
            	  break;
               default: 
            	  System.out.print("\n��������������ѡ����������: ");
             }
             if(!con){
            	 break;
             }
           }
          
      }
}
