package dao;

import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberVO;

public class MemberDAO {
	

	private ArrayList<MemberVO> arMember=new ArrayList<>();
	
	public ArrayList<MemberVO> getArMember() {
		return arMember;
	}

	public void setArMember(ArrayList<MemberVO> arMember) {
		this.arMember = arMember;
	}

}
