package cn.edu.scujcc.workoneweke;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    private List<User> users;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView simg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.studentname);
            simg = itemView.findViewById(R.id.studentimage);
        }
    }

    public ViewAdapter(List<User> user) {
        users = user;
    }

    //
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // 列表每项的内容
    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.name.setText(user.getName());
        holder.simg.setImageResource(user.getImg());
    }

    //列表有多少项
    @Override
    public int getItemCount() {
        return users.size();
    }
}
