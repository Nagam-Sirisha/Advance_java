package org.jsp.controller;

import org.jsp.dao.LaptopDao;
import org.jsp.dto.Laptop;

public class LaptopController 
{
	public static void main(String[] args) 
	{
		LaptopDao dao = new LaptopDao();
		Laptop laptop = new Laptop();
		
		laptop.setId(104);
		laptop.setBrandName("dell");
		laptop.setRam(32);
		laptop.setRom(1080);
		laptop.setCost(175000);
		
		dao.saveLaptop(laptop);
	}
}
