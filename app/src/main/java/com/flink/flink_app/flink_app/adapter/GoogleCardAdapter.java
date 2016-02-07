package com.flink.flink_app.flink_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.flink.flink_app.flink_app.R;
import com.flink.flink_app.flink_app.font.RobotoTextView;
import com.flink.flink_app.flink_app.model.ApiModel;
import com.flink.flink_app.flink_app.util.ImageUtil;
import com.flink.flink_app.flink_app.views.CustomProgress;

import java.util.List;

/**
 * Created by ligorio on 04/02/16.
 */
public class GoogleCardAdapter extends ArrayAdapter<ApiModel>{

    private LayoutInflater mInflater;

    public GoogleCardAdapter(Context context, List<ApiModel> items) {
        super(context, 0, items);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final ViewHolder holder;

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_item_google_cards,parent,false);
            holder = new ViewHolder();

            holder.image = (ImageView) convertView.findViewById(R.id.GcardImage);
            holder.title = (TextView) convertView.findViewById(R.id.GcargTitle);
            holder.bar = (CustomProgress) convertView.findViewById(R.id.gCardBar);
            holder.amount = (RobotoTextView) convertView.findViewById(R.id.monto);
            convertView.setTag(holder);

        }else{ holder = (ViewHolder) convertView.getTag(); }

        ApiModel item = getItem(position);
        ImageUtil.displayImage(holder.image, item.getImageURL(), null);
        holder.title.setText(item.getText());
        holder.bar.setMaximumPercentage(item.getProgress());
        holder.bar.setProgressColor(R.color.material_blue_900);
        holder.bar.setProgressBackgroundColor(R.color.material_blue_600);
        holder.bar.useRoundedRectangleShape(30.0f);
        holder.amount.setText("$10,000.00");

        return convertView;
    }

    private static class ViewHolder {
        public ImageView image;
        public TextView title;
        public CustomProgress bar;
        public  RobotoTextView amount;
    }






}

