package org.apache.commons.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GrowthList extends AbstractSerializableListDecorator {
    private static final long serialVersionUID = -3620001881672L;

    public GrowthList() {
        super(new ArrayList());
    }

    public static List decorate(List list) {
        return new GrowthList(list);
    }

    public void add(int i10, Object obj) {
        int size = getList().size();
        if (i10 > size) {
            getList().addAll(Collections.nCopies(i10 - size, (Object) null));
        }
        getList().add(i10, obj);
    }

    public boolean addAll(int i10, Collection collection) {
        boolean z10;
        int size = getList().size();
        if (i10 > size) {
            getList().addAll(Collections.nCopies(i10 - size, (Object) null));
            z10 = true;
        } else {
            z10 = false;
        }
        return getList().addAll(i10, collection) | z10;
    }

    public Object set(int i10, Object obj) {
        int size = getList().size();
        if (i10 >= size) {
            getList().addAll(Collections.nCopies((i10 - size) + 1, (Object) null));
        }
        return getList().set(i10, obj);
    }

    public GrowthList(int i10) {
        super(new ArrayList(i10));
    }

    protected GrowthList(List list) {
        super(list);
    }
}
