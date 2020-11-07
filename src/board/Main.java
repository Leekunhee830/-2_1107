package board;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Information> aInfor=new ArrayList<>();	

	static int gCheck(int index) {
		int ok=-1;
		for(int i=0;i<aInfor.size();i++) {
			if(index==aInfor.get(i).getCnt()) {
				ok=i;
		    	break;
			}
		}
		return ok;
	}
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String title="";
		String body="";
		String check="";
		int cnt=0;
		int updateNum=0;
		int deleteNum=0;
		
		while(true) {
			System.out.print("��ɾ �Է����ּ��� : ");
			check=sc.nextLine();
			if(check.equals("exit")) {
				System.out.println("����");
				break;
			}
				
			
			if(check.equals("add")) {
				System.out.print("�Խù� ������ �Է����ּ��� : ");
				title=sc.nextLine();
				System.out.print("�Խù� ������ �Է����ּ��� : ");
			    body=sc.nextLine();
			    cnt++;
			    
			    aInfor.add(new Information(title,body,cnt));		    
			   
			    System.out.println("�Խù��� ��ϵǾ����ϴ�.");
			}
			
			if(check.equals("list")) {
				for(int i=0;i<aInfor.size();i++) {
					Information info=aInfor.get(i);
					System.out.println("��ȣ : "+info.getCnt());
					System.out.println("���� : "+info.getTitle());
				    System.out.println("================================");
				}
			}
			
			if(check.equals("update")) {
				System.out.print("������ �Խù� ��ȣ:");
				updateNum=Integer.parseInt(sc.nextLine());
				int num=gCheck(updateNum);
				
				
				if(num==-1) {
					System.out.println("���� �Խù� ��ȣ �Դϴ�.");
				}else {
					System.out.print("���� : ");
					title=sc.nextLine();
				    System.out.print("���� : ");
					body=sc.nextLine();
						
					aInfor.set(num,new Information(title,body,updateNum));
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				}

			}
			
			if(check.equals("delete")){
				System.out.print("������ �Խù� ��ȣ :");
				deleteNum=Integer.parseInt(sc.nextLine());
				int num=gCheck(deleteNum);
				
				if(num==-1) {
					System.out.println("���� �Խù� ��ȣ �Դϴ�.");
				}else {
					aInfor.remove(num);
					System.out.println("�Խù��� ���� �Ǿ����ϴ�.");
				}

			}
		}
	}
}


