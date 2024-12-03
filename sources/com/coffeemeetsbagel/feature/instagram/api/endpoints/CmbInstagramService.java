package com.coffeemeetsbagel.feature.instagram.api.endpoints;

import com.coffeemeetsbagel.models.EmptyBodyObject;
import com.coffeemeetsbagel.models.responses.ResponseSocialMedia;
import retrofit2.b;
import vn.a;
import vn.o;

public interface CmbInstagramService {
    @o("/instagram_follow")
    b<ResponseSocialMedia> recordFollow(@a EmptyBodyObject emptyBodyObject);
}
