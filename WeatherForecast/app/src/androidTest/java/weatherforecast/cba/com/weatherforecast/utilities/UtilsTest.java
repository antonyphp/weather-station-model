package weatherforecast.cba.com.weatherforecast.utilities;

import junit.framework.TestCase;

/**
 * Created by Antony Philip on 7/9/2016.
 */
public class UtilsTest extends TestCase {

    public void testConvertPascalToHectopascals() throws Exception {
        float valueInPascals = 101325;
        float valueInHectoPascals = Utils.convertPascalToHectopascals(valueInPascals);
        assertEquals(valueInHectoPascals,1013.25f);

    }

    public void testGetTimeStampFromMills() throws Exception {
        long timeInMilliSeconds = 1468087902;
        String dateTime = Utils.getTimeStampFromMills(timeInMilliSeconds,Constants.LOCATION_TIME_STAMP_FORMAT);
        assertEquals(dateTime,"1970-01-18T05:18:07.902Z");

    }

    public void testRound() throws Exception {
        float numberToBeRounded = 23.456784f;
        float roundedNumber = Utils.round(numberToBeRounded,1);
        assertEquals(roundedNumber,23.5f);

    }
}