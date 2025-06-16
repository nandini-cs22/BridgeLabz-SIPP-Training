import java.util.Scanner;
class Prgm4
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius");
		int rad = sc.nextInt();
		double area = (3.14 *(rad*rad));
		System.out.println(area);
	}
} 