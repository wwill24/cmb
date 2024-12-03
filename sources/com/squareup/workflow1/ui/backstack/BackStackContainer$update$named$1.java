package com.squareup.workflow1.ui.backstack;

import com.squareup.workflow1.ui.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lcom/squareup/workflow1/ui/h;", "a", "(Ljava/lang/Object;)Lcom/squareup/workflow1/ui/h;"}, k = 3, mv = {1, 6, 0})
final class BackStackContainer$update$named$1 extends Lambda implements Function1<Object, h<?>> {

    /* renamed from: a  reason: collision with root package name */
    public static final BackStackContainer$update$named$1 f23227a = new BackStackContainer$update$named$1();

    BackStackContainer$update$named$1() {
        super(1);
    }

    /* renamed from: a */
    public final h<?> invoke(Object obj) {
        j.g(obj, "it");
        return new h<>(obj, "backstack");
    }
}
