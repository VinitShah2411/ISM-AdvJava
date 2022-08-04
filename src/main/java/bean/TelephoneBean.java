package bean;

public class TelephoneBean {

	static String firstname;
	static String lastname;
	static	String number;
	static int Choice;
	public static String getFirstname() {
		return firstname;
	}
	public static void setFirstname(String firstname) {
		TelephoneBean.firstname = firstname;
	}
	public static String getLastname() {
		return lastname;
	}
	public static void setLastname(String lastname) {
		TelephoneBean.lastname = lastname;
	}
	public static String getNumber() {
		return number;
	}
	public static void setNumber(String number) {
		TelephoneBean.number = number;
	}
	public static int getChoice() {
		return Choice;
	}
	public static void setChoice(int choice) {
		Choice = choice;
	}
	

}
