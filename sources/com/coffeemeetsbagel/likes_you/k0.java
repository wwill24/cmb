package com.coffeemeetsbagel.likes_you;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class k0 implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f34232a;

    public /* synthetic */ k0(Function2 function2) {
        this.f34232a = function2;
    }

    public final int compare(Object obj, Object obj2) {
        return LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$4.d(this.f34232a, obj, obj2);
    }
}
