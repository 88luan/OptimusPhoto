package com.ntl.optimus.optimusphoto;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ColorAdjustmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ColorAdjustmentFragment extends Fragment {

    private SeekBar OpacitySeekBar, ExposureSeekBar, BrightnessSeekBar, ContrastSeekBar, KXCurvesSeekBar, KYCurvesSeekBar,
            GainSeekBar, BaisSeekBar, GammaSeekBar, RedAdjustSeekBar, GreenAdjustSeekBar, BlueAdjustSeekBar, BlockSeekBar,
            DiffuseSeekBar, AmountSeekBar, DensitySeekBar, BlurSeekBar, GlowSeekBar, OilSeekBar;
    private LinearLayout OpacityLayout, ExposureLayout, ContrastLayout, CurvesLayout,
            GainLayout, GammaLayout, RedAdjustLayout, GreenAdjustLayout, BlueAdjustLayout, BlockLayout,
            DiffuseLayout, NoiseLayout, BlurLayout, GlowLayout, OilLayout;
    private TextView OpacityText, ExposureText, BrightnessText, ContrastText, KXCurvesText, KYCurvesText,
            GainText, BaisText, GammaText, RedAdjustText, GreenAdjustText, BlueAdjustText, BlockText,
            DiffuseText, AmountText, DensityText, BlurText, GlowText, OilText;

    private OnFragmentInteractionListener mListener;

    private View mRootView;

    public ColorAdjustmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_color_adjustment, container, false);
        findId();
        return mRootView;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onHandleBitmap(View v);

        public void onLoadSrcBitmap();
    }

    private void findId() {
        OpacitySeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_opacity);
        ExposureSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_exposure);
        BrightnessSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_brightness);
        ContrastSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_contrast);
        KXCurvesSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_KX);
        KYCurvesSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_KY);
        GainSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_gain);
        BaisSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_bais);
        GammaSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_gamma);
        RedAdjustSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_redAdjust);
        GreenAdjustSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_greenAdjust);
        BlueAdjustSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_blueAdjust);
        BlockSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_block);
        DiffuseSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_diffuse);
        AmountSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_amount);
        DensitySeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_density);
        BlurSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_blur);
        GlowSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_glow);
        OilSeekBar = (SeekBar) mRootView.findViewById(R.id.seekBar_oil);

        OpacityText = (TextView) mRootView.findViewById(R.id.text_opacity);
        ExposureText = (TextView) mRootView.findViewById(R.id.text_exposure);
        BrightnessText = (TextView) mRootView.findViewById(R.id.text_brightness);
        ContrastText = (TextView) mRootView.findViewById(R.id.text_contrast);
        KXCurvesText = (TextView) mRootView.findViewById(R.id.text_KX);
        KYCurvesText = (TextView) mRootView.findViewById(R.id.text_KY);
        GainText = (TextView) mRootView.findViewById(R.id.text_gain);
        BaisText = (TextView) mRootView.findViewById(R.id.text_bais);
        GammaText = (TextView) mRootView.findViewById(R.id.text_gamma);
        RedAdjustText = (TextView) mRootView.findViewById(R.id.text_redAdjust);
        GreenAdjustText = (TextView) mRootView.findViewById(R.id.text_greenAdjust);
        BlueAdjustText = (TextView) mRootView.findViewById(R.id.text_blueAdjust);
        BlockText = (TextView) mRootView.findViewById(R.id.text_block);
        DiffuseText = (TextView) mRootView.findViewById(R.id.text_diffuse);
        AmountText = (TextView) mRootView.findViewById(R.id.text_amount);
        DensityText = (TextView) mRootView.findViewById(R.id.text_density);
        BlurText = (TextView) mRootView.findViewById(R.id.text_blur);
        GlowText = (TextView) mRootView.findViewById(R.id.text_glow);
        OilText = (TextView) mRootView.findViewById(R.id.text_oil);

        OpacityLayout = (LinearLayout) mRootView.findViewById(R.id.layout_opacity);
        ExposureLayout = (LinearLayout) mRootView.findViewById(R.id.layout_exposure);
        ContrastLayout = (LinearLayout) mRootView.findViewById(R.id.layout_contrast);
        CurvesLayout = (LinearLayout) mRootView.findViewById(R.id.layout_curves);
        GainLayout = (LinearLayout) mRootView.findViewById(R.id.layout_gain);
        GammaLayout = (LinearLayout) mRootView.findViewById(R.id.layout_gamma);
        RedAdjustLayout = (LinearLayout) mRootView.findViewById(R.id.layout_redAdjust);
        GreenAdjustLayout = (LinearLayout) mRootView.findViewById(R.id.layout_greenAdjust);
        BlueAdjustLayout = (LinearLayout) mRootView.findViewById(R.id.layout_blueAdjust);
        BlockLayout = (LinearLayout) mRootView.findViewById(R.id.layout_block);
        DiffuseLayout = (LinearLayout) mRootView.findViewById(R.id.layout_diffuse);
        NoiseLayout = (LinearLayout) mRootView.findViewById(R.id.layout_noise);
        BlurLayout = (LinearLayout) mRootView.findViewById(R.id.layout_blur);
        GlowLayout = (LinearLayout) mRootView.findViewById(R.id.layout_glow);
        OilLayout = (LinearLayout) mRootView.findViewById(R.id.layout_oil);
    }

    private void invisibleSeekBarLayout() {
        OpacityLayout.setVisibility(View.INVISIBLE);
        ExposureLayout.setVisibility(View.INVISIBLE);
        ContrastLayout.setVisibility(View.INVISIBLE);
        CurvesLayout.setVisibility(View.INVISIBLE);
        GainLayout.setVisibility(View.INVISIBLE);
        GammaLayout.setVisibility(View.INVISIBLE);
        RedAdjustLayout.setVisibility(View.INVISIBLE);
        GreenAdjustLayout.setVisibility(View.INVISIBLE);
        BlueAdjustLayout.setVisibility(View.INVISIBLE);
        BlockLayout.setVisibility(View.INVISIBLE);
        DiffuseLayout.setVisibility(View.INVISIBLE);
        NoiseLayout.setVisibility(View.INVISIBLE);
        BlurLayout.setVisibility(View.INVISIBLE);
        GlowLayout.setVisibility(View.INVISIBLE);
        OilLayout.setVisibility(View.INVISIBLE);
    }

    public void setupSeekBar(final View v) {
        invisibleSeekBarLayout();

        switch (v.getId()) {
            case R.id.effect_natural:
                mListener.onLoadSrcBitmap();
                break;
            case R.id.effect_opacity:
                OpacityLayout.setVisibility(View.VISIBLE);
                OpacitySeekBar.setMax(255);
                OpacitySeekBar.setProgress(255);
                OpacityText.setText("Opacity: 100");
                OpacitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue(progress);
                        OpacityText.setText("Opacity: " + progress * 100 / 255);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_exposure:
                ExposureLayout.setVisibility(View.VISIBLE);
                ExposureSeekBar.setMax(500);
                ExposureSeekBar.setProgress(100);
                ExposureText.setText("Exposure: 100");
                ExposureSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue(progress);
                        ExposureText.setText("Exposure: " + progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_contrast:
                ContrastLayout.setVisibility(View.VISIBLE);
                BrightnessSeekBar.setMax(200);
                ContrastSeekBar.setMax(200);
                BrightnessSeekBar.setProgress(100);
                ContrastSeekBar.setProgress(100);
                BrightnessText.setText("Brightness: 0");
                ContrastText.setText("Contrast: 0");
                BrightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue1(progress);
                        BrightnessText.setText("Brightness: "+ (progress-100));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                ContrastSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue2(progress);
                        ContrastText.setText("Contrast: "+ (progress-100));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_curves:
                CurvesLayout.setVisibility(View.VISIBLE);
                KXCurvesSeekBar.setMax(100);
                KYCurvesSeekBar.setMax(100);
                KXCurvesSeekBar.setProgress(0);
                KYCurvesSeekBar.setProgress(0);
                KXCurvesText.setText("KX: 0");
                KYCurvesText.setText("KY: 0");
                KXCurvesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue1_0(progress);
                        KXCurvesText.setText("KX: "+ progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                KYCurvesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue2_0(progress);
                        KYCurvesText.setText("KY: "+ progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_gain:
                GainLayout.setVisibility(View.VISIBLE);
                GainSeekBar.setMax(100);
                BaisSeekBar.setMax(100);
                GainSeekBar.setProgress(0);
                BaisSeekBar.setProgress(0);
                GainText.setText("Gain: 0");
                BaisText.setText("Bais: 0");
                GainSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue1_0(progress);
                        GainText.setText("Gain: "+ progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                BaisSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue2_0(progress);
                        BaisText.setText("Bais: "+ progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_gamma:
                GammaLayout.setVisibility(View.VISIBLE);
                GammaSeekBar.setMax(500);
                GammaSeekBar.setProgress(100);
                GammaText.setText("Gamma: 100");
                GammaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue(progress);
                        GammaText.setText("Gamma: " + progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_grayscale:
                mListener.onHandleBitmap(v);
                break;
            case R.id.effect_invert:
                mListener.onHandleBitmap(v);
                break;
            case R.id.effect_redAdjust:
                RedAdjustLayout.setVisibility(View.VISIBLE);
                RedAdjustSeekBar.setMax(200);
                RedAdjustSeekBar.setProgress(100);
                RedAdjustText.setText("Red: 0");
                RedAdjustSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue(progress);
                        RedAdjustText.setText("Red: " + (progress-100));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_greenAdjust:
                GreenAdjustLayout.setVisibility(View.VISIBLE);
                GreenAdjustSeekBar.setMax(200);
                GreenAdjustSeekBar.setProgress(100);
                GreenAdjustText.setText("Green: 0");
                GreenAdjustSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue(progress);
                        GreenAdjustText.setText("Green: " + (progress-100));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_blueAdjust:
                BlueAdjustLayout.setVisibility(View.VISIBLE);
                BlueAdjustSeekBar.setMax(200);
                BlueAdjustSeekBar.setProgress(100);
                BlueAdjustText.setText("Blue: 0");
                BlueAdjustSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue(progress);
                        BlueAdjustText.setText("Blue: " + (progress-100));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_block:
                BlockLayout.setVisibility(View.VISIBLE);
                BlockSeekBar.setMax(100);
                BlockSeekBar.setProgress(0);
                BlockText.setText("Block: 0");
                BlockSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue(progress);
                        BlockText.setText("Block: " + (progress));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_diffuse:
                DiffuseLayout.setVisibility(View.VISIBLE);
                DiffuseSeekBar.setMax(100);
                DiffuseSeekBar.setProgress(0);
                DiffuseText.setText("Diffuse: 0");
                DiffuseSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue(progress);
                        DiffuseText.setText("Diffuse: " + (progress));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_noise:
                NoiseLayout.setVisibility(View.VISIBLE);
                AmountSeekBar.setMax(100);
                DensitySeekBar.setMax(100);
                AmountSeekBar.setProgress(0);
                DensitySeekBar.setProgress(0);
                AmountText.setText("Amount: 0");
                DensityText.setText("Density: 0");
                AmountSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue1_0(progress);
                        AmountText.setText("Amount: " + progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                DensitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue2_0(progress);
                        DensityText.setText("Density: "+ progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_smartBlur:
                BlurLayout.setVisibility(View.VISIBLE);
                BlurSeekBar.setMax(100);
                BlurSeekBar.setProgress(0);
                BlurText.setText("Radius: 0");
                BlurSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue_0(progress);
                        BlurText.setText("Radius: " + (progress));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_glow:
                GlowLayout.setVisibility(View.VISIBLE);
                GlowSeekBar.setMax(100);
                GlowSeekBar.setProgress(0);
                GlowText.setText("Radius: 0");
                GlowSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue_0(progress);
                        GlowText.setText("Radius: " + (progress));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
            case R.id.effect_maximum:
                mListener.onHandleBitmap(v);
                break;
            case R.id.effect_minimum:
                mListener.onHandleBitmap(v);
                break;
            case R.id.effect_oil:
                OilLayout.setVisibility(View.VISIBLE);
                OilSeekBar.setMax(10);
                OilSeekBar.setProgress(0);
                OilText.setText("Oil: 0");
                OilSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Filter.getInstance().setValue_0(progress);
                        OilText.setText("Oil: " + (progress));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mListener.onHandleBitmap(v);
                    }
                });
                break;
        }
    }



}
