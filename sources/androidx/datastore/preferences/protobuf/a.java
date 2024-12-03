package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.a.C0052a;
import androidx.datastore.preferences.protobuf.k0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0052a<MessageType, BuilderType>> implements k0 {
    protected int memoizedHashCode = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.a$a  reason: collision with other inner class name */
    public static abstract class C0052a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0052a<MessageType, BuilderType>> implements k0.a {
        protected static <T> void b(Iterable<T> iterable, List<? super T> list) {
            w.a(iterable);
            if (iterable instanceof a0) {
                List<?> e10 = ((a0) iterable).e();
                a0 a0Var = (a0) list;
                int size = list.size();
                for (Object next : e10) {
                    if (next == null) {
                        String str = "Element at index " + (a0Var.size() - size) + " is null.";
                        for (int size2 = a0Var.size() - 1; size2 >= size; size2--) {
                            a0Var.remove(size2);
                        }
                        throw new NullPointerException(str);
                    } else if (next instanceof ByteString) {
                        a0Var.b1((ByteString) next);
                    } else {
                        a0Var.add((String) next);
                    }
                }
            } else if (iterable instanceof t0) {
                list.addAll((Collection) iterable);
            } else {
                c(iterable, list);
            }
        }

        private static <T> void c(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T next : iterable) {
                if (next == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(next);
            }
        }

        protected static UninitializedMessageException h(k0 k0Var) {
            return new UninitializedMessageException(k0Var);
        }

        /* access modifiers changed from: protected */
        public abstract BuilderType d(MessageType messagetype);

        /* renamed from: e */
        public BuilderType n(k0 k0Var) {
            if (getDefaultInstanceForType().getClass().isInstance(k0Var)) {
                return d((a) k0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    protected static <T> void b(Iterable<T> iterable, List<? super T> list) {
        C0052a.b(iterable, list);
    }

    private String e(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    /* access modifiers changed from: package-private */
    public int c() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int d(y0 y0Var) {
        int c10 = c();
        if (c10 != -1) {
            return c10;
        }
        int d10 = y0Var.d(this);
        g(d10);
        return d10;
    }

    /* access modifiers changed from: package-private */
    public UninitializedMessageException f() {
        return new UninitializedMessageException(this);
    }

    /* access modifiers changed from: package-private */
    public void g(int i10) {
        throw new UnsupportedOperationException();
    }

    public void h(OutputStream outputStream) throws IOException {
        CodedOutputStream f02 = CodedOutputStream.f0(outputStream, CodedOutputStream.I(getSerializedSize()));
        a(f02);
        f02.c0();
    }

    public ByteString toByteString() {
        try {
            ByteString.g r10 = ByteString.r(getSerializedSize());
            a(r10.b());
            return r10.a();
        } catch (IOException e10) {
            throw new RuntimeException(e("ByteString"), e10);
        }
    }
}
