package weatherforecast.cba.com.weatherforecast.utilities;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class used for keeping all generic utility functions.
 * Created by Antony Philip on 7/9/2016.
 */
public class Utils {
    /**
     * Method used to convert value in Pascals unit to Hectopascals.
     * @param valueInPascals
     * @return
     */
    public static float convertPascalToHectopascals (float valueInPascals){
        return (float)(valueInPascals * 0.01);
    }

    /**
     * Method used to get a formatted String of time from timestamp in milliseconds.
     * @param milliSeconds
     * @param dateFormat
     * @return Time in specified String format.
     */
    public static String getTimeStampFromMills(long milliSeconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    /**
     * Round to certain number of decimals
     *
     * @param d
     * @param decimalPlace
     * @return
     */
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
