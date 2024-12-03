package q1;

import android.database.Cursor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.b;
import kotlin.jvm.internal.j;
import q1.e;
import t1.i;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a$\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a \u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\"\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¨\u0006\u0017"}, d2 = {"Lt1/i;", "database", "", "tableName", "Lq1/e;", "f", "", "Lq1/e$c;", "c", "Landroid/database/Cursor;", "cursor", "", "Lq1/e$d;", "b", "", "Lq1/e$a;", "a", "Lq1/e$e;", "e", "name", "", "unique", "d", "room-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class f {
    private static final Map<String, e.a> a(i iVar, String str) {
        Throwable th2;
        boolean z10;
        Cursor q12 = iVar.q1("PRAGMA table_info(`" + str + "`)");
        try {
            if (q12.getColumnCount() <= 0) {
                Map<String, e.a> i10 = h0.i();
                b.a(q12, (Throwable) null);
                return i10;
            }
            int columnIndex = q12.getColumnIndex("name");
            int columnIndex2 = q12.getColumnIndex("type");
            int columnIndex3 = q12.getColumnIndex("notnull");
            int columnIndex4 = q12.getColumnIndex("pk");
            int columnIndex5 = q12.getColumnIndex("dflt_value");
            Map c10 = g0.c();
            while (q12.moveToNext()) {
                String string = q12.getString(columnIndex);
                String string2 = q12.getString(columnIndex2);
                if (q12.getInt(columnIndex3) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int i11 = q12.getInt(columnIndex4);
                String string3 = q12.getString(columnIndex5);
                j.f(string, "name");
                j.f(string2, "type");
                e.a aVar = r11;
                e.a aVar2 = new e.a(string, string2, z10, i11, string3, 2);
                c10.put(string, aVar);
            }
            Map<String, e.a> b10 = g0.b(c10);
            b.a(q12, (Throwable) null);
            return b10;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            b.a(q12, th2);
            throw th4;
        }
    }

    private static final List<e.d> b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        List c10 = p.c();
        while (cursor.moveToNext()) {
            int i10 = cursor.getInt(columnIndex);
            int i11 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            j.f(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            j.f(string2, "cursor.getString(toColumnIndex)");
            c10.add(new e.d(i10, i11, string, string2));
        }
        return CollectionsKt___CollectionsKt.o0(p.a(c10));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d5, code lost:
        kotlin.io.b.a(r14, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d8, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.Set<q1.e.c> c(t1.i r14, java.lang.String r15) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "PRAGMA foreign_key_list(`"
            r0.append(r1)
            r0.append(r15)
            java.lang.String r15 = "`)"
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            android.database.Cursor r14 = r14.q1(r15)
            r15 = 0
            java.lang.String r0 = "id"
            int r0 = r14.getColumnIndex(r0)     // Catch:{ all -> 0x00d2 }
            java.lang.String r1 = "seq"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = "table"
            int r2 = r14.getColumnIndex(r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = "on_delete"
            int r3 = r14.getColumnIndex(r3)     // Catch:{ all -> 0x00d2 }
            java.lang.String r4 = "on_update"
            int r4 = r14.getColumnIndex(r4)     // Catch:{ all -> 0x00d2 }
            java.util.List r5 = b(r14)     // Catch:{ all -> 0x00d2 }
            r6 = -1
            r14.moveToPosition(r6)     // Catch:{ all -> 0x00d2 }
            java.util.Set r6 = kotlin.collections.m0.b()     // Catch:{ all -> 0x00d2 }
        L_0x0045:
            boolean r7 = r14.moveToNext()     // Catch:{ all -> 0x00d2 }
            if (r7 == 0) goto L_0x00ca
            int r7 = r14.getInt(r1)     // Catch:{ all -> 0x00d2 }
            if (r7 == 0) goto L_0x0052
            goto L_0x0045
        L_0x0052:
            int r7 = r14.getInt(r0)     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r12.<init>()     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r13.<init>()     // Catch:{ all -> 0x00d2 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x00d2 }
            r8.<init>()     // Catch:{ all -> 0x00d2 }
            java.util.Iterator r9 = r5.iterator()     // Catch:{ all -> 0x00d2 }
        L_0x0069:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x00d2 }
            if (r10 == 0) goto L_0x0085
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x00d2 }
            r11 = r10
            q1.e$d r11 = (q1.e.d) r11     // Catch:{ all -> 0x00d2 }
            int r11 = r11.c()     // Catch:{ all -> 0x00d2 }
            if (r11 != r7) goto L_0x007e
            r11 = 1
            goto L_0x007f
        L_0x007e:
            r11 = 0
        L_0x007f:
            if (r11 == 0) goto L_0x0069
            r8.add(r10)     // Catch:{ all -> 0x00d2 }
            goto L_0x0069
        L_0x0085:
            java.util.Iterator r7 = r8.iterator()     // Catch:{ all -> 0x00d2 }
        L_0x0089:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x00d2 }
            if (r8 == 0) goto L_0x00a4
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x00d2 }
            q1.e$d r8 = (q1.e.d) r8     // Catch:{ all -> 0x00d2 }
            java.lang.String r9 = r8.b()     // Catch:{ all -> 0x00d2 }
            r12.add(r9)     // Catch:{ all -> 0x00d2 }
            java.lang.String r8 = r8.d()     // Catch:{ all -> 0x00d2 }
            r13.add(r8)     // Catch:{ all -> 0x00d2 }
            goto L_0x0089
        L_0x00a4:
            q1.e$c r7 = new q1.e$c     // Catch:{ all -> 0x00d2 }
            java.lang.String r9 = r14.getString(r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String r8 = "cursor.getString(tableColumnIndex)"
            kotlin.jvm.internal.j.f(r9, r8)     // Catch:{ all -> 0x00d2 }
            java.lang.String r10 = r14.getString(r3)     // Catch:{ all -> 0x00d2 }
            java.lang.String r8 = "cursor.getString(onDeleteColumnIndex)"
            kotlin.jvm.internal.j.f(r10, r8)     // Catch:{ all -> 0x00d2 }
            java.lang.String r11 = r14.getString(r4)     // Catch:{ all -> 0x00d2 }
            java.lang.String r8 = "cursor.getString(onUpdateColumnIndex)"
            kotlin.jvm.internal.j.f(r11, r8)     // Catch:{ all -> 0x00d2 }
            r8 = r7
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00d2 }
            r6.add(r7)     // Catch:{ all -> 0x00d2 }
            goto L_0x0045
        L_0x00ca:
            java.util.Set r0 = kotlin.collections.m0.a(r6)     // Catch:{ all -> 0x00d2 }
            kotlin.io.b.a(r14, r15)
            return r0
        L_0x00d2:
            r15 = move-exception
            throw r15     // Catch:{ all -> 0x00d4 }
        L_0x00d4:
            r0 = move-exception
            kotlin.io.b.a(r14, r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.f.c(t1.i, java.lang.String):java.util.Set");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a4, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a5, code lost:
        kotlin.io.b.a(r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        throw r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final q1.e.C0192e d(t1.i r12, java.lang.String r13, boolean r14) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "PRAGMA index_xinfo(`"
            r0.append(r1)
            r0.append(r13)
            java.lang.String r1 = "`)"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.database.Cursor r12 = r12.q1(r0)
            java.lang.String r0 = "seqno"
            int r0 = r12.getColumnIndex(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = "cid"
            int r1 = r12.getColumnIndex(r1)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "name"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = "desc"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ all -> 0x00a2 }
            r4 = 0
            r5 = -1
            if (r0 == r5) goto L_0x009e
            if (r1 == r5) goto L_0x009e
            if (r2 == r5) goto L_0x009e
            if (r3 != r5) goto L_0x003d
            goto L_0x009e
        L_0x003d:
            java.util.TreeMap r5 = new java.util.TreeMap     // Catch:{ all -> 0x00a2 }
            r5.<init>()     // Catch:{ all -> 0x00a2 }
            java.util.TreeMap r6 = new java.util.TreeMap     // Catch:{ all -> 0x00a2 }
            r6.<init>()     // Catch:{ all -> 0x00a2 }
        L_0x0047:
            boolean r7 = r12.moveToNext()     // Catch:{ all -> 0x00a2 }
            if (r7 == 0) goto L_0x007b
            int r7 = r12.getInt(r1)     // Catch:{ all -> 0x00a2 }
            if (r7 >= 0) goto L_0x0054
            goto L_0x0047
        L_0x0054:
            int r7 = r12.getInt(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.String r8 = r12.getString(r2)     // Catch:{ all -> 0x00a2 }
            int r9 = r12.getInt(r3)     // Catch:{ all -> 0x00a2 }
            if (r9 <= 0) goto L_0x0065
            java.lang.String r9 = "DESC"
            goto L_0x0067
        L_0x0065:
            java.lang.String r9 = "ASC"
        L_0x0067:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00a2 }
            java.lang.String r11 = "columnName"
            kotlin.jvm.internal.j.f(r8, r11)     // Catch:{ all -> 0x00a2 }
            r5.put(r10, r8)     // Catch:{ all -> 0x00a2 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00a2 }
            r6.put(r7, r9)     // Catch:{ all -> 0x00a2 }
            goto L_0x0047
        L_0x007b:
            java.util.Collection r0 = r5.values()     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = "columnsMap.values"
            kotlin.jvm.internal.j.f(r0, r1)     // Catch:{ all -> 0x00a2 }
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.x0(r0)     // Catch:{ all -> 0x00a2 }
            java.util.Collection r1 = r6.values()     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "ordersMap.values"
            kotlin.jvm.internal.j.f(r1, r2)     // Catch:{ all -> 0x00a2 }
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.x0(r1)     // Catch:{ all -> 0x00a2 }
            q1.e$e r2 = new q1.e$e     // Catch:{ all -> 0x00a2 }
            r2.<init>(r13, r14, r0, r1)     // Catch:{ all -> 0x00a2 }
            kotlin.io.b.a(r12, r4)
            return r2
        L_0x009e:
            kotlin.io.b.a(r12, r4)
            return r4
        L_0x00a2:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r14 = move-exception
            kotlin.io.b.a(r12, r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.f.d(t1.i, java.lang.String, boolean):q1.e$e");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0078, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0079, code lost:
        kotlin.io.b.a(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007c, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.Set<q1.e.C0192e> e(t1.i r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "name"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "PRAGMA index_list(`"
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = "`)"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            android.database.Cursor r10 = r9.q1(r10)
            int r1 = r10.getColumnIndex(r0)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "origin"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = "unique"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ all -> 0x0076 }
            r4 = -1
            r5 = 0
            if (r1 == r4) goto L_0x0072
            if (r2 == r4) goto L_0x0072
            if (r3 != r4) goto L_0x0035
            goto L_0x0072
        L_0x0035:
            java.util.Set r4 = kotlin.collections.m0.b()     // Catch:{ all -> 0x0076 }
        L_0x0039:
            boolean r6 = r10.moveToNext()     // Catch:{ all -> 0x0076 }
            if (r6 == 0) goto L_0x006a
            java.lang.String r6 = r10.getString(r2)     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = "c"
            boolean r6 = kotlin.jvm.internal.j.b(r7, r6)     // Catch:{ all -> 0x0076 }
            if (r6 != 0) goto L_0x004c
            goto L_0x0039
        L_0x004c:
            java.lang.String r6 = r10.getString(r1)     // Catch:{ all -> 0x0076 }
            int r7 = r10.getInt(r3)     // Catch:{ all -> 0x0076 }
            r8 = 1
            if (r7 != r8) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r8 = 0
        L_0x0059:
            kotlin.jvm.internal.j.f(r6, r0)     // Catch:{ all -> 0x0076 }
            q1.e$e r6 = d(r9, r6, r8)     // Catch:{ all -> 0x0076 }
            if (r6 != 0) goto L_0x0066
            kotlin.io.b.a(r10, r5)
            return r5
        L_0x0066:
            r4.add(r6)     // Catch:{ all -> 0x0076 }
            goto L_0x0039
        L_0x006a:
            java.util.Set r9 = kotlin.collections.m0.a(r4)     // Catch:{ all -> 0x0076 }
            kotlin.io.b.a(r10, r5)
            return r9
        L_0x0072:
            kotlin.io.b.a(r10, r5)
            return r5
        L_0x0076:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r0 = move-exception
            kotlin.io.b.a(r10, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.f.e(t1.i, java.lang.String):java.util.Set");
    }

    public static final e f(i iVar, String str) {
        j.g(iVar, "database");
        j.g(str, "tableName");
        return new e(str, a(iVar, str), c(iVar, str), e(iVar, str));
    }
}
