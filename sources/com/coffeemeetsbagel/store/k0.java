package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import java.util.Map;
import qj.q;

public interface k0 {

    public interface a {
        void onFailure();

        void onSuccess();
    }

    public interface b<T, E extends Throwable> {
        void a(E e10);

        void b(T t10);
    }

    @Deprecated
    <T> void buyCmbItem(PurchaseType purchaseType, long j10, int i10, b<T, Throwable> bVar, Class cls, String str, String str2);

    <T, E extends Throwable> void buyCmbItem(j0<T> j0Var, b<T, E> bVar, boolean z10);

    Price getPrice(PurchaseType purchaseType);

    q<Map<String, Price>> priceCache();

    void refreshPricesFromApi(a aVar);
}
