package controllar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.BoardDAO;
import dto.BoardVO;
import dto.CommentVO;
import dto.MemberVO;

public class BoardController {
	
	BoardDAO bd=new BoardDAO();

	Scanner sc=new Scanner(System.in);
	SimpleDateFormat format1=new SimpleDateFormat("yyyy.MM.dd");
	
	
	public void index(MemberVO member) {
		
		//view
		Date time=new Date();
		String day=format1.format(time);

		while(true) {
			System.out.print("명령어를 입력해주세요["+member.getLoginId()+"("+member.getNickname()+")] : ");
			String check=sc.nextLine();
			if(check.equals("logout")) {
				System.out.println("로그아웃 되셨습니다.");
				break;
			}
			
			switch(check) {
			case "add":
				add(member);
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
				read(member);
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
		for(int i=0;i<bd.getArBoard().size();i++) {
			if(num==bd.getArBoard().get(i).getNum()) {
				cNum=i;
				break;
			}
		}
		return cNum;
	}
	
	
	public void printArticle(int cNum) {
		System.out.println("번호 : "+bd.getArBoard().get(cNum).getNum());
		System.out.println("제목 : "+bd.getArBoard().get(cNum).getTitle());
		System.out.println("작성자 : "+bd.getArBoard().get(cNum).getWriter());
		System.out.println("등록날짜 : "+bd.getArBoard().get(cNum).getDay());
		System.out.println("조회수 : "+bd.getArBoard().get(cNum).getViews());
		System.out.println("좋아요 : "+bd.getArBoard().get(cNum).getLike());
		System.out.println("==============================");
		System.out.println("------------댓글-------------");
		for(int i=0;i<bd.getArComment().size();i++) {
			if(bd.getArBoard().get(cNum).getNum()==bd.getArComment().get(i).getParetId()) {
				System.out.println("내용 : "+bd.getArComment().get(i).getBody());
				System.out.println("작성자 : "+bd.getArComment().get(i).getWriter());
				System.out.println("작성일 : "+bd.getArComment().get(i).getRegDate());
				
			}
		}
	}
	
	public void add(MemberVO member) {
		Date time=new Date();
		System.out.print("게시물 제목을 입력해주세요 : ");
		String title=sc.nextLine();
		System.out.print("게시물 내용을 입력해주세요 : ");
		String body=sc.nextLine();
		String day=format1.format(time);
		BoardVO board=new BoardVO(title,body,member.getNickname(),day,member.getLoginId());
		bd.getArBoard().add(board);
		System.out.println("게시물이 등록되었습니다.");
	}

	public void list() {
		for(int i=0;i<bd.getArBoard().size();i++) {
			System.out.println("번호  : "+bd.getArBoard().get(i).getNum());
			System.out.println("제목 : "+bd.getArBoard().get(i).getTitle());
			System.out.println("작성자 : "+bd.getArBoard().get(i).getWriter());
			System.out.println("등록날짜 : "+bd.getArBoard().get(i).getDay());
			System.out.println("조회수 : "+bd.getArBoard().get(i).getViews());
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
			bd.getArBoard().get(cNum).setTitle(title);
			bd.getArBoard().get(cNum).setBody(body);
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
			bd.getArBoard().remove(cNum);
			System.out.println("삭제가 완료 되었습니다.");
		}
	}
	
	public void read(MemberVO member) {
		System.out.print("상세보기 할 게시물 번호 : ");
		int num=Integer.parseInt(sc.nextLine());
		int cNum=searchCheck(num);	

		if(cNum==-1) {
			System.out.println("없는 게시물 번호 입니다.");
		}else {
			System.out.println("====="+bd.getArBoard().get(cNum).getNum()+"번 게시물"+"=====");
			printArticle(cNum);
			
			bd.getArBoard().get(cNum).setViews(bd.getArBoard().get(cNum).getViews()+1);
			
			while(true) {
				System.out.print("상세보기 기능을 선택해주세요(1.댓글 등록, 2.좋아요, 3.수정, 4.삭제, 5.목록으로) : ");
				int num2=Integer.parseInt(sc.nextLine());
				if(num2==5) {
					break;
				}
				switch(num2) {
				case 1:
					System.out.println("댓글 내용을 입력해주세요:");
					String comment=sc.nextLine();
					Date time=new Date();
					String day=format1.format(time);
					CommentVO cm=new CommentVO(bd.getArBoard().get(cNum).getNum(),member.getNickname(), comment, day);
					bd.getArComment().add(cm);
					System.out.println("댓글이 등록되었습니다.");
					printArticle(cNum);
				break;
				case 2:
					int like=bd.getArBoard().get(cNum).getLike()+1;
					bd.getArBoard().get(cNum).setLike(like);
					break;
				case 3:
					if(bd.getArBoard().get(cNum).getId().equals(member.getLoginId())) {
						System.out.print("제목 : ");
						String title=sc.nextLine();
						System.out.print("내용 : ");
						String body=sc.nextLine();
						bd.getArBoard().get(cNum).setTitle(title);
						bd.getArBoard().get(cNum).setBody(body);
						System.out.println("수정이 완료 되었습니다.");
					}else {
						System.out.println("자신의 게시물만 수정/삭제 할수 있습니다.");
					}
					break;
				case 4:
					if(bd.getArBoard().get(cNum).getId().equals(member.getLoginId())) {
						bd.getArBoard().remove(cNum);
						System.out.println("삭제 되었습니다.");
					}else{
						System.out.println("자신의 게시물만 수정/삭제 할수 있습니다.");
					}
					break;
				default:
					System.out.println("없는 기능입니다.");
						break;
				}
			}
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
				for(int i=0;i<bd.getArBoard().size();i++) {
					if(bd.getArBoard().get(i).getTitle().contains(keyword)) {
						System.out.println("번호 : "+bd.getArBoard().get(i).getNum());
						System.out.println("제목 : "+bd.getArBoard().get(i).getTitle());
					}
				}
				break;
			case 2:
				for(int i=0;i<bd.getArBoard().size();i++) {
					if(bd.getArBoard().get(i).getBody().contains(keyword)) {
						System.out.println("번호 : "+bd.getArBoard().get(i).getNum());
						System.out.println("제목 : "+bd.getArBoard().get(i).getTitle());
					}
				}
				break;
			case 3:
				for(int i=0;i<bd.getArBoard().size();i++) {
					if(bd.getArBoard().get(i).getBody().contains(keyword) ||
							bd.getArBoard().get(i).getTitle().contains(keyword)) {
						System.out.println("번호 : "+bd.getArBoard().get(i).getNum());
						System.out.println("제목 : "+bd.getArBoard().get(i).getTitle());
					}
				}
				break;
			case 4:
				for(int i=0;i<bd.getArBoard().size();i++) {
					if(bd.getArBoard().get(i).getWriter().contains(keyword)) {
						System.out.println("번호 : "+bd.getArBoard().get(i).getNum());
						System.out.println("제목 : "+bd.getArBoard().get(i).getTitle());
					}
				}
				break;
			default:
				break;
			}	
		}
		
	}
}
