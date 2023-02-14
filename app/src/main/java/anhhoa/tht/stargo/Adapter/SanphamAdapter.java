package anhhoa.tht.stargo.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import anhhoa.tht.stargo.Activity.ChiTietSanPham;
import anhhoa.tht.stargo.Model.Sanpham;
import anhhoa.tht.stargo.R;
import anhhoa.tht.stargo.Ultil.CheckConnect;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {
    Context context;
    ArrayList<Sanpham> arraysanpham;

    public SanphamAdapter(Context context, ArrayList<Sanpham> arraysanpham) {
        this.context = context;
        this.arraysanpham = arraysanpham;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_spmoinhat, null);
        return new ItemHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SanphamAdapter.ItemHolder holder, int position) {
        Sanpham sanpham = arraysanpham.get(position);
        holder.txttensp.setText(sanpham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasp.setText("Giá : "+ decimalFormat.format(sanpham.getGiasp())+" Đ");
        Picasso.get().load(sanpham.getHinhsp()).placeholder(R.drawable.noimage)
                .error(R.drawable.error).into(holder.imghinhsp);
    }

    @Override
    public int getItemCount() {
        return arraysanpham.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imghinhsp;
        public TextView txttensp,txtgiasp;

        public ItemHolder(View itemView) {
            super(itemView);
            imghinhsp = itemView.findViewById(R.id.imageviewsanpham);
            txttensp = itemView.findViewById(R.id.textviewtensanpham);
            txtgiasp = itemView.findViewById(R.id.textviewgiasanpham);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, ChiTietSanPham.class);
                intent.putExtra("Thongtinsanpham",arraysanpham.get(getPosition()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                CheckConnect.ShowToast_shor(context,arraysanpham.get(getPosition()).getTensp());
                context.startActivity(intent);
            });
        }
    }
}
