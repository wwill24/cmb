package com.coffeemeetsbagel.feature.discover.api;

import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.models.responses.ResponseGiveTakes;
import com.coffeemeetsbagel.models.responses.ResponseInfiniteScrollGiveTakes;
import retrofit2.b;
import vn.a;
import vn.f;
import vn.p;
import vn.t;

public interface DiscoverService {
    @f("/v4/discoversearch/infinitescroll")
    b<ResponseInfiniteScrollGiveTakes> getBagelsInfiniteScroll(@t("cursor_before") String str);

    @f("/discoversearch")
    b<ResponseGiveTakes> getFilteredBagels(@t("embed") String str, @t("age_from") Integer num, @t("age_to") Integer num2, @t("height_cm_from") Integer num3, @t("height_cm_to") Integer num4, @t("max_distance_km") Integer num5, @t("ethnicity") String str2, @t("degree") String str3, @t("recently_active") Boolean bool);

    @p("/risinggivetake")
    b<ResponseGeneric> likeRisingBagel(@a DiscoverRisingTakeBody discoverRisingTakeBody);

    @p("/givetake")
    b<ResponseGeneric> markGiveAsShown(@a DiscoverGiveShownBody discoverGiveShownBody);

    @p("/risinggivetake")
    b<ResponseGeneric> showRisingBagelAsShown(@a DiscoverRisingShownBody discoverRisingShownBody);
}
