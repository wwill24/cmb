package b2;

import androidx.work.OverwritingInputMerger;
import androidx.work.c;
import b2.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0002\u0007\bB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lb2/g;", "Lb2/n;", "Lb2/g$a;", "builder", "<init>", "(Lb2/g$a;)V", "e", "a", "b", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class g extends n {

    /* renamed from: e  reason: collision with root package name */
    public static final b f7742e = new b((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00008PX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lb2/g$a;", "Lb2/n$a;", "Lb2/g;", "k", "()Lb2/g;", "l", "()Lb2/g$a;", "thisObject", "Ljava/lang/Class;", "Landroidx/work/c;", "workerClass", "<init>", "(Ljava/lang/Class;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a extends n.a<a, g> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Class<? extends c> cls) {
            super(cls);
            j.g(cls, "workerClass");
            g().f15080d = OverwritingInputMerger.class.getName();
        }

        /* renamed from: k */
        public g b() {
            boolean z10;
            if (!c() || !g().f15086j.h()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return new g(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
        }

        /* renamed from: l */
        public a f() {
            return this;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0007¨\u0006\t"}, d2 = {"Lb2/g$b;", "", "Ljava/lang/Class;", "Landroidx/work/c;", "workerClass", "Lb2/g;", "a", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a(Class<? extends c> cls) {
            j.g(cls, "workerClass");
            return (g) new a(cls).a();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(a aVar) {
        super(aVar.d(), aVar.g(), aVar.e());
        j.g(aVar, "builder");
    }

    public static final g e(Class<? extends c> cls) {
        return f7742e.a(cls);
    }
}
