package com.clevertap.android.sdk.db;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.s;
import i4.e;
import java.util.Iterator;
import org.json.JSONException;
import org.json.a;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private DBAdapter f10175a;

    /* renamed from: b  reason: collision with root package name */
    private final e f10176b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f10177c;

    public b(CleverTapInstanceConfig cleverTapInstanceConfig, e eVar) {
        this.f10177c = cleverTapInstanceConfig;
        this.f10176b = eVar;
    }

    private void f(Context context) {
        s.n(context, s.s(this.f10177c, "comms_first_ts"), 0);
    }

    private void g(Context context) {
        SharedPreferences.Editor edit = s.h(context, "IJ").edit();
        edit.clear();
        s.l(edit);
    }

    private void h(Context context) {
        s.n(context, s.s(this.f10177c, "comms_last_ts"), 0);
    }

    private void i(Context context) {
        g(context);
        f(context);
        h(context);
    }

    private void m(Context context, org.json.b bVar, DBAdapter.Table table) {
        synchronized (this.f10176b.a()) {
            if (c(context).J(bVar, table) > 0) {
                p n10 = this.f10177c.n();
                String e10 = this.f10177c.e();
                n10.f(e10, "Queued event: " + bVar.toString());
                p n11 = this.f10177c.n();
                String e11 = this.f10177c.e();
                n11.t(e11, "Queued event to DB table " + table + ": " + bVar.toString());
            }
        }
    }

    public void a(Context context) {
        synchronized (this.f10176b.a()) {
            DBAdapter c10 = c(context);
            c10.H(DBAdapter.Table.EVENTS);
            c10.H(DBAdapter.Table.PROFILE_EVENTS);
            i(context);
        }
    }

    public c b(Context context, int i10, c cVar, EventGroup eventGroup) {
        if (eventGroup == EventGroup.PUSH_NOTIFICATION_VIEWED) {
            this.f10177c.n().t(this.f10177c.e(), "Returning Queued Notification Viewed events");
            return j(context, i10, cVar);
        }
        this.f10177c.n().t(this.f10177c.e(), "Returning Queued events");
        return l(context, i10, cVar);
    }

    public DBAdapter c(Context context) {
        if (this.f10175a == null) {
            DBAdapter dBAdapter = new DBAdapter(context, this.f10177c);
            this.f10175a = dBAdapter;
            dBAdapter.u(DBAdapter.Table.EVENTS);
            this.f10175a.u(DBAdapter.Table.PROFILE_EVENTS);
            this.f10175a.u(DBAdapter.Table.PUSH_NOTIFICATION_VIEWED);
            this.f10175a.s();
        }
        return this.f10175a;
    }

    public void d(Context context, org.json.b bVar, int i10) {
        DBAdapter.Table table;
        if (i10 == 3) {
            table = DBAdapter.Table.PROFILE_EVENTS;
        } else {
            table = DBAdapter.Table.EVENTS;
        }
        m(context, bVar, table);
    }

    public void e(Context context, org.json.b bVar) {
        m(context, bVar, DBAdapter.Table.PUSH_NOTIFICATION_VIEWED);
    }

    /* access modifiers changed from: package-private */
    public c j(Context context, int i10, c cVar) {
        return k(context, DBAdapter.Table.PUSH_NOTIFICATION_VIEWED, i10, cVar);
    }

    /* access modifiers changed from: package-private */
    public c k(Context context, DBAdapter.Table table, int i10, c cVar) {
        c n10;
        synchronized (this.f10176b.a()) {
            DBAdapter c10 = c(context);
            if (cVar != null) {
                table = cVar.c();
            }
            if (cVar != null) {
                c10.t(cVar.b(), cVar.c());
            }
            c cVar2 = new c();
            cVar2.g(table);
            n10 = n(c10.y(table, i10), cVar2);
        }
        return n10;
    }

    /* access modifiers changed from: package-private */
    public c l(Context context, int i10, c cVar) {
        c cVar2;
        synchronized (this.f10176b.a()) {
            DBAdapter.Table table = DBAdapter.Table.EVENTS;
            c k10 = k(context, table, i10, cVar);
            cVar2 = null;
            if (k10.d().booleanValue() && k10.c().equals(table)) {
                k10 = k(context, DBAdapter.Table.PROFILE_EVENTS, i10, (c) null);
            }
            if (!k10.d().booleanValue()) {
                cVar2 = k10;
            }
        }
        return cVar2;
    }

    /* access modifiers changed from: package-private */
    public c n(org.json.b bVar, c cVar) {
        if (bVar == null) {
            return cVar;
        }
        Iterator<String> keys = bVar.keys();
        if (keys.hasNext()) {
            String next = keys.next();
            cVar.f(next);
            try {
                cVar.e(bVar.getJSONArray(next));
            } catch (JSONException unused) {
                cVar.f((String) null);
                cVar.e((a) null);
            }
        }
        return cVar;
    }
}
