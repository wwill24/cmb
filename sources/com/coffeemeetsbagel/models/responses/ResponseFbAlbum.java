package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.FacebookPhoto;
import com.coffeemeetsbagel.models.util.FacebookParse;
import fa.a;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.b;

public class ResponseFbAlbum extends ResponseGeneric {
    private String after;
    private ArrayList<FacebookPhoto> mFacebookPhotos;
    private boolean mHasPaging;
    private String mPagingUrl;

    public ResponseFbAlbum(b bVar) {
        ArrayList<FacebookPhoto> arrayList = new ArrayList<>();
        this.mFacebookPhotos = arrayList;
        try {
            arrayList.addAll(FacebookParse.parseAlbumPhotos(bVar));
            if (bVar.has(FacebookParse.FB_PARAM_PAGING)) {
                b jSONObject = bVar.getJSONObject(FacebookParse.FB_PARAM_PAGING);
                if (jSONObject.has(FacebookParse.FB_PARAM_NEXT)) {
                    b jSONObject2 = jSONObject.getJSONObject(FacebookParse.FB_PARAM_CURSORS);
                    if (jSONObject2 != null && jSONObject2.has("after")) {
                        this.after = jSONObject2.getString("after");
                    }
                    this.mPagingUrl = jSONObject.getString(FacebookParse.FB_PARAM_NEXT);
                    this.mHasPaging = true;
                } else {
                    this.mHasPaging = false;
                }
            }
        } catch (JSONException e10) {
            a.i(e10);
        }
        setSuccess(true);
    }

    public String getAfter() {
        return this.after;
    }

    public ArrayList<FacebookPhoto> getFacebookPhotos() {
        return this.mFacebookPhotos;
    }

    public String getPagingUrl() {
        return this.mPagingUrl;
    }

    public boolean hasPaging() {
        return this.mHasPaging;
    }
}
