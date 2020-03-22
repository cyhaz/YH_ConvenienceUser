package kr.co.youhyun.convenienceuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import kr.co.youhyun.convenienceuser.adapters.ConvenienceStoreAdapter;
import kr.co.youhyun.convenienceuser.databinding.ActivityConvenienceStoreListViewBinding;
import kr.co.youhyun.convenienceuser.datas.ConvenienceStore;

public class ConvenienceStoreListViewActivity extends BaseActivity {

    List<ConvenienceStore> convenienceStores = new ArrayList<>();
    ConvenienceStoreAdapter convenienceStoreAdapter = null;
    ActivityConvenienceStoreListViewBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_convenience_store_list_view);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.convenienceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ConvenienceStore clickedStore = convenienceStores.get(position);

                Intent intent = new Intent(mContext, DetailPageActivity.class);
                intent.putExtra("store", clickedStore);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setValues() {

        convenienceStoreAdapter = new ConvenienceStoreAdapter(mContext, R.layout.convenience_store_list_item, convenienceStores);
        binding.convenienceListView.setAdapter(convenienceStoreAdapter);

        convenienceStores.add(new ConvenienceStore("CU", "02)1111-1111","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQTXhZnkuZP4eIlZAgqQse0Uicn3a5_FA9Fsvbi-CPrw5ipdz9_"));
        convenienceStores.add(new ConvenienceStore("GS25", "02)2222-2222","https://image.alba.kr/job/brand/0303D002.png"));
        convenienceStores.add(new ConvenienceStore("emart24", "02)3333-3333","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQC-F_1ZZDtVNp4riwwBUIJLA5eA9U1K-7aUIBxxBqIMjzVWOvm"));
        convenienceStores.add(new ConvenienceStore("7 eleven", "02)4444-4444","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRcsaKTxotxvxX8uBNpDTguLfliujs8Y8y3yOHZHfFavOqZonUq"));
        convenienceStores.add(new ConvenienceStore("MINI STOP", "02)5555-5555","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQH4SQTZppv2ahJwxI7OHZk41Cy79LKToJ519UvkZK_n_6RaLg5"));
        convenienceStores.add(new ConvenienceStore("Store Away", "02)6666-6666","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQKfkua88UwF3gLD-0yw5Kw90AVYh1bovY3pR2mjdrgLkn8NXJO"));
        convenienceStoreAdapter.notifyDataSetChanged();
    }
}
