package com.carbit3333333.loftcoin.ui.wallets;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carbit3333333.loftcoin.databinding.LiWalletBinding;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.ViewHolder> {
    private LayoutInflater inflater;

    @NonNull
    @Override
    public WalletAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LiWalletBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WalletAdapter.ViewHolder holder, int position) {

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        inflater = LayoutInflater.from(recyclerView.getContext());
    }

    @Override
    public int getItemCount() {
        return 10;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull  LiWalletBinding binding) {
            super(binding.getRoot());
        }
    }
}
