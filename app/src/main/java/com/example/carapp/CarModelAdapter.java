package com.example.carapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.carapp.databinding.ItemCarModelBinding;
import com.example.carapp.databinding.ItemCarModelExpandedBinding;
import java.util.List;

public class CarModelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CarModel> carModels;
    private OnCarModelClickListener listener;

    private static final int VIEW_TYPE_COLLAPSED = 0;
    private static final int VIEW_TYPE_EXPANDED = 1;

    public CarModelAdapter(List<CarModel> carModels, OnCarModelClickListener listener) {
        this.carModels = carModels;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return carModels.get(position).isExpanded() ? VIEW_TYPE_EXPANDED : VIEW_TYPE_COLLAPSED;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_COLLAPSED) {
            ItemCarModelBinding binding = ItemCarModelBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new CollapsedViewHolder(binding);
        } else {
            ItemCarModelExpandedBinding binding = ItemCarModelExpandedBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ExpandedViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CarModel carModel = carModels.get(position);
        if (holder instanceof CollapsedViewHolder) {
            CollapsedViewHolder bindingHolder = (CollapsedViewHolder) holder;
            bindingHolder.binding.tvModelName.setText(carModel.getName());
            bindingHolder.binding.tvModelShortDescription.setText(carModel.getShortDescription());
            Glide.with(holder.itemView.getContext()).load(carModel.getImgUrl()).into(bindingHolder.binding.ivModelImage);

            bindingHolder.binding.getRoot().setOnClickListener(v -> {
                toggleExpansion(position);
            });
        } else if (holder instanceof ExpandedViewHolder) {
            ExpandedViewHolder bindingHolder = (ExpandedViewHolder) holder;
            bindingHolder.binding.tvExpandedModelName.setText(carModel.getName());
            bindingHolder.binding.tvExpandedModelFullDescription.setText(carModel.getFullDescription());
            Glide.with(holder.itemView.getContext()).load(carModel.getImgUrl()).into(bindingHolder.binding.ivExpandedModelImage);

            bindingHolder.binding.getRoot().setOnClickListener(v -> {
                toggleExpansion(position);
            });
        }
    }

    @Override
    public int getItemCount() {
        return carModels.size();
    }

    private void toggleExpansion(int position) {

        for (int i = 0; i < carModels.size(); i++) {
            if (i != position) {
                carModels.get(i).setExpanded(false);
                notifyItemChanged(i);
            }
        }


        CarModel carModel = carModels.get(position);
        carModel.setExpanded(!carModel.isExpanded());
        notifyItemChanged(position);
    }

    public class CollapsedViewHolder extends RecyclerView.ViewHolder {
        private final ItemCarModelBinding binding;

        public CollapsedViewHolder(ItemCarModelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public class ExpandedViewHolder extends RecyclerView.ViewHolder {
        private final ItemCarModelExpandedBinding binding;

        public ExpandedViewHolder(ItemCarModelExpandedBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnCarModelClickListener {
        void onCarModelClick(CarModel carModel);
    }
}


