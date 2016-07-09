package weatherforecast.cba.com.weatherforecast.weatherstationmodel.weathertools;

import java.util.Calendar;

import weatherforecast.cba.com.weatherforecast.core.EnvironmentalFactors;
import weatherforecast.cba.com.weatherforecast.core.WeatherStationBase;

/**
 * Created by Antony Philip on 7/8/2016.
 * This simulator generates atmosphere temperature based on different environmental factors and statistical data.
 */
public class ThermometerSimulator {

    /**
     * This is the method exposed to the client to get Atmospheric Temperature
     * @param weatherStationBase
     * @return
     */
    public float getTemperature(WeatherStationBase weatherStationBase){
        Temperature temp = generateTempBasedOnSeason(weatherStationBase.getMonthOfYear());
        float temperature = getTemperatureBasedOnTime(temp, weatherStationBase.getTime());
        temperature = getTemperatureBasedGpsFactors(weatherStationBase,temperature);
        temperature = getTemperatureOnEnvironmentFactors(weatherStationBase,temperature);
        return temperature;
    }

    /**
     * Modifies the temperature based on various environmental factors
     * @param weatherStationBase
     * @param temp
     * @return
     */
    private float getTemperatureOnEnvironmentFactors(WeatherStationBase weatherStationBase, float temp) {
        float temperature = temp;
        if(weatherStationBase.isOceanCurrent()){
            temperature += 0.02;
        }
        if(weatherStationBase.getSoilColor() == EnvironmentalFactors.SoilColor.BLACK){
            temperature -=0.02;
        }else if(weatherStationBase.getSoilColor() == EnvironmentalFactors.SoilColor.BROWN ||
                weatherStationBase.getSoilColor() == EnvironmentalFactors.SoilColor.YELLOW){
            temperature +=0.02;
        }
        return temperature;
    }


    /**
     * Modifying temperature base on Gps Factors
     * @param weatherStationBase
     * @param temp
     * @return
     */
    private float getTemperatureBasedGpsFactors(WeatherStationBase weatherStationBase, float temp) {
        float temperature = temp;
        //Assuming 0.02 degrees increases as latitude increases
        temperature += (float)Math.abs(weatherStationBase.getLatitude())*0.02f;
        //Assuming 0.002 decreases as altitude increases
        temperature -=  Math.abs(weatherStationBase.getAltitudeInMeters())*0.002f;
        return temperature;
    }

    /**
     * Modifying temperature based on Time of day
     * @param temperature
     * @param time
     * @return
     */
    private float getTemperatureBasedOnTime(Temperature temperature, long time) {
        int hourOfDay  = getHourOfDay(time);
        float tempWithinTimeRange = 0;
        if(hourOfDay >= 0 && hourOfDay < 9){
            tempWithinTimeRange =  temperature.getMaxTemperature();

        }else if( hourOfDay == 9){
            tempWithinTimeRange = temperature.getTime9AmTemperature();

        }else if(hourOfDay > 9 && hourOfDay < 15){
            tempWithinTimeRange = temperature.getMinTemperature();

        }else if(hourOfDay == 15){
            tempWithinTimeRange = temperature.getTime3PmTemperature();

        }else if(hourOfDay > 15 && hourOfDay < 19){
            tempWithinTimeRange = temperature.getMinTemperature();
        }
        else{
            tempWithinTimeRange = temperature.getMaxTemperature();
        }
        return tempWithinTimeRange;

    }


    /**
     * Generate Temperature based for past statistical data.
     * @param monthOfYear
     * @return
     */
    private Temperature generateTempBasedOnSeason(String monthOfYear) {
        switch(monthOfYear){
            case "JAN" :
                return new Temperature(25.9f,18.7f,22.5f,24.8f);
            case "FEB":
                return new Temperature(25.8f,18.8f,23.3f,24.9f);
            case "MAR":
                return new Temperature(24.8f,17.6f,21.1f,24.0f);
            case "APR":
                return new Temperature(22.5f,14.7f,18.2f,22.0f);
            case "MAY":
                return new Temperature(19.5f,11.6f,14.6f,19.4f);
            case "JUN":
                return new Temperature(17.0f,9.3f,11.9f,16.9f);
            case "JUL":
                return new Temperature(16.3f,8.1f,10.9f,16.4f);
            case "AUG":
                return new Temperature(17.8f,9.0f,12.5f,17.8f);
            case "SEP":
                return new Temperature(20.0f,11.1f,15.7f,19.2f);
            case "OCT":
                return new Temperature(22.1f,13.6f,18.5f,20.7f);
            case "NOV":
                return new Temperature(23.6f,15.7f,19.9f,21.1f);
            case "DEC":
                return new Temperature(25.2f,17.5f,21.6f,23.8f);
            default:
                return new Temperature(0,0,0,0);

        }
    }

    /**
     * Temperature class that holds a days temperature information.
     */
    public class Temperature{
        /*Private Members */
        private float minTemperature;
        private float maxTemperature;
        private float time9AmTemperature;
        private float time3PmTemperature;


        /**
         * Constructor for initializing Temperature class
         * @param minTemperature
         * @param maxTemperature
         * @param time9AmTemperature
         * @param time3PmTemperature
         */
        public Temperature(float minTemperature, float maxTemperature, float time9AmTemperature, float time3PmTemperature) {
            this.minTemperature = minTemperature;
            this.maxTemperature = maxTemperature;
            this.time9AmTemperature = time9AmTemperature;
            this.time3PmTemperature = time3PmTemperature;
        }


        /**
         * Returns the Maximum temperature for a day
         * @return
         */
        public float getMaxTemperature() {
            return maxTemperature;
        }

        /**
         * returns the minimum temperature for the day.
         * @return
         */
        public float getMinTemperature() {
            return minTemperature;
        }

        /**
         * Returns the Temperature at 9AM
         * @return
         */
        public float getTime9AmTemperature() {
            return time9AmTemperature;
        }
        /**
         * Returns the Temperature at 3PM
         * @return
         */
        public float getTime3PmTemperature() {
            return time3PmTemperature;
        }

    }
    /**
     * Gets Hour of Day from a milliseconds time.
     * @return Hour of day (0-23)
     */
    private static int getHourOfDay(long milliSeconds) {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(milliSeconds);
        return time.get(Calendar.HOUR_OF_DAY);
    }
}
