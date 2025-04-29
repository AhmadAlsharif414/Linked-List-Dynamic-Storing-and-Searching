import java.lang.Math;
public class City {
    String cityName;
    double latitude;
    double  longitude;

    public City (String cityName, double latitude, double longitude){
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static double getDistence(City one, City two){
        double r = 6372.8;
        double distance = (2*r)*(Math.asin(Math.sqrt(Math.pow(Math.sin(Math.toRadians(two.latitude-one.latitude)/2),2)+Math.cos(Math.toRadians(one.latitude))*Math.cos(Math.toRadians(two.latitude))*Math.pow(Math.sin(Math.toRadians(two.longitude-one.longitude)/2),2))));
        return distance;
    }

    public String getName() {
        return cityName;
    }
}