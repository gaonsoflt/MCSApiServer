///*******************************************************************************
// * Copyright 2016 Brient Oh @ Pristine Core
// * boh@pristinecore.com
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// *******************************************************************************/
//package com.gaonsoft.mcs.sample.rest;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Param;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.gaonsoft.mcs.sample.dao.CustomerDAO;
//import com.gaonsoft.mcs.sample.domain.Customer;
//import com.gaonsoft.mcs.sample.mapper.CustomerMapper;
//
///**
// * RestCustomerController class
// * 
// * @author Brient Oh
// */
//@RestController
//public class RestCustomer2Controller {
//	
//	@Autowired
//	private CustomerMapper customerMapper;
//	
//	@Autowired
//	private CustomerDAO customerDao;
//	
////	@RequestMapping(value = "/customer2", method = RequestMethod.GET) 
////	public ResponseEntity<List<Customer>> listAllCustomers() {
////		final List<Customer> allCustomers = customerMapper.selectAllCustomers();
////		if (allCustomers.isEmpty()) {
////			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
////		}
////		
////		return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
////	}
//	
//	@RequestMapping(value = "/customer2", method = RequestMethod.GET) 
//	public ResponseEntity<List<Customer>> listAllCustomers(@Param("order") final boolean order) {
//		// true: DESC / false: ASC
//		final List<Customer> allCustomers;
//		if(order) {
//			allCustomers = customerDao.selectAllCostomerDesc();
//		} else {
//			allCustomers = customerMapper.selectAllCustomers();
//		}
//		if (allCustomers == null) {
//			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
//		}
//		
//		return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/customer2/{id}", method = RequestMethod.GET) 
//	public ResponseEntity<Customer> listCustomer(@PathVariable("id") final Long id) {
//		final Customer customer = customerMapper.selectCustomer(id);
//		if (customer == null) {
//			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
//		}
//		
//		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
//	}
//}