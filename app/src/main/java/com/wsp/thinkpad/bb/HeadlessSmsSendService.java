package com.wsp.thinkpad.bb;

/**
 * Created by ${吴心良}
 * on 2017/4/11.
 * description:
 */

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class HeadlessSmsSendService extends Service{

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("aa","HeadlessSmsSendService: "+intent);
        return null;
    }

}
