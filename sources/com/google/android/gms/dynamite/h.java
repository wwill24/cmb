package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class h implements DynamiteModule.a {
    h() {
    }

    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.C0484a aVar) throws DynamiteModule.LoadingException {
        int i10;
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int b10 = aVar.b(context, str);
        bVar.f39226a = b10;
        int i11 = 0;
        if (b10 != 0) {
            i10 = aVar.a(context, str, false);
            bVar.f39227b = i10;
        } else {
            i10 = aVar.a(context, str, true);
            bVar.f39227b = i10;
        }
        int i12 = bVar.f39226a;
        if (i12 != 0) {
            i11 = i12;
        } else if (i10 == 0) {
            bVar.f39228c = 0;
            return bVar;
        }
        if (i11 >= i10) {
            bVar.f39228c = -1;
        } else {
            bVar.f39228c = 1;
        }
        return bVar;
    }
}
