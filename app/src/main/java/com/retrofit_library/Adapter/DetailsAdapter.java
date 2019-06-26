package com.retrofit_library.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.retrofit_library.MainActivity;
import com.retrofit_library.Model.Contact;
import com.retrofit_library.R;

import java.util.ArrayList;
import java.util.List;

public class DetailsAdapter extends BaseAdapter {

    private ArrayList<String> dataList;
    private Context context;
    LayoutInflater inflater;

    public DetailsAdapter(Context context, ArrayList<String> dataList) {
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View view1 = inflater.inflate(R.layout.details_layout,viewGroup,false);

        TextView text = view1.findViewById(R.id.textview);
        text.setText(dataList.get(i));

        return view1;
    }
}
