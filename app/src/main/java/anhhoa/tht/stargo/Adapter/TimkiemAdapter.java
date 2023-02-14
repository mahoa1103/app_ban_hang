package anhhoa.tht.stargo.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import anhhoa.tht.stargo.Model.Sanpham;
import anhhoa.tht.stargo.R;

public class TimkiemAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> mangtimkiem;

    public TimkiemAdapter(Context context, ArrayList<Sanpham> mangtimkiem) {
        this.context = context;
        this.mangtimkiem = mangtimkiem;
    }

    @Override
    public int getCount() {
        return mangtimkiem.size();
    }

    @Override
    public Object getItem(int position) {
        return mangtimkiem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public static class ViewHolder{
        TextView txttentk,txtgiatk,txtmotatk;
        ImageView imghinhtk;
    }

    @SuppressLint({"SetTextI18n", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_timkiem,null);
            viewHolder.txttentk = convertView.findViewById(R.id.textviewtentimkiem);
            viewHolder.txtgiatk = convertView.findViewById(R.id.textviewgiatimkiem);
            viewHolder.txtmotatk = convertView.findViewById(R.id.textviewmotatimkiem);
            viewHolder.imghinhtk = convertView.findViewById(R.id.imageviewtimkiem);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(position);
        viewHolder.txttentk.setText(sanpham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiatk.setText("Giá : "+ decimalFormat.format(sanpham.getGiasp())+" Đ");
        viewHolder.txtmotatk.setMaxLines(2);
        viewHolder.txtmotatk.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotatk.setText(sanpham.getMotasp());
        Picasso.get().load(sanpham.getHinhsp()).placeholder(R.drawable.noimage)
                .error(R.drawable.error).into(viewHolder.imghinhtk);
        return convertView;
    }
}
