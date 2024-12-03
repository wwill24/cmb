package org.apache.commons.collections.list;

import java.util.List;
import org.apache.commons.collections.Factory;

public class LazyList extends AbstractSerializableListDecorator {
    private static final long serialVersionUID = -1708388017160694542L;
    protected final Factory factory;

    protected LazyList(List list, Factory factory2) {
        super(list);
        if (factory2 != null) {
            this.factory = factory2;
            return;
        }
        throw new IllegalArgumentException("Factory must not be null");
    }

    public static List decorate(List list, Factory factory2) {
        return new LazyList(list, factory2);
    }

    public Object get(int i10) {
        int size = getList().size();
        if (i10 < size) {
            Object obj = getList().get(i10);
            if (obj != null) {
                return obj;
            }
            Object create = this.factory.create();
            getList().set(i10, create);
            return create;
        }
        while (size < i10) {
            getList().add((Object) null);
            size++;
        }
        Object create2 = this.factory.create();
        getList().add(create2);
        return create2;
    }

    public List subList(int i10, int i11) {
        return new LazyList(getList().subList(i10, i11), this.factory);
    }
}
