package com.test.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dto.Cmember;
import com.test.service.CmemberService;


public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("server-connect.xml");
		CmemberService onjService = (CmemberService)context.getBean("cMembeService"); 
		
		int res = onjService.query_getRecordNum();
		System.out.println("record의 갯수 : " + res);
		
		List<String> list = onjService.query_getPwById("apple");
		printList(list);
		
		list = onjService.query_getIdByCNum(9867);
		printList(list);

		Cmember cmember = new Cmember();
		cmember.setName("desk");
		cmember.setcNum(9867);
		List<Cmember> memberList = onjService.query_getDataByNameANDCNum(cmember);
		printCmemberList(memberList);
		
//		onjService.query_delRecordByPw("con");
//		cmember.setData("mel", "con", "cal", 8774);
//		onjService.query_setRecord(cmember);
//		cmember.setData("del", "con", "wat", 6573);
//		onjService.query_setRecord(cmember);
		
		memberList = onjService.query_getDataByPw("con");
		printCmemberList(memberList);
		
//		cmember.setPw("door");
//		cmember.setId("memon");
//		onjService.query_setPwById(cmember);
	}
	
	public static <T> void printList(List<T> listData) {
		for (int i = 0; i < listData.size(); i++) {
			T t = listData.get(i);
			if (i == 0) {
				System.out.print(t);
			} else {
				System.out.print(", " + t);
			}
		}
		System.out.println("");
	}
	
	public static void printCmemberList(List<Cmember> listData) {
		for (Cmember cmember : listData) {
			System.out.println("id : " + cmember.getId());
			System.out.println("pw : " + cmember.getPw());
			System.out.println("name : " + cmember.getName());
			System.out.println("cNum : " + cmember.getcNum());
			System.out.println("");
		}
	}
}
