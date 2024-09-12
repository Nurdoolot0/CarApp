package com.example.carapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.carapp.databinding.ItemCarBrandBinding;
import java.util.List;

public class CarBrandAdapter extends RecyclerView.Adapter<CarBrandAdapter.CarBrandViewHolder> {
    private List<CarBrand> carBrands;
    private OnCarBrandClickListener listener;

    public CarBrandAdapter(List<CarBrand> carBrands, OnCarBrandClickListener listener) {
        this.carBrands = carBrands;
        this.listener = listener;
    }

    @Override
    public CarBrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCarBrandBinding binding = ItemCarBrandBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CarBrandViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CarBrandViewHolder holder, int position) {
        CarBrand carBrand = carBrands.get(position);
        holder.binding.tvBrandName.setText(carBrand.getName());
        Glide.with(holder.itemView.getContext()).load(carBrand.getLogoUrl()).into(holder.binding.ivBrandLogo);
        holder.binding.tvBrandDescription.setText(carBrand.getDescription());

        holder.itemView.setOnClickListener(v -> listener.onCarBrandClick(carBrand));
    }

    @Override
    public int getItemCount() {
        return carBrands.size();
    }

    public static class CarBrandViewHolder extends RecyclerView.ViewHolder {
        private ItemCarBrandBinding binding;

        public CarBrandViewHolder(ItemCarBrandBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnCarBrandClickListener {
        void onCarBrandClick(CarBrand carBrand);
    }
}
