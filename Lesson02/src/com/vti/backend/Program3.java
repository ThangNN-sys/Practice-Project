package com.vti.backend;

import java.rmi.registry.LocateRegistry;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Program3 {
	
	public static void main(String arg[]) {
		Locale locale = new Locale("vi", "VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		
		String toDay = dateFormat.format(new Date());
		System.out.println("VN: " + toDay);
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String toDay2 = simpleDateFormat.format(new Date());
		System.out.println(toDay2);
		
		System.out.printf("%,d %n", 100000000);
		System.out.printf("%.4f", 5.567098);
	}

}
