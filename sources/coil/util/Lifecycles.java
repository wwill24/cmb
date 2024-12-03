package coil.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "", "a", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroidx/lifecycle/k;", "observer", "b", "coil-base_release"}, k = 2, mv = {1, 7, 1})
/* renamed from: coil.util.-Lifecycles  reason: invalid class name */
public final class Lifecycles {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(androidx.lifecycle.Lifecycle r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof coil.util.Lifecycles$awaitStarted$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            coil.util.-Lifecycles$awaitStarted$1 r0 = (coil.util.Lifecycles$awaitStarted$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            coil.util.-Lifecycles$awaitStarted$1 r0 = new coil.util.-Lifecycles$awaitStarted$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref$ObjectRef) r6
            java.lang.Object r0 = r0.L$0
            androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
            gk.g.b(r7)     // Catch:{ all -> 0x0031 }
            goto L_0x0085
        L_0x0031:
            r7 = move-exception
            goto L_0x0096
        L_0x0033:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003b:
            gk.g.b(r7)
            androidx.lifecycle.Lifecycle$State r7 = r6.b()
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r7 = r7.b(r2)
            if (r7 == 0) goto L_0x004d
            kotlin.Unit r6 = kotlin.Unit.f32013a
            return r6
        L_0x004d:
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r0.L$0 = r6     // Catch:{ all -> 0x0091 }
            r0.L$1 = r7     // Catch:{ all -> 0x0091 }
            r0.label = r3     // Catch:{ all -> 0x0091 }
            kotlinx.coroutines.o r2 = new kotlinx.coroutines.o     // Catch:{ all -> 0x0091 }
            kotlin.coroutines.c r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r0)     // Catch:{ all -> 0x0091 }
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0091 }
            r2.y()     // Catch:{ all -> 0x0091 }
            coil.util.-Lifecycles$awaitStarted$2$1 r3 = new coil.util.-Lifecycles$awaitStarted$2$1     // Catch:{ all -> 0x0091 }
            r3.<init>(r2)     // Catch:{ all -> 0x0091 }
            r7.element = r3     // Catch:{ all -> 0x0091 }
            kotlin.jvm.internal.j.d(r3)     // Catch:{ all -> 0x0091 }
            androidx.lifecycle.k r3 = (androidx.lifecycle.k) r3     // Catch:{ all -> 0x0091 }
            r6.a(r3)     // Catch:{ all -> 0x0091 }
            java.lang.Object r2 = r2.v()     // Catch:{ all -> 0x0091 }
            java.lang.Object r3 = kotlin.coroutines.intrinsics.b.d()     // Catch:{ all -> 0x0091 }
            if (r2 != r3) goto L_0x0080
            kotlin.coroutines.jvm.internal.f.c(r0)     // Catch:{ all -> 0x0091 }
        L_0x0080:
            if (r2 != r1) goto L_0x0083
            return r1
        L_0x0083:
            r0 = r6
            r6 = r7
        L_0x0085:
            T r6 = r6.element
            androidx.lifecycle.k r6 = (androidx.lifecycle.k) r6
            if (r6 == 0) goto L_0x008e
            r0.d(r6)
        L_0x008e:
            kotlin.Unit r6 = kotlin.Unit.f32013a
            return r6
        L_0x0091:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L_0x0096:
            T r6 = r6.element
            androidx.lifecycle.k r6 = (androidx.lifecycle.k) r6
            if (r6 == 0) goto L_0x009f
            r0.d(r6)
        L_0x009f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.Lifecycles.a(androidx.lifecycle.Lifecycle, kotlin.coroutines.c):java.lang.Object");
    }

    public static final void b(Lifecycle lifecycle, k kVar) {
        lifecycle.d(kVar);
        lifecycle.a(kVar);
    }
}
