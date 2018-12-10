

	import java.io.*;

	//the class storing all the information about student

	class studentGrades{
		//storing names of  students
		private String [] studentNames=new String[5];
		
		//storing grades of 5 students 
		private char [] grades=new char[5];
		
		//storing scores of 4 tests of each of the student
		private double [][] scores=new double[5][4];
		
		//storing average test score
		private double[] average=new double[5];
		
		//default constructor
		studentGrades() {
			for(int i=0;i<5;i++) {
				studentNames[i]="notdefined";
				grades[i]='N';
				for(int j=0;j<4;j++) {
					scores[i][j]=(double)0;
				}
			}		
		}
		
		//setting the values or each student
		void SetValue(int std_num) throws IOException {
		/**
		 * 	Scanner in = new Scanner(System.in);
			
			System.out.println("Enter Name:"); 
			//studentNames[std_num]=in.nextLine();
			
			System.out.println("Enter the scores of 4 tests:");
			for(int i=0;i<4;i++)
			scores[std_num][i]=in.nextDouble();
			
			in.reset();
			in.close();
		*/	
			
			//using buffer reader to read the input
			BufferedReader input=new BufferedReader(new InputStreamReader (System.in));
			
			//input of name of student
			System.out.println("Enter Name:");
			String inputString=input.readLine(); 
			studentNames[std_num]=inputString;
			
			//input of scores
			System.out.println("Enter the scores of 4 tests:");
			for(int i=0;i<4;i++) {
				inputString=input.readLine();
				scores[std_num][i]=Double.parseDouble(inputString);
				
				//not accepting test scores less than 0 or greater than 100
				do {
					if ((scores[std_num][i])<0 || scores[std_num][i]>100) {
						System.out.println("SCORES SHOULD BE BETWEEN 0 AND 100");
						System.out.println("enter again:");
						inputString=input.readLine();
						scores[std_num][i]=Double.parseDouble(inputString);	
					}
				}while(scores[std_num][i]<0 ||  scores[std_num][i]>100);		
			}
		}
		
		//calculating average and grades
		void calculate(){
			for(int i=0;i<5;i++) {
				for(int j=0;j<4;j++) {
					average[i]=average[i]+scores[i][j];
				}
				average[i]=average[i]/4;
				if(average[i]<=100 && average[i]>=90)
					grades[i]='A';
				if(average[i]<=89 && average[i]>=80)
					grades[i]='B';
				if(average[i]<=79 && average[i]>=70)
					grades[i]='C';
				if(average[i]<=69 && average[i]>=60)
					grades[i]='D';
				if(average[i]<=59 && average[i]>=0)
					grades[i]='F';
			}
		}
		
		//get value of each student
		void getValue(int std_num) {
			//displaying the details of the student
		
			System.out.println("name: "+studentNames[std_num]);
			System.out.println("test scores: "+scores[std_num][0]+" "+
			scores[std_num][1]+" "+scores[std_num][2]+" "+scores[std_num][3]+" ");
			System.out.println("average "+average[std_num]);
			System.out.println("grade "+grades[std_num]);
		}
	}
	class StudentDetails {

	public static void main(String[] args) throws IOException {
		studentGrades obj=new studentGrades();
		System.out.println("**Student Grading System**");
		System.out.println("Enter the details of 5 students:");
		for(int i=0;i<5;i++) {
			System.out.println("Student"+" "+(i+1));
			obj.SetValue(i);
			}
		obj.calculate();
		System.out.println("displaying the details of students");
		for(int i=0;i<5;i++) {
			System.out.println("Student"+" "+(i+1));
			obj.getValue(i);
			}
		}
	}
	


