package com.flink.flink_app.flink_app;



import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Visibility;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.flink.flink_app.flink_app.adapter.GoogleCardAdapter;
import com.flink.flink_app.flink_app.model.ApiModel;
import com.flink.flink_app.flink_app.util.ImageUtil;
import com.flink.flink_app.flink_app.util.Sample;
import com.flink.flink_app.flink_app.util.VolleyCallBack;
import com.flink.flink_app.flink_app.util.VolleyRequest;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SaveFragment extends Fragment implements OnDismissCallback {
    private GoogleCardAdapter googleCardAdapter;
    private static final int INITIAL_DELAY_MILLIS = 300;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;
    private ListView listCard;
    private ProgressDialog pd;

    private FloatingActionButton addGoal;




    public SaveFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle save){
        super.onCreate(save);



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_save, container, false);

        ImageUtil load = new ImageUtil(getActivity());

       // pd = new ProgressDialog(this.getActivity(), ProgressDialog.STYLE_SPINNER);
        //pd.isIndeterminate();
        //pd.show(this.getActivity(),"PROG_DIALOG","Getting data...");


        googleCardAdapter = new GoogleCardAdapter(getActivity(), getRequestData() );






        addGoal = (FloatingActionButton)rootView.findViewById(R.id.button_add_goal);

        addGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.slide_left_in,R.anim.slide_left_out,R.anim.slide_right_in,R.anim.slide_right_out);

                AddGoalFragment fragment = AddGoalFragment.getInstance();

                fragmentTransaction.replace(R.id.root_fragment,new AddGoalFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return rootView;
    }

    @Override
    public void onResume(){
        super.onResume();
        //pd.dismiss();

       swingBottomInAnimationAdapter.notifyDataSetChanged();

    }



    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listCard  = (ListView) getActivity().findViewById(R.id.list_view);

        swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(
                new SwipeDismissAdapter(googleCardAdapter, this));
        swingBottomInAnimationAdapter.setAbsListView(listCard);

        assert swingBottomInAnimationAdapter.getViewAnimator() != null;
        swingBottomInAnimationAdapter.getViewAnimator().setInitialDelayMillis(
                INITIAL_DELAY_MILLIS);


        listCard.setClipToPadding(false);
        listCard.setDivider(null);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                8, r.getDisplayMetrics());
        listCard.setDividerHeight(px);
        listCard.setFadingEdgeLength(0);
        listCard.setFitsSystemWindows(true);
        px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12,
                r.getDisplayMetrics());
        listCard.setPadding(px, px, px, px);
        listCard.setScrollBarStyle(ListView.SCROLLBARS_OUTSIDE_OVERLAY);
        listCard.setAdapter(swingBottomInAnimationAdapter);





    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDismiss(@NonNull final ViewGroup listView,
                          @NonNull final int[] reverseSortedPositions) {
        for (int position : reverseSortedPositions) {
            googleCardAdapter.remove(googleCardAdapter.getItem(position));
        }
    }


    private  ArrayList<ApiModel> getRequestData() {
        VolleyRequest volleyRequest = new VolleyRequest("https://glaring-torch-9748.firebaseio.com/goals.json", getActivity());
        final ArrayList<ApiModel> list = new ArrayList<>();

       volleyRequest.getRequest(new VolleyCallBack() {
           @Override
           public void onSuccess(JSONObject data) {

               // Log.i("JsonRquest", String.valueOf(data.length())); Test
               for (int i = 0; i < data.length(); i++) {
                   try {
                       JSONObject goal = data.getJSONObject("g" + String.valueOf(i + 1));
                       float total = goal.getInt("save") / goal.getInt("amount");
                       list.add(new ApiModel(i, goal.getString("url"), goal.getString("target"), total));
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
               }
               swingBottomInAnimationAdapter.notifyDataSetChanged();
           }

           @Override
           public void customOnSuccess(JSONObject string) {
               //Some Stuff here
           }
        });

        /*list.add(new ApiModel(5, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/0.jpg", "Monument walk tour", 0.75F));
        list.add(new ApiModel(6, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/1.jpg", "Diving in sea", 0.15f));
        list.add(new ApiModel(7, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/2.jpg", "Fall in Prague", 0.43f));
        list.add(new ApiModel(8, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/3.jpg", "San Francisco tour", 0.32f));
        list.add(new ApiModel(9, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/4.jpg", "Geyser on Island", 0.28f));
        list.add(new ApiModel(10, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/5.jpg", "Old house tour",0.94f));
        list.add(new ApiModel(11, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/6.jpg", "Hitchhike", 0.37f));
        list.add(new ApiModel(12, "http://pengaja.com/uiapptemplate/newphotos/listviews/googlecards/travel/7.jpg", "Beach walk tour", 0.21f));*/

        return list;
    }



}
