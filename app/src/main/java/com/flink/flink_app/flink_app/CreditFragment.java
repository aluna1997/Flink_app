package com.flink.flink_app.flink_app;


import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Calendar;


public class CreditFragment extends Fragment {

    private float [] creditValues = {1000.00F,1100.00F,1200.00F,1300.00F, 1400.00F, 1500.00F, 1600.00F, 1700.00F, 1800.00F, 1900.00F, 2000.00F, 2100.00F, 2200.00F, 2300.00F, 2400.00F, 2500.00F, 2600.00F, 2700.00F, 2800.00F, 2900.0F,3000.00F};

    private float interest;
    private static final float PERCENT =0.01276F;

    private float totalCredit;
    private TextView totalCreditText;
    // Credit Amoun stuff
    private TextView creditText;
    private SeekBar creditBar;
    private float creditAmount=2000.00F;



    //Time stuff
    private TextView timeCredit;
    private SeekBar timeCreditBar;
    private int timeCreditValue=15;

    //Other stuff

    private TextView interestValue;
    private TextView amountText;
    private TextView payDate;

   private long timeInMills = timeCreditValue*24*60*60*1000;

    public CreditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_credit,container,false);
        interest = creditAmount*PERCENT*timeCreditValue;
        totalCredit = creditAmount+interest;

        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Calendar c = Calendar.getInstance();

        final long current = c.getTimeInMillis();

        c.setTimeInMillis(timeInMills+current);

        interestValue = (TextView)getActivity().findViewById(R.id.text_interest_value);
        amountText = (TextView) getActivity().findViewById(R.id.text_amount_value);
        totalCreditText = (TextView) getActivity().findViewById(R.id.text_total_value);
        payDate = (TextView) getActivity().findViewById(R.id.text_pdate_value);

        payDate.setText(c.get(Calendar.DAY_OF_MONTH)+" de "+getMonth(c.get(Calendar.MONTH)+1)+" del "+c.get(Calendar.YEAR));

        //Set time credit value;
        timeCreditBar = (SeekBar) getActivity().findViewById(R.id.credit_time);
        timeCredit = (TextView) getActivity().findViewById(R.id.time_value_text);


        //Set credit value
        creditBar = (SeekBar) getActivity().findViewById(R.id.credit_amount);
        creditText = (TextView) getActivity().findViewById((R.id.credit_text_value));
        creditBar.setMax(20);
        creditBar.setProgress(10);

        final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        decimalFormatSymbols.setGroupingSeparator(',');
        decimalFormatSymbols.setMonetaryDecimalSeparator('.');
        ((DecimalFormat) moneyFormat).setDecimalFormatSymbols(decimalFormatSymbols);

        interestValue.setText("$" + moneyFormat.format(interest));
        amountText.setText("$"+moneyFormat.format((creditAmount)));
        totalCreditText.setText("$"+moneyFormat.format(totalCredit));

        creditBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                creditAmount = creditValues[progress];


                creditText.setText("$"+moneyFormat.format(creditAmount));

                interest = creditAmount*PERCENT*timeCreditBar.getProgress();
                interestValue.setText("$"+moneyFormat.format(interest));

                amountText.setText("$"+moneyFormat.format(creditAmount));

                totalCredit = creditAmount+interest;

                totalCreditText.setText("$"+moneyFormat.format(totalCredit));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

      //chanege time credit

        timeCreditBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                timeCreditValue = progress;
                timeCredit.setText(String.valueOf(timeCreditValue)+" Días");

                interest = timeCreditValue*PERCENT*creditValues[creditBar.getProgress()];
                interestValue.setText("$"+moneyFormat.format(interest));


                totalCredit = creditAmount+interest;

                totalCreditText.setText("$" + moneyFormat.format(totalCredit));

                long mills= (long)progress*24*60*60*1000;
                Log.i("Fecha de hoy",String.valueOf(current));
                Log.i("Fecha con suma",String.valueOf(c.getTimeInMillis()) );
                Log.i("fecha sumada",String.valueOf(mills));
                Log.i("Progress value",String.valueOf(progress));

                c.setTimeInMillis(mills + current);
                payDate.setText(c.get(Calendar.DAY_OF_MONTH) + " de " + getMonth(c.get(Calendar.MONTH) + 1) + " del " + c.get(Calendar.YEAR));




            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private String getMonth (int month){
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
