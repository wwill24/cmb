package kotlin.collections;

import java.lang.reflect.Array;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

class i {
    public static final <T> T[] a(T[] tArr, int i10) {
        j.g(tArr, ReferenceElement.ELEMENT);
        Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i10);
        j.e(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) newInstance;
    }

    public static final void b(int i10, int i11) {
        if (i10 > i11) {
            throw new IndexOutOfBoundsException("toIndex (" + i10 + ") is greater than size (" + i11 + ").");
        }
    }
}
