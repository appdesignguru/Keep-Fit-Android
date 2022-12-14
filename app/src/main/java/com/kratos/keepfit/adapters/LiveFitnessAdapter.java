package com.kratos.keepfit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kratos.keepfit.R;
import com.kratos.keepfit.core.OnItemClickListener;
import com.kratos.keepfit.entities.LiveFitness;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;

public class LiveFitnessAdapter extends RecyclerView.Adapter<LiveFitnessAdapter.LiveFitnessHolder> {

    private final List<LiveFitness> liveFitnessList;
    private final Context context;
    private final OnItemClickListener<LiveFitness> onItemClickListener;

    public LiveFitnessAdapter(List<LiveFitness> liveFitnessList, Context context,
                              OnItemClickListener<LiveFitness> onItemClickListener){
        this.liveFitnessList = liveFitnessList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    protected class LiveFitnessHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private View itemView;
        private final TextView nameTextView;
        private final TextView numberOfViews;
        private LiveFitness liveFitness;

        public LiveFitnessHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            itemView.setOnClickListener(this);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            numberOfViews = itemView.findViewById(R.id.views_number_text_view);
        }

        public void bind(LiveFitness liveFitness){
            this.liveFitness = liveFitness;
            nameTextView.setText(liveFitness.getName());
            numberOfViews.setText(liveFitness.getNumberOfViews());
            ImageView img = new ImageView(context);
            Picasso.get().load(liveFitness.getBackgroundImageDrawableResource()).into(img, new Callback() {
                @Override
                public void onSuccess() {
                    itemView.setBackground(img.getDrawable());
                }

                @Override
                public void onError(Exception e) {

                }
            });
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(liveFitness);
        }
    }

    @NonNull
    @Override
    public LiveFitnessHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_live_fitness, viewGroup, false);
        return new LiveFitnessHolder(view);
    }

    @Override
    public void onBindViewHolder(LiveFitnessHolder holder, final int position) {
        holder.bind(liveFitnessList.get(position));
    }

    @Override
    public int getItemCount() {
        return liveFitnessList.size();
    }
}