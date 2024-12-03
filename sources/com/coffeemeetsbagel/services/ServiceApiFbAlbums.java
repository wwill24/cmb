package com.coffeemeetsbagel.services;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.responses.ResponseFbAlbums;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import gb.e;
import jc.a;

public class ServiceApiFbAlbums extends a {
    /* access modifiers changed from: private */
    public /* synthetic */ void f(ResultReceiver resultReceiver, String str, GraphResponse graphResponse) {
        if (graphResponse.getError() != null) {
            c(resultReceiver, new CmbErrorCode(graphResponse.getError().getErrorMessage(), graphResponse.getError().getErrorCode()));
            return;
        }
        d(resultReceiver, new SuccessStatus("Got fb albums successfully"), new ResponseFbAlbums(graphResponse.getJSONObject(), str));
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            c(this.f41052b, new CmbErrorCode("No parameters", 500));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("fields", "albums.limit(5000){id,name,count,picture.limit(1)},photos.limit(5000).fields(id,picture)");
        new GraphRequest(AccessToken.getCurrentAccessToken(), "me", bundle, HttpMethod.GET, new e(this, (ResultReceiver) extras.get("ResultReceiver"), Bakery.w().getResources().getString(R.string.title_tagged_album))).executeAndWait();
    }
}
