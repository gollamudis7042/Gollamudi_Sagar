import java.util.Scanner;

public class bmi
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter your weight in pounds");
		double num = keyboard.nextDouble();
		System.out.println("Please enter your height in inches");
		double num2 = keyboard.nextDouble();
		double num3 = num/(num2*num2);
		System.out.println("Your BMI is " + num3 * 703 + ".");
		
	}
}