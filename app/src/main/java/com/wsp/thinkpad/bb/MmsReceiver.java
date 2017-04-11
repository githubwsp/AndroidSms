package com.wsp.thinkpad.bb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ${吴心良}
 * on 2017/4/11.
 * description:
 */
public class MmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("aa","MmsReceiver: "+intent);
    }

}