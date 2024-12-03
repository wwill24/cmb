package com.google.android.gms.internal.gtm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.mparticle.kits.AppsFlyerKit;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.l;
import net.bytebuddy.description.type.TypeDescription;
import rd.u;

final class zzce extends zzbs implements Closeable {
    /* access modifiers changed from: private */
    public static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String zzb = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    private final zzcd zzc;
    private final zzfo zzd = new zzfo(zzC());
    /* access modifiers changed from: private */
    public final zzfo zze = new zzfo(zzC());

    zzce(zzbv zzbv) {
        super(zzbv);
        this.zzc = new zzcd(this, zzbv.zza(), zzae());
    }

    private final long zzad(String str, String[] strArr, long j10) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzf().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j11 = rawQuery.getLong(0);
                rawQuery.close();
                return j11;
            }
            rawQuery.close();
            return 0;
        } catch (SQLiteException e10) {
            zzL("Database error", str, e10);
            throw e10;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public final String zzae() {
        zzw();
        zzw();
        return "google_analytics_v4.db";
    }

    public final void close() {
        try {
            this.zzc.close();
        } catch (SQLiteException e10) {
            zzK("Sql error closing database", e10);
        } catch (IllegalStateException e11) {
            zzK("Error closing database", e11);
        }
    }

    public final void zzZ(List<Long> list) {
        p.k(list);
        u.h();
        zzW();
        if (!list.isEmpty()) {
            StringBuilder sb2 = new StringBuilder("hit_id");
            sb2.append(" in (");
            for (int i10 = 0; i10 < list.size(); i10++) {
                Long l10 = list.get(i10);
                if (l10 == null || l10.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i10 > 0) {
                    sb2.append(AppsFlyerKit.COMMA);
                }
                sb2.append(l10);
            }
            sb2.append(")");
            String sb3 = sb2.toString();
            try {
                SQLiteDatabase zzf = zzf();
                zzP("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                int delete = zzf.delete("hits2", sb3, (String[]) null);
                if (delete != list.size()) {
                    zzU("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb3);
                }
            } catch (SQLiteException e10) {
                zzK("Error deleting hits", e10);
                throw e10;
            }
        }
    }

    public final int zza() {
        u.h();
        zzW();
        if (!this.zzd.zzc(86400000)) {
            return 0;
        }
        this.zzd.zzb();
        zzO("Deleting stale hits (if any)");
        int delete = zzf().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzC().currentTimeMillis() - 2592000000L)});
        zzP("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final void zzaa() {
        zzW();
        zzf().endTransaction();
    }

    public final void zzab() {
        zzW();
        zzf().setTransactionSuccessful();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzac() {
        return zzb() == 0;
    }

    public final long zzb() {
        u.h();
        zzW();
        Cursor cursor = null;
        try {
            cursor = zzf().rawQuery("SELECT COUNT(*) FROM hits2", (String[]) null);
            if (cursor.moveToFirst()) {
                long j10 = cursor.getLong(0);
                cursor.close();
                return j10;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e10) {
            zzL("Database error", "SELECT COUNT(*) FROM hits2", e10);
            throw e10;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final long zzc() {
        u.h();
        zzW();
        return zzad(zzb, (String[]) null, 0);
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
    }

    public final long zze(long j10, String str, String str2) {
        p.g(str);
        p.g(str2);
        zzW();
        u.h();
        return zzad("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{"0", str, str2}, 0);
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase zzf() {
        try {
            return this.zzc.getWritableDatabase();
        } catch (SQLiteException e10) {
            zzS("Error opening database", e10);
            throw e10;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.gtm.zzex> zzj(long r17) {
        /*
            r16 = this;
            r11 = r16
            java.lang.String r0 = "hit_id"
            r1 = 0
            int r1 = (r17 > r1 ? 1 : (r17 == r1 ? 0 : -1))
            r12 = 0
            r13 = 1
            if (r1 < 0) goto L_0x000e
            r1 = r13
            goto L_0x000f
        L_0x000e:
            r1 = r12
        L_0x000f:
            com.google.android.gms.common.internal.p.a(r1)
            rd.u.h()
            r16.zzW()
            android.database.sqlite.SQLiteDatabase r2 = r16.zzf()
            r1 = 0
            java.lang.String r3 = "hit_time"
            java.lang.String r4 = "hit_string"
            java.lang.String r5 = "hit_url"
            java.lang.String r6 = "hit_app_id"
            java.lang.String[] r4 = new java.lang.String[]{r0, r3, r4, r5, r6}     // Catch:{ SQLiteException -> 0x0098 }
            java.lang.Object[] r3 = new java.lang.Object[r13]     // Catch:{ SQLiteException -> 0x0098 }
            r3[r12] = r0     // Catch:{ SQLiteException -> 0x0098 }
            java.lang.String r0 = "hits2"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "%s ASC"
            java.lang.String r9 = java.lang.String.format(r9, r3)     // Catch:{ SQLiteException -> 0x0098 }
            java.lang.String r10 = java.lang.Long.toString(r17)     // Catch:{ SQLiteException -> 0x0098 }
            r3 = r0
            android.database.Cursor r14 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0098 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            if (r1 == 0) goto L_0x008c
        L_0x004d:
            long r7 = r14.getLong(r12)     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            long r4 = r14.getLong(r13)     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            r1 = 2
            java.lang.String r1 = r14.getString(r1)     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            r2 = 3
            java.lang.String r2 = r14.getString(r2)     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            r3 = 4
            int r9 = r14.getInt(r3)     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            java.util.Map r3 = r11.zzk(r1)     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            if (r1 == 0) goto L_0x0070
        L_0x006e:
            r6 = r13
            goto L_0x007a
        L_0x0070:
            java.lang.String r1 = "http:"
            boolean r1 = r2.startsWith(r1)     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            if (r1 != 0) goto L_0x0079
            goto L_0x006e
        L_0x0079:
            r6 = r12
        L_0x007a:
            com.google.android.gms.internal.gtm.zzex r15 = new com.google.android.gms.internal.gtm.zzex     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            r10 = 0
            r1 = r15
            r2 = r16
            r1.<init>(r2, r3, r4, r6, r7, r9, r10)     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            r0.add(r15)     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0093, all -> 0x0090 }
            if (r1 != 0) goto L_0x004d
        L_0x008c:
            r14.close()
            return r0
        L_0x0090:
            r0 = move-exception
            r1 = r14
            goto L_0x009f
        L_0x0093:
            r0 = move-exception
            r1 = r14
            goto L_0x0099
        L_0x0096:
            r0 = move-exception
            goto L_0x009f
        L_0x0098:
            r0 = move-exception
        L_0x0099:
            java.lang.String r2 = "Error loading hits from the database"
            r11.zzK(r2, r0)     // Catch:{ all -> 0x0096 }
            throw r0     // Catch:{ all -> 0x0096 }
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()
        L_0x00a4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzce.zzj(long):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzk(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith(TypeDescription.Generic.OfWildcardType.SYMBOL)) {
                if (str.length() != 0) {
                    str = TypeDescription.Generic.OfWildcardType.SYMBOL.concat(str);
                } else {
                    str = new String(TypeDescription.Generic.OfWildcardType.SYMBOL);
                }
            }
            return l.a(new URI(str), "UTF-8");
        } catch (URISyntaxException e10) {
            zzK("Error parsing hit parameters", e10);
            return new HashMap(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzl(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = TypeDescription.Generic.OfWildcardType.SYMBOL.concat(valueOf);
            } else {
                str2 = new String(TypeDescription.Generic.OfWildcardType.SYMBOL);
            }
            return l.a(new URI(str2), "UTF-8");
        } catch (URISyntaxException e10) {
            zzK("Error parsing property parameters", e10);
            return new HashMap(0);
        }
    }

    public final void zzm() {
        zzW();
        zzf().beginTransaction();
    }

    public final void zzn(long j10) {
        u.h();
        zzW();
        ArrayList arrayList = new ArrayList(1);
        Long valueOf = Long.valueOf(j10);
        arrayList.add(valueOf);
        zzP("Deleting hit, id", valueOf);
        zzZ(arrayList);
    }
}
