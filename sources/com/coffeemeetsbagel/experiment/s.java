package com.coffeemeetsbagel.experiment;

import java.util.List;
import java.util.Map;
import qj.w;
import vn.f;
import vn.t;

public interface s {
    @f("/feature")
    w<Map<String, Boolean>> a();

    @f("/feature")
    w<Map<String, Boolean>> b(@t("names") List<String> list);
}
