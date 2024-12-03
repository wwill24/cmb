package com.facebook.gamingservices;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import java.io.File;
import java.io.FileNotFoundException;

public class GamingImageUploader {
    private static final String photoUploadEdge = "me/photos";
    private Context context;

    public GamingImageUploader(Context context2) {
        this.context = context2;
    }

    public void uploadToMediaLibrary(String str, Bitmap bitmap, boolean z10) {
        uploadToMediaLibrary(str, bitmap, z10, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, Bitmap bitmap, boolean z10, GraphRequest.Callback callback) {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), photoUploadEdge, bitmap, str, (Bundle) null, z10 ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }

    public void uploadToMediaLibrary(String str, File file, boolean z10) throws FileNotFoundException {
        uploadToMediaLibrary(str, file, z10, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, File file, boolean z10, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), photoUploadEdge, file, str, (Bundle) null, z10 ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z10) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, z10, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z10, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), photoUploadEdge, uri, str, (Bundle) null, z10 ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }
}
