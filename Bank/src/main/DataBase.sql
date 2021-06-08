Drop database if exists Accounts;
create database accounts;
USE accounts;
Create table accounts(
    
numOfaccounts int(14) PRIMARY KEY AUTO_INCREMENT,
ID varchar(20),
userName varchar(45),
password varchar (30),
clientName varchar(45),
accountType varchar(30),
balance real ,
indebtedness real,
status Boolean,
allowableLimit_perDay real ,
creatingDate date,
creditCardDate date,
debitDate date

);



	-- private String clientName;
	-- private final String ID; // unique for every account (it's const because it can't be changable)
	-- private String userName; // unique for every account
	-- private String password;
	-- public static int numOfaccounts = 0;
	-- protected double balance;
	-- protected double indebtedness;
	-- protected boolean status;
	-- protected double allowableLimit_perDay;
	-- private LocalDate creatingDate;
	-- protected LocalDate creditCardDate;
	-- protected LocalDate debitDate;
	-- private String accountType = null;