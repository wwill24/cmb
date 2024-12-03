package androidx.datastore.preferences;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Landroidx/datastore/preferences/b;", "", "a", "datastore-preferences-proto"}, k = 1, mv = {1, 5, 1})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5050a = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Landroidx/datastore/preferences/b$a;", "", "Ljava/io/InputStream;", "input", "Landroidx/datastore/preferences/d;", "a", "<init>", "()V", "datastore-preferences-proto"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a(InputStream inputStream) {
            j.g(inputStream, "input");
            try {
                d J = d.J(inputStream);
                j.f(J, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
                return J;
            } catch (InvalidProtocolBufferException e10) {
                throw new CorruptionException("Unable to parse preferences proto.", e10);
            }
        }
    }
}
