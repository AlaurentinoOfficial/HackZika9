package org.passinhos.passinhos.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.passinhos.passinhos.Models.Income;
import org.passinhos.passinhos.R;

import java.util.ArrayList;

public class IncomeAdapter extends ArrayAdapter<Income> {

    public static ArrayList<Income> dataSet;
    Context mContext;

    public IncomeAdapter(ArrayList<Income> data, Context context) {
        super(context, R.layout.income_list_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;
        TextView title;
        TextView descrip;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.income_list_item, parent, false);

            title = (TextView) convertView.findViewById(R.id.income_title);
            descrip = (TextView) convertView.findViewById(R.id.income_description);

            title.setText(dataSet.get(position).getTitle());
            descrip.setText(dataSet.get(position).getDescription());

            result=convertView;
        }

        return convertView;
    }
}
