package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.work.impl.background.systemalarm.g;
import b2.f;
import d2.e;
import g2.u;
import g2.x;
import java.util.ArrayList;
import java.util.List;

class c {

    /* renamed from: e  reason: collision with root package name */
    private static final String f7436e = f.i("ConstraintsCmdHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f7437a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7438b;

    /* renamed from: c  reason: collision with root package name */
    private final g f7439c;

    /* renamed from: d  reason: collision with root package name */
    private final e f7440d;

    c(@NonNull Context context, int i10, @NonNull g gVar) {
        this.f7437a = context;
        this.f7438b = i10;
        this.f7439c = gVar;
        this.f7440d = new e(gVar.g().n(), (d2.c) null);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        List<u> d10 = this.f7439c.g().o().K().d();
        ConstraintProxy.a(this.f7437a, d10);
        this.f7440d.a(d10);
        ArrayList<u> arrayList = new ArrayList<>(d10.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (u next : d10) {
            String str = next.f15077a;
            if (currentTimeMillis >= next.c() && (!next.h() || this.f7440d.d(str))) {
                arrayList.add(next);
            }
        }
        for (u uVar : arrayList) {
            String str2 = uVar.f15077a;
            Intent c10 = b.c(this.f7437a, x.a(uVar));
            f e10 = f.e();
            String str3 = f7436e;
            e10.a(str3, "Creating a delay_met command for workSpec with id (" + str2 + ")");
            this.f7439c.f().a().execute(new g.b(this.f7439c, c10, this.f7438b));
        }
        this.f7440d.reset();
    }
}
