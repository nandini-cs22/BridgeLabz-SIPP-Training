import java.util.Scanner;

class CollinearityCheck
{
	public static boolean isCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3)
	{
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    	}

    public static boolean isCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3)
	{
        return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
    	}

    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        boolean slopeResult = isCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaResult = isCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Collinear by Slope: " + slopeResult);
        System.out.println("Collinear by Area: " + areaResult);
    	}
}
