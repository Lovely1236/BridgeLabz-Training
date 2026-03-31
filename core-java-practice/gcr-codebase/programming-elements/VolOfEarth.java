public class VolOfEarth{
	public static void main(String[] args) {
		double radiusKm= 6378;
		double pi = Math.PI;
		double volKm= (4.0/3)* radiusKm * radiusKm * radiusKm;
		double KmToMiles= 0.621371;
		double volMiles= volKm * Math.pow(KmToMiles,3);
		System.out.println("The volume of earth in cubic Kilometers is:" + volKm +"and cubic miles is" + volMiles);
		
	}
}