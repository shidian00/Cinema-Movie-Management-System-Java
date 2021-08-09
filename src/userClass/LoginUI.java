package userClass;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import clientClass.ClientUI;

import adminClass.AdminUI;

public class LoginUI
{
	private LoginControl lc = new LoginControl();

	public void loginStart()
	{
		lc.readUser();
		Scanner s = new Scanner(System.in);
		int choice = 0;
		do
		{
			try
			{
				System.out.println("1 - Login ");
				System.out.println("2 - Register");
				System.out.println("3 - Exit");

				System.out.println("Enter choice: ");
				choice = s.nextInt();

				String skip = s.nextLine();

				switch (choice)
				{
				case 1:
					lc.loginAccount();
					break;
				case 2:
					lc.registerAccount();
					break;
				case 3:
					System.out.println("System exit");
					System.exit(3);
					break;
				default:
					System.out.println("Invalid Input");
					break;
				}
			} catch (InputMismatchException e)
			{
				System.out.println("Invalid Input");
				loginStart();
			}
		} while (choice != 3);
	}

}
