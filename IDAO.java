package dao;

import java.util.ArrayList;
import java.util.List;
import model.Record;
public interface IDAO
{
	// Here, use the interface, compared tom dao layer //
	
	public void compareRecords(ArrayList<Record> xlist, ArrayList<Record> ylist) throws Exception;
	public List<Record> getList();
	public StringBuilder getExactMatch();
	public StringBuilder getweakMatch();
	public StringBuilder getXBreak();
	}
