package com.vti.frontend;

import com.vti.backend.Transaction;
import com.vti.ultis.ScannerUtils;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 26, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 26, 2020
 */
public class TransactionProgram {

	public static void main(String[] args) throws Exception {
		question1();
	}

	public static void question1() throws Exception {
		System.out.println("Input department id: ");
		int id = ScannerUtils.inputId();

		new Transaction().deleteDepartmentUsingTransaction(id);
		System.out.println("delete success!");
	}
}
