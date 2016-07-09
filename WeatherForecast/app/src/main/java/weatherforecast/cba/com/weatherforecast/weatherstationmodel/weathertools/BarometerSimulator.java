package weatherforecast.cba.com.weatherforecast.weatherstationmodel.weathertools;

import weatherforecast.cba.com.weatherforecast.core.WeatherStationBase;
import weatherforecast.cba.com.weatherforecast.utilities.Utils;

/**
 * Created by Antony Philip on 7/8/2016.
 * This simulator generates atmosphere Pressure in Hectopascals unit based on statistical data.
 * Altitude(elevation) is considered for finding pressure using Barometric formula
 * (Refer https://en.wikipedia.org/wiki/Atmospheric_pressure for more info)
 */
public class BarometerSimulator {

    /**
     * This is the method exposed to client to get Atmospheric Pressure.
     * @param weatherStationBase
     * @return
     */
    public float getAtmosphericPressure(WeatherStationBase weatherStationBase){
        float pressure= getPressureUsingBarometricFormula(weatherStationBase.getAltitudeInMeters());
        return Utils.convertPascalToHectopascals(pressure);
    }

    /**
     * Returns atmospheric pressure in unit Pascals
     * @param altitude
     * @return
     */
    private float getPressureUsingBarometricFormula(float altitude) {
        //Using Barometric formula ---> P0.exp(-(g.M.h/R.T0)) ; where h is the altitude.
        final float SEA_LEVEL_STD_PRESSURE = 101325.0f;//(P0)
        final float SEA_LEVEL_STD_TEMPERATURE = 288.15f;//(T0)
        final float G_ACCELERATION = 9.80665f;//(g)
        final float MOLAR_MASS_OF_DRY_AIR = 0.0289644f;//(M)
        final float UNIVERSAL_GAS_CONSTANT = 8.31447f;//(R)

        float intermediateResult = (G_ACCELERATION * MOLAR_MASS_OF_DRY_AIR * altitude)/(UNIVERSAL_GAS_CONSTANT * SEA_LEVEL_STD_TEMPERATURE);
        float atmosphericPressure =(float)(SEA_LEVEL_STD_PRESSURE * Math.exp(-(intermediateResult)));
        return atmosphericPressure;
    }

}
