package com.example.retrofit.util;
import com.example.retrofit.network.RetrofitClient;
import com.example.retrofit.network.SOService;

public class ApiUtils {

    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }

}
