package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dto.BoardVO;
import dto.CommentVO;
import dto.MemberVO;

public class BoardDAO {
	

	private ArrayList<BoardVO> arBoard=new ArrayList<>();
	private ArrayList<CommentVO> arComment=new ArrayList<>();
	
	
	public ArrayList<BoardVO> getArBoard() {
		return arBoard;
	}
	
	public void setArBoard(ArrayList<BoardVO> arBoard) {
		this.arBoard = arBoard;
	}
	
	public ArrayList<CommentVO> getArComment() {
		return arComment;
	}
	
	public void setArComment(ArrayList<CommentVO> arComment) {
		this.arComment = arComment;
	}
	
		
}
