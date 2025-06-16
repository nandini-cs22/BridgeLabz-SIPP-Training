class Code6
{
	public static void main(string[] args)
	{
	 double km;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        km = sc.nextInt();  

        double miles = km / 1.6;

        System.out.println("The distance " + km + " km in miles is " + miles);
	}
}