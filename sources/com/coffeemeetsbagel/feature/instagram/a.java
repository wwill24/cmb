package com.coffeemeetsbagel.feature.instagram;

import com.coffeemeetsbagel.feature.instagram.api.models.InstagramMediaItem;
import com.coffeemeetsbagel.feature.instagram.b;
import com.coffeemeetsbagel.models.responses.ResponseSocialMedia;

public interface a {

    /* renamed from: com.coffeemeetsbagel.feature.instagram.a$a  reason: collision with other inner class name */
    public interface C0137a {
        void a();

        void b(ResponseSocialMedia responseSocialMedia);
    }

    String a();

    boolean b(String str);

    void c(String str);

    void d(C0137a aVar);

    b<InstagramMediaItem[], InstagramContract$InstagramError> e(b.a<InstagramMediaItem[], InstagramContract$InstagramError> aVar);

    String f(String str);

    boolean g(String str);
}
