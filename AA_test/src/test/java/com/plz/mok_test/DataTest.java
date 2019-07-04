package com.plz.mok_test;
	
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import com.plz.dao.CmemberDao;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/bean-context.xml"})
public class DataTest {
	
	@Autowired
	private WebApplicationContext context;

	@Autowired
	private CmemberDao dao;
	
	private MockMvc mockMvc;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
//	cmember 테이블의 레코드 개수를 model에 저장, 갯수가 맞으면 success
	@Test
	public void recordCheck() throws Exception{
		assertThat(dao.getCountRecord(), equalTo(4));
	}
	
//	id가 apple(param을 이용 컨트롤러로 전달 ),  레코드의 pw가 orange 이면  success
	@Test
	public void pwChecerById() throws Exception{
		assertThat(dao.getPwOfId("apple"), hasItem("orange"));
	}
	
//	cNum이 9867(param을 이용 컨트롤러로 전달 ), 레코드의 id가 memon이면 success
	@Test
	public void idCheckerBycNum() throws Exception{
		assertThat(dao.getIdOfcNum(9867), hasItem("memon"));
	}
	
//	아래와 같은 레코드를 추가 되면 success
//	(‘mel',‘con',‘cal',8774);
//	(‘del',‘con',‘wat',6573);
	
	
//	name가 desk인 레코드를 삭제되면 success
//	id 가 memon  인 레코드의 pw를 door로 변경되면 success
//	name가 desk이고, cNum이 9867인 레코드 모든 정보가 맞으면  success


	
}


