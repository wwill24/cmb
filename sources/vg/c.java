package vg;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.mlkit.common.sdkinternal.i;
import com.google.mlkit.vision.barcode.internal.d;

public class c {
    @NonNull
    public static a a(@NonNull b bVar) {
        p.l(bVar, "You must provide a valid BarcodeScannerOptions.");
        return ((d) i.c().a(d.class)).a(bVar);
    }
}
