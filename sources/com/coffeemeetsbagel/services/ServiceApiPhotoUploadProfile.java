package com.coffeemeetsbagel.services;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.responses.ResponsePhoto;
import gb.f;
import java.io.File;
import java.io.IOException;
import jc.a;
import lc.e;
import okhttp3.a0;
import okhttp3.s;
import okhttp3.v;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
import org.json.JSONException;
import org.json.b;

public class ServiceApiPhotoUploadProfile extends a {
    private void g(Bundle bundle, EventType eventType) {
        new Handler(Looper.getMainLooper()).post(new f(eventType, bundle));
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        String str;
        super.onHandleIntent(intent);
        v g10 = v.g("image/jpeg");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            fa.a.f("ServiceApiPhotoUploadProfile", "No extras passed");
            return;
        }
        String string = extras.getString(Extra.PHOTO_ID);
        if (extras.getString("caption") == null) {
            str = "";
        } else {
            str = extras.getString("caption");
        }
        int i10 = extras.getInt(Extra.PHOTO_INDEX);
        String string2 = extras.getString(Extra.IMAGE_PATH);
        if (string2 == null) {
            fa.a.f("ServiceApiPhotoUploadProfile", "No image path");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(Extra.PHOTO_INDEX, i10);
        bundle.putString(Extra.PHOTO_ID, string);
        g(bundle, EventType.PHOTO_UPLOADING);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("#photoId=");
        sb2.append(string);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("#photoCaption=");
        sb3.append(str);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("#photoIndex=");
        sb4.append(i10);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("#photoImgPath=");
        sb5.append(string2);
        File file = new File(string2);
        Bundle bundle2 = new Bundle();
        try {
            b bVar = new b();
            bVar.put(Extra.PHOTO_ID, (Object) string);
            bVar.put("caption", (Object) str);
            bVar.put("position", i10);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("#photo jsonObject=");
            sb6.append(bVar.toString());
            y.a q10 = new y.a().q(x4.a.f18540d + "photo");
            e.a(q10);
            y b10 = q10.i(new w.a().e(w.f33202l).b(s.m("Content-Disposition", "form-data; name=\"data\""), z.d(x4.a.f18538b, bVar.toString())).b(s.m("Content-Disposition", "form-data; name=\"image\"; filename=\"myfile.jpg\""), z.c(g10, file)).d()).b();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("#photo headers ");
            sb7.append(b10.e().toString());
            a0 f10 = this.f41054d.a(b10).f();
            int f11 = f10.f();
            StringBuilder sb8 = new StringBuilder();
            sb8.append("\n\n\n#photo responseCode=");
            sb8.append(f11);
            String string3 = f10.a().string();
            StringBuilder sb9 = new StringBuilder();
            sb9.append("\n#photo responseBody=");
            sb9.append(string3);
            bundle2.putInt(Extra.PHOTO_INDEX, i10);
            if (f11 == 200) {
                ResponsePhoto responsePhoto = (ResponsePhoto) this.f41053c.k(string3, ResponsePhoto.class);
                responsePhoto.setStatusCode(f11);
                if (responsePhoto.isSuccessful()) {
                    bundle2.putString(Extra.PHOTO_ID, responsePhoto.getPhotoId());
                    bundle2.putString(Extra.IMAGE_URI, responsePhoto.getPhotoUrl());
                    bundle2.putString("caption", str);
                    g(bundle2, EventType.PHOTO_UPLOAD_SUCCESS);
                    return;
                }
                g(bundle2, EventType.PHOTO_UPLOAD_ERROR);
                return;
            }
            throw new Exception("Response Code " + f11);
        } catch (IOException | JSONException e10) {
            fa.a.f("ServiceApiPhotoUploadProfile", e10.getMessage());
            g(bundle2, EventType.PHOTO_UPLOAD_ERROR);
        } catch (Exception e11) {
            fa.a.f("ServiceApiPhotoUploadProfile", "error uploading photo: " + e11.getMessage());
            g(bundle2, EventType.PHOTO_UPLOAD_ERROR);
        }
    }
}
