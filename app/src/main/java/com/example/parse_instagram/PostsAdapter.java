package com.example.parse_instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder>{

  private Context context;
  private List<Post> posts;

  public PostsAdapter(Context in_context, List<Post> in_posts) {
    this.context = in_context;
    this.posts = in_posts;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Post post = posts.get(position);
    holder.bind(post);
  }

  @Override
  public int getItemCount() {
    return posts.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    private TextView tvUsername;
    private TextView tvDescription;
    private ImageView ivImage;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      tvUsername = itemView.findViewById(R.id.tv_username);
      tvDescription = itemView.findViewById(R.id.tv_description);
      ivImage = itemView.findViewById(R.id.iv_image);
    }

    public void bind(Post post) {

      // Bind the post data to the view elements
      tvDescription.setText(post.getDescription());
      tvUsername.setText(post.getUser().getUsername());
      ParseFile image = post.getImage();
      if (image != null) {
        Glide.with(context).load(image.getUrl()).into(ivImage);
      }
    }
  }
}
