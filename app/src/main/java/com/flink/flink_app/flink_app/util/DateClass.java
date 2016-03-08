package com.flink.flink_app.flink_app.util;

/**
 * Created by ligorio on 24/02/16.
 */
public class DateClass {

    public static String getMonth (int month){
        String m= null;
        switch(month) {
            case 1: m= "Enero"; break;
            case 2:  m= "Febrero"; break;
            case 3: m= "Marzo"; break;
            case 4: m= "Abril"; break;
            case 5: m= "Mayo"; break;
            case 6: m= "Junio"; break;
            case 7: m= "Julio"; break;
            case 8: m= "Agosto"; break;
            case 9: m= "Septiembre"; break;
            case 10: m= "Octubre"; break;
            case 11: m= "Noviembre"; break;
            case 12: m= "Diciembre"; break;

        }
        return m;
    }
}
