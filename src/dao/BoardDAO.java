package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dto.BoardVO;
import dto.CommentVO;
import dto.MemberVO;

public class BoardDAO {
	
	Scanner sc=new Scanner(System.in);
	SimpleDateFormat format1=new SimpleDateFormat("yyyy.MM.dd");
	private ArrayList<BoardVO> arBoard=new ArrayList<>();
	private ArrayList<CommentVO> arComment=new ArrayList<>();
	
	
	public void index(MemberVO member) {
		//view
		Date time=new Date();
		String day=format1.format(time);
//		BoardVO board1=new BoardVO("제목1","내용1",day);
//		BoardVO board2=new BoardVO("제목2","내용2",day);
//		BoardVO board3=new BoardVO("제목3","내용3",day);
//		arBoard.add(board1);
//		arBoard.add(board2);
//		arBoard.add(board3);
		
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
		for(int i=0;i<arBoard.size();i++) {
			if(num==arBoard.get(i).getNum()) {
				cNum=i;
				break;
			}
		}
		return cNum;
	}
	
	public void printArticle(int cNum) {
		System.out.println("번호  : "+arBoard.get(cNum).getNum());
		System.out.println("제목 : "+arBoard.get(cNum).getTitle());
		System.out.println("작성자 : "+arBoard.get(cNum).getWriter());
		System.out.println("등록날짜 : "+arBoard.get(cNum).getDay());
		System.out.println("조회수 : "+arBoard.get(cNum).getViews());
		System.out.println("==============================");
		System.out.println("------------댓글-------------");
		for(int i=0;i<arComment.size();i++) {
			if(arBoard.get(cNum).getNum()==arComment.get(i).getParetId()) {
				System.out.println("내용 : "+arComment.get(i).getBody());
				System.out.println("작성자 : "+arComment.get(i).getWriter());
				System.out.println("작성일 : "+arComment.get(i).getRegDate());
				
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
		BoardVO board=new BoardVO(title,body,member.getNickname(),day);
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
	
	public void read(MemberVO member) {
		System.out.print("상세보기 할 게시물 번호 : ");
		int num=Integer.parseInt(sc.nextLine());
		int cNum=searchCheck(num);	

		if(cNum==-1) {
			System.out.println("없는 게시물 번호 입니다.");
		}else {
			System.out.println("====="+arBoard.get(cNum).getNum()+"번 게시물"+"=====");
			printArticle(cNum);
			
			arBoard.get(cNum).setViews(arBoard.get(cNum).getViews()+1);
			
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
					CommentVO cm=new CommentVO(arBoard.get(cNum).getNum(),member.getNickname(), comment, day);
					arComment.add(cm);
					System.out.println("댓글이 등록되었습니다.");
					printArticle(cNum);
				break;
				case 2:
					break;
				case 3:
					System.out.print("제목 : ");
					String title=sc.nextLine();
					System.out.print("내용 : ");
					String body=sc.nextLine();
					arBoard.get(cNum).setTitle(title);
					arBoard.get(cNum).setBody(body);
					System.out.println("수정이 완료 되었습니다.");
					break;
				case 4:
					arBoard.remove(cNum);
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
