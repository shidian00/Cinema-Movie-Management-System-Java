package userClass;

public class User
{
	private String email, password, telno, status;

	public User(String email, String password, String telno)
	{

		this.email = email;
		this.password = password;
		this.telno = telno;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getTelno()
	{
		return telno;
	}

	public void setTelno(String telno)
	{
		this.telno = telno;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

}
