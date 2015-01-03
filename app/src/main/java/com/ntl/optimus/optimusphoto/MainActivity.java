package com.ntl.optimus.optimusphoto;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.ScaleImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class MainActivity extends ActionBarActivity implements ColorAdjustmentFragment.OnFragmentInteractionListener{
    private static final String IMAGE_DIRECTORY_NAME = "Optimus NTL";
    private static final int CAMERA_CAPTURE_REQUEST_CODE = 100;
    private static final int GALLERY_REQUEST_CODE = 200;
    public static final int SIZE_HEIGHT = 1200;
    public static final int SIZE_WIDTH = 1600;
    public static String mSrcFileUri; // file uri to store image
    public ScaleImageView mZoomImageView;
    private DialogFragment mChooseDialog;
    public Bitmap mSrcBitmap;
    public Bitmap mDestinationBitmap;
    ColorAdjustmentFragment colorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mZoomImageView = (ScaleImageView) findViewById(R.id.mainScaleImage);

        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            colorFragment = new ColorAdjustmentFragment();

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction().add(R.id.fragment_container, colorFragment).commit();
        }
        //findId();

        showDialog();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_gallery) {
            openGallery(MainActivity.this);
        }
        else if (id == R.id.action_camera) {
            openCamera(MainActivity.this);
        }
        else if (id == R.id.action_save) {
            new SavingImage().execute(mDestinationBitmap);
        }

        return super.onOptionsItemSelected(item);
    }

    void showDialog() {
        // Create the fragment and show it as a dialog.
        mChooseDialog = MyDialogFragment.newInstance();
        mChooseDialog.show(getFragmentManager(), "dialog");
        mChooseDialog.setCancelable(true);
    }

    @Override
    public void onHandleBitmap(View v) {
        new HandleBitmapTask(v, mSrcBitmap).execute();
    }

    @Override
    public void onLoadSrcBitmap() {
        mZoomImageView.setImageBitmap(mSrcBitmap);
    }

    public static class MyDialogFragment extends DialogFragment {
        static MyDialogFragment newInstance() {
            return new MyDialogFragment();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //cài đặt theme cho dialog
            int style = DialogFragment.STYLE_NORMAL;
            int theme = android.R.style.Theme_Holo_Light_Dialog_NoActionBar;  //không có Title
            setStyle(style, theme);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            //NO Title
            //getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            View v = inflater.inflate(R.layout.fragment_dialog, container, false);

            ImageButton btCamera = (ImageButton) v.findViewById(R.id.btCamera);
            ImageButton btGallery = (ImageButton) v.findViewById(R.id.btGallery);
            btCamera.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    openCamera(getActivity());
                }
            });
            btGallery.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    openGallery(getActivity());
                }
            });

            return v;
        }
    }

    private static void openCamera(Activity activity) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Uri fileUri = getUriFileFromCamera();

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        // start the image capture Intent
        activity.startActivityForResult(intent, CAMERA_CAPTURE_REQUEST_CODE);

        mSrcFileUri = fileUri.getPath();
    }

    private static void openGallery(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    /**
     * Creating file uri to store image folder
     */
    public static Uri getUriFileFromCamera() {
        return Uri.fromFile(getFileFromCameraTake());
    }

    /**
     * returning image file
     */
    private static File getFileFromCameraTake() {

        // External sdcard location
        File imageFolder = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), //Pictures folder
                IMAGE_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!imageFolder.exists()) {
            if (!imageFolder.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File imageFile;
        imageFile = new File(imageFolder.getPath() + File.separator
                + "IMG_" + timeStamp + ".jpg");

        return imageFile;
    }

    /**
     * hiển thị Image vừa chụp trong Gallery
     */
    @Override
    protected void onStop() {
        super.onStop();
        sendBroadcast(new Intent(
                Intent.ACTION_MEDIA_MOUNTED,
                Uri.parse("file://" + Environment.getExternalStorageDirectory())));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSrcBitmap != null) {
            mSrcBitmap.recycle();
        }
        if (mDestinationBitmap != null) {
            mDestinationBitmap.recycle();
        }

        unbindDrawables(findViewById(R.id.RootView));
        System.gc();
        //hoặc có thể gọi killMyApp();
    }

    /**
     * Giải phóng bộ nhớ khi thoát ứng dựng
     * @param view Root View
     */
    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            ((ViewGroup) view).removeAllViews();
        }
    }

    private void killMyApp() {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> pids = am.getRunningAppProcesses();
        for (int i = 0; i < pids.size(); i++) {
            ActivityManager.RunningAppProcessInfo info = pids.get(i);
            if (info.processName.equalsIgnoreCase(getPackageName())) {
                android.os.Process.killProcess(info.pid);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if(mSrcBitmap != null || mDestinationBitmap != null){
                mSrcBitmap.recycle();
                mDestinationBitmap.recycle();
            }

            if (requestCode == CAMERA_CAPTURE_REQUEST_CODE) {

                mChooseDialog.dismiss();

                scaleDownImage(mSrcFileUri);
                displayImage(mSrcBitmap);

            } else if (requestCode == GALLERY_REQUEST_CODE) {

                mChooseDialog.dismiss();

                // region- Get path of image
                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                mSrcFileUri = c.getString(columnIndex);
                c.close();
                //endregion

                scaleDownImage(mSrcFileUri);
                displayImage(mSrcBitmap);
            }
        }
    }

    private void scaleDownImage(String uriFile){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap tempBitmap = BitmapFactory.decodeFile(uriFile, options);

        if(SIZE_WIDTH < tempBitmap.getWidth() && SIZE_HEIGHT < tempBitmap.getHeight()) {
            if (tempBitmap.getWidth() >= tempBitmap.getHeight()) {
                mSrcBitmap = Bitmap.createScaledBitmap(tempBitmap, SIZE_WIDTH, SIZE_HEIGHT, true);
            } else {
                float rateScaleWidth = ((float) SIZE_WIDTH) / tempBitmap.getHeight();
                float rateScaleHeight = ((float) SIZE_HEIGHT) / tempBitmap.getWidth();
                Matrix matrix = new Matrix();
                // resize the bit map
                matrix.postScale(rateScaleWidth, rateScaleHeight);
                // rotate the Bitmap
                matrix.postRotate(270);
                mSrcBitmap = Bitmap.createBitmap(tempBitmap, 0, 0, tempBitmap.getWidth(), tempBitmap.getHeight(), matrix, true);
            }
            tempBitmap.recycle();
        } else{ //  NOT scale
            if (tempBitmap.getWidth() >= tempBitmap.getHeight()) {
                mSrcBitmap = Bitmap.createBitmap(tempBitmap);
            } else {
                Matrix matrix = new Matrix();
                // rotate the Bitmap
                matrix.postRotate(270);
                mSrcBitmap = Bitmap.createBitmap(tempBitmap, 0, 0, tempBitmap.getWidth(), tempBitmap.getHeight(), matrix, true);
            }
        }

    }

    private void displayImage(Bitmap bitmap) {
        mZoomImageView.setImageBitmap(bitmap);
        if(bitmap.getWidth() > bitmap.getHeight()) {
            mZoomImageView.setOrientation(90);
        }
    }

    public void buttonClicked(View v) {
        colorFragment.setupSeekBar(v);
    }

    /**
     * custom ProgressDialog không có title, không có phần message, chỉ có icon
     * @param mContext
     * @return ProgressDialog
     */
    public static ProgressDialog createProgressDialog(Context mContext) {
        ProgressDialog dialog = new ProgressDialog(mContext);
        try {
            dialog.show();
        } catch (Exception e) {
        }
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.progress_dialog);
        // dialog.setMessage(Message);
        return dialog;
    }

    private class HandleBitmapTask extends AsyncTask<Void, Void, Bitmap> {
        private ProgressDialog progressDialog;
        View view;
        Bitmap bitmap;

        private HandleBitmapTask(View view, Bitmap bitmap) {
            this.view = view;
            this.bitmap = bitmap;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            return Filter.getInstance().handleBitmap(view, bitmap);
        }

        @Override
        protected void onPreExecute() {
            if (progressDialog == null) {
                progressDialog = createProgressDialog(MainActivity.this);
                progressDialog.show();
            } else {
                progressDialog.show();
            }
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    cancel(true);
                }
            });
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (mDestinationBitmap != null) {
                mDestinationBitmap.recycle();
            }
            mDestinationBitmap = bitmap;
            mZoomImageView.setImageBitmap(mDestinationBitmap);
            if (progressDialog.isShowing())
                progressDialog.dismiss();
        }
    }

    private class SavingImage extends AsyncTask<Bitmap, Void, Void> {
        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            if (progressDialog == null) {
                progressDialog = createProgressDialog(MainActivity.this);
                progressDialog.show();
            } else {
                progressDialog.show();
            }
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    cancel(true);
                }
            });
        }

        @Override
        protected Void doInBackground(Bitmap... params) {
            saveBitmapToFilePNG(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (progressDialog.isShowing())
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Save Successful", Toast.LENGTH_LONG).show();
            }
        }


    private void saveBitmapToFilePNG(Bitmap bmp) {
        try {
            File imageFolder = new File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), //Pictures folder
                    IMAGE_DIRECTORY_NAME);
            // Create the storage directory if it does not exist
            if (!imageFolder.exists()) {
                if (!imageFolder.mkdirs()) {
                    Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                            + IMAGE_DIRECTORY_NAME + " directory");
                }
            }

            // Create a media file name
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                    Locale.getDefault()).format(new Date());
            File imageFile;
            imageFile = new File(imageFolder.getPath() + File.separator + timeStamp + ".jpg");

            FileOutputStream fos = new FileOutputStream(imageFile, false);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
