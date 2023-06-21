package com.startandroid.calcproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListUpdater extends
        RecyclerView.Adapter<WordListUpdater.WordViewHolder>  {

    private final LinkedList<String> mWordList;
    private final LayoutInflater mInflater;
    static class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        final WordListUpdater mAdapter;

        public WordViewHolder(@NonNull View itemView, WordListUpdater adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.expression_item);
            this.mAdapter = adapter;
        }
    }

    public WordListUpdater(Context context,
                           LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordListUpdater.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(
                R.layout.history_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListUpdater.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

}
