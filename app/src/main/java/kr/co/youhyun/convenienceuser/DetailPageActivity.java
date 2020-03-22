package kr.co.youhyun.convenienceuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

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
                Intent intent = new Intent(mContext, LogoViewActivity.class);
                intent.putExtra("logoUrl", store.getLogoUrl());
                startActivity(intent);
            }
        });

        binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionListener pl = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        String phoneNumUri = String.format("tel:%s", store.getStorePhoneNum());
                        Uri uri = Uri.parse(phoneNumUri);
                        Intent intent = new Intent(Intent.ACTION_CALL, uri);
                        startActivity(intent);
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(mContext, "전화걸기 권한을 허가해야 사용가능합니다.", Toast.LENGTH_SHORT).show();
                    }
                };

                TedPermission
                        .with(mContext)
                        .setPermissionListener(pl)
                        .setDeniedMessage("[설정]에서 허용해야 사용가능합니다.")
                        .setPermissions(Manifest.permission.CALL_PHONE)
                        .check();
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
