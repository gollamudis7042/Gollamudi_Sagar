import java.util.ArrayList;
public class satellite
{
   public static void main(String[]args)
   {
       ArrayList<location> locate = new ArrayList<>();
       double[] honLoc = {5, 6};
       locate.add(new honda(honLoc));
       locate.add(new toyota("8, 9"));
       locate.add(new gmc(3, 8));

        double[] home = {0, 0};

        String printout = "\n\n" +
               "==========================" + "\nStarting locations...";

        for (location l : locate)
       {
           printout += "\nLocation for " + l.getID() + ": (" + getLocation(l.getLoc()) + ")";
       }

		
		for(location l: locate)
		{
		double x,y;
		x=(Math.random() * 100 + 1);
		y=(Math.random() * 100 + 1);
		System.out.println("After "+l.getID()+" moved ("+x+","+y+")");
		((car)l).move(x,y);
		System.out.println("new location ("+l.getLoc()[0]+","+l.getLoc()[1]+")");
		}
		
		printout += "\n\n" + "==========================" +
                   "\nDistance from home...";

        for (location l : locate)
       {
           printout += "\nDistance for " + l.getID() + ": (" + getDistance(l.getLoc(), home)+ ")";
       }

        System.out.println(printout);
   }

    public static double getDistance(double[] car, double[] home)
   {
       return Math.sqrt((Math.pow(car[0] - home[0], 2)+ Math.pow(car[1] - home[1], 2)));
   }

    public static String getLocation(double[] loc)
   {
       return loc[0] + ", " + loc[1];
   }
}