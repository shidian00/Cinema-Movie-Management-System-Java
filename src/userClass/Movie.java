package userClass;

public class Movie
{

	private String movieID, movieName, movieType, movieDate, timeSlot, theater;
	private int numberOfSeatAvailable;

	public String getMovieID()
	{
		return movieID;
	}

	public void setMovieID(String movieID)
	{
		this.movieID = movieID;
	}

	public String getMovieName()
	{
		return movieName;
	}

	public void setMovieName(String movieName)
	{
		this.movieName = movieName;
	}

	public String getMovieType()
	{
		return movieType;
	}

	public void setMovieType(String movieType)
	{
		this.movieType = movieType;
	}

	public String getMovieDate()
	{
		return movieDate;
	}

	public void setMovieDate(String movieDate)
	{
		this.movieDate = movieDate;
	}

	public String getTimeSlot()
	{
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot)
	{
		this.timeSlot = timeSlot;
	}

	public int getNumberOfSeatAvailable()
	{
		return numberOfSeatAvailable;
	}

	public void setNumberOfSeatAvailable(int numberOfSeatAvailable)
	{
		this.numberOfSeatAvailable = numberOfSeatAvailable;
	}

	public String getTheater()
	{
		return theater;
	}

	public void setTheatre(String theater)
	{
		this.theater = theater;
	}

	public Movie(String movieID, String movieName, String movieType, String movieDate,
			String timeSlot, int numberOfSeatAvailable, String theater)
	{
		this.movieID = movieID;
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieDate = movieDate;
		this.timeSlot = timeSlot;
		this.numberOfSeatAvailable = numberOfSeatAvailable;
		this.theater = theater;
	}

	public Movie()
	{
		// TODO Auto-generated constructor stub
	}

	public String Saver()
	{
		return getMovieID() + "," + getMovieName() + "," + getMovieType() + "," + getMovieDate()
				+ "," + getTimeSlot() + "," + getNumberOfSeatAvailable() + "," + getTheater()
				+ "\n";
	}

}
