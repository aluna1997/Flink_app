package com.flink.flink_app.flink_app.componets;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.flink.flink_app.flink_app.R;


public class CreditConfirmDialog extends DialogFragment {

    private String creditAmount;

    private  String creditTotal;
    private String creditDate;

    private TextView credit;
    private TextView total;
    private TextView date;





    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


            LayoutInflater inflater = getActivity().getLayoutInflater();

            final View view = inflater.inflate(R.layout.fragment_credit_dialog_confirm, null);

            credit = (TextView) view.findViewById(R.id.dialog_credit_amount);
         total = (TextView) view.findViewById(R.id.dialog_credit_total);
         date = (TextView) view.findViewById(R.id.dialog_credit_date);

        credit.setText("Monto del Credito: $" + getArguments().getString("credit"));
        total.setText("Total del credito: $" + getArguments().getString("total"));
        date.setText("Fecha de pago: " + getArguments().getString("date"));

            builder.setView(view)
                    .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "Nuevo credito", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            CreditConfirmDialog.this.getDialog().cancel();
                        }
                    }).setTitle("Confirma tu credito");
            return builder.create();


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);






    }
}
