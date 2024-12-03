package com.coffeemeetsbagel.feature.instagram;

import com.coffeemeetsbagel.feature.instagram.api.models.InstagramMediaItem;
import com.coffeemeetsbagel.feature.instagram.b;

public interface InstagramContract$Manager {

    public enum AuthUrlType {
        USER_HAS_AUTHED,
        USER_DENIED_AUTH,
        AUTH_ERROR,
        NONE
    }

    public interface a {
        void a();

        void b();
    }

    String a();

    AuthUrlType b(String str);

    b<InstagramMediaItem[], InstagramContract$InstagramError> c(b.a<InstagramMediaItem[], InstagramContract$InstagramError> aVar);

    void clear();

    boolean isLoggedIn();
}
