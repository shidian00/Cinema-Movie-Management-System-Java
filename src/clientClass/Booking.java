package clientClass;

public class Booking
{

	private String bookingMovieName;
	private String bookingID;
	private String bookingTimeSlot;
	private String bookingMovieDate;
	private String bookingTheatre;
	private String email;
	private String movieId;

	int bookingNumberTickets;

	public Booking(String bookingID, String bookingMovieDate, String bookingMovieName,
			int bookingNumberTickets, String bookingTimeSlot, String bookingTheatre, String movieId,
			String email)
	{
		this.bookingID = bookingID;
		this.bookingMovieDate = bookingMovieDate;
		this.bookingMovieName = bookingMovieName;
		this.bookingTimeSlot = bookingTimeSlot;
		this.bookingNumberTickets = bookingNumberTickets;
		this.bookingTheatre = bookingTheatre;
		this.movieId = movieId;
		this.email = email;

	}

	public String getMovieId()
	{
		return movieId;
	}

	public String getBookingMovieDate()
	{
		return bookingMovieDate;
	}

	public void setBookingMovieDate(String bookingMovieDate)
	{
		this.bookingMovieDate = bookingMovieDate;
	}

	public String getBookingMovieName()
	{
		return bookingMovieName;
	}

	public void setBookingMovieName(String bookingMovieName)
	{
		this.bookingMovieName = bookingMovieName;
	}

	public String getbookingID()
	{
		return bookingID;
	}

	public void setBookingID(String bookingID)
	{
		this.bookingID = bookingID;
	}

	public int getBookingNumberTickets()
	{
		return bookingNumberTickets;
	}

	public void setBookingNumberTickets(int bookingNumberTickets)
	{
		this.bookingNumberTickets = bookingNumberTickets;
	}

	public String getBookingTimeSlot()
	{
		return bookingTimeSlot;
	}

	public void setBookingTimeSlot(String bookingTimeSlot)
	{
		this.bookingTimeSlot = bookingTimeSlot;
	}

	public String getBookingTheatre()
	{
		return bookingTheatre;
	}

	public void setBookingTheatre(String bookingTheatre)
	{
		this.bookingTheatre = bookingTheatre;
	}

	public String getEmail()
	{
		return email;
	}
//	public String BookListSaver() // for saving all the data of booking record
//	{
//		return getbookingID() + "," + getBookingMovieDate() + "," + getBookingMovieName() + ","
//				+ getBookingNumberTickets() + ","
//				+ getBookingTimeSlot();
//	}
}
