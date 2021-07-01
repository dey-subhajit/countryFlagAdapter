package com.example.countryflag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv_country;

    String[] country_name = {"India", "Bangladesh", "New zealand", "America"};
    int[] country_flag = {R.drawable.flag_ind, R.drawable.flag_bng, R.drawable.nwz, R.drawable.usa};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_country = findViewById(R.id.lv_country);
        lv_country.setAdapter(new CountryList());

        lv_country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  clied_str = country_name[position];
                /*if(clied_str == "India"){
                    Toast.makeText(MainActivity.this, "Sob Beche Dey Noren", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, clied_str, Toast.LENGTH_LONG).show();
                }*/
                Toast.makeText(MainActivity.this, clied_str, Toast.LENGTH_SHORT).show();
            }
        });
    }

    class CountryList extends BaseAdapter{

        @Override
        public int getCount() {
            return country_name.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inf = getLayoutInflater();
            View row = inf.inflate(R.layout.country_child, null);
            TextView tv_country = row.findViewById(R.id.tv_country);
            tv_country.setText(country_name[position]);
            ImageView iv_flag = row.findViewById(R.id.iv_flag);
            iv_flag.setImageResource(country_flag[position]);
            return row;
        }
    }
}