//package com.gaonsoft.mcs.sample.mapper;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//
//import com.gaonsoft.mcs.sample.domain.Customer;
//
//public interface CustomerMapper {
//	@Select("SELECT * FROM Customer")
//	List<Customer> selectAllCustomers();
//	
//	@Select("SELECT * FROM CUSTOMER WHERE ID = #{id}")
//	Customer selectCustomer(@Param("id") long id);
//}
