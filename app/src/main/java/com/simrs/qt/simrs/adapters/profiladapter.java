package com.simrs.qt.simrs.adapters;



import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.simrs.qt.simrs.R;
import com.simrs.qt.simrs.model.profilpasienmodel;

import java.util.ArrayList;

public class profiladapter extends ArrayAdapter<profilpasienmodel> implements View.OnClickListener{

    private ArrayList<profilpasienmodel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtnorekmed;


    }

    public profiladapter(ArrayList<profilpasienmodel>data, Context context) {
        super(context, R.layout.day_datarow, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        profilpasienmodel dataModel=(profilpasienmodel)object;

        switch (v.getId())
        {
            case R.id.item_info:
               // Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
               //         .setAction("No action", null).show();

           //    Snackbar.make(v, "Release date" + dataModel.getName(), )
           //     break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        profilpasienmodel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.profil_datarow, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name_pasien);
            viewHolder.txtnorekmed = (TextView) convertView.findViewById(R.id.no_med_rec);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }



        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtnorekmed.setText(dataModel.getno_med_rec());


        // Return the completed view to render on screen
        return convertView;
    }
}