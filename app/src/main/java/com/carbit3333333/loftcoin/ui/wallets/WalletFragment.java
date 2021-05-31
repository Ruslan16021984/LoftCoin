package com.carbit3333333.loftcoin.ui.wallets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.util.DisplayMetrics;
import android.util.TypedValue;
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

        final TypedValue value = new TypedValue();
        view.getContext().getTheme().resolveAttribute(R.attr.walletCardWith, value, true);
        final DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        final int padding = (int) (displayMetrics.widthPixels - value.getDimension(displayMetrics)) / 2;
        binding.recycler.setPadding(padding, 0, padding, 0);
        binding.recycler.setClipToPadding(false);

        binding.recycler.addOnScrollListener(new CarouselScroller());
        binding.recycler.setLayoutManager(new LinearLayoutManager(view.getContext(),
                RecyclerView.HORIZONTAL, false));
        binding.recycler.setAdapter(new WalletAdapter());
        binding.recycler.setVisibility(View.VISIBLE);
        binding.walletCard.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        walletSnapHelper.attachToRecyclerView(null);
    }

    private static class CarouselScroller extends RecyclerView.OnScrollListener {
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            final int centerX = (recyclerView.getLeft() + recyclerView.getRight()) / 2;
            for (int i = 0; i < recyclerView.getChildCount(); ++i) {
                final View child = recyclerView.getChildAt(i);
                final int childCenterX = (child.getLeft() + child.getRight()) / 2;
                final float childOffset = Math.abs(centerX - childCenterX) / (float) centerX; // 1.2, 0, 1.2
                float factor = (float) (Math.pow(0.85, childOffset)); // 2^1/1.2, 2^0, 2^// 0.4, 1, 0.4
                child.setScaleX(factor);
                child.setScaleY(factor);
            }
        }
    }
}