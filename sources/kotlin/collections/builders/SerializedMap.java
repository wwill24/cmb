package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

final class SerializedMap implements Externalizable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32049a = new a((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SerializedMap(Map<?, ?> map2) {
        j.g(map2, "map");
        this.map = map2;
    }

    private final Object readResolve() {
        return this.map;
    }

    public void readExternal(ObjectInput objectInput) {
        j.g(objectInput, "input");
        byte readByte = objectInput.readByte();
        if (readByte == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                Map d10 = g0.d(readInt);
                for (int i10 = 0; i10 < readInt; i10++) {
                    d10.put(objectInput.readObject(), objectInput.readObject());
                }
                this.map = g0.b(d10);
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + readByte);
    }

    public void writeExternal(ObjectOutput objectOutput) {
        j.g(objectOutput, "output");
        objectOutput.writeByte(0);
        objectOutput.writeInt(this.map.size());
        for (Map.Entry next : this.map.entrySet()) {
            objectOutput.writeObject(next.getKey());
            objectOutput.writeObject(next.getValue());
        }
    }

    public SerializedMap() {
        this(h0.i());
    }
}
