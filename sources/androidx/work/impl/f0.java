package androidx.work.impl;

import android.content.Context;
import com.facebook.appevents.UserDataStore;
import com.mparticle.identity.IdentityHttpResponse;
import h2.o;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/work/impl/f0;", "Lp1/b;", "Lt1/i;", "db", "", "a", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class f0 extends b {

    /* renamed from: c  reason: collision with root package name */
    private final Context f7503c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(Context context) {
        super(9, 10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f7503c = context;
    }

    public void a(i iVar) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        iVar.D("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        o.c(this.f7503c, iVar);
        h2.j.c(this.f7503c, iVar);
    }
}
