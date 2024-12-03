package n4;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.task.Task;
import i4.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.json.JSONException;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final DBAdapter f16426a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<e> f16427b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f16428c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f16429d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f16430e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final e f16431f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final i4.b f16432g;

    /* renamed from: h  reason: collision with root package name */
    private final CleverTapInstanceConfig f16433h;

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CTInboxMessage f16434a;

        a(CTInboxMessage cTInboxMessage) {
            this.f16434a = cTInboxMessage;
        }

        /* renamed from: a */
        public Void call() {
            synchronized (d.this.f16431f.b()) {
                if (d.this.d(this.f16434a.f())) {
                    d.this.f16432g.b();
                }
            }
            return null;
        }
    }

    class b implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16436a;

        b(String str) {
            this.f16436a = str;
        }

        /* renamed from: a */
        public Void call() {
            d.this.f16426a.w(this.f16436a, d.this.f16429d);
            return null;
        }
    }

    class c implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16438a;

        c(String str) {
            this.f16438a = str;
        }

        /* renamed from: a */
        public Void call() {
            d.this.f16426a.G(this.f16438a, d.this.f16429d);
            return null;
        }
    }

    public d(CleverTapInstanceConfig cleverTapInstanceConfig, String str, DBAdapter dBAdapter, e eVar, i4.b bVar, boolean z10) {
        this.f16429d = str;
        this.f16426a = dBAdapter;
        this.f16427b = dBAdapter.F(str);
        this.f16430e = z10;
        this.f16431f = eVar;
        this.f16432g = bVar;
        this.f16433h = cleverTapInstanceConfig;
    }

    private e j(String str) {
        synchronized (this.f16428c) {
            Iterator<e> it = this.f16427b.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.e().equals(str)) {
                    return next;
                }
            }
            p.o("Inbox Message for message id - " + str + " not found");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(Void voidR) {
        this.f16432g.b();
    }

    private void p() {
        boolean z10;
        p.o("CTInboxController:trimMessages() called");
        ArrayList arrayList = new ArrayList();
        synchronized (this.f16428c) {
            Iterator<e> it = this.f16427b.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (this.f16430e || !next.a()) {
                    long d10 = next.d();
                    if (d10 <= 0 || System.currentTimeMillis() / 1000 <= d10) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        p.o("Inbox Message: " + next.e() + " is expired - removing");
                        arrayList.add(next);
                    }
                } else {
                    p.a("Removing inbox message containing video/audio as app does not support video. For more information checkout CleverTap documentation.");
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    c(((e) it2.next()).e());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str) {
        e j10 = j(str);
        if (j10 == null) {
            return false;
        }
        synchronized (this.f16428c) {
            this.f16427b.remove(j10);
        }
        com.clevertap.android.sdk.task.a.a(this.f16433h).c().f("RunDeleteMessage", new b(str));
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean d(String str) {
        e j10 = j(str);
        if (j10 == null) {
            return false;
        }
        synchronized (this.f16428c) {
            j10.r(1);
        }
        Task c10 = com.clevertap.android.sdk.task.a.a(this.f16433h).c();
        c10.e(new b(this));
        c10.c(new c(str));
        c10.f("RunMarkMessageRead", new c(str));
        return true;
    }

    public int i() {
        return l().size();
    }

    public e k(String str) {
        return j(str);
    }

    public ArrayList<e> l() {
        ArrayList<e> arrayList;
        synchronized (this.f16428c) {
            p();
            arrayList = this.f16427b;
        }
        return arrayList;
    }

    public void o(CTInboxMessage cTInboxMessage) {
        com.clevertap.android.sdk.task.a.a(this.f16433h).c().f("markReadInboxMessage", new a(cTInboxMessage));
    }

    public boolean q(org.json.a aVar) {
        p.o("CTInboxController:updateMessages() called");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            try {
                e k10 = e.k(aVar.j(i10), this.f16429d);
                if (k10 != null) {
                    if (this.f16430e || !k10.a()) {
                        arrayList.add(k10);
                        p.o("Inbox Message for message id - " + k10.e() + " added");
                    } else {
                        p.a("Dropping inbox message containing video/audio as app does not support video. For more information checkout CleverTap documentation.");
                    }
                }
            } catch (JSONException e10) {
                p.a("Unable to update notification inbox messages - " + e10.getLocalizedMessage());
            }
        }
        if (arrayList.size() <= 0) {
            return false;
        }
        this.f16426a.O(arrayList);
        p.o("New Notification Inbox messages added");
        synchronized (this.f16428c) {
            this.f16427b = this.f16426a.F(this.f16429d);
            p();
        }
        return true;
    }
}
