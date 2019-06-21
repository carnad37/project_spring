package com.test.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("mainBean.xml");
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		Person person = (Person)context.getBean("person");
		int res = 0;
//		person.setName("Person 1");
//		res = personDao.insert(person);
//		System.out.println(res);
//		
//		person.setName("Person 3");
//		res = personDao.insert(person);
//		System.out.println(res);
		

		
		Person person4 = personDao.selectById(2);
		System.out.println(person4.getName());
		System.out.println(person4.getId());
		
//		person.setId(1);
//		person.setName("Person 3");
//		personDao.update(person);

//		personDao.delete(1);
		
//		List<Person> list = personDao.selelctCondition(4);
		
//		List<Person> list = personDao.selectAll();
		
		List<Person> list = personDao.selectLike("4");
		for (Person pData : list) {
			System.out.println("id : " + pData.getId());
			System.out.println("name : " + pData.getName());
		}
		
//		List<Map<String, Object>> mapList = personDao.selectAllMapResult();
		Map<String, Object> dto = new HashMap<String, Object>();
		dto.put("id", 5);
		dto.put("name", "person 5");
		List<Map<String, Object>> mapList = personDao.selectMapParaMapResult(dto);
		for (Map<String, Object> map : mapList) {
			for (Map.Entry<String, Object> unitMap : map.entrySet()) {
				System.out.println("key : " + unitMap.getKey());
				System.out.println("value : " + unitMap.getValue());
			}
			System.out.println("");
		}
	}	
}
