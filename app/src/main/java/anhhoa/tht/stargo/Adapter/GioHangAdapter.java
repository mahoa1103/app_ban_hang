package anhhoa.tht.stargo.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import anhhoa.tht.stargo.Activity.GioHang;
import anhhoa.tht.stargo.Activity.MainActivity;
import anhhoa.tht.stargo.Model.Giohang;
import anhhoa.tht.stargo.R;

public class GioHangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Giohang> manggiohang;

    public GioHangAdapter(Context context, ArrayList<Giohang> manggiohang) {
        this.context = context;
        this.manggiohang = manggiohang;
    }

    @Override
    public int getCount() {
        return manggiohang.size();
    }

    @Override
    public Object getItem(int position) {
        return manggiohang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public static class ViewHolder{
        ImageView imggiohang;
        TextView txttenhang,txtgiahang;
        Button btnmis,btnvalues,btnpls;
    }

    @SuppressLint({"SetTextI18n", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_giohang,null);
            viewHolder.txttenhang = convertView.findViewById(R.id.textviewtengiohang);
            viewHolder.txtgiahang = convertView.findViewById(R.id.textviewgiagiohang);
            viewHolder.imggiohang = convertView.findViewById(R.id.imagegiohang);
            viewHolder.btnmis = convertView.findViewById(R.id.buttonminus);
            viewHolder.btnvalues = convertView.findViewById(R.id.buttonvalues);
            viewHolder.btnpls = convertView.findViewById(R.id.buttonplus);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Giohang giohang = (Giohang) getItem(position);
        viewHolder.txttenhang.setText(giohang.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiahang.setText("Giá : "+ decimalFormat.format(giohang.getGiasp())+" Đ");
        Picasso.get().load(giohang.getHinhsp()).placeholder(R.drawable.noimage)
                .error(R.drawable.error).into(viewHolder.imggiohang);
        viewHolder.btnvalues.setText(giohang.getSoluongsp() +  "");
        int sl = Integer.parseInt(viewHolder.btnvalues.getText().toString());
        if(sl >= 10){
            viewHolder.btnpls.setVisibility(View.INVISIBLE);
            viewHolder.btnmis.setVisibility(View.VISIBLE);
        }else if (sl <= 1 ){
            viewHolder.btnmis.setVisibility(View.INVISIBLE);
        }else if(sl >= 1){
            viewHolder.btnmis.setVisibility(View.VISIBLE);
            viewHolder.btnpls.setVisibility(View.VISIBLE);
        }
        viewHolder.btnpls.setOnClickListener(v -> {
            int slmoinhat = Integer.parseInt(viewHolder.btnvalues.getText().toString()) +1;
            int slht = MainActivity.manggiohang.get(position).getSoluongsp();
            long giaht = MainActivity.manggiohang.get(position).getGiasp();
            MainActivity.manggiohang.get(position).setSoluongsp(slmoinhat);
            long giamoinhat = (giaht * slmoinhat) / slht;
            MainActivity.manggiohang.get(position).setGiasp(giamoinhat);
            DecimalFormat decimalFormat1 = new DecimalFormat("###,###,###");
            viewHolder.txtgiahang.setText("Giá : "+ decimalFormat1.format(giamoinhat)+" Đ");
            GioHang.EventUtil();
            if(slmoinhat > 9){
                viewHolder.btnpls.setVisibility(View.INVISIBLE);
                viewHolder.btnmis.setVisibility(View.VISIBLE);
                viewHolder.btnvalues.setText(String.valueOf(slmoinhat));

            }else {
                viewHolder.btnmis.setVisibility(View.VISIBLE);
                viewHolder.btnpls.setVisibility(View.VISIBLE);
                viewHolder.btnvalues.setText(String.valueOf(slmoinhat));
            }
        });
        viewHolder.btnmis.setOnClickListener(v -> {
            int slmoinhat = Integer.parseInt(viewHolder.btnvalues.getText().toString()) - 1;
            int slht = MainActivity.manggiohang.get(position).getSoluongsp();
            long giaht = MainActivity.manggiohang.get(position).getGiasp();
            MainActivity.manggiohang.get(position).setSoluongsp(slmoinhat);
            long giamoinhat = (giaht * slmoinhat) / slht;
            MainActivity.manggiohang.get(position).setGiasp(giamoinhat);
            DecimalFormat decimalFormat1 = new DecimalFormat("###,###,###");
            viewHolder.txtgiahang.setText("Giá : "+ decimalFormat1.format(giamoinhat)+" Đ");
            GioHang.EventUtil();
            if(slmoinhat < 2){
                viewHolder.btnmis.setVisibility(View.INVISIBLE);
                viewHolder.btnpls.setVisibility(View.VISIBLE);
                viewHolder.btnvalues.setText(String.valueOf(slmoinhat));

            }else {
                viewHolder.btnmis.setVisibility(View.VISIBLE);
                viewHolder.btnpls.setVisibility(View.VISIBLE);
                viewHolder.btnvalues.setText(String.valueOf(slmoinhat));
            }
        });
        return convertView;
    }
}
