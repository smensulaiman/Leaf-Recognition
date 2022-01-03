package com.example.leafrecognition.networking;

import com.google.gson.annotations.SerializedName;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiInterface {

    @Multipart
    @POST("/file") //Here, `upload` is the PATH PARAMETER
    Call<ResponseModel> fileUpload(
            @Part("sender_information") RequestBody description,
            @Part MultipartBody.Part file);


    @POST("/predict") //Here, `upload` is the PATH PARAMETER
    Call<ResponseModel2> fileUpload2(
            @Body RequestModel2  requestModel2
    );

}
class ResponseModel2{

    @SerializedName("prediction")
    Prediction prediction;

    public ResponseModel2(Prediction prediction) {
        this.prediction = prediction;
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
    }
}

class Prediction{

    String data;
    String persent;

    public Prediction(String data, String persent) {
        this.data = data;
        this.persent = persent;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPersent() {
        return persent;
    }

    public void setPersent(String persent) {
        this.persent = persent;
    }
}

class RequestModel2{
    String image;

    public RequestModel2(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
