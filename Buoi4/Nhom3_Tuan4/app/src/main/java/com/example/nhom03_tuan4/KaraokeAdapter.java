package com.example.nhom03_tuan4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KaraokeAdapter extends RecyclerView.Adapter<KaraokeAdapter.ViewHolder> {
    private List<KaraokeData> karaokeList;

    public KaraokeAdapter(List<KaraokeData> karaokeList) {
        this.karaokeList = karaokeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.karaoke_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KaraokeData karaoke = karaokeList.get(position);

        holder.maSoTextView.setText(karaoke.getMaSo());
        holder.tieuDeTextView.setText(karaoke.getTieuDe());
        holder.noiDungTextView.setText(karaoke.getNoiDung());
        holder.tacGiaTextView.setText(karaoke.getTacGia());
    }

    @Override
    public int getItemCount() {
        return karaokeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView maSoTextView;
        TextView tieuDeTextView;
        TextView noiDungTextView;
        TextView tacGiaTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            maSoTextView = itemView.findViewById(R.id.txtMaSo);
            tieuDeTextView = itemView.findViewById(R.id.txtTieuDe);
            noiDungTextView = itemView.findViewById(R.id.txtNoiDung);
            tacGiaTextView = itemView.findViewById(R.id.txtTacGia);
        }
    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            //Toast.makeText(con, "on Move", Toast.LENGTH_SHORT).show();
            return false;
        }
        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            //Toast.makeText(GioHangActivity.this, "on Swiped ", Toast.LENGTH_SHORT).show();
            //Remove swiped item from list and notify the RecyclerView
            int position = viewHolder.getAdapterPosition();
            karaokeList.remove(position);
            notifyDataSetChanged();

        }
    };
}
