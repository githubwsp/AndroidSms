package com.wsp.thinkpad.bb;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
    SmsReceiver myReceiver;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("aa","as");
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                test();
            }
        });
    }
    //将新短信设置为已读
    public void test(){
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), new String[] { "_id", "address", "read" }, "read = ? ", new String[] {"0" }, "date desc");
            if (cursor != null) {
                ContentValues values = new ContentValues();
                values.put("read", "1");
                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    Log.e("cky", "" + cursor.getInt(cursor.getColumnIndex("_id")) + "  ,  " + cursor.getString(cursor.getColumnIndex("address")));
                    int res = getContentResolver().update(Uri.parse("content://sms/inbox"), values, "_id=?", new String[] { "" + cursor.getInt(cursor.getColumnIndex("_id")) });
                    Log.e("cky","geng xin = "+res);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
        }
    }
}
