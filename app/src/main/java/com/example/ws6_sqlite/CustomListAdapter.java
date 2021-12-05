package com.example.ws6_sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Pemain> Pemain;

    public CustomListAdapter(Activity activity, List<Pemain> Pemain) {
        this.activity = activity;
        this.Pemain = Pemain;
    }

    @Override
    public int getCount() {
        return Pemain.size();
    }

    @Override
    public Object getItem(int location) {
        return Pemain.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);

        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView accesoris = (TextView) convertView.findViewById(R.id.text_accesoris);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);

        Pemain m = Pemain.get(position);

        nama.setText("Nama : "+ m.get_nama());
        accesoris.setText("Accesoris : "+ m.get_accesoris());

        return convertView;
    }
}