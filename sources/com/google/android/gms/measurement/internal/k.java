package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzop;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.leanplum.internal.Constants;
import com.mparticle.kits.AppsFlyerKit;
import com.mparticle.kits.DataplanFilterImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smackx.csi.packet.ClientStateIndication;

final class k extends b9 {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f39973f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f39974g = {FirebaseAnalytics.Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f39975h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f39976i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f39977j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f39978k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f39979l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f39980m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: d  reason: collision with root package name */
    private final j f39981d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final x8 f39982e = new x8(this.f40059a.a());

    k(n9 n9Var) {
        super(n9Var);
        this.f40059a.z();
        this.f39981d = new j(this, this.f40059a.c(), "google_app_measurement.db");
    }

    static final void H(ContentValues contentValues, String str, Object obj) {
        p.g("value");
        p.k(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final long I(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = P().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j10 = cursor.getLong(0);
                cursor.close();
                return j10;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e10) {
            this.f40059a.d().r().c("Database error", str, e10);
            throw e10;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    private final long K(String str, String[] strArr, long j10) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = P().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j11 = rawQuery.getLong(0);
                rawQuery.close();
                return j11;
            }
            rawQuery.close();
            return j10;
        } catch (SQLiteException e10) {
            this.f40059a.d().r().c("Database error", str, e10);
            throw e10;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.String[]} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G(java.lang.String r21, long r22, long r24, com.google.android.gms.measurement.internal.l9 r26) {
        /*
            r20 = this;
            r1 = r20
            r2 = r26
            com.google.android.gms.common.internal.p.k(r26)
            r20.h()
            r20.i()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r20.P()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r5 = ""
            r13 = -1
            r15 = 2
            r12 = 1
            r11 = 0
            if (r4 == 0) goto L_0x0071
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0032
            java.lang.String[] r6 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r7 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            r6[r11] = r7     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r7 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            goto L_0x003a
        L_0x0032:
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r7 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            r6[r11] = r7     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
        L_0x003a:
            if (r4 == 0) goto L_0x003e
            java.lang.String r5 = "rowid <= ? and "
        L_0x003e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r4.append(r7)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            r4.append(r5)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x006e }
            if (r5 != 0) goto L_0x0062
            r4.close()
            return
        L_0x0062:
            java.lang.String r3 = r4.getString(r11)     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r5 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x006e }
            r4.close()     // Catch:{ SQLiteException -> 0x006e }
            goto L_0x00b3
        L_0x006e:
            r0 = move-exception
            goto L_0x020d
        L_0x0071:
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0080
            java.lang.String[] r6 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            r6[r11] = r3     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r7 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            goto L_0x0084
        L_0x0080:
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
        L_0x0084:
            if (r4 == 0) goto L_0x0088
            java.lang.String r5 = " and rowid <= ?"
        L_0x0088:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r7 = "select metadata_fingerprint from raw_events where app_id = ?"
            r4.append(r7)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            r4.append(r5)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r5 = " order by rowid limit 1;"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x006e }
            if (r5 != 0) goto L_0x00ac
            r4.close()
            return
        L_0x00ac:
            java.lang.String r5 = r4.getString(r11)     // Catch:{ SQLiteException -> 0x006e }
            r4.close()     // Catch:{ SQLiteException -> 0x006e }
        L_0x00b3:
            r16 = r4
            r17 = r5
            java.lang.String r5 = "raw_events_metadata"
            java.lang.String r4 = "metadata"
            java.lang.String[] r6 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x0205, all -> 0x0201 }
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r8 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0205, all -> 0x0201 }
            r8[r11] = r3     // Catch:{ SQLiteException -> 0x0205, all -> 0x0201 }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x0205, all -> 0x0201 }
            r9 = 0
            r10 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "2"
            r4 = r0
            r15 = r11
            r11 = r18
            r12 = r19
            android.database.Cursor r12 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x0205, all -> 0x0201 }
            boolean r4 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            if (r4 != 0) goto L_0x00f4
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            java.lang.String r2 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r3)     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r0.b(r2, r4)     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r12.close()
            return
        L_0x00f4:
            byte[] r4 = r12.getBlob(r15)     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            com.google.android.gms.internal.measurement.zzgc r5 = com.google.android.gms.internal.measurement.zzgd.zzu()     // Catch:{ IOException -> 0x01d7 }
            com.google.android.gms.internal.measurement.zzmh r4 = com.google.android.gms.measurement.internal.p9.E(r5, r4)     // Catch:{ IOException -> 0x01d7 }
            com.google.android.gms.internal.measurement.zzgc r4 = (com.google.android.gms.internal.measurement.zzgc) r4     // Catch:{ IOException -> 0x01d7 }
            com.google.android.gms.internal.measurement.zzlb r4 = r4.zzaD()     // Catch:{ IOException -> 0x01d7 }
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4     // Catch:{ IOException -> 0x01d7 }
            boolean r5 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            if (r5 == 0) goto L_0x0121
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40059a     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            com.google.android.gms.measurement.internal.q3 r5 = r5.d()     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            com.google.android.gms.measurement.internal.o3 r5 = r5.w()     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            java.lang.String r6 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.q3.z(r3)     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r5.b(r6, r7)     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
        L_0x0121:
            r12.close()     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            com.google.android.gms.common.internal.p.k(r4)     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r2.f40021a = r4     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            r13 = 3
            if (r4 == 0) goto L_0x0141
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r5[r15] = r3     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r14 = 1
            r5[r14] = r17     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r7 = 2
            r5[r7] = r6     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r7 = r4
            r8 = r5
            goto L_0x014d
        L_0x0141:
            r14 = 1
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ?"
            r5 = 2
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r6[r15] = r3     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r6[r14] = r17     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r7 = r4
            r8 = r6
        L_0x014d:
            java.lang.String r5 = "raw_events"
            java.lang.String r4 = "rowid"
            java.lang.String r6 = "name"
            java.lang.String r9 = "timestamp"
            java.lang.String r10 = "data"
            java.lang.String[] r6 = new java.lang.String[]{r4, r6, r9, r10}     // Catch:{ SQLiteException -> 0x01fb, all -> 0x01f5 }
            r9 = 0
            r10 = 0
            java.lang.String r11 = "rowid"
            r16 = 0
            r4 = r0
            r17 = r12
            r12 = r16
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x01f3, all -> 0x01f1 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x006e }
            if (r0 == 0) goto L_0x01c0
        L_0x0170:
            long r5 = r4.getLong(r15)     // Catch:{ SQLiteException -> 0x006e }
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.internal.measurement.zzfs r7 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x01a1 }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.p9.E(r7, r0)     // Catch:{ IOException -> 0x01a1 }
            com.google.android.gms.internal.measurement.zzfs r0 = (com.google.android.gms.internal.measurement.zzfs) r0     // Catch:{ IOException -> 0x01a1 }
            java.lang.String r7 = r4.getString(r14)     // Catch:{ SQLiteException -> 0x006e }
            r0.zzi(r7)     // Catch:{ SQLiteException -> 0x006e }
            r7 = 2
            long r8 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x006e }
            r0.zzm(r8)     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0     // Catch:{ SQLiteException -> 0x006e }
            boolean r0 = r2.a(r5, r0)     // Catch:{ SQLiteException -> 0x006e }
            if (r0 != 0) goto L_0x01b6
            r4.close()
            return
        L_0x01a1:
            r0 = move-exception
            r7 = 2
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40059a     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.measurement.internal.q3 r5 = r5.d()     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.measurement.internal.o3 r5 = r5.r()     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r6 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r3)     // Catch:{ SQLiteException -> 0x006e }
            r5.c(r6, r8, r0)     // Catch:{ SQLiteException -> 0x006e }
        L_0x01b6:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x006e }
            if (r0 != 0) goto L_0x0170
            r4.close()
            return
        L_0x01c0:
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ SQLiteException -> 0x006e }
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()     // Catch:{ SQLiteException -> 0x006e }
            java.lang.String r2 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.q3.z(r3)     // Catch:{ SQLiteException -> 0x006e }
            r0.b(r2, r5)     // Catch:{ SQLiteException -> 0x006e }
            r4.close()
            return
        L_0x01d7:
            r0 = move-exception
            r17 = r12
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a     // Catch:{ SQLiteException -> 0x01f3, all -> 0x01f1 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ SQLiteException -> 0x01f3, all -> 0x01f1 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x01f3, all -> 0x01f1 }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.q3.z(r3)     // Catch:{ SQLiteException -> 0x01f3, all -> 0x01f1 }
            r2.c(r4, r5, r0)     // Catch:{ SQLiteException -> 0x01f3, all -> 0x01f1 }
            r17.close()
            return
        L_0x01f1:
            r0 = move-exception
            goto L_0x01f8
        L_0x01f3:
            r0 = move-exception
            goto L_0x01fe
        L_0x01f5:
            r0 = move-exception
            r17 = r12
        L_0x01f8:
            r3 = r17
            goto L_0x0228
        L_0x01fb:
            r0 = move-exception
            r17 = r12
        L_0x01fe:
            r4 = r17
            goto L_0x020d
        L_0x0201:
            r0 = move-exception
            r3 = r16
            goto L_0x0228
        L_0x0205:
            r0 = move-exception
            r4 = r16
            goto L_0x020d
        L_0x0209:
            r0 = move-exception
            goto L_0x0228
        L_0x020b:
            r0 = move-exception
            r4 = r3
        L_0x020d:
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a     // Catch:{ all -> 0x0226 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ all -> 0x0226 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x0226 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.q3.z(r3)     // Catch:{ all -> 0x0226 }
            r2.c(r5, r3, r0)     // Catch:{ all -> 0x0226 }
            if (r4 == 0) goto L_0x0225
            r4.close()
        L_0x0225:
            return
        L_0x0226:
            r0 = move-exception
            r3 = r4
        L_0x0228:
            if (r3 == 0) goto L_0x022d
            r3.close()
        L_0x022d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.k.G(java.lang.String, long, long, com.google.android.gms.measurement.internal.l9):void");
    }

    public final int J(String str, String str2) {
        p.g(str);
        p.g(str2);
        h();
        i();
        try {
            return P().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            this.f40059a.d().r().d("Error deleting conditional property", q3.z(str), this.f40059a.D().f(str2), e10);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final long L(String str, String str2) {
        long j10;
        SQLiteException e10;
        p.g(str);
        p.g("first_open_count");
        h();
        i();
        SQLiteDatabase P = P();
        P.beginTransaction();
        try {
            j10 = K("select " + "first_open_count" + " from app2 where app_id=?", new String[]{str}, -1);
            if (j10 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (P.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    this.f40059a.d().r().c("Failed to insert column (got -1). appId", q3.z(str), "first_open_count");
                    P.endTransaction();
                    return -1;
                }
                j10 = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put("first_open_count", Long.valueOf(1 + j10));
                if (((long) P.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    this.f40059a.d().r().c("Failed to update column (got 0). appId", q3.z(str), "first_open_count");
                    P.endTransaction();
                    return -1;
                }
                P.setTransactionSuccessful();
                P.endTransaction();
                return j10;
            } catch (SQLiteException e11) {
                e10 = e11;
            }
        } catch (SQLiteException e12) {
            j10 = 0;
            e10 = e12;
            try {
                this.f40059a.d().r().d("Error inserting column. appId", q3.z(str), "first_open_count", e10);
                P.endTransaction();
                return j10;
            } catch (Throwable th2) {
                P.endTransaction();
                throw th2;
            }
        }
    }

    public final long M() {
        return K("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long N() {
        return K("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long O(String str) {
        p.g(str);
        return K("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase P() {
        h();
        try {
            return this.f39981d.getWritableDatabase();
        } catch (SQLiteException e10) {
            this.f40059a.d().w().b("Error opening database", e10);
            throw e10;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle Q(java.lang.String r8) {
        /*
            r7 = this;
            r7.h()
            r7.i()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.P()     // Catch:{ SQLiteException -> 0x00be, all -> 0x00bc }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00be, all -> 0x00bc }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x00be, all -> 0x00bc }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x00be, all -> 0x00bc }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00ba }
            if (r2 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.u4 r8 = r7.f40059a     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.measurement.internal.q3 r8 = r8.d()     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.measurement.internal.o3 r8 = r8.v()     // Catch:{ SQLiteException -> 0x00ba }
            java.lang.String r2 = "Default event parameters not found"
            r8.a(r2)     // Catch:{ SQLiteException -> 0x00ba }
            r1.close()
            return r0
        L_0x0030:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.internal.measurement.zzfs r3 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x00a2 }
            com.google.android.gms.internal.measurement.zzmh r2 = com.google.android.gms.measurement.internal.p9.E(r3, r2)     // Catch:{ IOException -> 0x00a2 }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ IOException -> 0x00a2 }
            com.google.android.gms.internal.measurement.zzlb r2 = r2.zzaD()     // Catch:{ IOException -> 0x00a2 }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ IOException -> 0x00a2 }
            com.google.android.gms.measurement.internal.n9 r8 = r7.f39651b     // Catch:{ SQLiteException -> 0x00ba }
            r8.g0()     // Catch:{ SQLiteException -> 0x00ba }
            java.util.List r8 = r2.zzi()     // Catch:{ SQLiteException -> 0x00ba }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00ba }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00ba }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x00ba }
        L_0x0056:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x00ba }
            if (r3 == 0) goto L_0x009e
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.internal.measurement.zzfx r3 = (com.google.android.gms.internal.measurement.zzfx) r3     // Catch:{ SQLiteException -> 0x00ba }
            java.lang.String r4 = r3.zzg()     // Catch:{ SQLiteException -> 0x00ba }
            boolean r5 = r3.zzu()     // Catch:{ SQLiteException -> 0x00ba }
            if (r5 == 0) goto L_0x0074
            double r5 = r3.zza()     // Catch:{ SQLiteException -> 0x00ba }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x00ba }
            goto L_0x0056
        L_0x0074:
            boolean r5 = r3.zzv()     // Catch:{ SQLiteException -> 0x00ba }
            if (r5 == 0) goto L_0x0082
            float r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x00ba }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x00ba }
            goto L_0x0056
        L_0x0082:
            boolean r5 = r3.zzy()     // Catch:{ SQLiteException -> 0x00ba }
            if (r5 == 0) goto L_0x0090
            java.lang.String r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x00ba }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x00ba }
            goto L_0x0056
        L_0x0090:
            boolean r5 = r3.zzw()     // Catch:{ SQLiteException -> 0x00ba }
            if (r5 == 0) goto L_0x0056
            long r5 = r3.zzd()     // Catch:{ SQLiteException -> 0x00ba }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x00ba }
            goto L_0x0056
        L_0x009e:
            r1.close()
            return r2
        L_0x00a2:
            r2 = move-exception
            com.google.android.gms.measurement.internal.u4 r3 = r7.f40059a     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ SQLiteException -> 0x00ba }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ SQLiteException -> 0x00ba }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r8)     // Catch:{ SQLiteException -> 0x00ba }
            r3.c(r4, r8, r2)     // Catch:{ SQLiteException -> 0x00ba }
            r1.close()
            return r0
        L_0x00ba:
            r8 = move-exception
            goto L_0x00c0
        L_0x00bc:
            r8 = move-exception
            goto L_0x00d7
        L_0x00be:
            r8 = move-exception
            r1 = r0
        L_0x00c0:
            com.google.android.gms.measurement.internal.u4 r2 = r7.f40059a     // Catch:{ all -> 0x00d5 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ all -> 0x00d5 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r8)     // Catch:{ all -> 0x00d5 }
            if (r1 == 0) goto L_0x00d4
            r1.close()
        L_0x00d4:
            return r0
        L_0x00d5:
            r8 = move-exception
            r0 = r1
        L_0x00d7:
            if (r0 == 0) goto L_0x00dc
            r0.close()
        L_0x00dc:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.k.Q(java.lang.String):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x011f A[Catch:{ SQLiteException -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0123 A[Catch:{ SQLiteException -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0157 A[Catch:{ SQLiteException -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0175 A[Catch:{ SQLiteException -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0178 A[Catch:{ SQLiteException -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0187 A[Catch:{ SQLiteException -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01d2 A[Catch:{ SQLiteException -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01f6 A[Catch:{ SQLiteException -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x020d A[Catch:{ SQLiteException -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x021f A[Catch:{ SQLiteException -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0259  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.q5 R(java.lang.String r39) {
        /*
            r38 = this;
            r1 = r38
            r2 = r39
            com.google.android.gms.common.internal.p.g(r39)
            r38.h()
            r38.i()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r38.P()     // Catch:{ SQLiteException -> 0x023a, all -> 0x0238 }
            java.lang.String r5 = "apps"
            java.lang.String r6 = "app_instance_id"
            java.lang.String r7 = "gmp_app_id"
            java.lang.String r8 = "resettable_device_id_hash"
            java.lang.String r9 = "last_bundle_index"
            java.lang.String r10 = "last_bundle_start_timestamp"
            java.lang.String r11 = "last_bundle_end_timestamp"
            java.lang.String r12 = "app_version"
            java.lang.String r13 = "app_store"
            java.lang.String r14 = "gmp_version"
            java.lang.String r15 = "dev_cert_hash"
            java.lang.String r16 = "measurement_enabled"
            java.lang.String r17 = "day"
            java.lang.String r18 = "daily_public_events_count"
            java.lang.String r19 = "daily_events_count"
            java.lang.String r20 = "daily_conversions_count"
            java.lang.String r21 = "config_fetched_time"
            java.lang.String r22 = "failed_config_fetch_time"
            java.lang.String r23 = "app_version_int"
            java.lang.String r24 = "firebase_instance_id"
            java.lang.String r25 = "daily_error_events_count"
            java.lang.String r26 = "daily_realtime_events_count"
            java.lang.String r27 = "health_monitor_sample"
            java.lang.String r28 = "android_id"
            java.lang.String r29 = "adid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String r34 = "session_stitching_token"
            java.lang.String r35 = "sgtm_upload_enabled"
            java.lang.String r36 = "target_os_version"
            java.lang.String r37 = "session_stitching_token_hash"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37}     // Catch:{ SQLiteException -> 0x023a, all -> 0x0238 }
            java.lang.String r7 = "app_id=?"
            r0 = 1
            java.lang.String[] r8 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x023a, all -> 0x0238 }
            r12 = 0
            r8[r12] = r2     // Catch:{ SQLiteException -> 0x023a, all -> 0x0238 }
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x023a, all -> 0x0238 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0236 }
            if (r5 != 0) goto L_0x0071
            r4.close()
            return r3
        L_0x0071:
            com.google.android.gms.measurement.internal.q5 r5 = new com.google.android.gms.measurement.internal.q5     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.n9 r6 = r1.f39651b     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.u4 r6 = r6.b0()     // Catch:{ SQLiteException -> 0x0236 }
            r5.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x0236 }
            java.lang.String r6 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0236 }
            r5.j(r6)     // Catch:{ SQLiteException -> 0x0236 }
            java.lang.String r6 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0236 }
            r5.y(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 2
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.H(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 3
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.D(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 4
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.E(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 5
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.C(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 6
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.l(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 7
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.k(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 8
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.z(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 9
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.u(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 10
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r7 != 0) goto L_0x00dd
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r6 == 0) goto L_0x00db
            goto L_0x00dd
        L_0x00db:
            r6 = r12
            goto L_0x00de
        L_0x00dd:
            r6 = r0
        L_0x00de:
            r5.F(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 11
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.t(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 12
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.r(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 13
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.q(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 14
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.o(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 15
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.n(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 16
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.w(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 17
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r7 == 0) goto L_0x0123
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0128
        L_0x0123:
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0236 }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x0236 }
        L_0x0128:
            r5.m(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 18
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.x(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 19
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.p(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 20
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.s(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 21
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.B(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 23
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r7 != 0) goto L_0x0160
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r6 == 0) goto L_0x015e
            goto L_0x0160
        L_0x015e:
            r6 = r12
            goto L_0x0161
        L_0x0160:
            r6 = r0
        L_0x0161:
            r5.i(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 24
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.h(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 25
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r7 == 0) goto L_0x0178
            r6 = 0
            goto L_0x017c
        L_0x0178:
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0236 }
        L_0x017c:
            r5.v(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r6 = 26
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r7 != 0) goto L_0x0199
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0236 }
            java.lang.String r7 = ","
            r8 = -1
            java.lang.String[] r6 = r6.split(r7, r8)     // Catch:{ SQLiteException -> 0x0236 }
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.I(r6)     // Catch:{ SQLiteException -> 0x0236 }
        L_0x0199:
            com.google.android.gms.internal.measurement.zzqu.zzc()     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.u4 r6 = r1.f40059a     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.g r6 = r6.z()     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.f3 r7 = com.google.android.gms.measurement.internal.g3.f39838q0     // Catch:{ SQLiteException -> 0x0236 }
            boolean r6 = r6.B(r2, r7)     // Catch:{ SQLiteException -> 0x0236 }
            if (r6 != 0) goto L_0x01b8
            com.google.android.gms.measurement.internal.u4 r6 = r1.f40059a     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.g r6 = r6.z()     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.f3 r7 = com.google.android.gms.measurement.internal.g3.f39834o0     // Catch:{ SQLiteException -> 0x0236 }
            boolean r6 = r6.B(r3, r7)     // Catch:{ SQLiteException -> 0x0236 }
            if (r6 == 0) goto L_0x01c1
        L_0x01b8:
            r6 = 28
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0236 }
            r5.J(r6)     // Catch:{ SQLiteException -> 0x0236 }
        L_0x01c1:
            com.google.android.gms.internal.measurement.zzrd.zzc()     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.u4 r6 = r1.f40059a     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.g r6 = r6.z()     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.f3 r7 = com.google.android.gms.measurement.internal.g3.f39842s0     // Catch:{ SQLiteException -> 0x0236 }
            boolean r6 = r6.B(r3, r7)     // Catch:{ SQLiteException -> 0x0236 }
            if (r6 == 0) goto L_0x01e5
            r6 = 29
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r7 != 0) goto L_0x01e1
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r6 == 0) goto L_0x01e1
            goto L_0x01e2
        L_0x01e1:
            r0 = r12
        L_0x01e2:
            r5.L(r0)     // Catch:{ SQLiteException -> 0x0236 }
        L_0x01e5:
            com.google.android.gms.internal.measurement.zzpz.zzc()     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.g r0 = r0.z()     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.f3 r6 = com.google.android.gms.measurement.internal.g3.G0     // Catch:{ SQLiteException -> 0x0236 }
            boolean r0 = r0.B(r3, r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r0 == 0) goto L_0x01ff
            r0 = 30
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0236 }
            r5.M(r6)     // Catch:{ SQLiteException -> 0x0236 }
        L_0x01ff:
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.g r0 = r0.z()     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.f3 r6 = com.google.android.gms.measurement.internal.g3.J0     // Catch:{ SQLiteException -> 0x0236 }
            boolean r0 = r0.B(r3, r6)     // Catch:{ SQLiteException -> 0x0236 }
            if (r0 == 0) goto L_0x0216
            r0 = 31
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0236 }
            r5.K(r6)     // Catch:{ SQLiteException -> 0x0236 }
        L_0x0216:
            r5.f()     // Catch:{ SQLiteException -> 0x0236 }
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0236 }
            if (r0 == 0) goto L_0x0232
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ SQLiteException -> 0x0236 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x0236 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.q3.z(r39)     // Catch:{ SQLiteException -> 0x0236 }
            r0.b(r6, r7)     // Catch:{ SQLiteException -> 0x0236 }
        L_0x0232:
            r4.close()
            return r5
        L_0x0236:
            r0 = move-exception
            goto L_0x023c
        L_0x0238:
            r0 = move-exception
            goto L_0x0257
        L_0x023a:
            r0 = move-exception
            r4 = r3
        L_0x023c:
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40059a     // Catch:{ all -> 0x0255 }
            com.google.android.gms.measurement.internal.q3 r5 = r5.d()     // Catch:{ all -> 0x0255 }
            com.google.android.gms.measurement.internal.o3 r5 = r5.r()     // Catch:{ all -> 0x0255 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.q3.z(r39)     // Catch:{ all -> 0x0255 }
            r5.c(r6, r2, r0)     // Catch:{ all -> 0x0255 }
            if (r4 == 0) goto L_0x0254
            r4.close()
        L_0x0254:
            return r3
        L_0x0255:
            r0 = move-exception
            r3 = r4
        L_0x0257:
            if (r3 == 0) goto L_0x025c
            r3.close()
        L_0x025c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.k.R(java.lang.String):com.google.android.gms.measurement.internal.q5");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzac S(java.lang.String r31, java.lang.String r32) {
        /*
            r30 = this;
            r1 = r30
            r8 = r32
            com.google.android.gms.common.internal.p.g(r31)
            com.google.android.gms.common.internal.p.g(r32)
            r30.h()
            r30.i()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r30.P()     // Catch:{ SQLiteException -> 0x00fd, all -> 0x00fb }
            java.lang.String r11 = "conditional_properties"
            java.lang.String r12 = "origin"
            java.lang.String r13 = "value"
            java.lang.String r14 = "active"
            java.lang.String r15 = "trigger_event_name"
            java.lang.String r16 = "trigger_timeout"
            java.lang.String r17 = "timed_out_event"
            java.lang.String r18 = "creation_timestamp"
            java.lang.String r19 = "triggered_event"
            java.lang.String r20 = "triggered_timestamp"
            java.lang.String r21 = "time_to_live"
            java.lang.String r22 = "expired_event"
            java.lang.String[] r12 = new java.lang.String[]{r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22}     // Catch:{ SQLiteException -> 0x00fd, all -> 0x00fb }
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00fd, all -> 0x00fb }
            r2 = 0
            r14[r2] = r31     // Catch:{ SQLiteException -> 0x00fd, all -> 0x00fb }
            r3 = 1
            r14[r3] = r8     // Catch:{ SQLiteException -> 0x00fd, all -> 0x00fb }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x00fd, all -> 0x00fb }
            boolean r4 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x00f9 }
            if (r4 != 0) goto L_0x004f
            r10.close()
            return r9
        L_0x004f:
            java.lang.String r4 = r10.getString(r2)     // Catch:{ SQLiteException -> 0x00f9 }
            if (r4 != 0) goto L_0x0057
            java.lang.String r4 = ""
        L_0x0057:
            r17 = r4
            java.lang.Object r6 = r1.Y(r10, r3)     // Catch:{ SQLiteException -> 0x00f9 }
            int r0 = r10.getInt(r0)     // Catch:{ SQLiteException -> 0x00f9 }
            if (r0 == 0) goto L_0x0066
            r21 = r3
            goto L_0x0068
        L_0x0066:
            r21 = r2
        L_0x0068:
            r0 = 3
            java.lang.String r22 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x00f9 }
            r0 = 4
            long r24 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.n9 r0 = r1.f39651b     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.p9 r0 = r0.g0()     // Catch:{ SQLiteException -> 0x00f9 }
            r2 = 5
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00f9 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzau> r3 = com.google.android.gms.measurement.internal.zzau.CREATOR     // Catch:{ SQLiteException -> 0x00f9 }
            android.os.Parcelable r0 = r0.B(r2, r3)     // Catch:{ SQLiteException -> 0x00f9 }
            r23 = r0
            com.google.android.gms.measurement.internal.zzau r23 = (com.google.android.gms.measurement.internal.zzau) r23     // Catch:{ SQLiteException -> 0x00f9 }
            r0 = 6
            long r19 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.n9 r0 = r1.f39651b     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.p9 r0 = r0.g0()     // Catch:{ SQLiteException -> 0x00f9 }
            r2 = 7
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00f9 }
            android.os.Parcelable r0 = r0.B(r2, r3)     // Catch:{ SQLiteException -> 0x00f9 }
            r26 = r0
            com.google.android.gms.measurement.internal.zzau r26 = (com.google.android.gms.measurement.internal.zzau) r26     // Catch:{ SQLiteException -> 0x00f9 }
            r0 = 8
            long r4 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00f9 }
            r0 = 9
            long r27 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.n9 r0 = r1.f39651b     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.p9 r0 = r0.g0()     // Catch:{ SQLiteException -> 0x00f9 }
            r2 = 10
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00f9 }
            android.os.Parcelable r0 = r0.B(r2, r3)     // Catch:{ SQLiteException -> 0x00f9 }
            r29 = r0
            com.google.android.gms.measurement.internal.zzau r29 = (com.google.android.gms.measurement.internal.zzau) r29     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.zzlk r18 = new com.google.android.gms.measurement.internal.zzlk     // Catch:{ SQLiteException -> 0x00f9 }
            r2 = r18
            r3 = r32
            r7 = r17
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.zzac r0 = new com.google.android.gms.measurement.internal.zzac     // Catch:{ SQLiteException -> 0x00f9 }
            r15 = r0
            r16 = r31
            r15.<init>(r16, r17, r18, r19, r21, r22, r23, r24, r26, r27, r29)     // Catch:{ SQLiteException -> 0x00f9 }
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x00f9 }
            if (r2 == 0) goto L_0x00f5
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x00f9 }
            java.lang.String r3 = "Got multiple records for conditional property, expected one"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r31)     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40059a     // Catch:{ SQLiteException -> 0x00f9 }
            com.google.android.gms.measurement.internal.l3 r5 = r5.D()     // Catch:{ SQLiteException -> 0x00f9 }
            java.lang.String r5 = r5.f(r8)     // Catch:{ SQLiteException -> 0x00f9 }
            r2.c(r3, r4, r5)     // Catch:{ SQLiteException -> 0x00f9 }
        L_0x00f5:
            r10.close()
            return r0
        L_0x00f9:
            r0 = move-exception
            goto L_0x00ff
        L_0x00fb:
            r0 = move-exception
            goto L_0x0124
        L_0x00fd:
            r0 = move-exception
            r10 = r9
        L_0x00ff:
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a     // Catch:{ all -> 0x0122 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ all -> 0x0122 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x0122 }
            java.lang.String r3 = "Error querying conditional property"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r31)     // Catch:{ all -> 0x0122 }
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40059a     // Catch:{ all -> 0x0122 }
            com.google.android.gms.measurement.internal.l3 r5 = r5.D()     // Catch:{ all -> 0x0122 }
            java.lang.String r5 = r5.f(r8)     // Catch:{ all -> 0x0122 }
            r2.d(r3, r4, r5, r0)     // Catch:{ all -> 0x0122 }
            if (r10 == 0) goto L_0x0121
            r10.close()
        L_0x0121:
            return r9
        L_0x0122:
            r0 = move-exception
            r9 = r10
        L_0x0124:
            if (r9 == 0) goto L_0x0129
            r9.close()
        L_0x0129:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.k.S(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    public final i T(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return U(j10, str, 1, false, false, z12, false, z14);
    }

    public final i U(long j10, String str, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        p.g(str);
        h();
        i();
        String[] strArr = {str};
        i iVar = new i();
        Cursor cursor = null;
        try {
            SQLiteDatabase P = P();
            cursor = P.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                this.f40059a.d().w().b("Not updating daily counts, app is not known. appId", q3.z(str));
                cursor.close();
                return iVar;
            }
            if (cursor.getLong(0) == j10) {
                iVar.f39909b = cursor.getLong(1);
                iVar.f39908a = cursor.getLong(2);
                iVar.f39910c = cursor.getLong(3);
                iVar.f39911d = cursor.getLong(4);
                iVar.f39912e = cursor.getLong(5);
            }
            if (z10) {
                iVar.f39909b += j11;
            }
            if (z11) {
                iVar.f39908a += j11;
            }
            if (z12) {
                iVar.f39910c += j11;
            }
            if (z13) {
                iVar.f39911d += j11;
            }
            if (z14) {
                iVar.f39912e += j11;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j10));
            contentValues.put("daily_public_events_count", Long.valueOf(iVar.f39908a));
            contentValues.put("daily_events_count", Long.valueOf(iVar.f39909b));
            contentValues.put("daily_conversions_count", Long.valueOf(iVar.f39910c));
            contentValues.put("daily_error_events_count", Long.valueOf(iVar.f39911d));
            contentValues.put("daily_realtime_events_count", Long.valueOf(iVar.f39912e));
            P.update("apps", contentValues, "app_id=?", strArr);
            cursor.close();
            return iVar;
        } catch (SQLiteException e10) {
            this.f40059a.d().r().c("Error updating daily counts. appId", q3.z(str), e10);
            if (cursor != null) {
                cursor.close();
            }
            return iVar;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.q V(java.lang.String r28, java.lang.String r29) {
        /*
            r27 = this;
            r1 = r27
            r15 = r29
            com.google.android.gms.common.internal.p.g(r28)
            com.google.android.gms.common.internal.p.g(r29)
            r27.h()
            r27.i()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String r10 = "current_session_count"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.<init>(r2)
            r19 = 0
            android.database.sqlite.SQLiteDatabase r2 = r27.P()     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            java.lang.String r3 = "events"
            r10 = 0
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            java.lang.Object[] r0 = r0.toArray(r4)     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            r4 = r0
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            java.lang.String r5 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            r6[r10] = r28     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            r11 = 1
            r6[r11] = r15     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0123, all -> 0x0121 }
            boolean r2 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r2 != 0) goto L_0x005c
            r13.close()
            return r19
        L_0x005c:
            long r5 = r13.getLong(r10)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            long r7 = r13.getLong(r11)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            long r16 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r0 = 3
            boolean r2 = r13.isNull(r0)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r3 = 0
            if (r2 == 0) goto L_0x0074
            r20 = r3
            goto L_0x0078
        L_0x0074:
            long r20 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
        L_0x0078:
            r0 = 4
            boolean r2 = r13.isNull(r0)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r2 == 0) goto L_0x0082
            r0 = r19
            goto L_0x008a
        L_0x0082:
            long r22 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            java.lang.Long r0 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
        L_0x008a:
            r2 = 5
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r9 == 0) goto L_0x0094
            r18 = r19
            goto L_0x009e
        L_0x0094:
            long r22 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r18 = r2
        L_0x009e:
            r2 = 6
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r9 == 0) goto L_0x00a8
            r22 = r19
            goto L_0x00b2
        L_0x00a8:
            long r22 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r22 = r2
        L_0x00b2:
            r2 = 7
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r9 != 0) goto L_0x00cb
            long r23 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r25 = 1
            int r2 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r2 != 0) goto L_0x00c4
            r10 = r11
        L_0x00c4:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r10)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r23 = r2
            goto L_0x00cd
        L_0x00cb:
            r23 = r19
        L_0x00cd:
            r2 = 8
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            if (r9 == 0) goto L_0x00d7
            r9 = r3
            goto L_0x00dc
        L_0x00d7:
            long r2 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r9 = r2
        L_0x00dc:
            com.google.android.gms.measurement.internal.q r24 = new com.google.android.gms.measurement.internal.q     // Catch:{ SQLiteException -> 0x011b, all -> 0x0115 }
            r2 = r24
            r3 = r28
            r4 = r29
            r11 = r16
            r25 = r13
            r13 = r20
            r15 = r0
            r16 = r18
            r17 = r22
            r18 = r23
            r2.<init>(r3, r4, r5, r7, r9, r11, r13, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            boolean r0 = r25.moveToNext()     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            if (r0 == 0) goto L_0x010d
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.q3.z(r28)     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
            r0.b(r2, r3)     // Catch:{ SQLiteException -> 0x0113, all -> 0x0111 }
        L_0x010d:
            r25.close()
            return r24
        L_0x0111:
            r0 = move-exception
            goto L_0x0118
        L_0x0113:
            r0 = move-exception
            goto L_0x011e
        L_0x0115:
            r0 = move-exception
            r25 = r13
        L_0x0118:
            r19 = r25
            goto L_0x014e
        L_0x011b:
            r0 = move-exception
            r25 = r13
        L_0x011e:
            r13 = r25
            goto L_0x0126
        L_0x0121:
            r0 = move-exception
            goto L_0x014e
        L_0x0123:
            r0 = move-exception
            r13 = r19
        L_0x0126:
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x014b }
            java.lang.String r3 = "Error querying events. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r28)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40059a     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.l3 r5 = r5.D()     // Catch:{ all -> 0x014b }
            r6 = r29
            java.lang.String r5 = r5.d(r6)     // Catch:{ all -> 0x014b }
            r2.d(r3, r4, r5, r0)     // Catch:{ all -> 0x014b }
            if (r13 == 0) goto L_0x014a
            r13.close()
        L_0x014a:
            return r19
        L_0x014b:
            r0 = move-exception
            r19 = r13
        L_0x014e:
            if (r19 == 0) goto L_0x0153
            r19.close()
        L_0x0153:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.k.V(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.q");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.r9 X(java.lang.String r20, java.lang.String r21) {
        /*
            r19 = this;
            r1 = r19
            r9 = r21
            com.google.android.gms.common.internal.p.g(r20)
            com.google.android.gms.common.internal.p.g(r21)
            r19.h()
            r19.i()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.P()     // Catch:{ SQLiteException -> 0x007d, all -> 0x007b }
            java.lang.String r12 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r2 = "value"
            java.lang.String r3 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r0, r2, r3}     // Catch:{ SQLiteException -> 0x007d, all -> 0x007b }
            java.lang.String r14 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r15 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x007d, all -> 0x007b }
            r2 = 0
            r15[r2] = r20     // Catch:{ SQLiteException -> 0x007d, all -> 0x007b }
            r3 = 1
            r15[r3] = r9     // Catch:{ SQLiteException -> 0x007d, all -> 0x007b }
            r16 = 0
            r17 = 0
            r18 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x007d, all -> 0x007b }
            boolean r4 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0079 }
            if (r4 != 0) goto L_0x0040
            r11.close()
            return r10
        L_0x0040:
            long r6 = r11.getLong(r2)     // Catch:{ SQLiteException -> 0x0079 }
            java.lang.Object r8 = r1.Y(r11, r3)     // Catch:{ SQLiteException -> 0x0079 }
            if (r8 != 0) goto L_0x004e
            r11.close()
            return r10
        L_0x004e:
            java.lang.String r4 = r11.getString(r0)     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.measurement.internal.r9 r0 = new com.google.android.gms.measurement.internal.r9     // Catch:{ SQLiteException -> 0x0079 }
            r2 = r0
            r3 = r20
            r5 = r21
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ SQLiteException -> 0x0079 }
            boolean r2 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0079 }
            if (r2 == 0) goto L_0x0075
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x0079 }
            java.lang.String r3 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r20)     // Catch:{ SQLiteException -> 0x0079 }
            r2.b(r3, r4)     // Catch:{ SQLiteException -> 0x0079 }
        L_0x0075:
            r11.close()
            return r0
        L_0x0079:
            r0 = move-exception
            goto L_0x007f
        L_0x007b:
            r0 = move-exception
            goto L_0x00a4
        L_0x007d:
            r0 = move-exception
            r11 = r10
        L_0x007f:
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r20)     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40059a     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.measurement.internal.l3 r5 = r5.D()     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = r5.f(r9)     // Catch:{ all -> 0x00a2 }
            r2.d(r3, r4, r5, r0)     // Catch:{ all -> 0x00a2 }
            if (r11 == 0) goto L_0x00a1
            r11.close()
        L_0x00a1:
            return r10
        L_0x00a2:
            r0 = move-exception
            r10 = r11
        L_0x00a4:
            if (r10 == 0) goto L_0x00a9
            r10.close()
        L_0x00a9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.k.X(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.r9");
    }

    /* access modifiers changed from: package-private */
    public final Object Y(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 0) {
            this.f40059a.d().r().a("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i10));
            }
            if (type == 3) {
                return cursor.getString(i10);
            }
            if (type != 4) {
                this.f40059a.d().r().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            this.f40059a.d().r().a("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String Z() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.P()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0022, all -> 0x0020 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001e }
            r0.close()
            return r1
        L_0x001a:
            r0.close()
            return r1
        L_0x001e:
            r2 = move-exception
            goto L_0x0025
        L_0x0020:
            r0 = move-exception
            goto L_0x003e
        L_0x0022:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x0025:
            com.google.android.gms.measurement.internal.u4 r3 = r6.f40059a     // Catch:{ all -> 0x003a }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x003a }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0039
            r0.close()
        L_0x0039:
            return r1
        L_0x003a:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1.close()
        L_0x0043:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.k.Z():java.lang.String");
    }

    public final List a0(String str, String str2, String str3) {
        p.g(str);
        h();
        i();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb2.append(" and name glob ?");
        }
        return b0(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List b0(String str, String[] strArr) {
        boolean z10;
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase P = P();
            String[] strArr2 = {"app_id", FirebaseAnalytics.Param.ORIGIN, "name", "value", ClientStateIndication.Active.ELEMENT, "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"};
            this.f40059a.z();
            Cursor query = P.query("conditional_properties", strArr2, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (query.moveToFirst()) {
                while (true) {
                    int size = arrayList.size();
                    this.f40059a.z();
                    if (size < 1000) {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object Y = Y(query, 3);
                        if (query.getInt(4) != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        String string4 = query.getString(5);
                        long j10 = query.getLong(6);
                        p9 g02 = this.f39651b.g0();
                        byte[] blob = query.getBlob(7);
                        Parcelable.Creator<zzau> creator = zzau.CREATOR;
                        arrayList.add(new zzac(string, string2, new zzlk(string3, query.getLong(10), Y, string2), query.getLong(8), z10, string4, (zzau) g02.B(blob, creator), j10, (zzau) this.f39651b.g0().B(query.getBlob(9), creator), query.getLong(11), (zzau) this.f39651b.g0().B(query.getBlob(12), creator)));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } else {
                        o3 r10 = this.f40059a.d().r();
                        this.f40059a.z();
                        r10.b("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                }
                query.close();
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (SQLiteException e10) {
            this.f40059a.d().r().b("Error querying conditional user property value", e10);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final List c0(String str) {
        p.g(str);
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            this.f40059a.z();
            Cursor query = P().query(DataplanFilterImpl.USER_ATTRIBUTES_KEY, new String[]{"name", FirebaseAnalytics.Param.ORIGIN, "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j10 = query.getLong(2);
                    Object Y = Y(query, 3);
                    if (Y == null) {
                        this.f40059a.d().r().b("Read invalid user property value, ignoring it. appId", q3.z(str));
                    } else {
                        arrayList.add(new r9(str, str2, string, j10, Y));
                    }
                } while (query.moveToNext());
                query.close();
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (SQLiteException e10) {
            this.f40059a.d().r().c("Error querying user properties. appId", q3.z(str), e10);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0123 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List d0(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            com.google.android.gms.common.internal.p.g(r18)
            r17.h()
            r17.i()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r11 = "1001"
            r12 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0105 }
            r13 = 3
            r3.<init>(r13)     // Catch:{ SQLiteException -> 0x0105 }
            r14 = r18
            r3.add(r14)     // Catch:{ SQLiteException -> 0x0103 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0103 }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x0103 }
            boolean r5 = android.text.TextUtils.isEmpty(r19)     // Catch:{ SQLiteException -> 0x0103 }
            if (r5 != 0) goto L_0x0038
            r15 = r19
            r3.add(r15)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r5 = " and origin=?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x00ff }
            goto L_0x003a
        L_0x0038:
            r15 = r19
        L_0x003a:
            boolean r5 = android.text.TextUtils.isEmpty(r20)     // Catch:{ SQLiteException -> 0x00ff }
            if (r5 != 0) goto L_0x0059
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00ff }
            r5.<init>()     // Catch:{ SQLiteException -> 0x00ff }
            r5.append(r0)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r6 = "*"
            r5.append(r6)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x00ff }
            r3.add(r5)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r5 = " and name glob ?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x00ff }
        L_0x0059:
            int r5 = r3.size()     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.Object[] r3 = r3.toArray(r5)     // Catch:{ SQLiteException -> 0x00ff }
            r7 = r3
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ SQLiteException -> 0x00ff }
            android.database.sqlite.SQLiteDatabase r3 = r17.P()     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r5 = "user_attributes"
            java.lang.String r6 = "name"
            java.lang.String r8 = "set_timestamp"
            java.lang.String r9 = "value"
            java.lang.String r10 = "origin"
            java.lang.String[] r6 = new java.lang.String[]{r6, r8, r9, r10}     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r8 = r4.toString()     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r10 = "rowid"
            com.google.android.gms.measurement.internal.u4 r4 = r1.f40059a     // Catch:{ SQLiteException -> 0x00ff }
            r4.z()     // Catch:{ SQLiteException -> 0x00ff }
            r9 = 0
            r16 = 0
            r4 = r5
            r5 = r6
            r6 = r8
            r8 = r9
            r9 = r16
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00ff }
            boolean r3 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x00ff }
            if (r3 != 0) goto L_0x009a
            r12.close()
            return r2
        L_0x009a:
            int r3 = r2.size()     // Catch:{ SQLiteException -> 0x00ff }
            com.google.android.gms.measurement.internal.u4 r4 = r1.f40059a     // Catch:{ SQLiteException -> 0x00ff }
            r4.z()     // Catch:{ SQLiteException -> 0x00ff }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x00c0
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ SQLiteException -> 0x00ff }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ SQLiteException -> 0x00ff }
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r3 = "Read more than the max allowed user properties, ignoring excess"
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40059a     // Catch:{ SQLiteException -> 0x00ff }
            r5.z()     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x00ff }
            r0.b(r3, r4)     // Catch:{ SQLiteException -> 0x00ff }
            goto L_0x00fb
        L_0x00c0:
            r3 = 0
            java.lang.String r7 = r12.getString(r3)     // Catch:{ SQLiteException -> 0x00ff }
            r3 = 1
            long r8 = r12.getLong(r3)     // Catch:{ SQLiteException -> 0x00ff }
            r3 = 2
            java.lang.Object r10 = r1.Y(r12, r3)     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r15 = r12.getString(r13)     // Catch:{ SQLiteException -> 0x00ff }
            if (r10 != 0) goto L_0x00e9
            com.google.android.gms.measurement.internal.u4 r3 = r1.f40059a     // Catch:{ SQLiteException -> 0x00ff }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ SQLiteException -> 0x00ff }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ SQLiteException -> 0x00ff }
            java.lang.String r4 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.q3.z(r18)     // Catch:{ SQLiteException -> 0x00ff }
            r3.d(r4, r5, r15, r0)     // Catch:{ SQLiteException -> 0x00ff }
            goto L_0x00f5
        L_0x00e9:
            com.google.android.gms.measurement.internal.r9 r3 = new com.google.android.gms.measurement.internal.r9     // Catch:{ SQLiteException -> 0x00ff }
            r4 = r3
            r5 = r18
            r6 = r15
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x00ff }
            r2.add(r3)     // Catch:{ SQLiteException -> 0x00ff }
        L_0x00f5:
            boolean r3 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x00ff }
            if (r3 != 0) goto L_0x009a
        L_0x00fb:
            r12.close()
            return r2
        L_0x00ff:
            r0 = move-exception
            goto L_0x010a
        L_0x0101:
            r0 = move-exception
            goto L_0x0127
        L_0x0103:
            r0 = move-exception
            goto L_0x0108
        L_0x0105:
            r0 = move-exception
            r14 = r18
        L_0x0108:
            r15 = r19
        L_0x010a:
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a     // Catch:{ all -> 0x0101 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ all -> 0x0101 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x0101 }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r18)     // Catch:{ all -> 0x0101 }
            r2.d(r3, r4, r15, r0)     // Catch:{ all -> 0x0101 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0101 }
            if (r12 == 0) goto L_0x0126
            r12.close()
        L_0x0126:
            return r0
        L_0x0127:
            if (r12 == 0) goto L_0x012c
            r12.close()
        L_0x012c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.k.d0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void e0() {
        i();
        P().beginTransaction();
    }

    public final void f0() {
        i();
        P().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final void g0(List list) {
        h();
        i();
        p.k(list);
        p.m(list.size());
        if (u()) {
            String str = "(" + TextUtils.join(AppsFlyerKit.COMMA, list) + ")";
            if (I("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                this.f40059a.d().w().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                P().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e10) {
                this.f40059a.d().r().b("Error incrementing retry count. error", e10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void h0() {
        h();
        i();
        if (u()) {
            long a10 = this.f39651b.e0().f39964e.a();
            long b10 = this.f40059a.a().b();
            long abs = Math.abs(b10 - a10);
            this.f40059a.z();
            if (abs > ((Long) g3.A.a((Object) null)).longValue()) {
                this.f39651b.e0().f39964e.b(b10);
                h();
                i();
                if (u()) {
                    SQLiteDatabase P = P();
                    this.f40059a.z();
                    int delete = P.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.f40059a.a().currentTimeMillis()), String.valueOf(g.i())});
                    if (delete > 0) {
                        this.f40059a.d().v().b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    public final void m(String str, String str2) {
        p.g(str);
        p.g(str2);
        h();
        i();
        try {
            P().delete(DataplanFilterImpl.USER_ATTRIBUTES_KEY, "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            this.f40059a.d().r().d("Error deleting user property. appId", q3.z(str), this.f40059a.D().f(str2), e10);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0333, code lost:
        r11.put("session_scoped", r0);
        r11.put("data", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0347, code lost:
        if (P().insertWithOnConflict("property_filters", (java.lang.String) null, r11, 5) != -1) goto L_0x035d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0349, code lost:
        r1.f40059a.d().r().b("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.q3.z(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x035d, code lost:
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0361, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r1.f40059a.d().r().c("Error storing property filter. appId", com.google.android.gms.measurement.internal.q3.z(r24), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x03ac, code lost:
        r3 = r25;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x017a, code lost:
        r11 = r0.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0186, code lost:
        if (r11.hasNext() == false) goto L_0x01ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0192, code lost:
        if (((com.google.android.gms.internal.measurement.zzet) r11.next()).zzj() != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0194, code lost:
        r1.f40059a.d().w().c("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.q3.z(r24), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ad, code lost:
        r11 = r0.zzg().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01c3, code lost:
        if (r11.hasNext() == false) goto L_0x0299;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r12 = (com.google.android.gms.internal.measurement.zzek) r11.next();
        i();
        h();
        com.google.android.gms.common.internal.p.g(r24);
        com.google.android.gms.common.internal.p.k(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01df, code lost:
        if (r12.zzg().isEmpty() == false) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e1, code lost:
        r0 = r1.f40059a.d().w();
        r9 = com.google.android.gms.measurement.internal.q3.z(r24);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f9, code lost:
        if (r12.zzp() == false) goto L_0x0206;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01fb, code lost:
        r20 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0206, code lost:
        r20 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0208, code lost:
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r9, r11, java.lang.String.valueOf(r20));
        r21 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0213, code lost:
        r3 = r12.zzbx();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put("app_id", r2);
        r7.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x022c, code lost:
        if (r12.zzp() == false) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x022e, code lost:
        r9 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0237, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0238, code lost:
        r7.put("filter_id", r9);
        r7.put("event_name", r12.zzg());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0248, code lost:
        if (r12.zzq() == false) goto L_0x0253;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x024a, code lost:
        r9 = java.lang.Boolean.valueOf(r12.zzn());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0253, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0254, code lost:
        r7.put("session_scoped", r9);
        r7.put("data", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0268, code lost:
        if (P().insertWithOnConflict("event_filters", (java.lang.String) null, r7, 5) != -1) goto L_0x027d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x026a, code lost:
        r1.f40059a.d().r().b("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.q3.z(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x027d, code lost:
        r3 = r25;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0299, code lost:
        r21 = r7;
        r0 = r0.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02a7, code lost:
        if (r0.hasNext() == false) goto L_0x03ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02a9, code lost:
        r3 = (com.google.android.gms.internal.measurement.zzet) r0.next();
        i();
        h();
        com.google.android.gms.common.internal.p.g(r24);
        com.google.android.gms.common.internal.p.k(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02c3, code lost:
        if (r3.zze().isEmpty() == false) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02c5, code lost:
        r0 = r1.f40059a.d().w();
        r8 = com.google.android.gms.measurement.internal.q3.z(r24);
        r9 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02dd, code lost:
        if (r3.zzj() == false) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02df, code lost:
        r3 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02e8, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02e9, code lost:
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r9, java.lang.String.valueOf(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02f2, code lost:
        r7 = r3.zzbx();
        r11 = new android.content.ContentValues();
        r11.put("app_id", r2);
        r11.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0309, code lost:
        if (r3.zzj() == false) goto L_0x0314;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x030b, code lost:
        r12 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0314, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0315, code lost:
        r11.put("filter_id", r12);
        r22 = r0;
        r11.put("property_name", r3.zze());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0327, code lost:
        if (r3.zzk() == false) goto L_0x0332;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0329, code lost:
        r0 = java.lang.Boolean.valueOf(r3.zzi());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0332, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(java.lang.String r24, java.util.List r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "app_id=? and audience_id=?"
            java.lang.String r0 = "app_id=?"
            java.lang.String r5 = "event_filters"
            java.lang.String r6 = "property_filters"
            com.google.android.gms.common.internal.p.k(r25)
            r8 = 0
        L_0x0012:
            int r9 = r25.size()
            if (r8 >= r9) goto L_0x00dc
            java.lang.Object r9 = r3.get(r8)
            com.google.android.gms.internal.measurement.zzei r9 = (com.google.android.gms.internal.measurement.zzei) r9
            com.google.android.gms.internal.measurement.zzkx r9 = r9.zzbB()
            com.google.android.gms.internal.measurement.zzeh r9 = (com.google.android.gms.internal.measurement.zzeh) r9
            int r11 = r9.zza()
            if (r11 == 0) goto L_0x009d
            r11 = 0
        L_0x002b:
            int r12 = r9.zza()
            if (r11 >= r12) goto L_0x009d
            com.google.android.gms.internal.measurement.zzek r12 = r9.zze(r11)
            com.google.android.gms.internal.measurement.zzkx r12 = r12.zzbB()
            com.google.android.gms.internal.measurement.zzej r12 = (com.google.android.gms.internal.measurement.zzej) r12
            com.google.android.gms.internal.measurement.zzkx r13 = r12.zzav()
            com.google.android.gms.internal.measurement.zzej r13 = (com.google.android.gms.internal.measurement.zzej) r13
            java.lang.String r14 = r12.zze()
            java.lang.String r14 = we.p.b(r14)
            if (r14 == 0) goto L_0x0050
            r13.zzb(r14)
            r14 = 1
            goto L_0x0051
        L_0x0050:
            r14 = 0
        L_0x0051:
            r15 = 0
        L_0x0052:
            int r7 = r12.zza()
            if (r15 >= r7) goto L_0x0088
            com.google.android.gms.internal.measurement.zzem r7 = r12.zzd(r15)
            java.lang.String r10 = r7.zze()
            r16 = r12
            java.lang.String[] r12 = we.q.f42129a
            r17 = r4
            java.lang.String[] r4 = we.q.f42130b
            java.lang.String r4 = we.v.b(r10, r12, r4)
            if (r4 == 0) goto L_0x0081
            com.google.android.gms.internal.measurement.zzkx r7 = r7.zzbB()
            com.google.android.gms.internal.measurement.zzel r7 = (com.google.android.gms.internal.measurement.zzel) r7
            r7.zza(r4)
            com.google.android.gms.internal.measurement.zzlb r4 = r7.zzaD()
            com.google.android.gms.internal.measurement.zzem r4 = (com.google.android.gms.internal.measurement.zzem) r4
            r13.zzc(r15, r4)
            r14 = 1
        L_0x0081:
            int r15 = r15 + 1
            r12 = r16
            r4 = r17
            goto L_0x0052
        L_0x0088:
            r17 = r4
            if (r14 == 0) goto L_0x0098
            r9.zzc(r11, r13)
            com.google.android.gms.internal.measurement.zzlb r4 = r9.zzaD()
            com.google.android.gms.internal.measurement.zzei r4 = (com.google.android.gms.internal.measurement.zzei) r4
            r3.set(r8, r4)
        L_0x0098:
            int r11 = r11 + 1
            r4 = r17
            goto L_0x002b
        L_0x009d:
            r17 = r4
            int r4 = r9.zzb()
            if (r4 == 0) goto L_0x00d6
            r4 = 0
        L_0x00a6:
            int r7 = r9.zzb()
            if (r4 >= r7) goto L_0x00d6
            com.google.android.gms.internal.measurement.zzet r7 = r9.zzf(r4)
            java.lang.String r10 = r7.zze()
            java.lang.String[] r11 = we.r.f42133a
            java.lang.String[] r12 = we.r.f42134b
            java.lang.String r10 = we.v.b(r10, r11, r12)
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.internal.measurement.zzkx r7 = r7.zzbB()
            com.google.android.gms.internal.measurement.zzes r7 = (com.google.android.gms.internal.measurement.zzes) r7
            r7.zza(r10)
            r9.zzd(r4, r7)
            com.google.android.gms.internal.measurement.zzlb r7 = r9.zzaD()
            com.google.android.gms.internal.measurement.zzei r7 = (com.google.android.gms.internal.measurement.zzei) r7
            r3.set(r8, r7)
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x00a6
        L_0x00d6:
            int r8 = r8 + 1
            r4 = r17
            goto L_0x0012
        L_0x00dc:
            r17 = r4
            r23.i()
            r23.h()
            com.google.android.gms.common.internal.p.g(r24)
            com.google.android.gms.common.internal.p.k(r25)
            android.database.sqlite.SQLiteDatabase r4 = r23.P()
            r4.beginTransaction()
            r23.i()     // Catch:{ all -> 0x0495 }
            r23.h()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.p.g(r24)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r7 = r23.P()     // Catch:{ all -> 0x0495 }
            r8 = 1
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ all -> 0x0495 }
            r10 = 0
            r9[r10] = r2     // Catch:{ all -> 0x0495 }
            r7.delete(r6, r0, r9)     // Catch:{ all -> 0x0495 }
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ all -> 0x0495 }
            r9[r10] = r2     // Catch:{ all -> 0x0495 }
            r7.delete(r5, r0, r9)     // Catch:{ all -> 0x0495 }
            java.util.Iterator r7 = r25.iterator()     // Catch:{ all -> 0x0495 }
        L_0x0112:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0495 }
            if (r0 == 0) goto L_0x03b2
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ all -> 0x0495 }
            r23.i()     // Catch:{ all -> 0x0495 }
            r23.h()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.p.g(r24)     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.p.k(r0)     // Catch:{ all -> 0x0495 }
            boolean r10 = r0.zzk()     // Catch:{ all -> 0x0495 }
            if (r10 != 0) goto L_0x0144
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Audience with no ID. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.q3.z(r24)     // Catch:{ all -> 0x0495 }
            r0.b(r8, r9)     // Catch:{ all -> 0x0495 }
            goto L_0x0112
        L_0x0144:
            int r10 = r0.zza()     // Catch:{ all -> 0x0495 }
            java.util.List r11 = r0.zzg()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0495 }
        L_0x0150:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0495 }
            if (r12 == 0) goto L_0x017a
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzek r12 = (com.google.android.gms.internal.measurement.zzek) r12     // Catch:{ all -> 0x0495 }
            boolean r12 = r12.zzp()     // Catch:{ all -> 0x0495 }
            if (r12 != 0) goto L_0x0150
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.q3.z(r24)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r0.c(r8, r9, r10)     // Catch:{ all -> 0x0495 }
            goto L_0x0112
        L_0x017a:
            java.util.List r11 = r0.zzh()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0495 }
        L_0x0182:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0495 }
            if (r12 == 0) goto L_0x01ad
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzet r12 = (com.google.android.gms.internal.measurement.zzet) r12     // Catch:{ all -> 0x0495 }
            boolean r12 = r12.zzj()     // Catch:{ all -> 0x0495 }
            if (r12 != 0) goto L_0x0182
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.q3.z(r24)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r0.c(r8, r9, r10)     // Catch:{ all -> 0x0495 }
            goto L_0x0112
        L_0x01ad:
            java.util.List r11 = r0.zzg()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0495 }
        L_0x01b5:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "data"
            java.lang.String r13 = "session_scoped"
            java.lang.String r14 = "filter_id"
            java.lang.String r9 = "audience_id"
            java.lang.String r15 = "app_id"
            if (r12 == 0) goto L_0x0299
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzek r12 = (com.google.android.gms.internal.measurement.zzek) r12     // Catch:{ all -> 0x0495 }
            r23.i()     // Catch:{ all -> 0x0495 }
            r23.h()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.p.g(r24)     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.p.k(r12)     // Catch:{ all -> 0x0495 }
            java.lang.String r21 = r12.zzg()     // Catch:{ all -> 0x0495 }
            boolean r21 = r21.isEmpty()     // Catch:{ all -> 0x0495 }
            if (r21 == 0) goto L_0x0213
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.q3.z(r24)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            boolean r13 = r12.zzp()     // Catch:{ all -> 0x0495 }
            if (r13 == 0) goto L_0x0206
            int r12 = r12.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0495 }
            r20 = r12
            goto L_0x0208
        L_0x0206:
            r20 = 0
        L_0x0208:
            java.lang.String r12 = java.lang.String.valueOf(r20)     // Catch:{ all -> 0x0495 }
            r0.d(r8, r9, r11, r12)     // Catch:{ all -> 0x0495 }
            r21 = r7
            goto L_0x0375
        L_0x0213:
            byte[] r3 = r12.zzbx()     // Catch:{ all -> 0x0495 }
            r21 = r7
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x0495 }
            r7.<init>()     // Catch:{ all -> 0x0495 }
            r7.put(r15, r2)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r7.put(r9, r15)     // Catch:{ all -> 0x0495 }
            boolean r9 = r12.zzp()     // Catch:{ all -> 0x0495 }
            if (r9 == 0) goto L_0x0237
            int r9 = r12.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0495 }
            goto L_0x0238
        L_0x0237:
            r9 = 0
        L_0x0238:
            r7.put(r14, r9)     // Catch:{ all -> 0x0495 }
            java.lang.String r9 = "event_name"
            java.lang.String r14 = r12.zzg()     // Catch:{ all -> 0x0495 }
            r7.put(r9, r14)     // Catch:{ all -> 0x0495 }
            boolean r9 = r12.zzq()     // Catch:{ all -> 0x0495 }
            if (r9 == 0) goto L_0x0253
            boolean r9 = r12.zzn()     // Catch:{ all -> 0x0495 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0495 }
            goto L_0x0254
        L_0x0253:
            r9 = 0
        L_0x0254:
            r7.put(r13, r9)     // Catch:{ all -> 0x0495 }
            r7.put(r8, r3)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r3 = r23.P()     // Catch:{ SQLiteException -> 0x0283 }
            r8 = 5
            r9 = 0
            long r7 = r3.insertWithOnConflict(r5, r9, r7, r8)     // Catch:{ SQLiteException -> 0x0283 }
            r12 = -1
            int r3 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x027d
            com.google.android.gms.measurement.internal.u4 r3 = r1.f40059a     // Catch:{ SQLiteException -> 0x0283 }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ SQLiteException -> 0x0283 }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ SQLiteException -> 0x0283 }
            java.lang.String r7 = "Failed to insert event filter (got -1). appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r24)     // Catch:{ SQLiteException -> 0x0283 }
            r3.b(r7, r8)     // Catch:{ SQLiteException -> 0x0283 }
        L_0x027d:
            r3 = r25
            r7 = r21
            goto L_0x01b5
        L_0x0283:
            r0 = move-exception
            com.google.android.gms.measurement.internal.u4 r3 = r1.f40059a     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = "Error storing event filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r24)     // Catch:{ all -> 0x0495 }
            r3.c(r7, r8, r0)     // Catch:{ all -> 0x0495 }
            goto L_0x0375
        L_0x0299:
            r21 = r7
            java.util.List r0 = r0.zzh()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0495 }
        L_0x02a3:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0495 }
            if (r3 == 0) goto L_0x03ac
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzet r3 = (com.google.android.gms.internal.measurement.zzet) r3     // Catch:{ all -> 0x0495 }
            r23.i()     // Catch:{ all -> 0x0495 }
            r23.h()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.p.g(r24)     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.p.k(r3)     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = r3.zze()     // Catch:{ all -> 0x0495 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0495 }
            if (r7 == 0) goto L_0x02f2
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r24)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            boolean r11 = r3.zzj()     // Catch:{ all -> 0x0495 }
            if (r11 == 0) goto L_0x02e8
            int r3 = r3.zza()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0495 }
            goto L_0x02e9
        L_0x02e8:
            r3 = 0
        L_0x02e9:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0495 }
            r0.d(r7, r8, r9, r3)     // Catch:{ all -> 0x0495 }
            goto L_0x0375
        L_0x02f2:
            byte[] r7 = r3.zzbx()     // Catch:{ all -> 0x0495 }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ all -> 0x0495 }
            r11.<init>()     // Catch:{ all -> 0x0495 }
            r11.put(r15, r2)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r11.put(r9, r12)     // Catch:{ all -> 0x0495 }
            boolean r12 = r3.zzj()     // Catch:{ all -> 0x0495 }
            if (r12 == 0) goto L_0x0314
            int r12 = r3.zza()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0495 }
            goto L_0x0315
        L_0x0314:
            r12 = 0
        L_0x0315:
            r11.put(r14, r12)     // Catch:{ all -> 0x0495 }
            java.lang.String r12 = "property_name"
            r22 = r0
            java.lang.String r0 = r3.zze()     // Catch:{ all -> 0x0495 }
            r11.put(r12, r0)     // Catch:{ all -> 0x0495 }
            boolean r0 = r3.zzk()     // Catch:{ all -> 0x0495 }
            if (r0 == 0) goto L_0x0332
            boolean r0 = r3.zzi()     // Catch:{ all -> 0x0495 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0495 }
            goto L_0x0333
        L_0x0332:
            r0 = 0
        L_0x0333:
            r11.put(r13, r0)     // Catch:{ all -> 0x0495 }
            r11.put(r8, r7)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r0 = r23.P()     // Catch:{ SQLiteException -> 0x0361 }
            r3 = 0
            r7 = 5
            long r11 = r0.insertWithOnConflict(r6, r3, r11, r7)     // Catch:{ SQLiteException -> 0x0361 }
            r18 = -1
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x035d
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ SQLiteException -> 0x0361 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ SQLiteException -> 0x0361 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x0361 }
            java.lang.String r3 = "Failed to insert property filter (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.q3.z(r24)     // Catch:{ SQLiteException -> 0x0361 }
            r0.b(r3, r7)     // Catch:{ SQLiteException -> 0x0361 }
            goto L_0x0375
        L_0x035d:
            r0 = r22
            goto L_0x02a3
        L_0x0361:
            r0 = move-exception
            com.google.android.gms.measurement.internal.u4 r3 = r1.f40059a     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = "Error storing property filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r24)     // Catch:{ all -> 0x0495 }
            r3.c(r7, r8, r0)     // Catch:{ all -> 0x0495 }
        L_0x0375:
            r23.i()     // Catch:{ all -> 0x0495 }
            r23.h()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.p.g(r24)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r0 = r23.P()     // Catch:{ all -> 0x0495 }
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ all -> 0x0495 }
            r3 = 0
            r7[r3] = r2     // Catch:{ all -> 0x0495 }
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r8 = 1
            r7[r8] = r3     // Catch:{ all -> 0x0495 }
            r3 = r17
            r0.delete(r6, r3, r7)     // Catch:{ all -> 0x0495 }
            r7 = 2
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ all -> 0x0495 }
            r8 = 0
            r7[r8] = r2     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0495 }
            r9 = 1
            r7[r9] = r8     // Catch:{ all -> 0x0495 }
            r0.delete(r5, r3, r7)     // Catch:{ all -> 0x0495 }
            r17 = r3
            r7 = r21
            r3 = r25
            goto L_0x0112
        L_0x03ac:
            r3 = r25
            r7 = r21
            goto L_0x0112
        L_0x03b2:
            r3 = 0
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0495 }
            r0.<init>()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r5 = r25.iterator()     // Catch:{ all -> 0x0495 }
        L_0x03bc:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0495 }
            if (r6 == 0) goto L_0x03dc
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzei r6 = (com.google.android.gms.internal.measurement.zzei) r6     // Catch:{ all -> 0x0495 }
            boolean r7 = r6.zzk()     // Catch:{ all -> 0x0495 }
            if (r7 == 0) goto L_0x03d7
            int r6 = r6.zza()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0495 }
            goto L_0x03d8
        L_0x03d7:
            r9 = r3
        L_0x03d8:
            r0.add(r9)     // Catch:{ all -> 0x0495 }
            goto L_0x03bc
        L_0x03dc:
            com.google.android.gms.common.internal.p.g(r24)     // Catch:{ all -> 0x0495 }
            r23.i()     // Catch:{ all -> 0x0495 }
            r23.h()     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r3 = r23.P()     // Catch:{ all -> 0x0495 }
            java.lang.String r5 = "select count(1) from audience_filter_values where app_id=?"
            r6 = 1
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x047a }
            r6 = 0
            r7[r6] = r2     // Catch:{ SQLiteException -> 0x047a }
            long r5 = r1.I(r5, r7)     // Catch:{ SQLiteException -> 0x047a }
            com.google.android.gms.measurement.internal.u4 r7 = r1.f40059a     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.g r7 = r7.z()     // Catch:{ all -> 0x0495 }
            r8 = 2000(0x7d0, float:2.803E-42)
            com.google.android.gms.measurement.internal.f3 r9 = com.google.android.gms.measurement.internal.g3.H     // Catch:{ all -> 0x0495 }
            int r7 = r7.o(r2, r9)     // Catch:{ all -> 0x0495 }
            int r7 = java.lang.Math.min(r8, r7)     // Catch:{ all -> 0x0495 }
            r8 = 0
            int r7 = java.lang.Math.max(r8, r7)     // Catch:{ all -> 0x0495 }
            long r8 = (long) r7     // Catch:{ all -> 0x0495 }
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 > 0) goto L_0x0413
            goto L_0x048e
        L_0x0413:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0495 }
            r5.<init>()     // Catch:{ all -> 0x0495 }
            r10 = 0
        L_0x0419:
            int r6 = r0.size()     // Catch:{ all -> 0x0495 }
            if (r10 >= r6) goto L_0x0435
            java.lang.Object r6 = r0.get(r10)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0495 }
            if (r6 == 0) goto L_0x048e
            int r6 = r6.intValue()     // Catch:{ all -> 0x0495 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0495 }
            r5.add(r6)     // Catch:{ all -> 0x0495 }
            int r10 = r10 + 1
            goto L_0x0419
        L_0x0435:
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r5)     // Catch:{ all -> 0x0495 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0495 }
            r5.<init>()     // Catch:{ all -> 0x0495 }
            java.lang.String r6 = "("
            r5.append(r6)     // Catch:{ all -> 0x0495 }
            r5.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = ")"
            r5.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0495 }
            java.lang.String r5 = "audience_filter_values"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0495 }
            r6.<init>()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in "
            r6.append(r8)     // Catch:{ all -> 0x0495 }
            r6.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = " order by rowid desc limit -1 offset ?)"
            r6.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0495 }
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x0495 }
            r8 = 0
            r6[r8] = r2     // Catch:{ all -> 0x0495 }
            java.lang.String r2 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0495 }
            r7 = 1
            r6[r7] = r2     // Catch:{ all -> 0x0495 }
            r3.delete(r5, r0, r6)     // Catch:{ all -> 0x0495 }
            goto L_0x048e
        L_0x047a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.u4 r3 = r1.f40059a     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0495 }
            java.lang.String r5 = "Database error querying filters. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.q3.z(r24)     // Catch:{ all -> 0x0495 }
            r3.c(r5, r2, r0)     // Catch:{ all -> 0x0495 }
        L_0x048e:
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0495 }
            r4.endTransaction()
            return
        L_0x0495:
            r0 = move-exception
            r4.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.k.n(java.lang.String, java.util.List):void");
    }

    public final void o() {
        i();
        P().setTransactionSuccessful();
    }

    public final void p(q5 q5Var) {
        p.k(q5Var);
        h();
        i();
        String l02 = q5Var.l0();
        p.k(l02);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", l02);
        contentValues.put("app_instance_id", q5Var.m0());
        contentValues.put("gmp_app_id", q5Var.a());
        contentValues.put("resettable_device_id_hash", q5Var.c());
        contentValues.put("last_bundle_index", Long.valueOf(q5Var.e0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(q5Var.f0()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(q5Var.d0()));
        contentValues.put("app_version", q5Var.o0());
        contentValues.put("app_store", q5Var.n0());
        contentValues.put("gmp_version", Long.valueOf(q5Var.c0()));
        contentValues.put("dev_cert_hash", Long.valueOf(q5Var.Z()));
        contentValues.put("measurement_enabled", Boolean.valueOf(q5Var.O()));
        contentValues.put("day", Long.valueOf(q5Var.Y()));
        contentValues.put("daily_public_events_count", Long.valueOf(q5Var.W()));
        contentValues.put("daily_events_count", Long.valueOf(q5Var.V()));
        contentValues.put("daily_conversions_count", Long.valueOf(q5Var.T()));
        contentValues.put("config_fetched_time", Long.valueOf(q5Var.S()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(q5Var.b0()));
        contentValues.put("app_version_int", Long.valueOf(q5Var.R()));
        contentValues.put("firebase_instance_id", q5Var.p0());
        contentValues.put("daily_error_events_count", Long.valueOf(q5Var.U()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(q5Var.X()));
        contentValues.put("health_monitor_sample", q5Var.b());
        q5Var.A();
        contentValues.put("android_id", 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(q5Var.N()));
        contentValues.put("admob_app_id", q5Var.j0());
        contentValues.put("dynamite_version", Long.valueOf(q5Var.a0()));
        contentValues.put("session_stitching_token", q5Var.d());
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(q5Var.Q()));
        contentValues.put("target_os_version", Long.valueOf(q5Var.h0()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(q5Var.g0()));
        List e10 = q5Var.e();
        if (e10 != null) {
            if (e10.isEmpty()) {
                this.f40059a.d().w().b("Safelisted events should not be an empty list. appId", l02);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(AppsFlyerKit.COMMA, e10));
            }
        }
        zzop.zzc();
        if (this.f40059a.z().B((String) null, g3.f39830m0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase P = P();
            if (((long) P.update("apps", contentValues, "app_id = ?", new String[]{l02})) == 0 && P.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                this.f40059a.d().r().b("Failed to insert/update app (got -1). appId", q3.z(l02));
            }
        } catch (SQLiteException e11) {
            this.f40059a.d().r().c("Error storing app. appId", q3.z(l02), e11);
        }
    }

    public final void q(q qVar) {
        long j10;
        p.k(qVar);
        h();
        i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", qVar.f40145a);
        contentValues.put("name", qVar.f40146b);
        contentValues.put("lifetime_count", Long.valueOf(qVar.f40147c));
        contentValues.put("current_bundle_count", Long.valueOf(qVar.f40148d));
        contentValues.put("last_fire_timestamp", Long.valueOf(qVar.f40150f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(qVar.f40151g));
        contentValues.put("last_bundled_day", qVar.f40152h);
        contentValues.put("last_sampled_complex_event_id", qVar.f40153i);
        contentValues.put("last_sampling_rate", qVar.f40154j);
        contentValues.put("current_session_count", Long.valueOf(qVar.f40149e));
        Boolean bool = qVar.f40155k;
        if (bool == null || !bool.booleanValue()) {
            j10 = null;
        } else {
            j10 = 1L;
        }
        contentValues.put("last_exempt_from_sampling", j10);
        try {
            if (P().insertWithOnConflict(Constants.Params.API_EVENTS_STATE, (String) null, contentValues, 5) == -1) {
                this.f40059a.d().r().b("Failed to insert/update event aggregates (got -1). appId", q3.z(qVar.f40145a));
            }
        } catch (SQLiteException e10) {
            this.f40059a.d().r().c("Error storing event aggregates. appId", q3.z(qVar.f40145a), e10);
        }
    }

    public final boolean r() {
        return I("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean s() {
        return I("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean t() {
        return I("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        Context c10 = this.f40059a.c();
        this.f40059a.z();
        return c10.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean v(String str, Long l10, long j10, zzft zzft) {
        h();
        i();
        p.k(zzft);
        p.g(str);
        p.k(l10);
        byte[] zzbx = zzft.zzbx();
        this.f40059a.d().v().c("Saving complex main event, appId, data size", this.f40059a.D().d(str), Integer.valueOf(zzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", zzbx);
        try {
            if (P().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.f40059a.d().r().b("Failed to insert complex main event (got -1). appId", q3.z(str));
            return false;
        } catch (SQLiteException e10) {
            this.f40059a.d().r().c("Error storing complex main event. appId", q3.z(str), e10);
            return false;
        }
    }

    public final boolean w(zzac zzac) {
        p.k(zzac);
        h();
        i();
        String str = zzac.f40479a;
        p.k(str);
        if (X(str, zzac.f40481c.f40500b) == null) {
            long I = I("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.f40059a.z();
            if (I >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, zzac.f40480b);
        contentValues.put("name", zzac.f40481c.f40500b);
        H(contentValues, "value", p.k(zzac.f40481c.S()));
        contentValues.put(ClientStateIndication.Active.ELEMENT, Boolean.valueOf(zzac.f40483e));
        contentValues.put("trigger_event_name", zzac.f40484f);
        contentValues.put("trigger_timeout", Long.valueOf(zzac.f40486h));
        contentValues.put("timed_out_event", this.f40059a.N().e0(zzac.f40485g));
        contentValues.put("creation_timestamp", Long.valueOf(zzac.f40482d));
        contentValues.put("triggered_event", this.f40059a.N().e0(zzac.f40487j));
        contentValues.put("triggered_timestamp", Long.valueOf(zzac.f40481c.f40501c));
        contentValues.put("time_to_live", Long.valueOf(zzac.f40488k));
        contentValues.put("expired_event", this.f40059a.N().e0(zzac.f40489l));
        try {
            if (P().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                this.f40059a.d().r().b("Failed to insert/update conditional user property (got -1)", q3.z(str));
            }
        } catch (SQLiteException e10) {
            this.f40059a.d().r().c("Error storing conditional user property", q3.z(str), e10);
        }
        return true;
    }

    public final boolean x(r9 r9Var) {
        p.k(r9Var);
        h();
        i();
        if (X(r9Var.f40231a, r9Var.f40233c) == null) {
            if (t9.Z(r9Var.f40233c)) {
                if (I("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{r9Var.f40231a}) >= ((long) this.f40059a.z().p(r9Var.f40231a, g3.I, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(r9Var.f40233c)) {
                long I = I("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{r9Var.f40231a, r9Var.f40232b});
                this.f40059a.z();
                if (I >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", r9Var.f40231a);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, r9Var.f40232b);
        contentValues.put("name", r9Var.f40233c);
        contentValues.put("set_timestamp", Long.valueOf(r9Var.f40234d));
        H(contentValues, "value", r9Var.f40235e);
        try {
            if (P().insertWithOnConflict(DataplanFilterImpl.USER_ATTRIBUTES_KEY, (String) null, contentValues, 5) == -1) {
                this.f40059a.d().r().b("Failed to insert/update user property (got -1). appId", q3.z(r9Var.f40231a));
            }
        } catch (SQLiteException e10) {
            this.f40059a.d().r().c("Error storing user property. appId", q3.z(r9Var.f40231a), e10);
        }
        return true;
    }
}
