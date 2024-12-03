package md;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.leanplum.internal.Constants;
import ed.h;
import ed.i;
import ed.p;
import hd.a;
import hd.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import nd.a;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.jingle.element.JingleReason;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

public class m0 implements d, nd.a, c {

    /* renamed from: f  reason: collision with root package name */
    private static final cd.b f41215f = cd.b.b("proto");

    /* renamed from: a  reason: collision with root package name */
    private final t0 f41216a;

    /* renamed from: b  reason: collision with root package name */
    private final od.a f41217b;

    /* renamed from: c  reason: collision with root package name */
    private final od.a f41218c;

    /* renamed from: d  reason: collision with root package name */
    private final e f41219d;

    /* renamed from: e  reason: collision with root package name */
    private final fk.a<String> f41220e;

    interface b<T, U> {
        U apply(T t10);
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final String f41221a;

        /* renamed from: b  reason: collision with root package name */
        final String f41222b;

        private c(String str, String str2) {
            this.f41221a = str;
            this.f41222b = str2;
        }
    }

    interface d<T> {
        T a();
    }

    m0(od.a aVar, od.a aVar2, e eVar, t0 t0Var, fk.a<String> aVar3) {
        this.f41216a = t0Var;
        this.f41217b = aVar;
        this.f41218c = aVar2;
        this.f41219d = eVar;
        this.f41220e = aVar3;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object A1(String str, LogEventDropped.Reason reason, long j10, SQLiteDatabase sQLiteDatabase) {
        if (!((Boolean) V1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())}), new q())).booleanValue()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put(JingleReason.ELEMENT, Integer.valueOf(reason.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j10));
            sQLiteDatabase.insert("log_event_dropped", (String) null, contentValues);
        } else {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j10 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())});
        }
        return null;
    }

    private boolean B0() {
        if (t0() * u0() >= this.f41219d.f()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object C1(long j10, p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j10));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(pd.a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put(JingleS5BTransportCandidate.ATTR_PRIORITY, Integer.valueOf(pd.a.a(pVar.d())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    private List<k> E0(List<k> list, Map<Long, Set<c>> map) {
        ListIterator<k> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            k next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                i.a l10 = next.b().l();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    l10.c(cVar.f41221a, cVar.f41222b);
                }
                listIterator.set(k.a(next.c(), next.d(), l10.d()));
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object F1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f41217b.a()).execute();
        return null;
    }

    private List<k> G1(SQLiteDatabase sQLiteDatabase, p pVar, int i10) {
        ArrayList arrayList = new ArrayList();
        Long x02 = x0(sQLiteDatabase, pVar);
        if (x02 == null) {
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        V1(sQLiteDatabase2.query(Constants.Params.API_EVENTS_STATE, new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{x02.toString()}, (String) null, (String) null, (String) null, String.valueOf(i10)), new s(this, arrayList, pVar));
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object H0(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i10 = cursor.getInt(0);
            e((long) i10, LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    private Map<Long, Set<c>> H1(SQLiteDatabase sQLiteDatabase, List<k> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            sb2.append(list.get(i10).c());
            if (i10 < list.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        V1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), (String[]) null, (String) null, (String) null, (String) null), new n(hashMap));
        return hashMap;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer I0(long j10, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j10)};
        V1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new c0(this));
        return Integer.valueOf(sQLiteDatabase.delete(Constants.Params.API_EVENTS_STATE, "timestamp_ms < ?", strArr));
    }

    private static byte[] I1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void L1(a.C0497a aVar, Map<String, List<LogEventDropped>> map) {
        for (Map.Entry next : map.entrySet()) {
            aVar.a(hd.c.c().c((String) next.getKey()).b((List) next.getValue()).a());
        }
    }

    private byte[] M1(long j10) {
        return (byte[]) V1(r0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j10)}, (String) null, (String) null, "sequence_num"), new u());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object Q0(Throwable th2) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase R0(Throwable th2) {
        throw new SynchronizationException("Timed out while trying to open db.", th2);
    }

    private <T> T R1(d<T> dVar, b<Throwable, T> bVar) {
        long a10 = this.f41218c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e10) {
                if (this.f41218c.a() >= ((long) this.f41219d.b()) + a10) {
                    return bVar.apply(e10);
                }
                SystemClock.sleep(50);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Long S0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    private static cd.b T1(String str) {
        if (str == null) {
            return f41215f;
        }
        return cd.b.b(str);
    }

    private static String U1(Iterable<k> iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator<k> it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().c());
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        return sb2.toString();
    }

    static <T> T V1(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ e W0(long j10, SQLiteDatabase sQLiteDatabase) {
        return (e) V1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new d0(j10));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Long a1(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean b1(p pVar, SQLiteDatabase sQLiteDatabase) {
        Long x02 = x0(sQLiteDatabase, pVar);
        if (x02 == null) {
            return Boolean.FALSE;
        }
        return (Boolean) V1(r0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{x02.toString()}), new t());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List c1(SQLiteDatabase sQLiteDatabase) {
        return (List) V1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new z());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List d1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(p.a().b(cursor.getString(1)).d(pd.a.b(cursor.getInt(2))).c(I1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List e1(p pVar, SQLiteDatabase sQLiteDatabase) {
        List<k> G1 = G1(sQLiteDatabase, pVar, this.f41219d.d());
        for (Priority priority : Priority.values()) {
            if (priority != pVar.d()) {
                int d10 = this.f41219d.d() - G1.size();
                if (d10 <= 0) {
                    break;
                }
                G1.addAll(G1(sQLiteDatabase, pVar.f(priority), d10));
            }
        }
        return E0(G1, H1(sQLiteDatabase, G1));
    }

    private LogEventDropped.Reason f0(int i10) {
        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
        if (i10 == reason.getNumber()) {
            return reason;
        }
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (i10 == reason2.getNumber()) {
            return reason2;
        }
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        if (i10 == reason3.getNumber()) {
            return reason3;
        }
        LogEventDropped.Reason reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (i10 == reason4.getNumber()) {
            return reason4;
        }
        LogEventDropped.Reason reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (i10 == reason5.getNumber()) {
            return reason5;
        }
        LogEventDropped.Reason reason6 = LogEventDropped.Reason.INVALID_PAYLOD;
        if (i10 == reason6.getNumber()) {
            return reason6;
        }
        LogEventDropped.Reason reason7 = LogEventDropped.Reason.SERVER_ERROR;
        if (i10 == reason7.getNumber()) {
            return reason7;
        }
        id.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i10));
        return reason;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ hd.a g1(Map map, a.C0497a aVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            LogEventDropped.Reason f02 = f0(cursor.getInt(1));
            long j10 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(LogEventDropped.c().c(f02).b(j10).a());
        }
        L1(aVar, map);
        aVar.e(v0());
        aVar.d(s0());
        aVar.c(this.f41220e.get());
        return aVar.b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ hd.a h1(String str, Map map, a.C0497a aVar, SQLiteDatabase sQLiteDatabase) {
        return (hd.a) V1(sQLiteDatabase.rawQuery(str, new String[0]), new v(this, map, aVar));
    }

    private void i0(SQLiteDatabase sQLiteDatabase) {
        R1(new j0(sQLiteDatabase), new k0());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object i1(List list, p pVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z10 = false;
            long j10 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z10 = true;
            }
            i.a k10 = i.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z10) {
                k10.h(new h(T1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                k10.h(new h(T1(cursor.getString(4)), M1(j10)));
            }
            if (!cursor.isNull(6)) {
                k10.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(k.a(j10, pVar, k10.d()));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object j1(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j10 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j10));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j10), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    private long m0(SQLiteDatabase sQLiteDatabase, p pVar) {
        Long x02 = x0(sQLiteDatabase, pVar);
        if (x02 != null) {
            return x02.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put(JingleS5BTransportCandidate.ATTR_PRIORITY, Integer.valueOf(pd.a.a(pVar.d())));
        contentValues.put("next_request_ms", 0);
        if (pVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(pVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Long m1(i iVar, p pVar, SQLiteDatabase sQLiteDatabase) {
        boolean z10;
        byte[] bArr;
        if (B0()) {
            e(1, LogEventDropped.Reason.CACHE_FULL, iVar.j());
            return -1L;
        }
        long m02 = m0(sQLiteDatabase, pVar);
        int e10 = this.f41219d.e();
        byte[] a10 = iVar.e().a();
        if (a10.length <= e10) {
            z10 = true;
        } else {
            z10 = false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(SDKConstants.PARAM_CONTEXT_CONTEXT_ID, Long.valueOf(m02));
        contentValues.put("transport_name", iVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.k()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", 0);
        contentValues.put("inline", Boolean.valueOf(z10));
        if (z10) {
            bArr = a10;
        } else {
            bArr = new byte[0];
        }
        contentValues.put("payload", bArr);
        long insert = sQLiteDatabase.insert(Constants.Params.API_EVENTS_STATE, (String) null, contentValues);
        if (!z10) {
            int ceil = (int) Math.ceil(((double) a10.length) / ((double) e10));
            for (int i10 = 1; i10 <= ceil; i10++) {
                byte[] copyOfRange = Arrays.copyOfRange(a10, (i10 - 1) * e10, Math.min(i10 * e10, a10.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i10));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", (String) null, contentValues2);
            }
        }
        for (Map.Entry next : iVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) next.getKey());
            contentValues3.put("value", (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ byte[] o1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i10 += blob.length;
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            byte[] bArr2 = (byte[]) arrayList.get(i12);
            System.arraycopy(bArr2, 0, bArr, i11, bArr2.length);
            i11 += bArr2.length;
        }
        return bArr;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object p1(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i10 = cursor.getInt(0);
            e((long) i10, LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object r1(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        V1(sQLiteDatabase.rawQuery(str2, (String[]) null), new r(this));
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    private hd.b s0() {
        return hd.b.b().b(hd.d.c().b(q0()).c(e.f41198a.f()).a()).a();
    }

    private long t0() {
        return r0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long u0() {
        return r0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private e v0() {
        return (e) A0(new b0(this.f41217b.a()));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Boolean w1(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    private Long x0(SQLiteDatabase sQLiteDatabase, p pVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{pVar.b(), String.valueOf(pd.a.a(pVar.d()))}));
        if (pVar.c() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb2.append(" and extras is null");
        }
        return (Long) V1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), new a0());
    }

    /* access modifiers changed from: package-private */
    public <T> T A0(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase r02 = r0();
        r02.beginTransaction();
        try {
            T apply = bVar.apply(r02);
            r02.setTransactionSuccessful();
            return apply;
        } finally {
            r02.endTransaction();
        }
    }

    public void F0(Iterable<k> iterable) {
        if (iterable.iterator().hasNext()) {
            A0(new m(this, "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + U1(iterable), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
        }
    }

    public Iterable<k> J1(p pVar) {
        return (Iterable) A0(new l0(this, pVar));
    }

    public Iterable<p> Q() {
        return (Iterable) A0(new p());
    }

    public k Q1(p pVar, i iVar) {
        id.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), iVar.j(), pVar.b());
        long longValue = ((Long) A0(new x(this, iVar, pVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return k.a(longValue, pVar, iVar);
    }

    public boolean S1(p pVar) {
        return ((Boolean) A0(new l(this, pVar))).booleanValue();
    }

    public void Z(p pVar, long j10) {
        A0(new h0(j10, pVar));
    }

    public void a() {
        A0(new i0(this));
    }

    public <T> T b(a.C0500a<T> aVar) {
        SQLiteDatabase r02 = r0();
        i0(r02);
        try {
            T f10 = aVar.f();
            r02.setTransactionSuccessful();
            return f10;
        } finally {
            r02.endTransaction();
        }
    }

    public hd.a c() {
        return (hd.a) A0(new o(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new HashMap(), hd.a.e()));
    }

    public void close() {
        this.f41216a.close();
    }

    public void e(long j10, LogEventDropped.Reason reason, String str) {
        A0(new w(str, reason, j10));
    }

    /* access modifiers changed from: package-private */
    public long q0() {
        return t0() * u0();
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase r0() {
        t0 t0Var = this.f41216a;
        Objects.requireNonNull(t0Var);
        return (SQLiteDatabase) R1(new e0(t0Var), new f0());
    }

    public long u1(p pVar) {
        return ((Long) V1(r0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(pd.a.a(pVar.d()))}), new g0())).longValue();
    }

    public int w() {
        return ((Integer) A0(new y(this, this.f41217b.a() - this.f41219d.c()))).intValue();
    }

    public void z(Iterable<k> iterable) {
        if (iterable.iterator().hasNext()) {
            r0().compileStatement("DELETE FROM events WHERE _id in " + U1(iterable)).execute();
        }
    }
}
