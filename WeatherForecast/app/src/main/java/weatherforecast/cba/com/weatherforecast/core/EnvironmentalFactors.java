package weatherforecast.cba.com.weatherforecast.core;

/**
 * Interface that depicts environmental factors that affects atmospheric temperature
 * Created by Antony Philip on 7/8/2016.
 */
public interface EnvironmentalFactors {
    /**
     * Method for checking whether land is near ocean
     * @return true if near ocean otherwise false
     */
    boolean isOceanCurrent();
    /**
     * Method for checking soil color which affect atmospheric temperature
     * @return SoilColor
     */
    SoilColor getSoilColor();
    /**
     * Method for checking Season
     * @return Season
     */
    Season getSeason(WeatherStationBase weatherStationBase);

    /**
     * Enum for denoting different Seasons
     */
    enum Season{
        SUMMER,
        AUTUMN,
        WINTER,
        SPRING
    }

    /**
     * Enum for denoting different Soil Colors
     */
    enum SoilColor{
        BROWN,
        YELLOW,
        BLACK
    }
}
