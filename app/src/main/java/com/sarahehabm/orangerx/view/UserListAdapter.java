package com.sarahehabm.orangerx.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sarahehabm.orangerx.R;
import com.sarahehabm.orangerx.model.User;

import java.util.ArrayList;

/**
 * Created by Sarah E. Mostafa on 16-Mar-17.
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<User> users;

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_user, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = users.get(position);

        holder.textViewId.setText(String.valueOf(user.getId()));
        holder.textViewName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if (users == null)
            return 0;

        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId, textViewName;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewId = (TextView) itemView.findViewById(R.id.textView_userId);
            textViewName = (TextView) itemView.findViewById(R.id.textView_userName);
        }
    }
}
