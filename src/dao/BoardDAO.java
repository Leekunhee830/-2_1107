package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dto.BoardVO;

public class BoardDAO {
	
	Scanner sc=new Scanner(System.in);
	private ArrayList<BoardVO> arBoard=new ArrayList<>();
	
	public void index() {
		//view
		while(true) {
			System.out.print("��ɾ �Է����ּ��� : ");
			String check=sc.nextLine();
			if(check.equals("exit")) {
				break;
			}
			
			switch(check) {
			case "add":
				add();
				break;
			case "list":
				list();
				break;
			case "update":
				update();
				break;
			case "delete":
				delete();
				break;
			case "read":
				read();
				break;
			case "search":
				search();
				break;
			default:
				System.out.println("��ɾ �߸� �Է��Ͽ����ϴ�.");
				break;
			}
		}
	}
	
	public int searchCheck(int num) {
		int cNum=-1;
		for(int i=0;i<arBoard.size();i++) {
			if(num==arBoard.get(i).getNum()) {
				cNum=i;
				break;
			}
		}
		return cNum;
	}
	
	public void add() {
		SimpleDateFormat format1=new SimpleDateFormat("yyyy.MM.dd");
		Date time=new Date();
		System.out.print("�Խù� ������ �Է����ּ��� : ");
		String title=sc.nextLine();
		System.out.print("�Խù� ������ �Է����ּ��� : ");
		String body=sc.nextLine();
		String day=format1.format(time);
		BoardVO board=new BoardVO(title,body,day);
		arBoard.add(board);
		System.out.println("�Խù��� ��ϵǾ����ϴ�.");
	}
	
	public void list() {
		for(int i=0;i<arBoard.size();i++) {
			System.out.println("��ȣ  : "+arBoard.get(i).getNum());
			System.out.println("���� : "+arBoard.get(i).getTitle());
			System.out.println("�ۼ��� : "+arBoard.get(i).getWriter());
			System.out.println("��ϳ�¥ : "+arBoard.get(i).getDay());
			System.out.println("��ȸ�� : "+arBoard.get(i).getViews());
			System.out.println("==============================");
		}
	}
	
	public void update() {
		 
		System.out.print("������ �Խù� ��ȣ : ");
		int num=Integer.parseInt(sc.nextLine());
		int cNum=searchCheck(num);
		
		if(cNum==-1) {
			System.out.println("���� �Խù� ��ȣ �Դϴ�.");
		}else {
			System.out.print("���� : ");
			String title=sc.nextLine();
			System.out.print("���� : ");
			String body=sc.nextLine();
			arBoard.get(cNum).setTitle(title);
			arBoard.get(cNum).setBody(body);
			System.out.println("������ �Ϸ� �Ǿ����ϴ�.");
		}
	}
	
	public void delete() {
		System.out.print("������ �Խù� ��ȣ : ");
		int num=Integer.parseInt(sc.nextLine());
		int cNum=searchCheck(num);
		
		if(cNum==-1) {
			System.out.println("���� �Խù� ��ȣ �Դϴ�.");
		}else {
			arBoard.remove(cNum);
			System.out.println("������ �Ϸ� �Ǿ����ϴ�.");
		}
	}
	
	public void read() {
		System.out.print("�󼼺��� �� �Խù� ��ȣ : ");
		int num=Integer.parseInt(sc.nextLine());
		int cNum=searchCheck(num);	
	
		if(cNum==-1) {
			System.out.println("���� �Խù� ��ȣ �Դϴ�.");
		}else {
			System.out.println("====="+arBoard.get(cNum).getNum()+"�� �Խù�"+"=====");
			System.out.println("��ȣ: "+arBoard.get(cNum).getNum());
			System.out.println("����: "+arBoard.get(cNum).getTitle());
			System.out.println("����: "+arBoard.get(cNum).getBody());
			System.out.println("===============");
			arBoard.get(cNum).setViews(arBoard.get(cNum).getViews()+1);
		}
	}
	
	public void search() {
		String keyword="";
		System.out.print("�˻� �׸��� �������ּ��� (1.����, 2.����, 3.����+����, 4.�ۼ���): ");
		int num=Integer.parseInt(sc.nextLine());
		if(num<1 || num>4) {
			System.out.println("���� �׸��Դϴ�.");
		}else {
			System.out.print("�˻� Ű���带 �Է����ּ��� : ");
			keyword=sc.nextLine();
			switch(num) {
			case 1:
				for(int i=0;i<arBoard.size();i++) {
					if(arBoard.get(i).getTitle().contains(keyword)) {
						System.out.println("��ȣ : "+arBoard.get(i).getNum());
						System.out.println("���� : "+arBoard.get(i).getTitle());
					}
				}
				break;
			case 2:
				for(int i=0;i<arBoard.size();i++) {
					if(arBoard.get(i).getBody().contains(keyword)) {
						System.out.println("��ȣ : "+arBoard.get(i).getNum());
						System.out.println("���� : "+arBoard.get(i).getTitle());
					}
				}
				break;
			case 3:
				for(int i=0;i<arBoard.size();i++) {
					if(arBoard.get(i).getBody().contains(keyword) ||
							arBoard.get(i).getTitle().contains(keyword)) {
						System.out.println("��ȣ : "+arBoard.get(i).getNum());
						System.out.println("���� : "+arBoard.get(i).getTitle());
					}
				}
				break;
			case 4:
				for(int i=0;i<arBoard.size();i++) {
					if(arBoard.get(i).getWriter().contains(keyword)) {
						System.out.println("��ȣ : "+arBoard.get(i).getNum());
						System.out.println("���� : "+arBoard.get(i).getTitle());
					}
				}
				break;
			default:
				break;
			}	
		}
		
	}
	
	
}
