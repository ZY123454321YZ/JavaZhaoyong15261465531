package com.huawei.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huawei.entity.User;

public abstract class SuperService
{
	public void doService(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {};
	
	public  abstract <T> List<T> getValues();

}
