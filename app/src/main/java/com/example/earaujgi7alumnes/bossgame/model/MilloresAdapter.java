package com.example.earaujgi7alumnes.bossgame.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.earaujgi7alumnes.bossgame.R;

import java.util.List;

/**
 * Created by mcalvico7.alumnes on 02/05/17.
 */

public class MilloresAdapter extends RecyclerView.Adapter<MilloresAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView punts;
        public TextView valor;
        public ImageButton messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            punts = (TextView) itemView.findViewById(R.id.punts);
            valor = (TextView) itemView.findViewById(R.id.percent);
            messageButton = (ImageButton) itemView.findViewById(R.id.fotoo);
        }
    }

    // Store a member variable for the contacts
    private List<Millora> mContacts;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public MilloresAdapter(Context context, List<Millora> contacts) {
        mContacts = contacts;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public MilloresAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_millora, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MilloresAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Millora millora = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.punts;
        textView.setText(millora.getCost());
        TextView textView2 = viewHolder.valor;
        textView2.setText(millora.getValor());
        ImageButton button = viewHolder.messageButton;
        button.setBackgroundResource(R.drawable.images);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}