package weatherforecast.cba.com.weatherforecast.weatherstationmodel;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by 778363aypp on 7/10/2016.
 */
public class WeatherReportCenterTest extends TestCase {

    public void testGetWeatherReportFromAllStations() throws Exception {
        WeatherReportCenter weatherReportCenter = WeatherReportCenter.getInstance();
        String weatherReport = weatherReportCenter.getWeatherReportFromAllStations();
        assertNotNull(weatherReport);
    }
}