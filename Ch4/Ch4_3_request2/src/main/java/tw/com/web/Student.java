package tw.com.web;

public class Student {
	private String name;
	private int score;
	
	public Student(String name,String scoreStr) {
		this.name = name;
		this.score = Integer.parseInt(scoreStr);
	}
	
	public String toString() {
		return name+":"+score;
	}
}
