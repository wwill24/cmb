package q1;

import android.database.Cursor;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a%\u0010\u0001\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0001\u0010\f¨\u0006\r"}, d2 = {"Landroid/database/Cursor;", "c", "a", "", "name", "", "d", "e", "cursor", "b", "", "columnNames", "([Ljava/lang/String;Ljava/lang/String;)I", "room-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class a {
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0071, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0072, code lost:
        kotlin.io.b.a(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0075, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.database.Cursor a(android.database.Cursor r7) {
        /*
            java.lang.String r0 = "c"
            kotlin.jvm.internal.j.g(r7, r0)
            android.database.MatrixCursor r0 = new android.database.MatrixCursor     // Catch:{ all -> 0x006f }
            java.lang.String[] r1 = r7.getColumnNames()     // Catch:{ all -> 0x006f }
            int r2 = r7.getCount()     // Catch:{ all -> 0x006f }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x006f }
        L_0x0012:
            boolean r1 = r7.moveToNext()     // Catch:{ all -> 0x006f }
            r2 = 0
            if (r1 == 0) goto L_0x006b
            int r1 = r7.getColumnCount()     // Catch:{ all -> 0x006f }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x006f }
            r3 = 0
            int r4 = r7.getColumnCount()     // Catch:{ all -> 0x006f }
        L_0x0024:
            if (r3 >= r4) goto L_0x0067
            int r5 = r7.getType(r3)     // Catch:{ all -> 0x006f }
            if (r5 == 0) goto L_0x0062
            r6 = 1
            if (r5 == r6) goto L_0x0057
            r6 = 2
            if (r5 == r6) goto L_0x004c
            r6 = 3
            if (r5 == r6) goto L_0x0045
            r6 = 4
            if (r5 != r6) goto L_0x003f
            byte[] r5 = r7.getBlob(r3)     // Catch:{ all -> 0x006f }
            r1[r3] = r5     // Catch:{ all -> 0x006f }
            goto L_0x0064
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006f }
            r0.<init>()     // Catch:{ all -> 0x006f }
            throw r0     // Catch:{ all -> 0x006f }
        L_0x0045:
            java.lang.String r5 = r7.getString(r3)     // Catch:{ all -> 0x006f }
            r1[r3] = r5     // Catch:{ all -> 0x006f }
            goto L_0x0064
        L_0x004c:
            double r5 = r7.getDouble(r3)     // Catch:{ all -> 0x006f }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ all -> 0x006f }
            r1[r3] = r5     // Catch:{ all -> 0x006f }
            goto L_0x0064
        L_0x0057:
            long r5 = r7.getLong(r3)     // Catch:{ all -> 0x006f }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x006f }
            r1[r3] = r5     // Catch:{ all -> 0x006f }
            goto L_0x0064
        L_0x0062:
            r1[r3] = r2     // Catch:{ all -> 0x006f }
        L_0x0064:
            int r3 = r3 + 1
            goto L_0x0024
        L_0x0067:
            r0.addRow(r1)     // Catch:{ all -> 0x006f }
            goto L_0x0012
        L_0x006b:
            kotlin.io.b.a(r7, r2)
            return r0
        L_0x006f:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r1 = move-exception
            kotlin.io.b.a(r7, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.a.a(android.database.Cursor):android.database.Cursor");
    }

    private static final int b(Cursor cursor, String str) {
        boolean z10;
        if (Build.VERSION.SDK_INT > 25) {
            return -1;
        }
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        j.f(columnNames, "columnNames");
        return c(columnNames, str);
    }

    public static final int c(String[] strArr, String str) {
        j.g(strArr, "columnNames");
        j.g(str, "name");
        String str2 = '.' + str;
        String str3 = '.' + str + '`';
        int length = strArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            String str4 = strArr[i10];
            int i12 = i11 + 1;
            if (str4.length() >= str.length() + 2) {
                if (r.s(str4, str2, false, 2, (Object) null)) {
                    return i11;
                }
                if (str4.charAt(0) == '`' && r.s(str4, str3, false, 2, (Object) null)) {
                    return i11;
                }
            }
            i10++;
            i11 = i12;
        }
        return -1;
    }

    public static final int d(Cursor cursor, String str) {
        j.g(cursor, "c");
        j.g(str, "name");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex('`' + str + '`');
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        return b(cursor, str);
    }

    public static final int e(Cursor cursor, String str) {
        String str2;
        j.g(cursor, "c");
        j.g(str, "name");
        int d10 = d(cursor, str);
        if (d10 >= 0) {
            return d10;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            j.f(columnNames, "c.columnNames");
            str2 = l.c0(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } catch (Exception unused) {
            str2 = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }
}
