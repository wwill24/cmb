package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.g;
import androidx.work.impl.e;
import androidx.work.impl.v;
import androidx.work.impl.w;
import b2.f;
import g2.m;
import g2.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b implements e {

    /* renamed from: e  reason: collision with root package name */
    private static final String f7431e = f.i("CommandHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f7432a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<m, f> f7433b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Object f7434c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final w f7435d;

    b(@NonNull Context context, @NonNull w wVar) {
        this.f7432a = context;
        this.f7435d = wVar;
    }

    static Intent b(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    static Intent c(@NonNull Context context, @NonNull m mVar) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        return q(intent, mVar);
    }

    static Intent d(@NonNull Context context, @NonNull m mVar, boolean z10) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z10);
        return q(intent, mVar);
    }

    static Intent e(@NonNull Context context, @NonNull m mVar) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        return q(intent, mVar);
    }

    static Intent f(@NonNull Context context, @NonNull m mVar) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        return q(intent, mVar);
    }

    private void g(@NonNull Intent intent, int i10, @NonNull g gVar) {
        f e10 = f.e();
        String str = f7431e;
        e10.a(str, "Handling constraints changed " + intent);
        new c(this.f7432a, i10, gVar).a();
    }

    private void h(@NonNull Intent intent, int i10, @NonNull g gVar) {
        synchronized (this.f7434c) {
            m p10 = p(intent);
            f e10 = f.e();
            String str = f7431e;
            e10.a(str, "Handing delay met for " + p10);
            if (!this.f7433b.containsKey(p10)) {
                f fVar = new f(this.f7432a, i10, gVar, this.f7435d.d(p10));
                this.f7433b.put(p10, fVar);
                fVar.g();
            } else {
                f e11 = f.e();
                e11.a(str, "WorkSpec " + p10 + " is is already being handled for ACTION_DELAY_MET");
            }
        }
    }

    private void i(@NonNull Intent intent, int i10) {
        m p10 = p(intent);
        boolean z10 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
        f e10 = f.e();
        String str = f7431e;
        e10.a(str, "Handling onExecutionCompleted " + intent + ", " + i10);
        a(p10, z10);
    }

    private void j(@NonNull Intent intent, int i10, @NonNull g gVar) {
        f e10 = f.e();
        String str = f7431e;
        e10.a(str, "Handling reschedule " + intent + ", " + i10);
        gVar.g().s();
    }

    private void k(@NonNull Intent intent, int i10, @NonNull g gVar) {
        m p10 = p(intent);
        f e10 = f.e();
        String str = f7431e;
        e10.a(str, "Handling schedule work for " + p10);
        WorkDatabase o10 = gVar.g().o();
        o10.e();
        try {
            u h10 = o10.K().h(p10.b());
            if (h10 == null) {
                f e11 = f.e();
                e11.k(str, "Skipping scheduling " + p10 + " because it's no longer in the DB");
            } else if (h10.f15078b.b()) {
                f e12 = f.e();
                e12.k(str, "Skipping scheduling " + p10 + "because it is finished.");
                o10.j();
            } else {
                long c10 = h10.c();
                if (!h10.h()) {
                    f e13 = f.e();
                    e13.a(str, "Setting up Alarms for " + p10 + "at " + c10);
                    a.c(this.f7432a, o10, p10, c10);
                } else {
                    f e14 = f.e();
                    e14.a(str, "Opportunistically setting an alarm for " + p10 + "at " + c10);
                    a.c(this.f7432a, o10, p10, c10);
                    gVar.f().a().execute(new g.b(gVar, b(this.f7432a), i10));
                }
                o10.C();
                o10.j();
            }
        } finally {
            o10.j();
        }
    }

    private void l(@NonNull Intent intent, @NonNull g gVar) {
        List<v> list;
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        if (extras.containsKey("KEY_WORKSPEC_GENERATION")) {
            int i10 = extras.getInt("KEY_WORKSPEC_GENERATION");
            list = new ArrayList<>(1);
            v b10 = this.f7435d.b(new m(string, i10));
            if (b10 != null) {
                list.add(b10);
            }
        } else {
            list = this.f7435d.c(string);
        }
        for (v vVar : list) {
            f e10 = f.e();
            String str = f7431e;
            e10.a(str, "Handing stopWork work for " + string);
            gVar.g().x(vVar);
            a.a(this.f7432a, gVar.g().o(), vVar.a());
            gVar.a(vVar.a(), false);
        }
    }

    private static boolean m(Bundle bundle, @NonNull String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    static m p(@NonNull Intent intent) {
        return new m(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    private static Intent q(@NonNull Intent intent, @NonNull m mVar) {
        intent.putExtra("KEY_WORKSPEC_ID", mVar.b());
        intent.putExtra("KEY_WORKSPEC_GENERATION", mVar.a());
        return intent;
    }

    public void a(@NonNull m mVar, boolean z10) {
        synchronized (this.f7434c) {
            f remove = this.f7433b.remove(mVar);
            this.f7435d.b(mVar);
            if (remove != null) {
                remove.h(z10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        boolean z10;
        synchronized (this.f7434c) {
            if (!this.f7433b.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void o(@NonNull Intent intent, int i10, @NonNull g gVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            g(intent, i10, gVar);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            j(intent, i10, gVar);
        } else if (!m(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            f e10 = f.e();
            String str = f7431e;
            e10.c(str, "Invalid request for " + action + " , requires " + "KEY_WORKSPEC_ID" + " .");
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            k(intent, i10, gVar);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            h(intent, i10, gVar);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            l(intent, gVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            i(intent, i10);
        } else {
            f e11 = f.e();
            String str2 = f7431e;
            e11.k(str2, "Ignoring intent " + intent);
        }
    }
}
