package com.exam.select;
 

import java.util.List;
import java.util.Map;


 


public class SelectService {

       private SelectDao dao;
      
       public SelectService() {}
       public SelectService(SelectDao onjDao) {
             this.dao = onjDao;
       }
      
  
       //======== multi row ===========   

//       //query
//       public List<Emp> query_getEmpByDeptno(int deptno) {
//             return dao.query_getEmpByDeptno(deptno);
//       }
//   
//       //query
//       public List<Emp> query_getEmpByDeptnoByBean(int deptno) {
//             return dao.query_getEmpByDeptnoByBean(deptno);
//       }
       
       //queryForList
       public List<Map<String, Object>> queryForList_getListByDeptno(int deptno) {
           return dao.queryForList_getListByDeptno(deptno);
     }
    
       
       public List<String> query_getEnameByDeptno(int deptno) {
    	   	return dao.query_getEnameByDeptno(deptno);
       }
 
}