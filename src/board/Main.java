package board;

import java.util.ArrayList;
import java.util.Calendar;
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
		Calendar cal=Calendar.getInstance();
		
		String title="";
		String body="";
		String cmd="";
		int cnt=3;
		int number=0;
		
		Information a1=new Information("1제목","1내용",1);
		Information a2=new Information("2제목","2내용",2);
		Information a3=new Information("3제목","3내용",3);
		
		aInfor.add(a1);
		aInfor.add(a2);
		aInfor.add(a3);
		
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			cmd=sc.nextLine();
			
			if(cmd.equals("exit")) {
				System.out.println("종료");
				break;
			}
				
			
			if(cmd.equals("add")) {
				System.out.print("게시물 제목을 입력해주세요: ");
				title=sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요: ");
			    body=sc.nextLine();
			    cnt++;
		   
			    aInfor.add(new Information(title,body,cnt));		    
			   
			    System.out.println("게시물이 등록되었습니다.");
			}
			
			if(cmd.equals("list")) {
				for(int i=0;i<aInfor.size();i++) {
					Information info=aInfor.get(i);
					System.out.println("번호 : "+info.getCnt());
					System.out.println("제목 : "+info.getTitle());
					System.out.println("작성자: "+info.getWriter());
					System.out.println("등록일자: "+info.getYear()
							+"."+info.getMonth()
							+"."+info.getDay());
					System.out.println("조회수:"+info.getpNumber());
				    System.out.println("================================");
				}
			}
			
			if(cmd.equals("update")) {
				System.out.print("수정할 게시물번호:");
				number=Integer.parseInt(sc.nextLine());
				int num=gCheck(number);
				
				if(num==-1) {
					System.out.println("없는 게시물 번호입니다.");
				}else {
					System.out.print("제목 : ");
					title=sc.nextLine();
				    System.out.print("내용 : ");
					body=sc.nextLine();
						
					aInfor.set(num,new Information(title,body,number));
					System.out.println("수정이 완료되었습니다.");
				}

			}
			
			if(cmd.equals("delete")){
				System.out.print("삭제할 게시물번호:");
				number=Integer.parseInt(sc.nextLine());
				int num=gCheck(number);
				
				if(num==-1) {
					System.out.println("없는 게시물 번호입니다.");
				}else {
					aInfor.remove(num);
					System.out.println("게시물이 삭제되었습니다.");
				}
			}
			
			if(cmd.equals("read")) {
				System.out.print("게시물 번호:");
				number=Integer.parseInt(sc.nextLine());
				int num=gCheck(number);
				
				if(num==-1) {
					System.out.println("없는 게시물 번호입니다.");
				}else {
					int pCheck=aInfor.get(num).getpNumber();
					pCheck++;
					aInfor.get(num).setpNumber(pCheck);
					
					System.out.println("======="+aInfor.get(num).getCnt()+"번 게시물=======");
					System.out.println(aInfor.get(num).getCnt());
					System.out.println(aInfor.get(num).getTitle());
					System.out.println(aInfor.get(num).getBody());
					System.out.println("========================");
				}
			}
			
			if(cmd.equals("search")) {
				System.out.print("검색 항목을 선택해주세요(1.제목 , 2.내용 , 3.제목+내용 , 4.작성자): ");
                number=Integer.parseInt(sc.nextLine());
                if(number>5&&number<0) {
                	System.out.println("없는 번호입니다.");
                }
                System.out.print("검색 키워드를 입력하세요:");
                String search=sc.nextLine();
                
                switch(number) {
                case 1:
                	for(int i=0;i<aInfor.size();i++) {
                		if(aInfor.get(i).getTitle().contains(search)) {
                			System.out.println("번호: "+aInfor.get(i).getCnt());
                			System.out.println("제목: "+aInfor.get(i).getTitle());
                		}
                	}    	
                	break;
                case 2:
                	for(int i=0;i<aInfor.size();i++) {
                		if(aInfor.get(i).getBody().contains(search)) {
                			System.out.println("번호: "+aInfor.get(i).getCnt());
                			System.out.println("제목: "+aInfor.get(i).getTitle());
                		}
                	}    	
                	break;
                case 3:
                	for(int i=0;i<aInfor.size();i++) {
                		if(aInfor.get(i).getBody().contains(search)||aInfor.get(i).getTitle().contains(search)) {
                			System.out.println("번호: "+aInfor.get(i).getCnt());
                			System.out.println("제목: "+aInfor.get(i).getTitle());
                		}
                	}    	
                	break;
                case 4:
                	for(int i=0;i<aInfor.size();i++) {
                		if(aInfor.get(i).getWriter().contains(search)) {
                			System.out.println("번호: "+aInfor.get(i).getCnt());
                			System.out.println("제목: "+aInfor.get(i).getTitle());
                		}
                	}    	
                	break;
                }
				
				
			}
			
			
			
			
		}
	}
}


