package dao;


import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Record;

public class DAO implements IDAO
{
	//we can create  x & y list and then we  can add the string builder//
	List<Record> xlist;
	List<Record> ylist; 
	StringBuilder exactMatch = new StringBuilder();
	StringBuilder weakMatch = new StringBuilder();
	StringBuilder xbreak = new StringBuilder();
	StringBuilder ybreak = new StringBuilder();
	public void readFiles() throws Exception
	{
		
	}
// we can compared the object  //
	public void compareRecords(ArrayList<Record> xlist, ArrayList<Record> ylist) throws Exception
	{
		Record xset[] = new Record[xlist.size()];
		Record yset[] = new Record[ylist.size()];
		int index =0;
		int indexy=0;
		for(Record x : xlist)
		{
			xset[index] = x;
			index++;
			}
		for(Record y : ylist)
		{
			yset[indexy] = y;
			indexy++;
			}
		for(int i=0; i<xset.length; i++)
		{
			// here, we can use if else condition//
			if((xset[i].getAccountId().equals(yset[i].getAccountId())) &&
					(xset[i].getPostingDate().equals(yset[i].getPostingDate())) &&
					(xset[i].getAmount()==yset[i].getAmount()))
			{
				exactMatch.append(xset[i].getTransactionid()+yset[i].getTransactionid());
				}
			else if((xset[i].getAccountId().equals(yset[i].getAccountId())) &&
					(numberOfdays(xset[i].getPostingDate(), yset[i].getPostingDate())<=1) &&
					(diffInAmount(xset[i].getAmount(), yset[i].getAmount())<=0.01))
			{
				weakMatch.append(xset[i].getTransactionid()+yset[i].getTransactionid()+", ");
				}
			else
			{
				xbreak.append(xset[i].getTransactionid()+", ");
				ybreak.append(yset[i].getTransactionid()+", ");
				}
			}
		}
	private int numberOfdays(LocalDate d1, LocalDate d2) throws ParseException
	{
		Predicate<LocalDate> isHoliday = date -> date.getDayOfWeek()==DayOfWeek.SATURDAY ||date.getDayOfWeek()==DayOfWeek.SUNDAY;
		long daysBetween = ChronoUnit.DAYS.between(d1, d2);
		long workingDays = Stream.iterate(d1, date -> date.plusDays(1)).limit(daysBetween)
				.filter(isHoliday.negate()).count();
		return (int) workingDays;
		}
	private double diffInAmount(double amount1, double amount2)
	{
		float diffinAmount = 0.0f;
		if((float)amount1 < (float)amount2)
			diffinAmount = (float) (amount2-amount1);
		else 
			diffinAmount = (float) (amount1 - amount2);
		return diffinAmount;
		}
	public List<Record> getList()
	{
		return xlist;
		}
	public StringBuilder getExactMatch()
	{
		return exactMatch;
		}
	public StringBuilder getweakMatch()
	{
		return weakMatch;
		}
	public StringBuilder getXBreak()
	{
		return xbreak;
		}
	public StringBuilder getYBreak()
	{
		return ybreak;
		}
	}
