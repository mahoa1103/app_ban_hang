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

public class LaptopAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arraylaptop;

    public LaptopAdapter(Context context, ArrayList<Sanpham> arraylaptop) {
        this.context = context;
        this.arraylaptop = arraylaptop;
    }

    @Override
    public int getCount() {
        return arraylaptop.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylaptop.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    public static class ViewHolder {
        TextView txttenlaptop,txtgialaptop,txtmotalaptop;
        ImageView imghinhlaptop;
    }
    @SuppressLint({"SetTextI18n", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_laptop,null);
            viewHolder.txttenlaptop = convertView.findViewById(R.id.textviewtenlaptop);
            viewHolder.txtgialaptop = convertView.findViewById(R.id.textviewgialaptop);
            viewHolder.txtmotalaptop = convertView.findViewById(R.id.textviewmotalaptop);
            viewHolder.imghinhlaptop = convertView.findViewById(R.id.imageviewlaptop);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (LaptopAdapter.ViewHolder) convertView.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(position);
        viewHolder.txttenlaptop.setText(sanpham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgialaptop.setText("Giá : "+ decimalFormat.format(sanpham.getGiasp())+" Đ");
        viewHolder.txtmotalaptop.setMaxLines(2);
        viewHolder.txtmotalaptop.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotalaptop.setText(sanpham.getMotasp());
        Picasso.get().load(sanpham.getHinhsp()).placeholder(R.drawable.noimage)
                .error(R.drawable.error).into(viewHolder.imghinhlaptop);

        return convertView;
    }
}
