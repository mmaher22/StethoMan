package com.example.youhanamikhaiel.stethoman;
import android.os.AsyncTask;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.ImageView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;



public class doctoreditinfo extends AppCompatActivity implements View.OnClickListener {
    EditText Email, Mobile, Password, Achievements;
    private Button buttonUpload;
    private Button buttonImage;


    public static final String UPLOAD_URL = "http://stethoman.esy.es/UPImg.php";
    public static final String Img = "image";
    public static final String TAG = "MY MESSAGE";

    private int PICK_IMAGE_REQUEST = 1;
    private Bitmap bitmap;
    private ImageView imageView;
    private Uri filePath;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctoreditinfo);
        Email = (EditText) findViewById(R.id.doctoremail);
        Mobile = (EditText) findViewById(R.id.doctormobile);
        Password = (EditText) findViewById(R.id.doctorpassword);
        Achievements = (EditText) findViewById(R.id.awards);
        buttonImage = (Button) findViewById(R.id.button6);
        buttonImage.setOnClickListener(this);

    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }


    public void UpdateInfo(View view) {
        String email = Email.getText().toString().trim();
        String mobile = Mobile.getText().toString().trim();
        String pass = Password.getText().toString().trim();
        String awards = Achievements.getText().toString().trim();

        String type = "update";
        BackgroundDoctor backgrounddoctor = new BackgroundDoctor(this);
        backgrounddoctor.execute(type, email, mobile, pass, awards );
        uploadImage();
    }
    private void uploadImage(){
        class UploadImage extends AsyncTask<Bitmap,Void,String>{

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                String uploadImage = getStringImage(bitmap);
                HashMap<String,String> data = new HashMap<>();
                data.put(Img, uploadImage);
                String result = rh.sendPostRequest(UPLOAD_URL,data);
                return result;
            }
        }
        UploadImage ui = new UploadImage();
        if(bitmap != null)
            ui.execute(bitmap);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonImage) {
            showFileChooser();
        }

    }
}


