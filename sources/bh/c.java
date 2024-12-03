package bh;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.mlkit.common.sdkinternal.i;

public class c {
    @NonNull
    public static d a(@NonNull e eVar) {
        p.l(eVar, "You must provide a valid FaceDetectorOptions.");
        return ((com.google.mlkit.vision.face.internal.c) i.c().a(com.google.mlkit.vision.face.internal.c.class)).a(eVar);
    }
}
