package adminClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import userClass.Movie;

public class AdminControl
{

	private ArrayList<Movie> movies = new ArrayList<Movie>();

	private Movie[] movie;

	public Movie[] getMovie()
	{
		return movie;
	}

	public void setMovie(Movie[] movie)
	{
		this.movie = movie;
	}

	public void listmoviebanner()
	{
		System.out.println("Welcome to cinema management system.");
		System.out.println("1. List movie");
		System.out.println("2. Add movie");
		System.out.println("3. Update movie");
		System.out.println("4. Exit");
		System.out.println("Please enter your choice:");
	}

	public void listmovie()
	{
		System.out.printf("%-7s %-15s %-30s %-20s %-20s %-20s %-20s %-20s %n", "Index",
				"Movie ID",
				"Movie Name", "Movie Type", "Movie Date",
				"Time slot", "Seat available", "Theater");

		for (int x = 0; x < movies.size(); x++)
		{
			System.out.printf("%-7s %-15s %-30s %-20s %-20s %-20s %-20s %-20s %n", x,
					movies.get(x).getMovieID(),
					movies.get(x).getMovieName(),
					movies.get(x).getMovieType(),
					movies.get(x).getMovieDate(),
					movies.get(x).getTimeSlot(),
					movies.get(x).getNumberOfSeatAvailable(),
					movies.get(x).getTheater());
		}
	}

	public void addmovie()
	{

		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the movie ID: ");
		String input1 = sc.nextLine();

		System.out.print("Please enter the movie name: ");
		String input2 = sc.nextLine();

		System.out.print("Please enter the movie type: ");
		String input3 = sc.nextLine();

		System.out.print("Please enter the movie date: ");
		String input4 = sc.nextLine();

		System.out.print("Please enter the movie time slot: ");
		String input5 = sc.nextLine();

		Integer input6 = 0;
		boolean valid = false;
		while (valid == false)
		{

			try
			{
				System.out.print("Please enter the number of seat available for the movie: ");
				input6 = Integer.parseInt(sc.nextLine());
				valid = true;
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				System.out.println("Invalid input, please try again");
			}

		}
		System.out.print("Please enter the movie theater: ");
		String input7 = sc.nextLine();

		try
		{
			String outputtext = input1 + "," + input2 + "," + input3 + "," + input4 + "," + input5
					+ ","
					+ input6 + "," + input7 + "\n";
			Movie movieobject = new Movie(input1, input2, input3, input4, input5, input6, input7);
			File file = new File("movie.txt");
			FileWriter fw = new FileWriter(file, true);
			fw.write(outputtext);
			fw.close();
		} catch (IOException e)
		{

		}
		System.out.print("The movie is successfully added.\n");
		readMovie();
	}

	public void updatemovie()
	{
		listmovie();
		if (movies.size() == 0)
		{
			System.out.println("No movie added");
		} else
		{
			try
			{
				Scanner sc = new Scanner(System.in);
				System.out.print("Please choose an index to update:");
				int x = sc.nextInt();
				String skip = sc.nextLine();

				System.out.println(movies.get(x).getMovieID() + " is found !!!");

				System.out.println("Please enter the movie type:");
				String movietype = sc.nextLine();
				movies.get(x).setMovieType(movietype);

				System.out.println("Please enter the movie date:");
				String moviedate = sc.nextLine();

				movies.get(x).setMovieDate(moviedate);

				System.out.println("Please enter the time slot:");
				String movietime = sc.nextLine();
				movies.get(x).setTimeSlot(movietime);

				System.out.println("Please enter the seat available:");
				int seat = sc.nextInt();
				movies.get(x).setNumberOfSeatAvailable(seat);

				skip = sc.nextLine();

				System.out.println("Please enter the theater:");
				String theater = sc.nextLine();
				movies.get(x).setTheatre(theater);

				PrintWriter pw = new PrintWriter("Movie.txt");
				for (int i = 0; i < movies.size(); i++)
				{
					pw.write(movies.get(i).Saver());
				}

				System.out.println("Update Succefully");
				pw.close();
				movies.removeAll(movies);
				readMovie();
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}

	}

	public void readMovie()
	{
		movies.clear();
		try
		{
			File file = new File("Movie.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNext())
			{
				String[] tokens = sc.nextLine().split(",");
				movies.add(new Movie(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4],
						Integer.parseInt(tokens[5]), tokens[6]));

			}
			sc.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

	}
}
