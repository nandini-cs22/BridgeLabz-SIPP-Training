import java.util.Scanner;
class Prgm5
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius");
		int rad = sc.nextInt();
		System.out.println("Enter the height");
		int height = sc.nextInt();
		double volume = 3.14 * (rad*rad)* height;
		System.out.println(volume);
	}
}