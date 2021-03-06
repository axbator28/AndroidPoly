package com.example.axbat.tp_17_09.ViewHolders;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.Commentaire;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentViewHolder extends RecyclerView.ViewHolder {

    private TextView user;
    private TextView comment;
    private CircleImageView image;

    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);
        this.user=itemView.findViewById(R.id.com_username);
        this.comment=itemView.findViewById(R.id.com_text);
        this.image=itemView.findViewById(R.id.com_image);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void layoutForCategory(Commentaire com){
        if(com!=null){
            if(com.getUsername()!=null) {
                user.setText(com.getUsername());
            }
            if(com.getComment()!=null) {
                comment.setText(com.getComment());
            }
            if(com.getUserImage()!=null){
                image.setImageResource(com.getUserImage());
                image.setImageTintList(null);
            }
        }
    }
}
