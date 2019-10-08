package edu.ssafy.ws07;

public class Movie {
	protected String title;
	protected String director;
	protected int grade;
	protected String genre;
	protected String summary;
	
	public Movie(String title, String director, int grade, String genre) {
		super();
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
	}

	public Movie(String title, String director, int grade, String genre, String summary) {
		super();
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
		this.summary = summary;
	}
	
	public Movie() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", grade=" + grade + ", genre=" + genre
				+ ", summary=" + summary + "]";
	}
	
}
