package y;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.d0;
import androidx.camera.core.o1;
import x.c;

public class a {
    public boolean a() {
        c cVar = (c) x.a.a(c.class);
        if (cVar == null || cVar.d(d0.f2485h)) {
            return true;
        }
        return false;
    }

    public boolean b(@NonNull o1 o1Var) {
        return a() && o1Var.getFormat() == 256;
    }
}
