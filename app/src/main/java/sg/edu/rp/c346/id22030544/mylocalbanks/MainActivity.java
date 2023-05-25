package sg.edu.rp.c346.id22030544.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDbs;
    TextView tvOcbc;
    TextView tvUob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDbs = findViewById(R.id.textViewDbs);
        tvOcbc = findViewById(R.id.textViewOcbc);
        tvUob = findViewById(R.id.textViewUob);

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);


    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == tvDbs){
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");

        }
        else if(v == tvOcbc){
            menu.add(1,0,0,"Website");
            menu.add(1,1,1,"Contact the bank");

        }
        else if(v == tvUob){
            menu.add(2,0,0,"Website");
            menu.add(2,1,1,"Contact the bank");

        }


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }
    public boolean onContextItemSelected(MenuItem item) {
        int groupId = item.getGroupId();
        int itemId = item.getItemId();
        if(groupId == 0){
            if(itemId == 0){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
                startActivity(intent);

            }
            else{
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18001111111L
                ));
                startActivity(intentCall);
            }
        }
        else if(groupId == 1){
            if(itemId == 0){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
                startActivity(intent);

            }
            else{
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18003633333L
                ));
                startActivity(intentCall);
            }
        }
        else if(groupId == 2){
            if(itemId == 0){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.uob.com"));
                startActivity(intent);

            }
            else{
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18002222121L
                ));
                startActivity(intentCall);
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            tvDbs.setText("DBS");
            tvOcbc.setText("UOB");
            tvUob.setText("OCBC");

            return true;

        } else if (id == R.id.ChineseSelection) {
            tvDbs.setText("星展银行");
            tvOcbc.setText("华侨银行");
            tvUob.setText("大华银行");

            return true;

        }

        return super.onOptionsItemSelected(item);
    }


}