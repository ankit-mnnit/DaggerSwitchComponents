package com.jiomoney.daggerpoc.config;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public class Constants {

    public static final long CONNECT_TIME_OUT = 10000;
    public static final long READ_TIME_OUT = 10000;
    public static final long WRITE_TIME_OUT = 10000;
    public static final int MAX_IDLE_CONNECTIONS = 5;
    public static final long KEEP_ALIVE_DURATION = 5000;


    public static class GeocodeAddressConstants {

        // For address line 1
        public static final String ROUTE = "route";
        public static final String PREMISE = "premise";
        public static final String STREET_ADDRESS = "street_address";
        public static final String STREET_NUMBER = "street_number";
        public static final String ROOM = "room";

        // For address line 2
        public static final String SUBLOCALITY_LEVEL_1 = "sublocality_level_1";
        public static final String SUBLOCALITY_LEVEL_2 = "sublocality_level_2";
        public static final String SUBLOCALITY_LEVEL_3 = "sublocality_level_3";

        // For city
        public static final String CITY_NAME = "locality";
        public static final String ADMINISTRATIVE_LEVEL_2 = "administrative_area_level_2";

        // For state
        public static final String ADMINISTRATIVE_LEVEL_1 = "administrative_area_level_1";

        // For postal code
        public static final String POSTAL_CODE = "postal_code";

        public static final String COUNTRY = "country";

    }

}
