package userClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import adminClass.AdminUI;
import clientClass.ClientUI;

public class LoginControl
{
	private ArrayList<User> users = new ArrayList<User>();

	private AdminUI adminUI = new AdminUI();
	private ClientUI clientUI = new ClientUI();

	public void loginAccount()
	{
		Scanner s = new Scanner(System.in);

		User u = null;

		System.out.println("Enter email: ");
		String name = s.nextLine();

		System.out.println("Enter password");
		String password = s.nextLine();

		u = verifyUser(name, password);

		if (u instanceof Administrator)
			adminUI.adminUI();
		else if (u instanceof Client)
			clientUI.clientUI(u.getEmail());
		else
			System.out.println("Please check you login detail again!!");

	}

	public void registerAccount()
	{
		String regexEmail = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		String email = "";
		String regexPassword = "^[A-Za-z0-9]{5,10}$";
		String password = "";
		Boolean check = false;
		Scanner s = new Scanner(System.in);

		do
		{
			System.out.println("Enter email: ");
			email = s.nextLine();
			check = email.matches(regexEmail);

			if (check == false)
				System.out.println("Please use a valid email");
			else
			{
				if (verifyUser(email) != null)
				{
					check = false;
					if (check == false)
						System.out.println("Entered email already registered");
				}
			}
		} while (check == false);

		do
		{
			System.out.println("Enter password (Atleast 5 char with no special) : ");
			password = s.nextLine();
			check = password.matches(regexPassword);

			if (check == false)
				System.out.println("Please fulfill the password requirement");
		} while (check == false);

		System.out.println("Enter Telephone Number: ");
		String telno = s.nextLine();

		try
		{
			File file = new File("User.txt");
			FileWriter fw;
			String outputText = "\n" + email + "," + password + "," + telno + "," + "no";

			fw = new FileWriter(file, true);
			fw.write(outputText);
			fw.close();
			System.out.println("Register Successfully");
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		readUser();
	}

	public void readUser()
	{
		users.clear();
		File file = new File("User.txt");
		Scanner s;
		try
		{
			s = new Scanner(file);

			while (s.hasNext())
			{
				String data = s.nextLine();
				String[] values = data.split(",");

				if (values[3].equals("yes"))
				{
					users.add(
							new Administrator(values[0], values[1], values[2], values[3]));
				} else if (values[3].equals("no"))
				{
					users.add(new Client(values[0], values[1], values[2], values[3]));
				}

			}
			s.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

	}

	public User verifyUser(String email, String password)
	{

		for (int x = 0; x < users.size(); x++)
		{
			if (users.get(x).getEmail().equals(email))
			{
				if (users.get(x).getPassword().equals(password))
				{ return users.get(x); }
			}
		}
		return null;
	}

	public User verifyUser(String email)
	{

		for (int x = 0; x < users.size(); x++)
		{
			if (users.get(x).getEmail().equals(email))
			{ return users.get(x); }
		}
		return null;
	}
}
