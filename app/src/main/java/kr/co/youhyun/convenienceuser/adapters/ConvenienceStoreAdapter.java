package kr.co.youhyun.convenienceuser.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import kr.co.youhyun.convenienceuser.R;
import kr.co.youhyun.convenienceuser.datas.ConvenienceStore;

public class ConvenienceStoreAdapter extends ArrayAdapter<ConvenienceStore> {

    Context mContext;
    List<ConvenienceStore> mList;
    LayoutInflater inf;

    public ConvenienceStoreAdapter(@NonNull Context context, int resource, @NonNull List<ConvenienceStore> objects) {
        super(context, resource, objects);

        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        if (row == null){
            row = inf.inflate(R.layout.convenience_store_list_item, null);
        }

        ConvenienceStore data = mList.get(position);
        ImageView logoImg = row.findViewById(R.id.convenienceLogoImg);
        TextView nameTxt = row.findViewById(R.id.ConvenienceNameTxt);
        TextView phoneNumTxt = row.findViewById(R.id.conveniencePhoneNumTxt);

        nameTxt.setText(data.getStoreName());
        phoneNumTxt.setText(data.getStorePhoneNum());
        Glide.with(mContext).load(data.getLogoUrl()).into(logoImg);

        return row;

    }
}
