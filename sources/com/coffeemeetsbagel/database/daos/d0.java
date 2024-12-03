package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.PriceEntity;
import java.util.List;
import qj.w;
import u6.j;

public abstract class d0 implements l<PriceEntity>, j {
    public w<List<PriceEntity>> a() {
        return g();
    }

    public int c(List<PriceEntity> list) {
        kotlin.jvm.internal.j.g(list, "prices");
        f();
        return s(list).size();
    }

    public abstract int f();

    public abstract w<List<PriceEntity>> g();
}
