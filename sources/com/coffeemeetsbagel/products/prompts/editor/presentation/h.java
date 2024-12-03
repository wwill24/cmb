package com.coffeemeetsbagel.products.prompts.editor.presentation;

import com.coffeemeetsbagel.products.prompts.editor.presentation.g;
import fj.d;
import fk.a;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

public final class h implements d<qj.h<Unit>> {

    /* renamed from: a  reason: collision with root package name */
    private final g.b f35938a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PublishSubject<Unit>> f35939b;

    public h(g.b bVar, a<PublishSubject<Unit>> aVar) {
        this.f35938a = bVar;
        this.f35939b = aVar;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [io.reactivex.subjects.PublishSubject, io.reactivex.subjects.PublishSubject<kotlin.Unit>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static qj.h<kotlin.Unit> a(com.coffeemeetsbagel.products.prompts.editor.presentation.g.b r0, io.reactivex.subjects.PublishSubject<kotlin.Unit> r1) {
        /*
            qj.h r0 = r0.a(r1)
            java.lang.Object r0 = fj.g.e(r0)
            qj.h r0 = (qj.h) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.products.prompts.editor.presentation.h.a(com.coffeemeetsbagel.products.prompts.editor.presentation.g$b, io.reactivex.subjects.PublishSubject):qj.h");
    }

    public static h b(g.b bVar, a<PublishSubject<Unit>> aVar) {
        return new h(bVar, aVar);
    }

    /* renamed from: c */
    public qj.h<Unit> get() {
        return a(this.f35938a, this.f35939b.get());
    }
}
