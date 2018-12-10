


import java.io.*;

class AtmTransaction{
	//as in atm we already have stored accounts along with
	//there passwords so i am considering two string arrays storing
	//account numbers and their corresponding passwords
	private String [] accountNumbers=new String[]
			{"123","234","345","456","567","678","789","890"};
	//for convenience keeping passwords same as the account numbers 
	private String [] passwords=new String[]
			{"123","234","345","456","567","678","789","890"};
	//int to store the iterator pointing to the account
	 int pointer;
	 //balance 
	 double [] balance=new double[] {2000,3000,5000,7000,6850,4000,8765,9800};
	 AtmTransaction(){
		 pointer=0;
	 }
	
	//to check account number
	boolean checkAccNumber(String num) {
		
	//search for this string in the string of account numbers 
		for(int i=0;i<accountNumbers.length;i++) {
			if (num.equals(accountNumbers[i])) {
				pointer=i;
				return true;				
			}	
		}
		return false;
	}
	
	//to check account password
		boolean checkPassword(String pass) {
			
			//search for this string in the string of account numbers 
				if (pass.equals(passwords[pointer])) {
					return true;				
				}	
				else
					return false;
		}
	
		//withdrawing money
		void withdraw(double amt) {
			if( amt%100==0 || amt%500==0 || amt%2000==0) {
				if((balance[pointer]-amt)<0) {
					System.out.println("CANNOT WITHDRAW THIS AMOUNT \n"
				+"note:amount to be wihdrawn greater than balance ");
				}
				else
					balance[pointer]=balance[pointer]-amt;
			}
			else
				System.out.println("CANNOT WITHDRAW THIS AMOUNT \n"+"note:amount not multiple of 100,500,or 2000");
		}
		
		//depositing money
		void deposit(double amt) {
			if(amt>4000) {
				System.out.println("CANNOT DEPOSIT MORE THAN 4000");
			}
			else
			balance[pointer]+=amt;
		}
		
		//check balance
		void checkBalance() {
			System.out.println("your current balance is : "+balance[pointer]);
		}
		
}
public class AtmMachine {

	public static void main(String[] args) throws Exception {
		//creating object
		AtmTransaction object=new AtmTransaction();
		
		//asking for inputs 
		System.out.println("****ATM TRANSACTION****");	
		//using Buffer Reader to read
		BufferedReader input=new BufferedReader(new InputStreamReader (System.in));
		
		System.out.println("Enter your account number:");
		String accNum=new String();
		accNum=input.readLine();
		
		//checking account number
		while(!object.checkAccNumber(accNum)) {
			System.out.println("ACCOUNT NUMBER INVALID");
			System.out.println("Enter your account number:");
			accNum=input.readLine();
		}
		
		System.out.println("enter password:");
		String pass=new String();
		pass=input.readLine();
		
		//checking account password
		while(!object.checkPassword(pass)) {
			System.out.println("ACCOUNT PASSWORD INVALID");
			System.out.println("Enter your account password:");
			pass=input.readLine();
		}
			//switch menu
		while(true) {
			System.out.println("enter your choice \n"+"1.withdraw"
			+"2.deposit"+"3.check balance"+"4.exit()");
			String temp=new String();
			temp=input.readLine();
			int opt=Integer.parseInt(temp);
			switch(opt) {
			case 1:
				System.out.println("enter the amount");
				temp=input.readLine();
				object.withdraw(Double.parseDouble(temp));
				break;
			case 2:
				System.out.println("enter the amount");
				temp=input.readLine();
				object.deposit(Double.parseDouble(temp));
				break;
			case 3:
				object.checkBalance();
				break;
			case 4:
				System.exit(0);
			default:
					System.out.println("THANKS FOR USING ATM");
			}
		}
	}
	}




