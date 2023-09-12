package MorrisLAB02;

public class CourseOutcome {
	String studentID;
	String courseName;
	double grade;
	int hours;
	
	public CourseOutcome(String x, String y, double z, int a) {
		studentID = x;
		courseName = y;
		grade = z;
		hours = a;
	}
	
	public String toString() {
		return studentID +" scored " + grade + " in " + courseName + ", " + hours + " hours.";
	}
	
	public boolean equals(CourseOutcome x) {
		return this.toString().equals(x.toString());
		
	}
	
	
}
