package com.alhikmah.materialdesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ContactsAdapter extends
        RecyclerView.Adapter<ContactsAdapter.ViewHolder>{

   // private List<Contact> mContacts;
    Context c;

    // Pass in the contact array into the constructor
    public ContactsAdapter(Context c) {
        this.c = c;
    }

    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvHometown;
        private Context context;

        public ViewHolder(Context context, View itemView) {
            super(itemView);
        }
    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.feed_list, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(context,contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder viewHolder, int position) {
//        // Get the data model based on position
//        Contact contact = mContacts.get(position);
//
//        // Set item views based on the data model
//        TextView textView = viewHolder.nameTextView;
//        textView.setText(contact.getName());
//
//        Button button = viewHolder.messageButton;
//
//        if (contact.isOnline()) {
//            button.setText("Message");
//            button.setEnabled(true);
//        }
//        else {
//            button.setText("Offline");
//            button.setEnabled(false);
//        }

    }

    // Return the total count of items
    @Override
    public int getItemCount() {
//        return mContacts.size();
        return 5;
    }
}
