package com.coffeemeetsbagel.feature.discover.api;

import c7.d;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.models.responses.ResponseGiveTakes;
import com.coffeemeetsbagel.models.responses.ResponseInfiniteScrollGiveTakes;
import com.coffeemeetsbagel.models.util.StringUtils;
import retrofit2.b;
import retrofit2.r;
import v7.a;
import w7.j;

public class DiscoverApi implements a {
    private static final String TAG = "DiscoverApi";
    /* access modifiers changed from: private */
    public String cursorBefore;
    /* access modifiers changed from: private */
    public boolean moreBefore;
    private d retrofitManager;

    public DiscoverApi(d dVar) {
        this.retrofitManager = dVar;
    }

    public void clearInfiniteScrollCursors() {
        this.cursorBefore = null;
        this.moreBefore = false;
    }

    public void filterTakes(j jVar, final a.C0214a aVar) {
        ((DiscoverService) this.retrofitManager.c(DiscoverService.class)).getFilteredBagels("profile", jVar.b(), jVar.c(), jVar.f(), jVar.g(), jVar.h(), StringUtils.join(jVar.e()), StringUtils.join(jVar.d()), jVar.i()).L(new retrofit2.d<ResponseGiveTakes>() {
            public void onFailure(b<ResponseGiveTakes> bVar, Throwable th2) {
                aVar.onFailure();
            }

            public void onResponse(b<ResponseGiveTakes> bVar, r<ResponseGiveTakes> rVar) {
                if (rVar.g()) {
                    aVar.a(rVar.a().getResults());
                } else {
                    aVar.onFailure();
                }
            }
        });
    }

    public void getBagelsInfiniteScroll(final a.c cVar) {
        DiscoverService discoverService = (DiscoverService) this.retrofitManager.c(DiscoverService.class);
        String str = this.cursorBefore;
        if ((str == null && !this.moreBefore) || (str != null && this.moreBefore)) {
            discoverService.getBagelsInfiniteScroll(str).L(new retrofit2.d<ResponseInfiniteScrollGiveTakes>() {
                public void onFailure(b<ResponseInfiniteScrollGiveTakes> bVar, Throwable th2) {
                    fa.a.f(DiscoverApi.TAG, Bakery.w().getApplicationContext().getString(R.string.load_error_infinite_scroll));
                    fa.a.i(th2);
                    cVar.onFailure();
                }

                public void onResponse(b<ResponseInfiniteScrollGiveTakes> bVar, r<ResponseInfiniteScrollGiveTakes> rVar) {
                    ResponseInfiniteScrollGiveTakes a10 = rVar.a();
                    if (!rVar.g() || a10 == null) {
                        cVar.onFailure();
                        return;
                    }
                    DiscoverApi.this.cursorBefore = a10.getCursorBefore();
                    DiscoverApi.this.moreBefore = a10.getMoreBefore();
                    cVar.a(a10.getData());
                }
            });
        }
    }

    public void markGiveTakeAsSeen(String str, final a.b bVar) {
        ((DiscoverService) this.retrofitManager.c(DiscoverService.class)).markGiveAsShown(new DiscoverGiveShownBody(str, true)).L(new retrofit2.d<ResponseGeneric>() {
            public void onFailure(b<ResponseGeneric> bVar, Throwable th2) {
                bVar.a(th2.getMessage(), 0);
            }

            public void onResponse(b<ResponseGeneric> bVar, r<ResponseGeneric> rVar) {
                if (rVar.g()) {
                    bVar.b(rVar.a());
                } else {
                    bVar.a(rVar.h(), rVar.b());
                }
            }
        });
    }

    public void markRisingGiveTakeAsSeen(String str, final a.b bVar) {
        ((DiscoverService) this.retrofitManager.c(DiscoverService.class)).showRisingBagelAsShown(new DiscoverRisingShownBody(str, true)).L(new retrofit2.d<ResponseGeneric>() {
            public void onFailure(b<ResponseGeneric> bVar, Throwable th2) {
                bVar.a(th2.getMessage(), 0);
            }

            public void onResponse(b<ResponseGeneric> bVar, r<ResponseGeneric> rVar) {
                if (rVar.g()) {
                    bVar.b(rVar.a());
                } else {
                    bVar.a(rVar.h(), rVar.b());
                }
            }
        });
    }

    public void sendLikeBackRisingGiveTake(String str, final a.b bVar) {
        ((DiscoverService) this.retrofitManager.c(DiscoverService.class)).likeRisingBagel(new DiscoverRisingTakeBody(str, 1)).L(new retrofit2.d<ResponseGeneric>() {
            public void onFailure(b<ResponseGeneric> bVar, Throwable th2) {
                bVar.a(th2.getMessage(), 0);
            }

            public void onResponse(b<ResponseGeneric> bVar, r<ResponseGeneric> rVar) {
                if (rVar.g()) {
                    bVar.b(rVar.a());
                } else {
                    bVar.a(rVar.h(), rVar.b());
                }
            }
        });
    }
}
