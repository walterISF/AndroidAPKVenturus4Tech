package br.org.venturus.venturus4tech;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by vntlab on 05/02/18.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>
{
    public String[] mData = {"1", "2", "3", "Venturus"};

    private View mView;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(mView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView().setText(mData[position]);
    }

    @Override
    public int getItemCount()
    {
        return mData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tvName);
            getTextView();
        }
        public TextView getTextView()
        {
            return  mTextView;
        }
    }
}
