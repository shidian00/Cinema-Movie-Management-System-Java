package adminClass;

import java.util.Scanner;

public class AdminUI
{
	public void adminUI()
	{
		AdminControl c = new AdminControl();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		c.readMovie();

		do
		{
			c.listmoviebanner();

			choice = sc.nextInt();
			if (choice == 1)
			{
				c.listmovie();
			} else if (choice == 2)
				c.addmovie();
			else if (choice == 3)
				c.updatemovie();
			else if (choice == 4)
				;
			else
				System.out.println("There is no such option available!\n");

		} while (choice != 4);

	}
}
