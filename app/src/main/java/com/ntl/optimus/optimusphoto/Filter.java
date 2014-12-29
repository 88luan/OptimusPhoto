package com.ntl.optimus.optimusphoto;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.SeekBar;

import com.jabistudio.androidjhlabs.filter.ExposureFilter;
import com.jabistudio.androidjhlabs.filter.OpacityFilter;
import com.jabistudio.androidjhlabs.filter.util.AndroidUtils;

/**
 * Created by N56 on 23/12/2014.
 */
public class Filter {
    private int value;

    Filter() {
        value=0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Bitmap handleBitmap(View view, Bitmap bitmap) {
        int[] colors = AndroidUtils.bitmapToIntArray(bitmap);

        if (view.getId() == R.id.effect_opacity) {
            OpacityFilter filter = new OpacityFilter();
            filter.setOpacity(value);
            colors = filter.filter(colors, bitmap.getWidth(), bitmap.getHeight());
            return Bitmap.createBitmap(colors, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_exposure) {
            ExposureFilter filter = new ExposureFilter();
            filter.setExposure(getExposure(value));
            colors = filter.filter(colors, bitmap.getWidth(), bitmap.getHeight());
            return Bitmap.createBitmap(colors, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        return null;
    }

    private float getExposure(int value){
        float retValue = 0;
        retValue = (float)(value / 100f);
        return retValue;
    }
}