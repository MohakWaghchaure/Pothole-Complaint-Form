package app.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public final class PotholeComplaintServiceUtils {
    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\"\'\\\\]");
    private static final Pattern INVALID_Latitude_PATTERN = Pattern.compile("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)$");
    private static final Pattern INVALID_Longitude_PATTERN = Pattern.compile("^[-+]?((1[0-7]|[1-9])?\\d(\\.\\d+)?|180(\\.0+)?)$");
    // package private for testing
    static final int COMPLAINT_ID_LENGTH = 10;

    static final int USER_ID_LENGTH = 7;

    // do not instantiate
    private PotholeComplaintServiceUtils() {}

    /**
     * Checks that the provided String contains only valid characters.
     *
     * @param stringToValidate the playlist name to be validated
     * @return true if the String is valid (contains only valid characters),
     *         false otherwise
     */
    public static boolean isValidString(final String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        }

        return !INVALID_CHARACTER_PATTERN.matcher(stringToValidate).find();
    }

    public static boolean isValidLatitude(final String latitudeToValidate) {
        if (StringUtils.isBlank(latitudeToValidate)) {
            return false;
        }

        return !INVALID_CHARACTER_PATTERN.matcher(latitudeToValidate).find();
    }

    public static boolean isValidLongitude(final String longitudeToValidate) {
        if (StringUtils.isBlank(longitudeToValidate)) {
            return false;
        }

        return !INVALID_CHARACTER_PATTERN.matcher(longitudeToValidate).find();
    }

    public static String generateComplaintId() {
        return "COMP-"+ RandomStringUtils.randomAlphanumeric(COMPLAINT_ID_LENGTH);
    }
    public static String generateUserId() {
        return "USER-" + RandomStringUtils.randomAlphanumeric(USER_ID_LENGTH);
    }

    public static String getIsoDateTimeString() {
        // Get the current date and time
        ZonedDateTime now = ZonedDateTime.now();

        // Format the date and time in ISO 8601 format
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String isoDateTimeString = now.format(formatter);

        return isoDateTimeString;
    }
}
