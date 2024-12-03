package com.coffeemeetsbagel.services;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.responses.ResponseFbAlbum;
import com.coffeemeetsbagel.models.util.FacebookParse;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import gb.d;
import jc.a;

public class ServiceApiFbAlbum extends a {
    /* access modifiers changed from: private */
    public /* synthetic */ void f(GraphResponse graphResponse) {
        if (graphResponse.getError() != null) {
            c(this.f41052b, new CmbErrorCode(graphResponse.getError().getErrorMessage(), graphResponse.getError().getErrorCode()));
            return;
        }
        d(this.f41052b, new SuccessStatus("Got fb albums successfully"), new ResponseFbAlbum(graphResponse.getJSONObject()));
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            c(this.f41052b, new CmbErrorCode("No parameters", 500));
            return;
        }
        String string = extras.getString("id");
        String string2 = extras.getString("after");
        if (FacebookParse.FB_PARAM_TAGGED_ID.equals(string)) {
            string = "me";
        }
        String str = string + "/photos";
        Bundle bundle = new Bundle();
        bundle.putString(FacebookParse.FB_PARAM_FIELD_LIMIT, String.valueOf(FacebookParse.FB_NO_LIMIT));
        bundle.putString("fields", "id,source,picture");
        if (!TextUtils.isEmpty(string2)) {
            bundle.putString("after", string2);
        }
        new GraphRequest(AccessToken.getCurrentAccessToken(), str, bundle, HttpMethod.GET, new d(this)).executeAndWait();
    }
}
