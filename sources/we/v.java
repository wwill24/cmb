package we;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;

public final class v {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038 A[Catch:{ IOException | ClassNotFoundException -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d A[Catch:{ IOException | ClassNotFoundException -> 0x0041 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(java.lang.Object r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0041
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0032 }
            r2.<init>(r1)     // Catch:{ all -> 0x0032 }
            r2.writeObject(r4)     // Catch:{ all -> 0x002e }
            r2.flush()     // Catch:{ all -> 0x002e }
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ all -> 0x002e }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x002e }
            byte[] r1 = r1.toByteArray()     // Catch:{ all -> 0x002e }
            r3.<init>(r1)     // Catch:{ all -> 0x002e }
            r4.<init>(r3)     // Catch:{ all -> 0x002e }
            java.lang.Object r1 = r4.readObject()     // Catch:{ all -> 0x002c }
            r2.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0041 }
            r4.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0041 }
            return r1
        L_0x002c:
            r1 = move-exception
            goto L_0x0036
        L_0x002e:
            r4 = move-exception
            r1 = r4
            r4 = r0
            goto L_0x0036
        L_0x0032:
            r4 = move-exception
            r1 = r4
            r4 = r0
            r2 = r4
        L_0x0036:
            if (r2 == 0) goto L_0x003b
            r2.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0041 }
        L_0x003b:
            if (r4 == 0) goto L_0x0040
            r4.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0041 }
        L_0x0040:
            throw r1     // Catch:{ IOException | ClassNotFoundException -> 0x0041 }
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: we.v.a(java.lang.Object):java.lang.Object");
    }

    public static String b(String str, String[] strArr, String[] strArr2) {
        p.k(strArr);
        p.k(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i10 = 0; i10 < min; i10++) {
            String str2 = strArr[i10];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i10];
            }
        }
        return null;
    }

    public static String c(Context context, String str, String str2) {
        p.k(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str2)) {
            str2 = k.a(context);
        }
        return k.b("google_app_id", resources, str2);
    }
}
