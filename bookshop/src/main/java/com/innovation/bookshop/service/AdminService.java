package com.innovation.bookshop.service;

import com.innovation.bookshop.model.Admin;


public interface AdminService {
	Admin login(String email,String password);
}
