package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.a;
import com.google.protobuf.a.C0250a;
import com.google.protobuf.l0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0250a<MessageType, BuilderType>> implements l0 {
    protected int memoizedHashCode = 0;

    /* renamed from: com.google.protobuf.a$a  reason: collision with other inner class name */
    public static abstract class C0250a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0250a<MessageType, BuilderType>> implements l0.a {
        @Deprecated
        protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll(iterable, (List) collection);
        }

        private static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list) {
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

        private String getReadingExceptionMessage(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static UninitializedMessageException newUninitializedMessageException(l0 l0Var) {
            return new UninitializedMessageException(l0Var);
        }

        public abstract BuilderType clone();

        /* access modifiers changed from: protected */
        public abstract BuilderType internalMergeFrom(MessageType messagetype);

        public boolean mergeDelimitedFrom(InputStream inputStream, n nVar) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new C0251a(inputStream, h.y(read, inputStream)), nVar);
            return true;
        }

        public abstract BuilderType mergeFrom(h hVar, n nVar) throws IOException;

        protected static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            w.a(iterable);
            if (iterable instanceof b0) {
                List<?> e10 = ((b0) iterable).e();
                b0 b0Var = (b0) list;
                int size = list.size();
                for (Object next : e10) {
                    if (next == null) {
                        String str = "Element at index " + (b0Var.size() - size) + " is null.";
                        for (int size2 = b0Var.size() - 1; size2 >= size; size2--) {
                            b0Var.remove(size2);
                        }
                        throw new NullPointerException(str);
                    } else if (next instanceof ByteString) {
                        b0Var.I((ByteString) next);
                    } else {
                        b0Var.add((String) next);
                    }
                }
            } else if (iterable instanceof u0) {
                list.addAll((Collection) iterable);
            } else {
                addAllCheckingNulls(iterable, list);
            }
        }

        /* renamed from: com.google.protobuf.a$a$a  reason: collision with other inner class name */
        static final class C0251a extends FilterInputStream {

            /* renamed from: a  reason: collision with root package name */
            private int f21738a;

            C0251a(InputStream inputStream, int i10) {
                super(inputStream);
                this.f21738a = i10;
            }

            public int available() throws IOException {
                return Math.min(super.available(), this.f21738a);
            }

            public int read() throws IOException {
                if (this.f21738a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f21738a--;
                }
                return read;
            }

            public long skip(long j10) throws IOException {
                int skip = (int) super.skip(Math.min(j10, (long) this.f21738a));
                if (skip >= 0) {
                    this.f21738a -= skip;
                }
                return (long) skip;
            }

            public int read(byte[] bArr, int i10, int i11) throws IOException {
                int i12 = this.f21738a;
                if (i12 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i10, Math.min(i11, i12));
                if (read >= 0) {
                    this.f21738a -= read;
                }
                return read;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return mergeDelimitedFrom(inputStream, n.b());
        }

        public BuilderType mergeFrom(h hVar) throws IOException {
            return mergeFrom(hVar, n.b());
        }

        public BuilderType mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                h D = byteString.D();
                mergeFrom(D);
                D.a(0);
                return this;
            } catch (InvalidProtocolBufferException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e11);
            }
        }

        public BuilderType mergeFrom(ByteString byteString, n nVar) throws InvalidProtocolBufferException {
            try {
                h D = byteString.D();
                mergeFrom(D, nVar);
                D.a(0);
                return this;
            } catch (InvalidProtocolBufferException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e11);
            }
        }

        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, 0, bArr.length);
        }

        public BuilderType mergeFrom(byte[] bArr, int i10, int i11) throws InvalidProtocolBufferException {
            try {
                h l10 = h.l(bArr, i10, i11);
                mergeFrom(l10);
                l10.a(0);
                return this;
            } catch (InvalidProtocolBufferException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e11);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, n nVar) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, 0, bArr.length, nVar);
        }

        public BuilderType mergeFrom(byte[] bArr, int i10, int i11, n nVar) throws InvalidProtocolBufferException {
            try {
                h l10 = h.l(bArr, i10, i11);
                mergeFrom(l10, nVar);
                l10.a(0);
                return this;
            } catch (InvalidProtocolBufferException e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e11);
            }
        }

        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            h f10 = h.f(inputStream);
            mergeFrom(f10);
            f10.a(0);
            return this;
        }

        public BuilderType mergeFrom(InputStream inputStream, n nVar) throws IOException {
            h f10 = h.f(inputStream);
            mergeFrom(f10, nVar);
            f10.a(0);
            return this;
        }

        public BuilderType mergeFrom(l0 l0Var) {
            if (getDefaultInstanceForType().getClass().isInstance(l0Var)) {
                return internalMergeFrom((a) l0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    @Deprecated
    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        C0250a.addAll(iterable, (List) collection);
    }

    protected static void checkByteStringIsUtf8(ByteString byteString) throws IllegalArgumentException {
        if (!byteString.A()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    /* access modifiers changed from: package-private */
    public int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSize(z0 z0Var) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int d10 = z0Var.d(this);
        setMemoizedSerializedSize(d10);
        return d10;
    }

    /* access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    /* access modifiers changed from: package-private */
    public void setMemoizedSerializedSize(int i10) {
        throw new UnsupportedOperationException();
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream g02 = CodedOutputStream.g0(bArr);
            writeTo(g02);
            g02.d();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e10);
        }
    }

    public ByteString toByteString() {
        try {
            ByteString.g C = ByteString.C(getSerializedSize());
            writeTo(C.b());
            return C.a();
        } catch (IOException e10) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e10);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream f02 = CodedOutputStream.f0(outputStream, CodedOutputStream.J(CodedOutputStream.X(serializedSize) + serializedSize));
        f02.Y0(serializedSize);
        writeTo(f02);
        f02.c0();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream f02 = CodedOutputStream.f0(outputStream, CodedOutputStream.J(getSerializedSize()));
        writeTo(f02);
        f02.c0();
    }

    protected static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        C0250a.addAll(iterable, list);
    }
}
