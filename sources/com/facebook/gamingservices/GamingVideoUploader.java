package com.facebook.gamingservices;

import android.content.Context;
import android.net.Uri;
import com.facebook.GraphRequest;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;

public class GamingVideoUploader {
    private Context context;

    public GamingVideoUploader(Context context2) {
        this.context = context2;
    }

    public void uploadToMediaLibrary(String str, Uri uri) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, (GraphRequest.OnProgressCallback) null);
    }

    public void uploadToMediaLibrary(String str, Uri uri, GraphRequest.OnProgressCallback onProgressCallback) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, false, onProgressCallback);
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z10, GraphRequest.OnProgressCallback onProgressCallback) throws FileNotFoundException {
        ShareVideoContent build = new ShareVideoContent.Builder().setVideo(new ShareVideo.Builder().setLocalUrl(uri).build()).setContentDescription(str).build();
        if (z10) {
            onProgressCallback = new OpenGamingMediaDialog(this.context, onProgressCallback);
        }
        VideoUploader.uploadAsyncWithProgressCallback(build, onProgressCallback);
    }
}
