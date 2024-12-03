package androidx.work.impl;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.h0;
import androidx.sqlite.db.framework.d;
import com.mparticle.identity.IdentityHttpResponse;
import g2.b;
import g2.e;
import g2.o;
import g2.r;
import g2.v;
import g2.z;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import t1.j;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&¨\u0006\u0014"}, d2 = {"Landroidx/work/impl/WorkDatabase;", "Landroidx/room/RoomDatabase;", "Lg2/v;", "K", "Lg2/b;", "F", "Lg2/z;", "L", "Lg2/j;", "H", "Lg2/o;", "I", "Lg2/r;", "J", "Lg2/e;", "G", "<init>", "()V", "p", "a", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class WorkDatabase extends RoomDatabase {

    /* renamed from: p  reason: collision with root package name */
    public static final a f7407p = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Landroidx/work/impl/WorkDatabase$a;", "", "Landroid/content/Context;", "context", "Ljava/util/concurrent/Executor;", "queryExecutor", "", "useTestDatabase", "Landroidx/work/impl/WorkDatabase;", "b", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public static final j c(Context context, j.b bVar) {
            kotlin.jvm.internal.j.g(context, "$context");
            kotlin.jvm.internal.j.g(bVar, "configuration");
            j.b.a a10 = j.b.f17636f.a(context);
            a10.d(bVar.f17638b).c(bVar.f17639c).e(true).a(true);
            return new d().a(a10.b());
        }

        public final WorkDatabase b(Context context, Executor executor, boolean z10) {
            RoomDatabase.a<WorkDatabase> aVar;
            Class<WorkDatabase> cls = WorkDatabase.class;
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            kotlin.jvm.internal.j.g(executor, "queryExecutor");
            if (z10) {
                aVar = h0.c(context, cls).c();
            } else {
                aVar = h0.a(context, cls, "androidx.work.workdb").f(new y(context));
            }
            return aVar.g(executor).a(c.f7484a).b(i.f7569c).b(new s(context, 2, 3)).b(j.f7570c).b(k.f7571c).b(new s(context, 5, 6)).b(l.f7572c).b(m.f7573c).b(n.f7574c).b(new f0(context)).b(new s(context, 10, 11)).b(f.f7502c).b(g.f7532c).b(h.f7535c).e().d();
        }
    }

    public static final WorkDatabase E(Context context, Executor executor, boolean z10) {
        return f7407p.b(context, executor, z10);
    }

    public abstract b F();

    public abstract e G();

    public abstract g2.j H();

    public abstract o I();

    public abstract r J();

    public abstract v K();

    public abstract z L();
}
