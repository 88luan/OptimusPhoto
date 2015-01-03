package com.ntl.optimus.optimusphoto;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.SeekBar;

import com.jabistudio.androidjhlabs.filter.BlockFilter;
import com.jabistudio.androidjhlabs.filter.ContrastFilter;
import com.jabistudio.androidjhlabs.filter.Curve;
import com.jabistudio.androidjhlabs.filter.CurvesFilter;
import com.jabistudio.androidjhlabs.filter.DiffuseFilter;
import com.jabistudio.androidjhlabs.filter.ExposureFilter;
import com.jabistudio.androidjhlabs.filter.GainFilter;
import com.jabistudio.androidjhlabs.filter.GammaFilter;
import com.jabistudio.androidjhlabs.filter.GlowFilter;
import com.jabistudio.androidjhlabs.filter.GrayscaleFilter;
import com.jabistudio.androidjhlabs.filter.InvertFilter;
import com.jabistudio.androidjhlabs.filter.MaximumFilter;
import com.jabistudio.androidjhlabs.filter.MinimumFilter;
import com.jabistudio.androidjhlabs.filter.NoiseFilter;
import com.jabistudio.androidjhlabs.filter.OilFilter;
import com.jabistudio.androidjhlabs.filter.OpacityFilter;
import com.jabistudio.androidjhlabs.filter.RGBAdjustFilter;
import com.jabistudio.androidjhlabs.filter.SmartBlurFilter;
import com.jabistudio.androidjhlabs.filter.util.AndroidUtils;

/**
 * Created by N56 on 23/12/2014.
 */
public class Filter {
    private int value;
    private int value1;
    private int value2;
    private int value_0;
    private int value1_0;
    private int value2_0;

    private static Filter instance = null;

    private Filter() {
        value=100;
        value1=100;
        value2=100;
        value_0=0;
        value1_0 = 0;
        value2_0 = 0;

    }

    public static Filter getInstance() {
        if (instance == null) {
            instance = new Filter();
        }
        return instance;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public void setValue_0(int value_0) {
        this.value_0 = value_0;
    }

    public void setValue1_0(int value1_0) {
        this.value1_0 = value1_0;
    }

    public void setValue2_0(int value2_0) {
        this.value2_0 = value2_0;
    }


    public Bitmap handleBitmap(View view, Bitmap SrcBitmap) {
        int[] colors = AndroidUtils.bitmapToIntArray(SrcBitmap);

        if (view.getId() == R.id.effect_opacity) {
            OpacityFilter filter = new OpacityFilter();
            filter.setOpacity(value);

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_exposure) {
            ExposureFilter filter = new ExposureFilter();
            filter.setExposure(getValue(value));

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_contrast) {
            ContrastFilter filter = new ContrastFilter();
            filter.setBrightness(getValue(value1));
            filter.setContrast(getValue(value2));

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_curves) {
            CurvesFilter filter = new CurvesFilter();
            Curve curve = new Curve();
            curve.addKnot(getValue(value1_0), getValue(value2_0));
            filter.setCurve(curve);

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_gain) {
            GainFilter filter = new GainFilter();
            filter.setGain(getValue(value1_0));
            filter.setBias(getValue(value2_0));

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_gamma) {
            GammaFilter filter = new GammaFilter();
            filter.setGamma(getValue(value));

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_grayscale) {
            GrayscaleFilter filter = new GrayscaleFilter();

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_invert) {
            InvertFilter filter = new InvertFilter();

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_redAdjust) {
            RGBAdjustFilter filter = new RGBAdjustFilter();
            filter.setRFactor(getRGBAdjust(value));

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_greenAdjust) {
            RGBAdjustFilter filter = new RGBAdjustFilter();
            filter.setGFactor(getRGBAdjust(value));

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_blueAdjust) {
            RGBAdjustFilter filter = new RGBAdjustFilter();
            filter.setBFactor(getRGBAdjust(value));

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_block) {
            BlockFilter filter = new BlockFilter();
            if(value == 0){
                value = 1;
            }
            filter.setBlockSize(value);

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_diffuse) {
            DiffuseFilter filter = new DiffuseFilter();
            filter.setScale(value);

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_noise) {
            NoiseFilter filter = new NoiseFilter();
            filter.setAmount(value1_0);
            filter.setDensity(value2_0);

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_smartBlur) {
            SmartBlurFilter filter = new SmartBlurFilter();
            filter.setRadius(value_0);
            filter.setThreshold(value_0);

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_glow) {
            GlowFilter filter = new GlowFilter();
            //Amount is 0~1 value
            filter.setAmount(getValue(value_0));
            filter.setRadius(value_0);

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_maximum) {
            MaximumFilter filter = new MaximumFilter();

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_minimum) {
            MinimumFilter filter = new MinimumFilter();

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        else if(view.getId() == R.id.effect_oil) {
            OilFilter filter = new OilFilter();
            filter.setLevels(value_0);
            filter.setRange(value_0);

            colors = filter.filter(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight());
            return Bitmap.createBitmap(colors, SrcBitmap.getWidth(), SrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        return null;
    }

    private float getValue(int value){
        float retValue = 0;
        retValue = (float)(value / 100f);
        return retValue;
    }

    private float getRGBAdjust(int value){
        float retValue = 0;
        retValue = (float)((value - 100) / 100f);
        return retValue;
    }
}
