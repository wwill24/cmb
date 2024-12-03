package ci;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import r1.d;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J.\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0001*\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0010¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0011"}, d2 = {"Lci/b;", "", "Landroid/view/View;", "view", "Lr1/d;", "d", "T", "Landroid/content/Context;", "Lwk/c;", "ownerClass", "b", "(Landroid/content/Context;Lwk/c;)Ljava/lang/Object;", "Landroidx/lifecycle/l;", "a", "c", "<init>", "()V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f19008a = new b();

    private b() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T b(android.content.Context r3, wk.c<T> r4) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r4.isInstance(r3)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            java.lang.Object r1 = wk.d.a(r4, r3)
            goto L_0x001d
        L_0x000c:
            boolean r0 = r3 instanceof android.content.ContextWrapper
            if (r0 == 0) goto L_0x0013
            android.content.ContextWrapper r3 = (android.content.ContextWrapper) r3
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            if (r3 != 0) goto L_0x0017
            goto L_0x001d
        L_0x0017:
            android.content.Context r3 = r3.getBaseContext()
            if (r3 != 0) goto L_0x0000
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ci.b.b(android.content.Context, wk.c):java.lang.Object");
    }

    private final d d(View view) {
        d a10 = ViewTreeSavedStateRegistryOwner.a(view);
        if (a10 != null) {
            return a10;
        }
        Context context = view.getContext();
        j.f(context, "view.context");
        return (d) b(context, l.b(d.class));
    }

    public final androidx.lifecycle.l a(View view) {
        j.g(view, "view");
        androidx.lifecycle.l a10 = ViewTreeLifecycleOwner.a(view);
        if (a10 != null) {
            return a10;
        }
        Context context = view.getContext();
        j.f(context, "view.context");
        return (androidx.lifecycle.l) b(context, l.b(androidx.lifecycle.l.class));
    }

    public final d c(View view) {
        j.g(view, "view");
        d d10 = d(view);
        if (d10 != null) {
            return d10;
        }
        throw new IllegalStateException(j.p("Expected to find a SavedStateRegistryOwner either in a parent view or the Context of ", view).toString());
    }
}
