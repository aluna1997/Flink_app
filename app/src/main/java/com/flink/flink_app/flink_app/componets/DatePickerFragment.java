package com.flink.flink_app.flink_app.componets;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.flink.flink_app.flink_app.R;
import com.flink.flink_app.flink_app.util.DateClass;

import java.util.Calendar;

/**
 * Created by ligorio on 24/02/16.
 */
public  class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        dateGoal(year,monthOfYear,dayOfMonth);

    }
     public String dateGoal(int year,int month, int day){

         String date = String.valueOf(day)+" de "+ DateClass.getMonth(month+1)+" del "+String.valueOf(year);
         ((TextView) getActivity().findViewById(R.id.goal_date_text)).setText(date);
         Toast.makeText(getActivity(),date,Toast.LENGTH_SHORT);
         return date;

     }


}
