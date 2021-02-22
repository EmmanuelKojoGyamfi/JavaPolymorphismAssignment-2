public class Firm {
public static void main (String[] args)
{
Staff personnel = new Staff();
personnel.payday();
}
}

public class Staff
{
StaffMember[] staffList;

public Staff ()
{
staffList = new StaffMember[6];
staffList[0] = new Executive ("Kojo", "Nim Avenue",
"555-0469", "123-45-6789", 2423.07);
staffList[1] = new Employee ("Ama", "Tamale Main Town",
"555-0101", "987-65-4321", 1246.15);
staffList[2] = new Employee ("Daystar", "East Legon",
"555-0000", "010-20-3040", 1169.23);
staffList[3] = new Hourly ("Diana", "678 Fifth Ave.",
"555-0690", "958-47-3625", 10.55);
staffList[4] = new Volunteer ("Fausty", "Stc Main Road.",
"555-8374") ;
staffList[5] = new Volunteer ("Clifford", "321 Duds Lane",
"555-7282");
((Executive)staffList[0]).awardBonus (500.00);
((Hourly)staffList[3]).addHours (40);
}

public void payday ()
{
double amount;
for (int count=0; count < staffList.length; count++)
{
System.out.println (staffList[count]);
amount = staffList[count].pay(); 
if (amount == 0.0)
System.out.println ("Thanks!");
else
System.out.println ("Paid: " + amount);
System.out.println ("------------------------------------");
}
}
}

abstract public class StaffMember
{
protected String name;
protected String address;
protected String phone;

public StaffMember (String eName, String eAddress, String ePhone)
{
name = eName;
address = eAddress;
phone = ePhone;
}

public String toString()
{
String result = "Name: " + name + "\n";
result += "Address: " + address + "\n";
result += "Phone: " + phone;
return result;
}

public abstract double pay();
}

public class Volunteer extends StaffMember
{

public Volunteer (String eName, String eAddress, String ePhone)
{
super (eName, eAddress, ePhone);
}

public double pay()
{
return 0.0;
}
}

public class Employee extends StaffMember
{
protected String socialSecurityNumber;
protected double payRate;

public Employee (String eName, String eAddress, String ePhone,
String socSecNumber, double rate)
{
super (eName, eAddress, ePhone);
socialSecurityNumber = socSecNumber;
payRate = rate;
}

public String toString()
{
String result = super.toString ();
result += "\nSocial Security Number: " + socialSecurityNumber;
return result;
}

public double pay()
{
return payRate;
}
}

public class Executive extends Employee
{
private double bonus;


public Executive (String eName, String eAddress, String ePhone,
String socSecNumber, double rate)
{
super (eName, eAddress, ePhone, socSecNumber, rate);
bonus = 0; 
}

public void awardBonus (double execBonus)
{
bonus = execBonus;
}

public double pay()
{
double payment = super.pay() + bonus;
bonus = 0;
return payment;
}
}

public class Hourly extends Employee
{
private int hoursWorked;


public Hourly (String eName, String eAddress, String ePhone,
String socSecNumber, double rate)
{
super (eName, eAddress, ePhone, socSecNumber, rate);
hoursWorked = 0;
}


public void addHours (int moreHours)
{
hoursWorked += moreHours;
}

public double pay()
{
double payment = payRate * hoursWorked;
hoursWorked = 0;
return payment;
}


public String toString()
{
String result = super.toString();
result += "\nCurrent hours: " + hoursWorked;
return result;
}
}

