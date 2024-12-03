package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<byte[]> f4653a = new c();

    static class a {
        static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    private static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!Arrays.equals(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> d(e eVar, Resources resources) {
        if (eVar.b() != null) {
            return eVar.b();
        }
        return e.c(resources, eVar.c());
    }

    @NonNull
    static g.a e(@NonNull Context context, @NonNull e eVar, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo f10 = f(context.getPackageManager(), eVar, context.getResources());
        if (f10 == null) {
            return g.a.a(1, (g.b[]) null);
        }
        return g.a.a(0, h(context, eVar, f10.authority, cancellationSignal));
    }

    static ProviderInfo f(@NonNull PackageManager packageManager, @NonNull e eVar, Resources resources) throws PackageManager.NameNotFoundException {
        String e10 = eVar.e();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e10, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + e10);
        } else if (resolveContentProvider.packageName.equals(eVar.f())) {
            List<byte[]> b10 = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(b10, f4653a);
            List<List<byte[]>> d10 = d(eVar, resources);
            for (int i10 = 0; i10 < d10.size(); i10++) {
                ArrayList arrayList = new ArrayList(d10.get(i10));
                Collections.sort(arrayList, f4653a);
                if (c(b10, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + e10 + ", but package was not " + eVar.f());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            byte b11 = bArr2[i10];
            if (b10 != b11) {
                return b10 - b11;
            }
        }
        return 0;
    }

    @NonNull
    static g.b[] h(Context context, e eVar, String str, CancellationSignal cancellationSignal) {
        int i10;
        int i11;
        int i12;
        Uri uri;
        int i13;
        boolean z10;
        int i14;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
        Cursor cursor = null;
        try {
            int i15 = 0;
            cursor = a.a(context.getContentResolver(), build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{eVar.g()}, (String) null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    if (columnIndex != -1) {
                        i10 = cursor.getInt(columnIndex);
                    } else {
                        i10 = i15;
                    }
                    if (columnIndex4 != -1) {
                        i11 = cursor.getInt(columnIndex4);
                    } else {
                        i11 = i15;
                    }
                    if (columnIndex3 == -1) {
                        i12 = i10;
                        uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        i12 = i10;
                        uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    if (columnIndex5 != -1) {
                        i13 = cursor.getInt(columnIndex5);
                    } else {
                        i13 = 400;
                    }
                    if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                        i14 = i12;
                        z10 = false;
                    } else {
                        i14 = i12;
                        z10 = true;
                    }
                    arrayList2.add(g.b.a(uri, i11, i13, z10, i14));
                    i15 = 0;
                }
                arrayList = arrayList2;
            }
            return (g.b[]) arrayList.toArray(new g.b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
