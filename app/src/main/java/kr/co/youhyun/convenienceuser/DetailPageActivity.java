package kr.co.youhyun.convenienceuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;

import kr.co.youhyun.convenienceuser.databinding.ActivityDetailPageBinding;
import kr.co.youhyun.convenienceuser.datas.ConvenienceStore;

public class DetailPageActivity extends BaseActivity {

    ConvenienceStore store = null;
    ActivityDetailPageBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_page);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.logoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void setValues() {

        store = (ConvenienceStore) getIntent().getSerializableExtra("store");

        binding.storeNameTxt.setText(store.getStoreName());
        binding.storePhoneNumTxt.setText(store.getStorePhoneNum());
        Glide.with(mContext).load(store.getLogoUrl()).into(binding.logoImg);
    }
}
