package q1;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import t1.l;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a(\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u001a\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\n\u001a\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u0011"}, d2 = {"Landroidx/room/RoomDatabase;", "db", "Lt1/l;", "sqLiteQuery", "", "maybeCopy", "Landroid/os/CancellationSignal;", "signal", "Landroid/database/Cursor;", "b", "Lt1/i;", "", "a", "Ljava/io/File;", "databaseFile", "", "c", "room-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class b {
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        kotlin.io.b.a(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(t1.i r6) {
        /*
            java.lang.String r0 = "db"
            kotlin.jvm.internal.j.g(r6, r0)
            java.util.List r0 = kotlin.collections.p.c()
            java.lang.String r1 = "SELECT name FROM sqlite_master WHERE type = 'trigger'"
            android.database.Cursor r1 = r6.q1(r1)
        L_0x000f:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x005c }
            r3 = 0
            if (r2 == 0) goto L_0x001e
            java.lang.String r2 = r1.getString(r3)     // Catch:{ all -> 0x005c }
            r0.add(r2)     // Catch:{ all -> 0x005c }
            goto L_0x000f
        L_0x001e:
            kotlin.Unit r2 = kotlin.Unit.f32013a     // Catch:{ all -> 0x005c }
            r2 = 0
            kotlin.io.b.a(r1, r2)
            java.util.List r0 = kotlin.collections.p.a(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x002c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r4 = "triggerName"
            kotlin.jvm.internal.j.f(r1, r4)
            r4 = 2
            java.lang.String r5 = "room_fts_content_sync_"
            boolean r4 = kotlin.text.r.J(r1, r5, r3, r4, r2)
            if (r4 == 0) goto L_0x002c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "DROP TRIGGER IF EXISTS "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r6.D(r1)
            goto L_0x002c
        L_0x005b:
            return
        L_0x005c:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x005e }
        L_0x005e:
            r0 = move-exception
            kotlin.io.b.a(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.b.a(t1.i):void");
    }

    public static final Cursor b(RoomDatabase roomDatabase, l lVar, boolean z10, CancellationSignal cancellationSignal) {
        int i10;
        j.g(roomDatabase, UserDataStore.DATE_OF_BIRTH);
        j.g(lVar, "sqLiteQuery");
        Cursor z11 = roomDatabase.z(lVar, cancellationSignal);
        if (!z10 || !(z11 instanceof AbstractWindowedCursor)) {
            return z11;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) z11;
        int count = abstractWindowedCursor.getCount();
        if (abstractWindowedCursor.hasWindow()) {
            i10 = abstractWindowedCursor.getWindow().getNumRows();
        } else {
            i10 = count;
        }
        if (i10 < count) {
            return a.a(z11);
        }
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        kotlin.io.b.a(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int c(java.io.File r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "databaseFile"
            kotlin.jvm.internal.j.g(r8, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r8)
            java.nio.channels.FileChannel r8 = r0.getChannel()
            r0 = 4
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x003b }
            r2 = 60
            r4 = 4
            r6 = 1
            r1 = r8
            r1.tryLock(r2, r4, r6)     // Catch:{ all -> 0x003b }
            r1 = 60
            r8.position(r1)     // Catch:{ all -> 0x003b }
            int r1 = r8.read(r7)     // Catch:{ all -> 0x003b }
            if (r1 != r0) goto L_0x0033
            r7.rewind()     // Catch:{ all -> 0x003b }
            int r0 = r7.getInt()     // Catch:{ all -> 0x003b }
            r1 = 0
            kotlin.io.b.a(r8, r1)
            return r0
        L_0x0033:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x003b }
            java.lang.String r1 = "Bad database header, unable to read 4 bytes at offset 60"
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r1 = move-exception
            kotlin.io.b.a(r8, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.b.c(java.io.File):int");
    }
}
