package userClass;

public class Client extends User
{

	public Client(String email, String password, String telno, String status)
	{
		super(email, password, telno);
		super.setStatus(status);
	}

	public String Saver()
	{
		return getEmail() + "," + getPassword() + "," + getTelno() + "," + "no";
	}
}
