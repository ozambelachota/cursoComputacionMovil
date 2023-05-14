package com.example.appdesaludos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText edad;
    private EditText celular;
    private EditText email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre= findViewById(R.id.txtnombre);
        edad=findViewById(R.id.txtedad);
        celular = findViewById(R.id.txtcelular);
        email = findViewById(R.id.txtemail);





       /* if (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // La dirección de correo electrónico es válida, podemos continuar con el procesamiento de la entrada del usuario
        } else {
            // La dirección de correo electrónico es inválida, mostramos un mensaje de error
            email.setError("Please enter a valid email address");
        }*/
    }

    public String validarEdad(){
        int edadV = Integer.parseInt(edad.getText().toString());
        String validar;

        if (edadV>0 && edadV<=2){
            validar = "eres una bebe";

        }
        else if (edadV>3 && edadV<=12){
            validar = "eres un niño";

        }else if (edadV>13 && edadV<=18){
            validar = "eres un adolescente";

        }else if (edadV>19 && edadV<=50){
            validar = "eres un adulto";

        }
        else if (edadV>50){
            validar = "eres un anciano";
        }else {
         validar="";}
        return validar;
    }

    public boolean validarEmail(){
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches()) {
            email.setError("Correo electrónico inválido");
            email.requestFocus();
            return false;
        }
        return true;

    }



    public void saludar(View view){
        int edadT = Integer.parseInt(edad.getText().toString());
        String emailV = email.getText().toString();
        //String emailV = "ejemplo@gmail.com";


     /*   if(validarEmail(emailV)){

        }
        else {

            Toast.makeText(this, "Email incorrecto", Toast.LENGTH_SHORT).show();
        }*/

        if (validarEmail()){

        }

        if (validarEdad()!="" && nombre.getText().length()<=50  ){
              if (edadT>=0 && edadT<=99){
                    Toast.makeText(this, nombre.getText().toString()+"\t"+validarEdad()+"\t"+celular.getText().toString(), Toast.LENGTH_LONG).show();
                }else {
                  Toast.makeText(this, "Ingrese un rango de 0 a 99", Toast.LENGTH_SHORT).show();
              }

        }else{
            Toast.makeText(this,"muchos caracteres", Toast.LENGTH_SHORT).show();

        }

    }



}