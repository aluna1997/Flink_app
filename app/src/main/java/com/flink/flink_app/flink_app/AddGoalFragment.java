package com.flink.flink_app.flink_app;


import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.flink.flink_app.flink_app.componets.DatePickerFragment;
import com.flink.flink_app.flink_app.util.Sample;

import java.io.IOException;

import info.hoang8f.android.segmented.SegmentedGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddGoalFragment extends Fragment {

    private Button goalButton;
    private SegmentedGroup periodChoices;
    private ImageView camera;
    private FrameLayout imageGoal;

    private int PICK_IMAGE_REQUEST=1;


    public static AddGoalFragment getInstance(){
        AddGoalFragment  f = new AddGoalFragment();

        return f;
    }



    public AddGoalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_add_goal, container, false);
        goalButton = (Button) v.findViewById(R.id.button_goal_date);
        camera = (ImageView) v.findViewById(R.id.camara_select_photo);
        imageGoal = (FrameLayout) v.findViewById(R.id.charge_image);
        goalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getFragmentManager();
                DialogFragment picker = new DatePickerFragment();
                 picker.show( manager ,"datepicker");



            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                // Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // Always show the chooser (if there are multiple options available)
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);



            }
        });

        return v;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PICK_IMAGE_REQUEST && resultCode== Activity.RESULT_OK && data != null && data.getData() != null ){
            Uri uri = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),uri);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getActivity().getResources(),bitmap);
                imageGoal.setBackground(bitmapDrawable);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
