package com.quentinrouet.listener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quentinrouet.listener.databinding.OiseauLineBinding;

/**
 * Created by quentin for Androkado on 17/03/2022.
 */
public class OiseauViewHolder extends RecyclerView.ViewHolder{
   OiseauLineBinding binding;
   //Sans dataBidning
   //public OiseauViewHolder(@NonNull View view) {
   public OiseauViewHolder(@NonNull OiseauLineBinding binding) {
      //Sans dataBinding
      //super(view);
      super(binding.getRoot());
      this.binding = binding;
   }
}
