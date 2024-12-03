package com.mparticle.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.mparticle.segmentation.Segment;
import com.mparticle.segmentation.SegmentListener;
import com.mparticle.segmentation.SegmentMembership;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.b;

class n {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f22554c = {"_id", "segment_id", "action"};

    /* renamed from: a  reason: collision with root package name */
    private final m f22555a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final f f22556b;

    n(m mVar, f fVar) {
        this.f22555a = mVar;
        this.f22556b = fVar;
    }

    /* access modifiers changed from: package-private */
    public void a(long j10, String str, SegmentListener segmentListener) {
        new a(j10, str, segmentListener).execute(new Void[0]);
    }

    /* access modifiers changed from: package-private */
    public SegmentMembership a(String str) {
        String[] strArr;
        String str2;
        SQLiteDatabase readableDatabase = this.f22555a.getReadableDatabase();
        if (str == null || str.length() <= 0) {
            str2 = null;
            strArr = null;
        } else {
            str2 = "endpoint_ids like ?";
            strArr = new String[]{"%\"" + str + "\"%"};
        }
        Cursor query = readableDatabase.query("segments", (String[]) null, str2, strArr, (String) null, (String) null, "_id desc");
        SparseArray sparseArray = new SparseArray();
        StringBuilder sb2 = new StringBuilder("(");
        if (query.getCount() <= 0) {
            return new SegmentMembership(new ArrayList());
        }
        while (query.moveToNext()) {
            int i10 = query.getInt(query.getColumnIndexOrThrow("_id"));
            sparseArray.put(i10, new Segment(i10, query.getString(query.getColumnIndexOrThrow("name")), query.getString(query.getColumnIndexOrThrow("endpoint_ids"))));
            sb2.append(i10);
            sb2.append(", ");
        }
        query.close();
        sb2.delete(sb2.length() - 2, sb2.length());
        sb2.append(")");
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query2 = readableDatabase.query(false, "segment_memberships", f22554c, String.format("segment_id in %s and timestamp < %d", new Object[]{sb2.toString(), Long.valueOf(currentTimeMillis)}), (String[]) null, (String) null, (String) null, "segment_id desc, timestamp desc", (String) null);
        ArrayList arrayList = new ArrayList();
        int i11 = -1;
        while (query2.moveToNext()) {
            int i12 = query2.getInt(1);
            if (i12 != i11) {
                if (query2.getString(2).equals("add")) {
                    arrayList.add((Segment) sparseArray.get(i12));
                }
                i11 = i12;
            }
        }
        query2.close();
        readableDatabase.close();
        return new SegmentMembership(arrayList);
    }

    class a extends AsyncTask<Void, Void, SegmentMembership> {

        /* renamed from: a  reason: collision with root package name */
        ExecutorService f22557a = Executors.newSingleThreadExecutor();

        /* renamed from: b  reason: collision with root package name */
        String f22558b;

        /* renamed from: c  reason: collision with root package name */
        SegmentListener f22559c;

        /* renamed from: d  reason: collision with root package name */
        long f22560d;

        /* renamed from: com.mparticle.internal.n$a$a  reason: collision with other inner class name */
        class C0260a implements Callable<Boolean> {
            C0260a() {
            }

            /* renamed from: a */
            public Boolean call() throws Exception {
                boolean z10;
                b a10 = n.this.f22556b.a();
                if (a10 != null) {
                    n.this.a(a10);
                }
                if (a10 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }

        a(long j10, String str, SegmentListener segmentListener) {
            this.f22560d = j10;
            this.f22558b = str;
            this.f22559c = segmentListener;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public SegmentMembership doInBackground(Void... voidArr) {
            FutureTask futureTask = new FutureTask(new C0260a());
            this.f22557a.execute(futureTask);
            try {
                futureTask.get(this.f22560d, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            } catch (ExecutionException e11) {
                e11.printStackTrace();
            } catch (TimeoutException e12) {
                e12.printStackTrace();
            }
            this.f22557a.shutdown();
            return n.this.a(this.f22558b);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(SegmentMembership segmentMembership) {
            this.f22559c.onSegmentsRetrieved(segmentMembership);
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar) throws JSONException {
        SQLiteDatabase writableDatabase = this.f22555a.getWritableDatabase();
        org.json.a jSONArray = bVar.getJSONArray(NetworkProfile.MALE);
        writableDatabase.beginTransaction();
        String str = null;
        try {
            writableDatabase.delete("segment_memberships", (String) null, (String[]) null);
            writableDatabase.delete("segments", (String) null, (String[]) null);
            for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                ContentValues contentValues = new ContentValues();
                b j10 = jSONArray.j(i10);
                int i11 = j10.getInt("id");
                String string = j10.getString("n");
                String aVar = j10.getJSONArray("s").toString();
                contentValues.put("_id", Integer.valueOf(i11));
                contentValues.put("name", string);
                contentValues.put("endpoint_ids", aVar);
                writableDatabase.insert("segments", str, contentValues);
                org.json.a jSONArray2 = j10.getJSONArray("c");
                int i12 = 0;
                while (i12 < jSONArray2.o()) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("segment_id", Integer.valueOf(i11));
                    contentValues2.put("action", jSONArray2.j(i12).getString("a"));
                    contentValues2.put("timestamp", Long.valueOf(jSONArray2.j(i12).optLong("ct", 0)));
                    writableDatabase.insert("segment_memberships", (String) null, contentValues2);
                    i12++;
                    str = null;
                }
                String str2 = str;
            }
            writableDatabase.setTransactionSuccessful();
        } catch (Exception e10) {
            Logger.debug("Failed to insert audiences: " + e10.getMessage());
        } finally {
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }
}
