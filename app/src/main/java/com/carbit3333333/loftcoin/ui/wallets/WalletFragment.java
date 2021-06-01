package com.carbit3333333.loftcoin.ui.wallets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carbit3333333.loftcoin.R;
import com.carbit3333333.loftcoin.databinding.FragmentWalletBinding;
import com.carbit3333333.loftcoin.ui.wallets.WalletAdapter;

public class WalletFragment extends Fragment {
    private SnapHelper walletSnapHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wallet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final FragmentWalletBinding binding = FragmentWalletBinding.bind(view);
        walletSnapHelper = new PagerSnapHelper();
        walletSnapHelper.attachToRecyclerView(binding.recycler);
        binding.recycler.setLayoutManager(new LinearLayoutManager(view.getContext(),
                RecyclerView.HORIZONTAL, false));
        binding.recycler.setAdapter(new WalletAdapter());
        binding.recycler.setVisibility(View.VISIBLE);
        binding.walletCard.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        walletSnapHelper.attachToRecyclerView(null);
        super.onDestroy();

    }
}