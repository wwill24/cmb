package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class SerializedCollection implements Externalizable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32048a = new a((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 0;
    private Collection<?> collection;
    private final int tag;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SerializedCollection(Collection<?> collection2, int i10) {
        j.g(collection2, "collection");
        this.collection = collection2;
        this.tag = i10;
    }

    private final Object readResolve() {
        return this.collection;
    }

    public void readExternal(ObjectInput objectInput) {
        Collection<?> collection2;
        j.g(objectInput, "input");
        byte readByte = objectInput.readByte();
        byte b10 = readByte & 1;
        if ((readByte & -2) == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                int i10 = 0;
                if (b10 == 0) {
                    List d10 = p.d(readInt);
                    while (i10 < readInt) {
                        d10.add(objectInput.readObject());
                        i10++;
                    }
                    collection2 = p.a(d10);
                } else if (b10 == 1) {
                    Set c10 = m0.c(readInt);
                    while (i10 < readInt) {
                        c10.add(objectInput.readObject());
                        i10++;
                    }
                    collection2 = m0.a(c10);
                } else {
                    throw new InvalidObjectException("Unsupported collection type tag: " + b10 + '.');
                }
                this.collection = collection2;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + readByte + '.');
    }

    public void writeExternal(ObjectOutput objectOutput) {
        j.g(objectOutput, "output");
        objectOutput.writeByte(this.tag);
        objectOutput.writeInt(this.collection.size());
        for (Object writeObject : this.collection) {
            objectOutput.writeObject(writeObject);
        }
    }

    public SerializedCollection() {
        this(q.j(), 0);
    }
}
