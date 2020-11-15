package dao;

import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberVO;

public class MemberDAO {
	
	Scanner sc=new Scanner(System.in);
	BoardDAO bo=new BoardDAO();
	private ArrayList<MemberVO> arMember=new ArrayList<>();
	
	
	public void view2(){
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd=sc.nextLine();
		
			switch(cmd) {
			case "signup":
				signup();
			break;
			case "signin":
				signin();
				break;
			case "list":
				bo.list();
			break;
			case "help":
				System.out.println("article[add:게시물추가/list:게시물 목록 조회/"
						+ "read:게시물 조회/search:검색]");
				System.out.println("member[signup:회원가입/signin:로그인/"
						+ "findpass:비밀번호 찾기/findid:아이디 찾기/logout:로그아웃]");
				break;
			default:
				System.out.println("로그인 후 사용 가능합니다.");
			break;
		}
		
		}
		
	}
	
	public void signup(){
		System.out.println("===회원 가입을 진행합니다===");
		System.out.print("아이디를 입력해주세요 : ");
		String id=sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw=sc.nextLine();
		System.out.print("닉네임을 입력해주세요 : ");
		String nick=sc.nextLine();
		MemberVO member=new MemberVO(id,pw,nick);
		arMember.add(member);
		System.out.println("===회원가입이 완료되었습니다.===");
	}
	
	public void signin() {
		boolean loginCheck=false;
		MemberVO member=null;
		System.out.print("아이디 : ");
		String id=sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw=sc.nextLine();
	
		
		for(int i=0;i<arMember.size();i++) {
			if(arMember.get(0).getLoginId().equals(id) && 
					arMember.get(0).getLoginPw().equals(pw)) {
				member=arMember.get(i);
				loginCheck=true;
				break;
			}
		}
		if(!loginCheck) {
			System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
		}else {
			System.out.println(member.getNickname()+
					"님 환영합니다.");
			bo.index(member);
		}

	}
	
}
