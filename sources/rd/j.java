package rd;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;

public final class j implements w {

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f41854b;

    /* renamed from: a  reason: collision with root package name */
    private final LogPrinter f41855a = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        f41854b = builder.build();
    }

    public final void a(k kVar) {
        ArrayList arrayList = new ArrayList(kVar.e());
        Collections.sort(arrayList, new i(this));
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            String obj = ((m) arrayList.get(i10)).toString();
            if (!TextUtils.isEmpty(obj)) {
                if (sb2.length() != 0) {
                    sb2.append(", ");
                }
                sb2.append(obj);
            }
        }
        this.f41855a.println(sb2.toString());
    }

    public final Uri zzb() {
        return f41854b;
    }
}
