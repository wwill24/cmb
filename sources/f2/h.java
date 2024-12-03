package f2;

import android.content.Context;
import b2.f;
import com.mparticle.identity.IdentityHttpResponse;
import d2.a;
import i2.b;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\b\u0004\u0012\u0006\u0010\"\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b#\u0010$J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0004X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R$\u0010 \u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00008F@FX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001d¨\u0006%"}, d2 = {"Lf2/h;", "T", "", "Ld2/a;", "listener", "", "c", "f", "h", "i", "Li2/b;", "a", "Li2/b;", "taskExecutor", "Landroid/content/Context;", "b", "Landroid/content/Context;", "d", "()Landroid/content/Context;", "appContext", "Ljava/lang/Object;", "lock", "Ljava/util/LinkedHashSet;", "Ljava/util/LinkedHashSet;", "listeners", "e", "currentState", "newState", "getState", "()Ljava/lang/Object;", "g", "(Ljava/lang/Object;)V", "state", "initialState", "context", "<init>", "(Landroid/content/Context;Li2/b;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class h<T> {

    /* renamed from: a  reason: collision with root package name */
    private final b f14648a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f14649b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f14650c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet<a<T>> f14651d = new LinkedHashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private T f14652e;

    protected h(Context context, b bVar) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(bVar, "taskExecutor");
        this.f14648a = bVar;
        Context applicationContext = context.getApplicationContext();
        j.f(applicationContext, "context.applicationContext");
        this.f14649b = applicationContext;
    }

    /* access modifiers changed from: private */
    public static final void b(List list, h hVar) {
        j.g(list, "$listenersList");
        j.g(hVar, "this$0");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(hVar.f14652e);
        }
    }

    public final void c(a<T> aVar) {
        j.g(aVar, "listener");
        synchronized (this.f14650c) {
            if (this.f14651d.add(aVar)) {
                if (this.f14651d.size() == 1) {
                    this.f14652e = e();
                    f e10 = f.e();
                    String a10 = i.f14653a;
                    e10.a(a10, getClass().getSimpleName() + ": initial state = " + this.f14652e);
                    h();
                }
                aVar.a(this.f14652e);
            }
            Unit unit = Unit.f32013a;
        }
    }

    /* access modifiers changed from: protected */
    public final Context d() {
        return this.f14649b;
    }

    public abstract T e();

    public final void f(a<T> aVar) {
        j.g(aVar, "listener");
        synchronized (this.f14650c) {
            if (this.f14651d.remove(aVar) && this.f14651d.isEmpty()) {
                i();
            }
            Unit unit = Unit.f32013a;
        }
    }

    public final void g(T t10) {
        synchronized (this.f14650c) {
            T t11 = this.f14652e;
            if (t11 == null || !j.b(t11, t10)) {
                this.f14652e = t10;
                this.f14648a.a().execute(new g(CollectionsKt___CollectionsKt.x0(this.f14651d), this));
                Unit unit = Unit.f32013a;
            }
        }
    }

    public abstract void h();

    public abstract void i();
}
