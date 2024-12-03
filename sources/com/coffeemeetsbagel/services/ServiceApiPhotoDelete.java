package com.coffeemeetsbagel.services;

import android.content.Intent;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.transport.SuccessStatus;
import jc.a;
import t8.c;

public class ServiceApiPhotoDelete extends a {
    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);
        String string = intent.getExtras().getString(Extra.PHOTO_ID);
        int i10 = intent.getExtras().getInt(Extra.PHOTO_INDEX);
        ResponseGeneric w10 = c.w(string);
        if (w10.isSuccessful()) {
            d(this.f41052b, new SuccessStatus("Photo deleted successfully"), Integer.valueOf(i10));
        } else {
            c(this.f41052b, w10.getErrorCode().setErrorMessage("Failed to delete photo"));
        }
    }
}
