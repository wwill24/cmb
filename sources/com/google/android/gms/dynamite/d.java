package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class d implements DynamiteModule.a {
    d() {
    }

    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.C0484a aVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int a10 = aVar.a(context, str, true);
        bVar.f39227b = a10;
        if (a10 != 0) {
            bVar.f39228c = 1;
        } else {
            int b10 = aVar.b(context, str);
            bVar.f39226a = b10;
            if (b10 != 0) {
                bVar.f39228c = -1;
            }
        }
        return bVar;
    }
}
