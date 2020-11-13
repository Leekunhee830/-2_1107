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
			System.out.print("명령어를 입력해주세요 : ");
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
				System.out.println("명령어를 잘못 입력하였습니다.");
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
		System.out.print("게시물 제목을 입력해주세요 : ");
		String title=sc.nextLine();
		System.out.print("게시물 내용을 입력해주세요 : ");
		String body=sc.nextLine();
		String day=format1.format(time);
		BoardVO board=new BoardVO(title,body,day);
		arBoard.add(board);
		System.out.println("게시물이 등록되었습니다.");
	}
	
	public void list() {
		for(int i=0;i<arBoard.size();i++) {
			System.out.println("번호  : "+arBoard.get(i).getNum());
			System.out.println("제목 : "+arBoard.get(i).getTitle());
			System.out.println("작성자 : "+arBoard.get(i).getWriter());
			System.out.println("등록날짜 : "+arBoard.get(i).getDay());
			System.out.println("조회수 : "+arBoard.get(i).getViews());
			System.out.println("==============================");
		}
	}
	
	public void update() {
		 
		System.out.print("수정할 게시물 번호 : ");
		int num=Integer.parseInt(sc.nextLine());
		int cNum=searchCheck(num);
		
		if(cNum==-1) {
			System.out.println("없는 게시물 번호 입니다.");
		}else {
			System.out.print("제목 : ");
			String title=sc.nextLine();
			System.out.print("내용 : ");
			String body=sc.nextLine();
			arBoard.get(cNum).setTitle(title);
			arBoard.get(cNum).setBody(body);
			System.out.println("수정이 완료 되었습니다.");
		}
	}
	
	public void delete() {
		System.out.print("삭제할 게시물 번호 : ");
		int num=Integer.parseInt(sc.nextLine());
		int cNum=searchCheck(num);
		
		if(cNum==-1) {
			System.out.println("없는 게시물 번호 입니다.");
		}else {
			arBoard.remove(cNum);
			System.out.println("삭제가 완료 되었습니다.");
		}
	}
	
	public void read() {
		System.out.print("상세보기 할 게시물 번호 : ");
		int num=Integer.parseInt(sc.nextLine());
		int cNum=searchCheck(num);	
	
		if(cNum==-1) {
			System.out.println("없는 게시물 번호 입니다.");
		}else {
			System.out.println("====="+arBoard.get(cNum).getNum()+"번 게시물"+"=====");
			System.out.println("번호: "+arBoard.get(cNum).getNum());
			System.out.println("제목: "+arBoard.get(cNum).getTitle());
			System.out.println("내용: "+arBoard.get(cNum).getBody());
			System.out.println("===============");
			arBoard.get(cNum).setViews(arBoard.get(cNum).getViews()+1);
		}
	}
	
	public void search() {
		String keyword="";
		System.out.print("검색 항목을 선택해주세요 (1.제목, 2.내용, 3.제목+내용, 4.작성자): ");
		int num=Integer.parseInt(sc.nextLine());
		if(num<1 || num>4) {
			System.out.println("없는 항목입니다.");
		}else {
			System.out.print("검색 키워드를 입력해주세요 : ");
			keyword=sc.nextLine();
			switch(num) {
			case 1:
				for(int i=0;i<arBoard.size();i++) {
					if(arBoard.get(i).getTitle().contains(keyword)) {
						System.out.println("번호 : "+arBoard.get(i).getNum());
						System.out.println("제목 : "+arBoard.get(i).getTitle());
					}
				}
				break;
			case 2:
				for(int i=0;i<arBoard.size();i++) {
					if(arBoard.get(i).getBody().contains(keyword)) {
						System.out.println("번호 : "+arBoard.get(i).getNum());
						System.out.println("제목 : "+arBoard.get(i).getTitle());
					}
				}
				break;
			case 3:
				for(int i=0;i<arBoard.size();i++) {
					if(arBoard.get(i).getBody().contains(keyword) ||
							arBoard.get(i).getTitle().contains(keyword)) {
						System.out.println("번호 : "+arBoard.get(i).getNum());
						System.out.println("제목 : "+arBoard.get(i).getTitle());
					}
				}
				break;
			case 4:
				for(int i=0;i<arBoard.size();i++) {
					if(arBoard.get(i).getWriter().contains(keyword)) {
						System.out.println("번호 : "+arBoard.get(i).getNum());
						System.out.println("제목 : "+arBoard.get(i).getTitle());
					}
				}
				break;
			default:
				break;
			}	
		}
		
	}
	
	
}
