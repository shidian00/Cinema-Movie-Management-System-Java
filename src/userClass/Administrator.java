package userClass;

public class Administrator extends User
{
	public Administrator(String email, String password, String telno, String status)
	{
		super(email, password, telno);
		super.setStatus(status);
	}
}
