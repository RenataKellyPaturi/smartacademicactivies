package com.smartacademic.myapplication.activitys;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.smartacademic.myapplication.R;
import com.smartacademic.myapplication.util.ImageResizeUtils;
import com.smartacademic.myapplication.util.Permissao;
import com.smartacademic.myapplication.util.SDCardUtils;
import com.squareup.picasso.Picasso;

import java.io.File;



public class EnviarCertificadoActivity extends BaseActivity{



    private ImageView imagemView;
    private ImageButton btimagem;
    private File arquivoImagem;
    private EditText evento;
    private Button enviar;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private final String TAG = "SmartAcademicActivities";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_certificado);

        imagemView = (ImageView) findViewById(R.id.imgFoto);
        Picasso.with(getBaseContext()).load("https://firebasestorage.googleapis.com/v0/b/smart-academic-activities.appspot.com/o/imagens%2Fandroid_update.png?alt=media&token=78b1d199-fc98-4f9a-8b4a-be20d6f17071")
                .into(imagemView);

        btimagem = (ImageButton) findViewById(R.id.btnFoto);
        btimagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA};

                if (Permissao.validate(EnviarCertificadoActivity.this, 0, permissions)) {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    arquivoImagem = SDCardUtils.getPrivateFile(getBaseContext(), "certificado.png", Environment.DIRECTORY_PICTURES);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(arquivoImagem));
                    startActivityForResult(intent, 0);
                }//fim if
            }
        });

        evento = (EditText) findViewById(R.id.nomeEvento);
        enviar = (Button) findViewById(R.id.btnEnviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode==RESULT_OK && arquivoImagem!=null){
            int w = imagemView.getWidth();
            int h = imagemView.getHeight();
            Bitmap bitmap = ImageResizeUtils.getResizedImage(Uri.fromFile(arquivoImagem), w, h, false);
            imagemView.setImageBitmap(bitmap);
            uploadFirebaseStorage();
        }
    }

    public void uploadFirebaseStorage(){
        StorageReference storageReference = storage.getReferenceFromUrl("gs://smart-academic-activities.appspot.com");

        StorageReference fileReference = storageReference.child("imagens/certificado.png");

        UploadTask uploadTask = fileReference.putFile(Uri.fromFile(arquivoImagem));

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Log.d(TAG, "upload realizado com sucesso!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.e(TAG, "ocorreu um erro no upload!");
            }
        });
    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem menuItem){
//        switch(menuItem.getItemId()){
//            case android.R.id.home:
//                finish();
//                break;
//        }
//        return super.onOptionsItemSelected(menuItem);
//    }
//    public void tirarFoto(View view){
//
//        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//        startActivityForResult(intent, 0);
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        if(data != null){
//            Bundle bundle = data.getExtras();
//            if (bundle != null){
//                Bitmap img = (Bitmap) bundle.get("data");
//                ImageView iv = (ImageView) findViewById(R.id.imgFoto);
//                iv.setImageBitmap(img);
//            }
//        }
//    }
}
