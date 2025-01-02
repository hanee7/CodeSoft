package findingPersentage;

public class studentsMarks {
	public static double calPersentage(int[] marks,int totalmarks) {
		int sum=0; 
		for(int mark:marks) {
			sum+=mark;
		}
		double persentage=((double)sum/totalmarks)*100;
				return persentage;
	}
	public static void main(String[] args) {
		int[] marks= {90,90,90,90,90,90};
		int totalmarks=100*marks.length;
		double persentage=calPersentage(marks, totalmarks);
		System.out.println(persentage);
	}
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * //public calPersentage(int[] marks,int totalmarks) {
	 * 
	 * int sum=0;
	 * 
	 * int[] marks= {90,90,90,90,90,90}; int totalmarks=100*marks.length;
	 * 
	 * for(int mark:marks) { sum+=mark; } double
	 * persentage=((double)sum/totalmarks)*100;
	 * 
	 * System.out.println(persentage); }
	 */
}
