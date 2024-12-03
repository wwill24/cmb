package com.coffeemeetsbagel.feature.instagram.api.endpoints;

import com.coffeemeetsbagel.feature.instagram.api.models.InstagramEnvelope;
import com.coffeemeetsbagel.feature.instagram.api.models.InstagramMediaItem;
import retrofit2.b;
import vn.f;
import vn.t;
import vn.y;

public interface InstagramService {
    @f("/v1/users/self/media/recent")
    b<InstagramEnvelope<InstagramMediaItem[]>> getRecentMedia(@t("access_token") String str);

    @f
    b<InstagramEnvelope<InstagramMediaItem[]>> getRecentMediaPaging(@y String str);
}
