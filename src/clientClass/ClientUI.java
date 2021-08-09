package clientClass;

import java.util.Scanner;
import userClass.LoginUI;

public class ClientUI
{
	public void clientUI(String clientEmail)
	{
		ClientControl cc = new ClientControl(clientEmail);
		LoginUI lu = new LoginUI();
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		do
		{
			cc.displayMenu();
			choice = sc.nextInt();

			switch (choice)
			{
			case 0:
				cc.displayMovie();
				break;
			case 1:
				cc.createBooking();
				break;
			case 2:
				cc.deleteBooking();
				break;
			case 3:
				cc.displayBooking();
				break;
			case 4:
				cc.editBooking();
				break;
			case 5:
				cc.displaySearchSubMenu();
				clientUI(clientEmail);
				break;
			case 6:
				System.out.println("Have a nice Day");
				lu.loginStart();
				break;
			default:
				System.out.println("Invalid Selection");
			}
		} while (choice != 5);
	}

}
