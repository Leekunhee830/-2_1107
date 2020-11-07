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
			System.out.print("명령어를 입력해주세요 : ");
			check=sc.nextLine();
			if(check.equals("exit")) {
				System.out.println("종료");
				break;
			}
				
			
			if(check.equals("add")) {
				System.out.print("게시물 제목을 입력해주세요 : ");
				title=sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요 : ");
			    body=sc.nextLine();
			    cnt++;
			    
			    aInfor.add(new Information(title,body,cnt));		    
			   
			    System.out.println("게시물이 등록되었습니다.");
			}
			
			if(check.equals("list")) {
				for(int i=0;i<aInfor.size();i++) {
					Information info=aInfor.get(i);
					System.out.println("번호 : "+info.getCnt());
					System.out.println("제목 : "+info.getTitle());
				    System.out.println("================================");
				}
			}
			
			if(check.equals("update")) {
				System.out.print("수정할 게시물 번호:");
				updateNum=Integer.parseInt(sc.nextLine());
				int num=gCheck(updateNum);
				
				
				if(num==-1) {
					System.out.println("없는 게시물 번호 입니다.");
				}else {
					System.out.print("제목 : ");
					title=sc.nextLine();
				    System.out.print("내용 : ");
					body=sc.nextLine();
						
					aInfor.set(num,new Information(title,body,updateNum));
					System.out.println("수정이 완료되었습니다.");
				}

			}
			
			if(check.equals("delete")){
				System.out.print("삭제할 게시물 번호 :");
				deleteNum=Integer.parseInt(sc.nextLine());
				int num=gCheck(deleteNum);
				
				if(num==-1) {
					System.out.println("없는 게시물 번호 입니다.");
				}else {
					aInfor.remove(num);
					System.out.println("게시물이 삭제 되었습니다.");
				}

			}
		}
	}
}


