package weatherforecast.cba.com.weatherforecast.core;

/**
 * Interface that depicts Gps factors that affects atmospheric pressure, temperature and humidity
 * Created by Antony Philip on 7/8/2016.
 */
public interface GpsFactors {
    /**
     * Method for getting latitude of place
     * @return latitude
     */
    double getLatitude();
    /**
     * Method for getting longitude of place
     * @return longitude
     */
    double getLongitude();
    /**
     * Method for getting altitude of place
     * @return altitude
     */
    float getAltitudeInMeters();

}
