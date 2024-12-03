package kj;

import androidx.annotation.NonNull;
import ij.q;
import ij.s;
import io.noties.markwon.core.CoreProps;
import lj.b;
import lj.h;

public class g implements s {
    public Object a(@NonNull ij.g gVar, @NonNull q qVar) {
        if (CoreProps.ListItemType.BULLET == CoreProps.f30053a.c(qVar)) {
            return new b(gVar.e(), CoreProps.f30054b.c(qVar).intValue());
        }
        return new h(gVar.e(), String.valueOf(CoreProps.f30055c.c(qVar)) + "." + 160);
    }
}
