package com.coffeemeetsbagel.models.util;

import com.coffeemeetsbagel.models.FacebookAlbum;
import com.coffeemeetsbagel.models.FacebookPhoto;
import java.util.ArrayList;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public final class FacebookParse {
    public static final String EXTRA_AFTER = "after";
    private static final String EXTRA_URL = "url";
    private static final String FB_DATA = "data";
    public static final String FB_ME = "me";
    public static final int FB_NO_LIMIT = 5000;
    public static final String FB_PARAM_AFTER = "after";
    public static final String FB_PARAM_BATCH_FIELDS = "fields";
    public static final String FB_PARAM_CURSORS = "cursors";
    public static final String FB_PARAM_FIELD_ALBUMS = "albums";
    public static final String FB_PARAM_FIELD_COUNT = "count";
    public static final String FB_PARAM_FIELD_COVER_PHOTO = "picture.limit(1)";
    public static final String FB_PARAM_FIELD_ID = "id";
    public static final String FB_PARAM_FIELD_LIMIT = "limit";
    public static final String FB_PARAM_FIELD_NAME = "name";
    public static final String FB_PARAM_FIELD_PHOTOS = "photos";
    public static final String FB_PARAM_FIELD_PICTURE = "picture";
    public static final String FB_PARAM_FIELD_SOURCE = "source";
    public static final String FB_PARAM_NEXT = "next";
    public static final String FB_PARAM_PAGING = "paging";
    public static final String FB_PARAM_PICTURE = "picture";
    public static final String FB_PARAM_TAGGED_ID = "tagged";
    public static final String FB_PHOTOS = "photos";
    public static final FacebookParse INSTANCE = new FacebookParse();

    private FacebookParse() {
    }

    public static final ArrayList<FacebookPhoto> parseAlbumPhotos(b bVar) throws JSONException {
        j.g(bVar, JsonPacketExtension.ELEMENT);
        ArrayList<FacebookPhoto> arrayList = new ArrayList<>();
        if (bVar.has("data")) {
            a jSONArray = bVar.getJSONArray("data");
            int o10 = jSONArray.o();
            for (int i10 = 0; i10 < o10; i10++) {
                b j10 = jSONArray.j(i10);
                FacebookPhoto facebookPhoto = new FacebookPhoto();
                facebookPhoto.setSourceUrl(j10.getString("source"));
                facebookPhoto.setId(j10.getString("id"));
                facebookPhoto.setThumb(j10.getString("picture"));
                if (facebookPhoto.getId() != null) {
                    arrayList.add(facebookPhoto);
                }
            }
        }
        return arrayList;
    }

    public static final ArrayList<FacebookAlbum> parseAlbums(b bVar) throws JSONException {
        boolean z10;
        int i10;
        j.g(bVar, JsonPacketExtension.ELEMENT);
        ArrayList<FacebookAlbum> arrayList = new ArrayList<>();
        if (bVar.has(FB_PARAM_FIELD_ALBUMS)) {
            b jSONObject = bVar.getJSONObject(FB_PARAM_FIELD_ALBUMS);
            if (jSONObject.has("data")) {
                a jSONArray = jSONObject.getJSONArray("data");
                int o10 = jSONArray.o();
                for (int i11 = 0; i11 < o10; i11++) {
                    b j10 = jSONArray.j(i11);
                    FacebookAlbum facebookAlbum = new FacebookAlbum();
                    facebookAlbum.setId(j10.optString("id"));
                    facebookAlbum.setName(j10.optString("name"));
                    String optString = j10.optString("count");
                    j.f(optString, "countString");
                    if (optString.length() > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        i10 = Integer.parseInt(optString);
                    } else {
                        i10 = 0;
                    }
                    facebookAlbum.setCount(i10);
                    if (j10.has("picture")) {
                        facebookAlbum.setThumbUrl(j10.getJSONObject("picture").getJSONObject("data").getString("url"));
                    }
                    if (facebookAlbum.getId() != null) {
                        arrayList.add(facebookAlbum);
                    }
                }
            }
        }
        return arrayList;
    }

    public static final FacebookAlbum parseTaggedAlbum(b bVar, String str) throws JSONException {
        j.g(bVar, JsonPacketExtension.ELEMENT);
        FacebookAlbum facebookAlbum = new FacebookAlbum();
        if (bVar.has("photos")) {
            b jSONObject = bVar.getJSONObject("photos");
            if (jSONObject.has("data")) {
                a jSONArray = jSONObject.getJSONArray("data");
                facebookAlbum.setThumbUrl(jSONArray.j(0).getString("picture"));
                facebookAlbum.setCount(jSONArray.o());
                facebookAlbum.setId(FB_PARAM_TAGGED_ID);
                facebookAlbum.setName(str);
            }
        }
        return facebookAlbum;
    }
}
