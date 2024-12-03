package com.coffeemeetsbagel.store.alc;

import com.google.gson.d;
import com.google.gson.j;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jivesoftware.smackx.mam.element.MamElements;
import qj.b0;
import qj.w;

final class PurchaseRepository$buyItem$1 extends Lambda implements Function1<j, b0<? extends T>> {
    final /* synthetic */ d $gson;
    final /* synthetic */ Class<T> $listenerType;
    final /* synthetic */ PurchaseRepository<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchaseRepository$buyItem$1(PurchaseRepository<T> purchaseRepository, d dVar, Class<T> cls) {
        super(1);
        this.this$0 = purchaseRepository;
        this.$gson = dVar;
        this.$listenerType = cls;
    }

    /* access modifiers changed from: private */
    public static final Object d(j jVar, PurchaseRepository purchaseRepository, d dVar, Class cls) {
        kotlin.jvm.internal.j.g(jVar, "$jsonElement");
        kotlin.jvm.internal.j.g(purchaseRepository, "this$0");
        kotlin.jvm.internal.j.g(cls, "$listenerType");
        if (jVar.d().r(MamElements.MamResultExtension.ELEMENT)) {
            kotlin.jvm.internal.j.f(dVar, "gson");
            return purchaseRepository.i(jVar, dVar, cls);
        }
        kotlin.jvm.internal.j.f(dVar, "gson");
        return purchaseRepository.j(jVar, dVar, cls);
    }

    /* renamed from: c */
    public final b0<? extends T> invoke(j jVar) {
        kotlin.jvm.internal.j.g(jVar, "jsonElement");
        return w.A(new g(jVar, this.this$0, this.$gson, this.$listenerType));
    }
}
