package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class i implements DynamiteModule.a {
    i() {
    }

    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.C0484a aVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        bVar.f39226a = aVar.b(context, str);
        int a10 = aVar.a(context, str, true);
        bVar.f39227b = a10;
        int i10 = bVar.f39226a;
        if (i10 == 0) {
            if (a10 == 0) {
                bVar.f39228c = 0;
                return bVar;
            }
            i10 = 0;
        }
        if (a10 >= i10) {
            bVar.f39228c = 1;
        } else {
            bVar.f39228c = -1;
        }
        return bVar;
    }
}
