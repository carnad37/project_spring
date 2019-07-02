//package com.test.mok;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.test.dao.MemberDAO;
//import com.test.dto.Member;
//
//
//public class RegSvc {
//
//
//    @Autowired
//    private MemberDAO dao;
//
//    @Test
//    public void register() {
//        // 데이터가 초기화되므로, "user" ID를 갖는 데이터는 항상 DB에 존재하지 않음
//    	Member regReq = createRequest("user", "사용자");
//    	dao.register(regReq);
//        assertThat(dao.selectById("user"), notNullValue());
//    }
//
//    @Test(expected = DuplicateIdException.class)
//    public void duplicateIdTest() {
//        // 데이터를 초기화할 때 ID가 "gildong"인 데이터를 삽입하므로, 항상 ID 중복 에러 발생
//    	Member regReq = createRequest("gildong", "홍길동");
//        memberRegisterService.register(regReq);
//    }
//
//    public Member createRequest(String id, String name) {
//    	Member regReq = new Member();
//        regReq.setId(id);
//        regReq.setPassword("1234");
////        regReq.setConfirmPassword("1234");
//        regReq.setName(name);
//        return regReq;
//    }
//}
