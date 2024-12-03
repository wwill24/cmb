package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text_common.zzks;
import com.google.android.gms.internal.mlkit_vision_text_common.zzkt;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmo;
import com.google.android.gms.internal.mlkit_vision_text_common.zzog;
import eh.d;

public final class a {
    static zzmo a(int i10) {
        if (i10 == 1) {
            return zzmo.LATIN;
        }
        if (i10 == 2) {
            return zzmo.LATIN_AND_CHINESE;
        }
        if (i10 == 3) {
            return zzmo.LATIN_AND_DEVANAGARI;
        }
        if (i10 == 4) {
            return zzmo.LATIN_AND_JAPANESE;
        }
        if (i10 != 5) {
            return zzmo.TYPE_UNKNOWN;
        }
        return zzmo.LATIN_AND_KOREAN;
    }

    static void b(zzog zzog, boolean z10, zzks zzks) {
        zzog.zzf(new d(z10, zzks), zzkt.ON_DEVICE_TEXT_LOAD);
    }
}
