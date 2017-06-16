package com.example.vincent.utilisateurs;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private ArrayList<User> personne;

    public Adapter(ArrayList<User> pPersonne){

        this.personne = pPersonne;
    }

    @Override
    public int getItemCount() {

        return personne.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listcell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.display(personne.get(position), holder);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView email;
        private final ImageView img;
        //private Pair<String, String> currentPair;

        public MyViewHolder(final View itemView) {

            super(itemView);
            name = ((TextView) itemView.findViewById(R.id.name));
            email = ((TextView) itemView.findViewById(R.id.email));
            img = ((ImageView) itemView.findViewById(R.id.img));

            /*itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentPair.first)
                            .setMessage(currentPair.second)
                            .show();
                }
            }); */
        }

        public void display(User pUser, MyViewHolder holder) {

            name.setText(pUser.getNom());
            email.setText(pUser.getEmail());
            Uri url = Uri.parse(pUser.getImg());
            Glide
                    .with(holder.img.getContext())
                    .load(url)
                    .into(img);
        }
    }
}