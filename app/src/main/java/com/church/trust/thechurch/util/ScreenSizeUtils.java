package com.church.trust.thechurch.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Han on 2017-04-07.
 */

public class ScreenSizeUtils {

    public static DisplayMetrics metrics(Context context){
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    public static int actionbarSize(Context context){
        TypedArray styledAttributes = context.getTheme().obtainStyledAttributes( new int[] { android.R.attr.actionBarSize });
        int actionbarSize = (int) styledAttributes.getDimension(0,0);
        styledAttributes.recycle();
        return actionbarSize;
    }

    public static int statusbarSize(Context context){
        int statusbarSize=0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(resourceId>0){
            statusbarSize = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusbarSize;
    }

}
