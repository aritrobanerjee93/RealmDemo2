package com.example.realmdemo2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private RealmResults<Person> mPersonRealmResults;
    private Context mContext;
    private static final String TAG = "Experiment";
    private int count;

    public MyAdapter(RealmResults<Person> persons, Context context){
        mPersonRealmResults = persons;
        mContext = context;
        count = 0;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        Log.i(TAG, "onCreateViewHolder: Triggered And Also the Parent Id is " + parent.getId());
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: Triggered");
        Person person = mPersonRealmResults.get(position);
        holder.name.setText(person.getName());
        holder.email.setText(person.getEmail());
        holder.phone.setText(person.getPhone());
        holder.age.setText(person.getAge()+"");
    }

    @Override
    public int getItemCount() {
        return mPersonRealmResults.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView email;
        private TextView phone;
        private TextView age;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            count++;
            Log.i(TAG, "MyViewHolder: Number of Active ViewHolders:" + count);
            name = itemView.findViewById(R.id.name_tv);
            email = itemView.findViewById(R.id.email_tv);
            phone = itemView.findViewById(R.id.phone_tv);
            age = itemView.findViewById(R.id.age_tv);
        }
    }
}
