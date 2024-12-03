package androidx.work.impl;

import android.content.Context;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/work/impl/s;", "Lp1/b;", "Lt1/i;", "db", "", "a", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mContext", "", "startVersion", "endVersion", "<init>", "(Landroid/content/Context;II)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class s extends b {

    /* renamed from: c  reason: collision with root package name */
    private final Context f7599c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(Context context, int i10, int i11) {
        super(i10, i11);
        j.g(context, "mContext");
        this.f7599c = context;
    }

    public void a(i iVar) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        if (this.f16905b >= 10) {
            iVar.a0("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
            return;
        }
        this.f7599c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
    }
}
