package com.coffeemeetsbagel.store.alc;

import c7.d;
import com.coffeemeetsbagel.store.alc.models.PurchaseRequest;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.e;
import com.google.gson.l;
import dk.a;
import gk.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;
import qj.b0;
import qj.w;

public final class PurchaseRepository<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f36747a;

    /* renamed from: b  reason: collision with root package name */
    private final f f36748b = b.b(new PurchaseRepository$api$2(this));

    public enum PurchaseRequestSource {
        SUGGESTED,
        DISCOVER
    }

    public PurchaseRepository(d dVar) {
        j.g(dVar, "retrofit");
        this.f36747a = dVar;
    }

    public static /* synthetic */ w f(PurchaseRepository purchaseRepository, String str, long j10, int i10, Class cls, PurchaseRequestSource purchaseRequestSource, String str2, String str3, String str4, int i11, Object obj) {
        int i12 = i11;
        return purchaseRepository.e(str, j10, i10, cls, (i12 & 16) != 0 ? null : purchaseRequestSource, (i12 & 32) != 0 ? null : str2, (i12 & 64) != 0 ? null : str3, (i12 & 128) != 0 ? null : str4);
    }

    /* access modifiers changed from: private */
    public static final b0 g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    private final i h() {
        return (i) this.f36748b.getValue();
    }

    /* access modifiers changed from: private */
    public final T i(com.google.gson.j jVar, com.google.gson.d dVar, Class<T> cls) {
        l p10 = jVar.d().p(MamElements.MamResultExtension.ELEMENT);
        j.f(p10, "jsonElement.asJsonObject.getAsJsonObject(\"result\")");
        return dVar.g(p10, cls);
    }

    /* access modifiers changed from: private */
    public final T j(com.google.gson.j jVar, com.google.gson.d dVar, Class<T> cls) {
        return dVar.g(jVar.d().q("success"), cls);
    }

    public final w<T> e(String str, long j10, int i10, Class<T> cls, PurchaseRequestSource purchaseRequestSource, String str2, String str3, String str4) {
        boolean z10;
        boolean z11;
        j.g(str, "itemName");
        j.g(cls, "listenerType");
        PurchaseRequest purchaseRequest = new PurchaseRequest(str, j10, i10);
        boolean z12 = true;
        if (str2 != null) {
            if (str2.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                purchaseRequest.setBagelId(str2);
            }
        }
        if (purchaseRequestSource != null) {
            purchaseRequest.setSource(Integer.valueOf(purchaseRequestSource.ordinal()));
        }
        if (str3 != null) {
            if (str3.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                purchaseRequest.setGiveTenId(str3);
            }
        }
        if (str4 != null) {
            if (str4.length() <= 0) {
                z12 = false;
            }
            if (z12) {
                purchaseRequest.setDiscoverSearchResultId(str4);
            }
        }
        w<R> v10 = h().a(purchaseRequest).K(a.c()).v(new f(new PurchaseRepository$buyItem$1(this, new e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b(), cls)));
        j.f(v10, "T> @Inject constructor(p…    }\n            }\n    }");
        return v10;
    }
}
