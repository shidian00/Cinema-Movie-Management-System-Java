package clientClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import userClass.Movie;

public class ClientControl
{
	private ArrayList<Movie> movieList = new ArrayList<>();
	private ArrayList<Booking> bookingDetailList = new ArrayList<>();
	private ArrayList<Booking> bookingList = new ArrayList<>();

	protected String clientEmail;

	public ClientControl(String clientEmail)
	{
		this.clientEmail = clientEmail;
		readMovieFile(); // raedMovie data
		readBookingTxt(); // get all booking data
		outputBookingTxtIntoBookingDetailTxt(); // write all booking data into BookingDetail
		readBookingDetailTxt(); // read data in BookingDetail into BookindDetailList
	}

	public void displayMenu()
	{
		System.out.println("Welcome to Client Interface:");
		System.out.println("0: Display Movie list");
		System.out.println("1. Create Movie Booking");
		System.out.println("2. Delete Booking");
		System.out.println("3. View Booking");
		System.out.println("4. Edit Booking");
		System.out.println("5. Search Booking");
		System.out.println("6. Exit");
		System.out.print("Enter your choice (1-6): ");
	}

	public void displaySearchSubMenu()
	{
		Scanner input = new Scanner(System.in);
		int choice = 0;

		try
		{
			System.out.println("Do you want to search by:");
			System.out.println("1. Movie Name");
			System.out.println("2. Booking Date");
			System.out.println("3. Back to main");
			System.out.print("Enter your choice (1-3): ");

			choice = input.nextInt();
			input.nextLine();

			while (choice < 1 || choice > 3)
			{
				System.out.println("Invalid choice.");
				System.out.print("Enter your choice (1-3): ");
				choice = input.nextInt();
				input.nextLine();
			}
		} catch (InputMismatchException e)
		{
			System.out.println("Please input valid choice.");
		}
		switch (choice)
		{
		case 1:
			searchByMovieName();
			break;
		case 2:
			searchByBookingDate();
			break;
		case 3:

		}

	}

	public void displayMovie()
	{

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-15s %-30s %-20s %-20s %-20s %-20s %-20s %n", "Movie ID",
				"Movie Name", "Movie Type",
				"Movie Date", "Time slot", "Seat available", "Theater");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < movieList.size(); i++)
		{
			System.out.printf("%-15s %-30s %-20s %-20s %-20s %-20s %-20s %n",
					movieList.get(i).getMovieID(),
					movieList.get(i).getMovieName(), movieList.get(i).getMovieType(),
					movieList.get(i).getMovieDate(), movieList.get(i).getTimeSlot(),
					movieList.get(i).getNumberOfSeatAvailable(), movieList.get(i).getTheater());
		}

	}

	public void displayBooking()
	{
		System.out.printf("%-20s %-20s %-30s %-20s %-25s %-30s %-20s %n", "Booking ID", "Movie ID",
				"Booking date",
				"Movie name",
				"NumberofTickets", "Movie time slot", "Movie Theatre");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int x = 0; x < bookingDetailList.size(); x++)
		{
			System.out.printf("%-20s %-20s %-30s %-20s %-25s %-30s %-20s %n",
					bookingDetailList.get(x).getbookingID(),
					bookingDetailList.get(x).getMovieId(),
					bookingDetailList.get(x).getBookingMovieDate(),
					bookingDetailList.get(x).getBookingMovieName(),
					bookingDetailList.get(x).getBookingNumberTickets(),
					bookingDetailList.get(x).getBookingTimeSlot(),
					bookingDetailList.get(x).getBookingTheatre());
		}
	}

	public void readBookingTxt()
	{
		try
		{
			bookingList.removeAll(bookingList);
			File bookingFile = new File("Booking.txt");
			Scanner readBooking = new Scanner(bookingFile);
			if (bookingFile.length() == 0)
			{
				System.out.println("Booking record is empty ...");
			} else
			{
				while (readBooking.hasNext())
				{
					String[] tokens = readBooking.nextLine().split(",");

					bookingList.add(new Booking(tokens[0], tokens[1], tokens[2],
							Integer.parseInt(tokens[3]), tokens[4],
							tokens[5], tokens[6], tokens[7]));
				}
			}
			readBooking.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void readBookingDetailTxt()
	{
		try
		{
			bookingDetailList.removeAll(bookingDetailList);
			File bookingFile = new File("BookingDetail.txt");
			Scanner readBooking = new Scanner(bookingFile);

			while (readBooking.hasNext())
			{
				String[] tokens = readBooking.nextLine().split(",");

				bookingDetailList.add(new Booking(tokens[0], tokens[1], tokens[2],
						Integer.parseInt(tokens[3]), tokens[4],
						tokens[5], tokens[6], tokens[7]));

			}

			readBooking.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void updateBookingTxt()
	{
		resetID();
		try
		{
			FileWriter writeBooking = new FileWriter("Booking.txt");
			for (int j = 0; j < bookingList.size(); j++)
			{
				writeBooking.write(bookingList.get(j).getbookingID() + ","
						+ bookingList.get(j).getBookingMovieDate()
						+ "," + bookingList.get(j).getBookingMovieName() + ","
						+ bookingList.get(j).getBookingNumberTickets() + ","
						+ bookingList.get(j).getBookingTimeSlot()
						+ "," + bookingList.get(j).getBookingTheatre() + ","
						+ bookingList.get(j).getMovieId() + ","
						+ bookingList.get(j).getEmail() + "\n");
			}
			writeBooking.close();
			readBookingTxt();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void updateBookingDetailTxt()
	{
		resetID();
		try
		{
			FileWriter writeBooking = new FileWriter("BookingDetail.txt");
			for (int j = 0; j < bookingDetailList.size(); j++)
			{
				writeBooking.write(bookingDetailList.get(j).getbookingID() + ","
						+ bookingDetailList.get(j).getBookingMovieDate()
						+ "," + bookingDetailList.get(j).getBookingMovieName() + ","
						+ bookingDetailList.get(j).getBookingNumberTickets() + ","
						+ bookingDetailList.get(j).getBookingTimeSlot()
						+ "," + bookingDetailList.get(j).getBookingTheatre() + ","
						+ bookingDetailList.get(j).getMovieId() + ","
						+ bookingDetailList.get(j).getEmail() + "\n");
			}
			writeBooking.close();

			readBookingDetailTxt();
			filterCLientEmail();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void filterCLientEmail()
	{

		int i = bookingList.size() - 1;

		while (i > -1)
		{
			for (int j = 0; j <= i; j++)
			{
				if (bookingList.get(i).getEmail().equals(clientEmail)) // TODO Might got problem?
				{
					bookingList.remove(i);
					break;
				}
			}
			i--;
		}

		for (int x = 0; x < bookingDetailList.size(); x++)
		{
			bookingList.add(bookingDetailList.get(x)); // get filtered data into bookingList
		}
		updateBookingTxt();
	}

	public void outputBookingTxtIntoBookingDetailTxt()
	{
		resetID();
		try
		{
			FileWriter writeBooking = new FileWriter("BookingDetail.txt");
			for (int j = 0; j < bookingList.size(); j++)
			{
				if (bookingList.get(j).getEmail().equals(clientEmail))
					writeBooking.write(bookingList.get(j).getbookingID() + ","
							+ bookingList.get(j).getBookingMovieDate()
							+ "," + bookingList.get(j).getBookingMovieName() + ","
							+ bookingList.get(j).getBookingNumberTickets() + ","
							+ bookingList.get(j).getBookingTimeSlot()
							+ "," + bookingList.get(j).getBookingTheatre() + ","
							+ bookingList.get(j).getMovieId() + ","
							+ bookingList.get(j).getEmail() + "\n");
			}
			writeBooking.close();

			readBookingDetailTxt();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void readMovieFile()
	{
		movieList.removeAll(movieList);
		try
		{
			File movieFile = new File("Movie.txt");
			Scanner readMovie = new Scanner(movieFile);

			if (movieFile.length() == 0)
			{
				System.out.println("Movie record is empty");
			} else
				while (readMovie.hasNext())
				{
					String[] tokens = readMovie.nextLine().split(",");
					movieList.add(new Movie(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4],
							Integer.parseInt(tokens[5]), tokens[6]));
				}
			readMovie.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void updateMovieFile()
	{
		try
		{
			FileWriter writeMovie = new FileWriter("Movie.txt");
			for (int j = 0; j < movieList.size(); j++)
			{
				writeMovie.write(movieList.get(j).Saver());
			}
			writeMovie.close();
			readMovieFile();

		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void createBooking()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			File bookingFile = new File("Booking.txt");
			if (!bookingFile.exists())
			{
				bookingFile.createNewFile();
				System.out.println("Booking file created");
			}

			Scanner readBooking = new Scanner(bookingFile);
			String bookingID = "B";
			int count = 0;
			while (readBooking.hasNextLine())
			{
				count++;
				readBooking.nextLine();
			}
			bookingID = bookingID + count;
			readBooking.close();

			displayMovie();

			String movieID = "";
			int numberOfTicket = 0;
			Boolean checkTicket = false;
			do
			{
				System.out.print("Enter a Movie ID to book a ticket: ");
				movieID = sc.nextLine();

				System.out.println("Enter number of ticket: ");
				numberOfTicket = sc.nextInt();

				checkTicket = checkNumberofTicket(movieID, numberOfTicket, false);

				if (checkTicket == false)
				{
					String skip = sc.nextLine();
					System.out.println("Invalid number of ticket inputed !! / Invalid Movie ID !!");
				}
			} while (checkTicket == false);

			String skip = sc.nextLine();

			for (int j = 0; j < movieList.size(); j++)
			{
				if (movieID.equals(movieList.get(j).getMovieID()))
				{
					System.out.println("Booking Movie Name: " + movieList.get(j).getMovieName());
					System.out.println("Date of Movie : " + movieList.get(j).getMovieDate());
					System.out
							.println("Booking Movie Time Slot: " + movieList.get(j).getTimeSlot());
					System.out.println("Booking Movie Theatre: " + movieList.get(j).getTheater());
					bookingDetailList.add(
							new Booking(bookingID, movieList.get(j).getMovieDate(),
									movieList.get(j).getMovieName(),
									numberOfTicket, movieList.get(j).getTimeSlot(),
									movieList.get(j).getTheater(), movieID,
									clientEmail));
				}
			}

			updateBookingDetailTxt();
			System.out.println("Book Ticket Successfully, your Booking ID is " + bookingID);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteBooking()
	{
		Scanner sc = new Scanner(System.in);
		displayBooking();
		System.out.println("Enter the booking ID to remove: ");
		String bookingID = sc.nextLine();

		Boolean deleted = false;
		for (int x = 0; x < bookingDetailList.size(); x++)
		{
			if (bookingID.compareTo(bookingDetailList.get(x).getbookingID()) == 0)
			{
				if (checkNumberofTicket(bookingDetailList.get(x).getMovieId(),
						bookingDetailList.get(x).getBookingNumberTickets(), true) == true)
				{
					bookingDetailList.remove(x);
					deleted = true;
					break;
				}
			}

		}

		if (deleted == true)
			System.out.println("Delete BookingID: \"" + bookingID + "\" successfully.");
		else
			System.out.println(
					"Fail to delete BookingID: \"" + bookingID + "\" Please check your input");

		updateBookingDetailTxt();
	}

	public void editBooking()
	{
		Scanner input = new Scanner(System.in);

		displayBooking(); // show Booking list
		System.out.print("Enter ID of booking you wish to update: ");
		String theBookingID = input.next();
		System.out.println();

		Booking BookingFound = editUtilitySearchBookingId(theBookingID); // get booking record
																			// according to
		// user's booking id input

		if (editUtilitySearchBookingId(theBookingID) == null) // if cannot found the booking id
			System.out.println("No booking with that ID found");
		else
		{

			displayMovie(); // show Movie list
			System.out.print("Enter ID of movie you wish to add: ");
			String theMovieID = input.next();
			Movie MovieFound = editUtilitySearchMovieId(theMovieID); // get movie record according
																		// to
			// user's movie id input

			if (editUtilitySearchMovieId(theMovieID) == null) // if cannot found the movie id
				System.out.println("No movie with that name found");
			else
			{
				System.out.println("Edit Successfully");
				System.out.println();

				// edit the movie time and name
				BookingFound.setBookingMovieName(MovieFound.getMovieName());
				BookingFound.setBookingID(MovieFound.getMovieName());
				BookingFound.setBookingTimeSlot(MovieFound.getTimeSlot());
				BookingFound.setBookingMovieDate(MovieFound.getMovieDate());
				BookingFound.setBookingTheatre(MovieFound.getTheater());

				// print the changes into booking list in Booking.txt
				updateBookingDetailTxt();
			}
		}
	}

	public Booking editUtilitySearchBookingId(String theBookingID)
	{
		boolean found = false;
		int i = 0;
		Booking theBook = null;
		while (i < bookingDetailList.size() && !found)
		{
			theBook = bookingDetailList.get(i);
			if (theBook.getbookingID().equals(theBookingID))
			{
				found = true;
			} else
			{
				i++;
			}
		}
		if (!found)
		{
			theBook = null;
		}
		return theBook;
	}

	public Movie editUtilitySearchMovieId(String theMovieID)
	{
		boolean found = false;
		int i = 0;
		Movie theMovie = null;
		while (i < movieList.size() && !found)
		{
			theMovie = movieList.get(i);
			if (theMovie.getMovieID().equals(theMovieID))
			{
				found = true;
			} else
			{
				i++;
			}
		}
		if (!found)
		{
			theMovie = null;
		}
		return theMovie;
	}

	public void searchByMovieName()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name of movie: ");
		String theName = input.nextLine();
		boolean found = false;
		int i = 0;
		Booking theBook = null;
		System.out.printf("%-20s %-20s %-30s %-20s %-20s %n", "Booking ID", "Booking date",
				"Movie name", "NumberofTickets", "Movie time slot");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		while (i < bookingDetailList.size() && !found)
		{
			theBook = bookingDetailList.get(i);
			if (theBook.getBookingMovieName().toUpperCase().equals(theName.toUpperCase()))
			{

				System.out.printf("%-20s %-20s %-30s %-20s %-20s %n", theBook.getbookingID(),
						theBook.getBookingMovieDate(),
						theBook.getBookingMovieName(), theBook.getBookingNumberTickets(),
						theBook.getBookingTimeSlot());
			}
			i++;
		}

		System.out.println();
	}

	public void searchByBookingDate()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter date of booking: ");
		String theDate = input.next();
		boolean found = false;
		int i = 0;
		Booking theBook = null;
		System.out.printf("%-20s %-20s %-30s %-20s %-20s %n", "Booking ID", "Booking date",
				"Movie name", "NumberofTickets", "Movie time slot");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		while (i < bookingDetailList.size() && !found)
		{
			theBook = bookingDetailList.get(i);
			if (theBook.getBookingMovieDate().toUpperCase().equals(theDate))
			{

				System.out.printf("%-20s %-20s %-30s %-20s %-20s %n", theBook.getbookingID(),
						theBook.getBookingMovieDate(),
						theBook.getBookingMovieName(), theBook.getBookingNumberTickets(),
						theBook.getBookingTimeSlot());
			}
			i++;
		}

	}

	public Boolean checkNumberofTicket(String movideId, int numberOfTicketOrdered, Boolean addSeat)
	{
		if (addSeat == true)
		{
			for (int x = 0; x < movieList.size(); x++)
			{
				if (movieList.get(x).getMovieID().equals(movideId))
				{
					movieList.get(x).setNumberOfSeatAvailable(
							movieList.get(x).getNumberOfSeatAvailable()
									+ numberOfTicketOrdered);
					return true;
				}

			}

		} else
			for (int x = 0; x < movieList.size(); x++)
			{
				if (movieList.get(x).getMovieID().equals(movideId))
				{
					if (movieList.get(x).getNumberOfSeatAvailable() < numberOfTicketOrdered)
						return false;
					else if (movieList.get(x).getNumberOfSeatAvailable() > numberOfTicketOrdered)
					{
						movieList.get(x).setNumberOfSeatAvailable(
								movieList.get(x).getNumberOfSeatAvailable()
										- numberOfTicketOrdered);
						updateMovieFile();
						return true;
					}
				}
			}
		return false;
	}

	public void resetID()
	{
		for (int x = 0; x < bookingDetailList.size(); x++)
		{
			bookingDetailList.get(x).setBookingID("B" + x);
		}
	}

}
