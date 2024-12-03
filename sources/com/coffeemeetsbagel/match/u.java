package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.match.models.ActionOnBagelNetworkRequest;
import com.coffeemeetsbagel.match.models.MarkChatDeletedBody;
import com.coffeemeetsbagel.match.models.NewWoosShownBody;
import com.coffeemeetsbagel.match.models.ReportBagelBody;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.responses.ResponseBagel;
import com.coffeemeetsbagel.models.responses.ResponseBagels;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import qj.w;
import retrofit2.b;
import vn.a;
import vn.f;
import vn.p;
import vn.s;
import vn.t;

public interface u {
    @f("/bagels?embed=profile")
    b<ResponseBagels> a(@t("prefetch") boolean z10, @t("couples_only") boolean z11, @t("cursor_before") String str, @t("updated_after") String str2, @t("cursor_after") String str3);

    @f("/bagel/{id}")
    b<Bagel> b(@s("id") String str, @t("embed") String str2);

    @p("/bagel/{id}")
    w<Bagel> c(@s("id") String str, @a ActionOnBagelNetworkRequest actionOnBagelNetworkRequest);

    @p("/bagel/{id}")
    b<ResponseBagel> d(@s("id") String str, @a ReportBagelBody reportBagelBody);

    @f("/bagels?embed=profile")
    b<ResponseBagels> e(@t("prefetch") boolean z10, @t("couples_only") boolean z11, @t("cursor_before") String str);

    @p("/bagel/{id}")
    w<ResponseGeneric> f(@s("id") String str, @a NewWoosShownBody newWoosShownBody);

    @p("/bagel/{id}")
    b<Bagel> g(@s("id") String str, @a ActionOnBagelNetworkRequest actionOnBagelNetworkRequest);

    @p("/bagel/{id}")
    b<Object> h(@s("id") String str, @a MarkChatDeletedBody markChatDeletedBody);
}
