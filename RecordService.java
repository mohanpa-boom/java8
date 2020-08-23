package service;

import java.util.ArrayList;
import dao.DAO;
import model.Record;

public class RecordService implements IRecordService
{
	DAO  dao = new DAO();
			
	public void readFiles() throws Exception
	{
		dao.readFiles();
		}
	public void compareRecords(ArrayList<Record> xlist,ArrayList<Record> ylist) throws Exception
	{
		dao.compareRecords(xlist, ylist);
		}
	public StringBuilder getExactMatch()
	{
		return dao.getExactMatch();
		}
	public StringBuilder getWeakMatch()
	{
		return dao.getweakMatch();
		}
	public StringBuilder getXBreak()
	{
		return dao.getXBreak();
		}
	public StringBuilder getYBreak()
	{
		return dao.getYBreak();
		}
	}
