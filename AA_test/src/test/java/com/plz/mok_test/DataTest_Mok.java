package com.plz.mok_test;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.plz.dao.CmemberDao;
import com.plz.dto.Cmember;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
"file:src/main/webapp/WEB-INF/spring/bean-context.xml"})
@Transactional
public class DataTest_Mok {
	
	@Autowired
	private CmemberDao dao;	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}	
	
	
//	cmember 테이블의 레코드 개수를 model에 저장, 갯수가 맞으면 success//
	@Test
	public void rowChecker() throws Exception {
		this.mockMvc.perform(get("/rowCount"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("row", 3));
	}
	@Test
	public void assert_rowChecker() throws Exception {
		assertThat(dao.getCountRecord(), equalTo(3));
	}
	
	
//	id가 apple(param을 이용 컨트롤러로 전달 ),  레코드의 pw가 orange 이면  success
	@Test
	public void pwChecker() throws Exception{
		this.mockMvc.perform(get("/getPwOfId").param("id", "apple"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("pw", hasItem("orange")));
	}
	@Test
	public void assert_pwChecker() throws Exception{
		assertThat(dao.getPwOfId("apple"), hasItem("orange"));
	}
	
//	cNum이 9867(param을 이용 컨트롤러로 전달 ), 레코드의 id가 memon이면 success
	@Test
	public void idChecker() throws Exception{
		this.mockMvc.perform(get("/getIdOfcNum").param("cNum", "9867"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("cNum", hasItem("memon")));
	}
	@Test
	public void assert_idChecker() throws Exception{
		assertThat(dao.getIdOfcNum(9867), hasItem("memon"));
	}
	
//	아래와 같은 레코드를 추가 되면 success
//	(‘mel',‘con',‘cal',8774);
//	(‘del',‘con',‘wat',6573);
	//트랜잭션이 적용되어 있다.
	@Test
	public void insertChecker() throws Exception{		
		
		this.mockMvc.perform(get("/setRecord").param("id", "mel").param("pw", "con").param("name", "cal").param("cNum", "8774"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("result", is(1)));
		this.mockMvc.perform(get("/setRecord").param("id", "del").param("pw", "con").param("name", "wat").param("cNum", "6573"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("result", is(1)));
	}
	@Test
	public void assert_insertChecker() throws Exception{		
		List<Cmember> memberList = Arrays.asList(new Cmember("mel", "con", "cal", 8774),
												new Cmember("del", "con", "wat", 6573));		
		int test = dao.setRecord(memberList);
		assertThat(test, is(2));
	}
	
//	name가 desk인 레코드를 삭제되면 success
	@Test
	public void delChecker() throws Exception{
		this.mockMvc.perform(get("/delRecordByName").param("name", "desk"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("result", is(2)));
	}
	@Test
	public void assert_delChecker() throws Exception{
		int test = dao.delRecordByName("desk");
		assertThat(test, is(2));
	}
	
//	id 가  memon인 레코드의 pw를 door로 변경되면 success
	@Test
	public void updateChecker() throws Exception{
		this.mockMvc.perform(get("/updateRecordById").param("id", "memon").param("nPw", "door"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("result", is(1)));
	}
	@Test
	public void assert_updateChecker() throws Exception{
		int test = dao.updateRecordById("memon", "door");
		assertThat(test, is(1));
	}
	
//	name가 desk이고, cNum이 9867인 레코드 모든 정보가 맞으면  success
	@Test
	public void selectNameAndcNumChecker() throws Exception{
		this.mockMvc.perform(get("/updateRecordById").param("id", "desk").param("cNum", "9867"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("result", not(IsEmptyCollection.empty())));
	}

	@Test
	public void assert_selectNameAndcNumChecker() throws Exception{
		List<Cmember> memeberList = dao.getRecordByNameAndCNum("desk", 9867);
		assertThat(memeberList.isEmpty(), is(false));
	}

	
	
}
