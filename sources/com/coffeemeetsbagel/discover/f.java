package com.coffeemeetsbagel.discover;

import com.coffeemeetsbagel.models.responses.ResponseGiveTakes;
import com.coffeemeetsbagel.models.responses.ResponseRisingGiveTakes;
import qj.w;
import vn.t;

public interface f {
    @vn.f("/givetakes?embed=profile")
    w<ResponseGiveTakes> a(@t("updated_after") String str);

    @vn.f("/risinggivetakes?embed=profile")
    w<ResponseRisingGiveTakes> b(@t("updated_after") String str);
}
