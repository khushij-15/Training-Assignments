import java.util.Scanner;

/*
*Scanner(InputStream.obj)
*Scanner(Reader obj)
*
*Methods:
*String nextLine();
*int nextInt();
*float nextFloat();
*/
public class InputThroughScanner{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Enter your age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter your percentage: ");
		float perc = scanner.nextFloat();
		scanner.nextLine();
		System.out.println("Enter your address: ");
		String address = scanner.nextLine();

		System.out.println("Welcome "+name);
		System.out.println("Your age is "+age);
		System.out.println("Your percentage is "+perc);
		System.out.println("Your address is "+address);
	}
}

