package weatherforecast.cba.com.weatherforecast.weatherstationmodel.weathertools;

/**
 * Created by Antony Philip on 7/9/2016.
 * calculates % of atmospheric humidity(Relative Humidity)
 * Refer http://www.engineeringtoolbox.com/relative-humidity-air-d_687.html
 */
public class PsychrometerSimulator {

    /**
     * Gets % of atmospheric humidity
     * @param atmosphericPressure
     * @param atmosphericTemperature
     * @return
     */
    public int getAtmosphericHumidity(float atmosphericPressure,float atmosphericTemperature){
        int atmosphericHumidity = 0;
        atmosphericHumidity = calculateHumidity(atmosphericPressure,atmosphericTemperature);
        return atmosphericHumidity ;
    }

    /**
     * calculates % of atmospheric humidity
     * @param pressure
     * @param temperature
     * @return
     */
    private int calculateHumidity(float pressure, float temperature) {
        //Using Relative Humidity formula φ = pw / pws % (where , φ = relative humidity (%), pw = vapor partial pressure (hPa)
        // pws = saturation vapor partial pressure )

        float saturationVaporPressure = calculateSaturationVaporPressure(temperature);
        int humidity = (int)(pressure / saturationVaporPressure);
        return humidity;
    }

    /**
     * Calculates saturation vapor pressure
     * @param temperature
     * @return
     */
    private float calculateSaturationVaporPressure(float temperature) {
        /*Using Formula e = 6.11 x 10^((7.5 x T)/(237.3 + T)) where T is the temperature in Celsius
         (Refer http://www.srh.noaa.gov/images/epz/wxcalc/vaporPressure.pdf)*/

        float powValue = (float)((7.5 * temperature)/(237.3 + temperature));
        float saturationPressure = (float)(6.11 * Math.pow(10,powValue));
        return saturationPressure;
    }
}
