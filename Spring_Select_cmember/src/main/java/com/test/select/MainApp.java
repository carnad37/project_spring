package com.test.select;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
		CmemberService onjService = (CmemberService)context.getBean("cmemberService");
		
		System.out.println("※ Cmember 테이블의 레코드 개수를 출력하세요");
		System.out.println("result : " + onjService.query_getCountRecord());
		System.out.println("");
		
		System.out.println("※ Id가  apple인 레코드의 pw를 출력하세요");
		System.out.print("result : ");
		printList(onjService.query_getPwOfId("apple"));
		System.out.println("");
		
		System.out.println("※ cNum이  9867인 레코드의 id를 출력하세요");
		System.out.print("result : ");
		printList(onjService.query_getIdOfcNum(9867));
		System.out.println("");
		
		System.out.println("※Name이 desk이고, cNum이  9867인 레코드의 정보를 출력하세요.");
		printCmemberList(onjService.query_getRecordByNameAndCNum("desk", 9867));

//		System.out.println("※레코드를 추가하세요.");
//		List<Cmember> memberList = new LinkedList<Cmember>();
//		memberList.add(new Cmember("memon", "key", "desk", 9867));
//		memberList.add(new Cmember("mel", "con", "cal", 8774));
//		memberList.add(new Cmember("del", "con", "wat", 6573));
//		onjService.query_setRecord(memberList);
		
		System.out.println("※PW가 con인 레코드의 정보를 출력하세요.");
		printCmemberList(onjService.query_getRecordByPw("con"));
		
//		System.out.println("※Name이 desk인 레코드를 삭제하세요.");
//		onjService.query_delRecordByName("desk");
		
		System.out.println("※iD가 memon인 레코드의  pw를 door로 변경하세요.");
		onjService.query_updateRecordById("memon", "door");	
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
		}
		System.out.println("");
	}
}
