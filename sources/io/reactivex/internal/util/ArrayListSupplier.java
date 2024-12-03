package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import vj.j;

public enum ArrayListSupplier implements Callable<List<Object>>, j<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> b() {
        return INSTANCE;
    }

    /* renamed from: a */
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    /* renamed from: c */
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
