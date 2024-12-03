package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.FacebookAlbum;
import com.coffeemeetsbagel.models.util.FacebookParse;
import fa.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.b;

public class ResponseFbAlbums extends ResponseGeneric {
    private ArrayList<FacebookAlbum> mFacebookAlbums = new ArrayList<>();
    private FacebookAlbum mTaggedAlbum;

    public ResponseFbAlbums(b bVar, String str) {
        setSuccess(true);
        try {
            this.mFacebookAlbums.addAll(FacebookParse.parseAlbums(bVar));
            this.mTaggedAlbum = FacebookParse.parseTaggedAlbum(bVar, str);
        } catch (JSONException e10) {
            a.i(e10);
        }
    }

    public List<FacebookAlbum> getFacebookAlbums() {
        return this.mFacebookAlbums;
    }

    public FacebookAlbum getTaggedAlbum() {
        return this.mTaggedAlbum;
    }
}
