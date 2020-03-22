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

                Intent intent = new Intent(mContext, )
            }
        });


//        binding.pizzaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                PizzaStore clickedStore = pizzaStores.get(position);
//
//                Intent intent = new Intent(mContext, PizzaStoreDetailActivity.class);
//                intent.putExtra("store", clickedStore);
//                startActivity(intent);
//
//            }
//        });

    }

    @Override
    public void setValues() {

    }
}
