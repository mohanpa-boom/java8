package com.cg.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Record;
import service.RecordService;

public class UserMain
{
	public static void main(String[] args) throws Exception
	{
		RecordService service = new RecordService();
		String str[];
		Record record;
		File xfile = new File("C:\\Users\\admin\\Desktop\\x_s.txt");
		BufferedReader xbr = new BufferedReader(new FileReader(xfile));
		ArrayList<Record> xlist = new ArrayList<Record>();
		String s;
		while((s=xbr.readLine())!= null) {
			str = s.split("; ");
			record = new Record();
			record.setTransactionid(str[0]);
			record.setAccountId(str[1]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDate date = LocalDate.parse(str[2], formatter);
			record.setPostingDate(date);
			record.setAmount(Double.parseDouble(str[3]));
			xlist.add(record);
		}
		File yfile = new File("C:\\Users\\admin\\Desktop\\y_s.txt");		        
		BufferedReader ybr = new BufferedReader(new FileReader(yfile));
		ArrayList<Record> ylist = new ArrayList<Record>();
		while((s=ybr.readLine())!= null) {
			str = s.split("; ");
			record = new Record();
			record.setTransactionid(str[0]);
			record.setAccountId(str[1]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDate date = LocalDate.parse(str[2], formatter);
			record.setPostingDate(date);
			record.setAmount(Double.parseDouble(str[3]));
			ylist.add(record);
		}
		xbr.close(); ybr.close();
		service.compareRecords(xlist,ylist);
		
		System.out.println("Report \n# XY exact Matches");
		System.out.println(service.getExactMatch());
		
		System.out.println("# XY weak Matches");
		System.out.println(service.getWeakMatch());
		
		System.out.println("# X breaks");
		System.out.println(service.getXBreak());
		
		System.out.println("# Y breaks");
		System.out.println(service.getYBreak());
	}

}
