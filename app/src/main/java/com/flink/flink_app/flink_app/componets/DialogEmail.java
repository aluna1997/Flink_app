package com.flink.flink_app.flink_app.componets;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.flink.flink_app.flink_app.R;

/**
 * Created by ligorio on 08/02/16.
 */
public class DialogEmail extends DialogFragment {

@Override
public Dialog onCreateDialog(Bundle saveInstance){

    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

    LayoutInflater inflater = getActivity().getLayoutInflater();


    builder.setView(inflater.inflate(R.layout.dialog_email,null))
            .setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getActivity(),"mensaje enviado",Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    DialogEmail.this.getDialog().cancel();
                }
            })
            .setTitle("Escribe tu correo y pronto nos contactaremos contigo.");

    return builder.create();


}




}


