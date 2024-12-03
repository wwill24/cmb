package com.coffeemeetsbagel.feature.bagel.paging;

import hb.c;

public enum BagelPagingMetaType {
    BAGELS("cursors_bagels_"),
    BAGELS_PREFETCH("cursors_bagels_prefetch_"),
    BAGELS_COUPLES("cursors_couples_"),
    BAGELS_COUPLES_PREFETCH("cursors_couples_prefetch_");
    
    private final String prefix;

    private BagelPagingMetaType(String str) {
        this.prefix = str;
    }

    public static BagelPagingMetaType b(boolean z10, boolean z11) {
        if (z11) {
            if (z10) {
                return BAGELS_COUPLES_PREFETCH;
            }
            return BAGELS_COUPLES;
        } else if (z10) {
            return BAGELS_PREFETCH;
        } else {
            return BAGELS;
        }
    }

    private String d() {
        return this.prefix + "current_pages";
    }

    private String h() {
        return this.prefix + "current_token";
    }

    private String j() {
        return this.prefix + "cursor_before";
    }

    private String k() {
        return this.prefix + "more_before";
    }

    public void a(c cVar) {
        cVar.remove(j());
        cVar.remove(k());
        cVar.remove(h());
        cVar.remove(d());
    }

    public int c(c cVar) {
        return cVar.l(d());
    }

    public String e(c cVar) {
        return cVar.r(h());
    }

    public String i(c cVar) {
        return cVar.r(j());
    }

    public String l() {
        return this.prefix;
    }

    public boolean o(c cVar) {
        return cVar.n(k(), true);
    }

    public void p(c cVar, int i10) {
        cVar.c(d(), i10);
    }

    public void q(c cVar, String str) {
        cVar.w(h(), str);
    }

    public void r(c cVar, String str) {
        cVar.w(j(), str);
    }

    public void s(c cVar, boolean z10) {
        cVar.f(k(), z10);
    }
}
