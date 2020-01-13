package com.example.retrofitexample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitexample.R;
import com.example.retrofitexample.model.LoginResponse;
import com.example.retrofitexample.network.ApiClient;
import com.example.retrofitexample.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText userName_edt, password_edt;
    Button login_btn;
    LoginResponse loginResponseData;
    //ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName_edt = (EditText) findViewById(R.id.username_edt);
        password_edt = (EditText) findViewById(R.id.password_edt);
        login_btn = (Button) findViewById(R.id.login_btn);

        //creating obj for our interface
       // apiInterface = ApiClient.getClient().create(ApiInterface.class);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();

            }
        });
    }
    private void userLogin() {
        String username_str = userName_edt.getText().toString().trim();
        String password_str = password_edt.getText().toString().trim();

        // ApiClient is a class in which we define a method getClient() that returns the API Interface class object

        // loginUser is a POST request type method in which we are sending our field's data
        // enqueue is used for callback response and error


      /*  Call<LoginResponse> call = apiInterface.loginUser(username_str, password_str);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginResponseData = response.body();
                int status = loginResponseData.getStatus();
              //  int mobnum = (int) Integer.parseInt(String.valueOf(loginResponseData.getResponse().getMobileNo()));
                Log.d("loginstat", String.valueOf(loginResponseData));
                if (status == 200) {
                    Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("failure", t.toString());

            }
        });*/


        ApiClient.getClient().loginUser(username_str,password_str).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginResponseData = response.body();
                int status = loginResponseData.getStatus();
                if (status==200){
                    Toast.makeText(getApplicationContext(),"we get response",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),WelcomeActivity.class);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("failure", t.toString());
            }
        });

       /* Call<LoginResponse> call = ApiClient.getClient().loginUser(username_str,password_str);
                call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginResponseData = response.body();
                int status = loginResponseData.getStatus();
                Log.d("loginstat", String.valueOf(loginResponseData));
                if (status==200){
                    Intent i = new Intent(getApplicationContext(),WelcomeActivity.class);
                    startActivity(i);
                    finish();
                }


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("failure", t.toString());

            }
        });*/
    }

}
