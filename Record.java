package model;

import java.time.LocalDate;

public class Record
{
	// Here, private data base added, using get & set method //
	private String transactionid;
	private String accountId;
	private LocalDate postingDate;
	private double amount;
	public String getTransactionid()
	{
		return transactionid;
		}
	public void setTransactionid(String transactionid)
	{
		this.transactionid = transactionid;
		}
	public String getAccountId()
	{
		return accountId;
		}
	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
		}
	public LocalDate getPostingDate()
	{
		return postingDate;
		}
	public void setPostingDate(LocalDate postingDate)
	{
		this.postingDate = postingDate;
		}
	public double getAmount()
	{
		return amount;
		}
	public void setAmount(double amount)
	{
		this.amount = amount;
		}
	public Record()
	{
		super();
		}
	public Record(String transactionid, String accountId, LocalDate postingDate, double amount)
	{
		super();
		this.transactionid = transactionid;
		this.accountId = accountId;
		this.postingDate = postingDate;
		this.amount = amount;
		}
	@Override
	public String toString()
	{
		return "Record [transactionid=" + transactionid + ", accountId=" + accountId + ", postingDate=" + postingDate
				+ ", amount=" + amount + "]";
		}
	}
