package service;

import java.util.ArrayList;
import model.Record;

public interface IRecordService
{

	public void compareRecords(ArrayList<Record> xlist, ArrayList<Record> ylist) throws Exception;
	public StringBuilder getExactMatch();
	public StringBuilder getWeakMatch();
	public StringBuilder getXBreak();
	public StringBuilder getYBreak();
	}
