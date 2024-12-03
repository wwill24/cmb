package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.PhotoEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import qj.h;
import u6.i;

public abstract class b0 implements l<PhotoEntity>, i {
    public int a(PhotoEntity photoEntity) {
        j.g(photoEntity, "entity");
        return e(photoEntity);
    }

    public int c(List<PhotoEntity> list) {
        j.g(list, "photoList");
        return k(list);
    }

    public int f(List<PhotoEntity> list) {
        j.g(list, "photos");
        return o(list);
    }

    public void g(PhotoEntity photoEntity, PhotoEntity photoEntity2) {
        j.g(photoEntity2, "new");
        if (photoEntity != null) {
            e(photoEntity);
        }
        q(photoEntity2);
    }

    public h<List<PhotoEntity>> i(String str) {
        j.g(str, "profileId");
        return n(str);
    }

    public abstract void j(String str, List<String> list);

    public abstract h<List<PhotoEntity>> n(String str);

    public int o(List<PhotoEntity> list) {
        PhotoEntity photoEntity;
        j.g(list, "data");
        List<Long> s10 = s(list);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (T next : s10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                q.s();
            }
            if (-1 == ((Number) next).longValue()) {
                photoEntity = list.get(i10);
            } else {
                photoEntity = null;
            }
            if (photoEntity != null) {
                arrayList.add(photoEntity);
            }
            i10 = i11;
        }
        return (list.size() - arrayList.size()) + k(arrayList);
    }

    public int t(Map<String, ? extends List<PhotoEntity>> map) {
        j.g(map, "photoMap");
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            List<PhotoEntity> list = (List) next.getValue();
            ArrayList arrayList = new ArrayList(r.t(list, 10));
            for (PhotoEntity url : list) {
                arrayList.add(url.getUrl());
            }
            j(str, arrayList);
        }
        return o(r.u(map.values()));
    }
}
