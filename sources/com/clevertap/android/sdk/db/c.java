package com.clevertap.android.sdk.db;

import com.clevertap.android.sdk.db.DBAdapter;
import org.json.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private a f10178a;

    /* renamed from: b  reason: collision with root package name */
    private String f10179b;

    /* renamed from: c  reason: collision with root package name */
    private DBAdapter.Table f10180c;

    public a a() {
        return this.f10178a;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.f10179b;
    }

    /* access modifiers changed from: package-private */
    public DBAdapter.Table c() {
        return this.f10180c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f10178a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean d() {
        /*
            r1 = this;
            java.lang.String r0 = r1.f10179b
            if (r0 == 0) goto L_0x0011
            org.json.a r0 = r1.f10178a
            if (r0 == 0) goto L_0x0011
            int r0 = r0.o()
            if (r0 > 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = 0
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.c.d():java.lang.Boolean");
    }

    /* access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f10178a = aVar;
    }

    /* access modifiers changed from: package-private */
    public void f(String str) {
        this.f10179b = str;
    }

    /* access modifiers changed from: package-private */
    public void g(DBAdapter.Table table) {
        this.f10180c = table;
    }

    public String toString() {
        if (d().booleanValue()) {
            return "tableName: " + this.f10180c + " | numItems: 0";
        }
        return "tableName: " + this.f10180c + " | lastId: " + this.f10179b + " | numItems: " + this.f10178a.o() + " | items: " + this.f10178a.toString();
    }
}
