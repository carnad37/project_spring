package com.test.service;

import java.util.List;

import com.test.dao.CmemberDAO;
import com.test.dto.Cmember;

public class Service {
	
	private CmemberDAO cDAO;

	public Service(CmemberDAO cDAO) {
		super();
		this.cDAO = cDAO;
	}
	
	public void query_getByIdStartWord(String idStartWord) {
		printAll(cDAO.getByIdStartWord(idStartWord));
	}
	
	public void query_getByOvercNum(int cNum) {
		printIdANDName(cDAO.getByOvercNum(cNum));
	}
	
	public void query_getByNameLast(String nameLast) {
		printcNum(cDAO.getByNameLast(nameLast));
	}
	
	public void query_getByPWStartWord(String pwStartWord) {
		printNameANDcNum(cDAO.getByPWStartWord(pwStartWord));
	}
	
	private void printAll(List<Cmember> memberList) {
		for (Cmember cmember : memberList) {
			System.out.println("id : " + cmember.getId());
			System.out.println("pw : " + cmember.getPw());
			System.out.println("name : " + cmember.getName());
			System.out.println("cNum : " + cmember.getcNum());
			System.out.println("");
		}
	}
	
	private void printIdANDName(List<Cmember> memberList) {
		for (Cmember cmember : memberList) {
			System.out.println("id : " + cmember.getId());
			System.out.println("name : " + cmember.getName());
			System.out.println("");
		}
	}
	
	private void printNameANDcNum(List<Cmember> memberList) {
		for (Cmember cmember : memberList) {
			System.out.println("name : " + cmember.getName());
			System.out.println("cNum : " + cmember.getcNum());
			System.out.println("");
		}
	}
	
	private void printcNum(List<Cmember> memberList) {
		for (Cmember cmember : memberList) {
			System.out.println("cNum : " + cmember.getcNum());
			System.out.println("");
		}
	}
	
}
