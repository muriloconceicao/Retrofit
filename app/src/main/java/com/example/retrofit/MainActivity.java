package com.example.retrofit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit.model.Item;
import com.example.retrofit.model.SOAnswersResponse;
import com.example.retrofit.network.SOService;
import com.example.retrofit.util.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SOService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService = ApiUtils.getSOService();
        loadAnswers();
    }

    private void loadAnswers() {
        mService.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(@NonNull Call<SOAnswersResponse> call, @NonNull Response<SOAnswersResponse> response) {
                if(response.isSuccessful()) {
                    if (response.body() != null) {
                        List<Item> itemList = response.body().getItems();
                    }
                }
                Log.d(TAG, "onResponse: Sucesso");
            }

            @Override
            public void onFailure(@NonNull Call<SOAnswersResponse> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: Erro");
            }
        });
    }
}