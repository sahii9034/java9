//A date of birth program sort of interesting logic
import java.util.Scanner;

class InvalidDateOfBirthException extends Exception {
 InvalidDateOfBirthException(String err) {
 super(err);
 }
}
public class DateOfBirthValidator {
public static boolean Day(int day, int month, int year) {
if (month == 2) 
{ 
if (isLeapYear(year)) 
{
  return day <= 29;
 }
 else {
   return day <= 28;
  }
  } else {
 return day >= 1 && day <= 31;
  }
 }
   public static boolean isLeapYear(int year)
 {
 return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
public static boolean Month(int month) {
 return 1 <= month && month <= 12;
    }

public static boolean Year(int year) {
return 2002 <= year && year <= 2015;
}
public static void theDateOfBirth(String dateOfBirth) throws InvalidDateOfBirthException {
try {
String[] str = dateOfBirth.split("-");
int year = Integer.parseInt(str[0]);
int month = Integer.parseInt(str[1]);
int day = Integer.parseInt(str[2]);
if (!(Day(day, month, year) && Month(month) && Year(year))) {
throw new InvalidDateOfBirthException("Invalid date of birth");
}
System.out.println("Date of birth is valid!");
} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
throw new InvalidDateOfBirthException("Invalid date format");
}
}
public static void main(String[] args)
{
Scanner s = new Scanner(System.in);
try
 {
System.out.print("Enter date of birth (YYYY-MM-DD): ");
String dob = s.next();
theDateOfBirth(dob);
}
 catch (InvalidDateOfBirthException e) {
 System.out.println("Error: " +e);
}
}
}
