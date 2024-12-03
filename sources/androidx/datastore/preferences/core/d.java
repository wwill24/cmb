package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.i;
import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.b;
import androidx.datastore.preferences.core.a;
import androidx.datastore.preferences.d;
import androidx.datastore.preferences.e;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u001b\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u00078\u0006XD¢\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Landroidx/datastore/preferences/core/d;", "Landroidx/datastore/core/i;", "Landroidx/datastore/preferences/core/a;", "", "value", "Landroidx/datastore/preferences/PreferencesProto$Value;", "f", "", "name", "Landroidx/datastore/preferences/core/MutablePreferences;", "mutablePreferences", "", "c", "Ljava/io/InputStream;", "input", "b", "(Ljava/io/InputStream;Lkotlin/coroutines/c;)Ljava/lang/Object;", "t", "Ljava/io/OutputStream;", "output", "g", "(Landroidx/datastore/preferences/core/a;Ljava/io/OutputStream;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "fileExtension", "d", "()Landroidx/datastore/preferences/core/a;", "defaultValue", "<init>", "()V", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class d implements i<a> {

    /* renamed from: a  reason: collision with root package name */
    public static final d f5060a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final String f5061b = "preferences_pb";

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5062a;

        static {
            int[] iArr = new int[PreferencesProto$Value.ValueCase.values().length];
            iArr[PreferencesProto$Value.ValueCase.BOOLEAN.ordinal()] = 1;
            iArr[PreferencesProto$Value.ValueCase.FLOAT.ordinal()] = 2;
            iArr[PreferencesProto$Value.ValueCase.DOUBLE.ordinal()] = 3;
            iArr[PreferencesProto$Value.ValueCase.INTEGER.ordinal()] = 4;
            iArr[PreferencesProto$Value.ValueCase.LONG.ordinal()] = 5;
            iArr[PreferencesProto$Value.ValueCase.STRING.ordinal()] = 6;
            iArr[PreferencesProto$Value.ValueCase.STRING_SET.ordinal()] = 7;
            iArr[PreferencesProto$Value.ValueCase.VALUE_NOT_SET.ordinal()] = 8;
            f5062a = iArr;
        }
    }

    private d() {
    }

    private final void c(String str, PreferencesProto$Value preferencesProto$Value, MutablePreferences mutablePreferences) {
        int i10;
        PreferencesProto$Value.ValueCase S = preferencesProto$Value.S();
        if (S == null) {
            i10 = -1;
        } else {
            i10 = a.f5062a[S.ordinal()];
        }
        switch (i10) {
            case -1:
                throw new CorruptionException("Value case is null.", (Throwable) null, 2, (DefaultConstructorMarker) null);
            case 1:
                mutablePreferences.j(c.a(str), Boolean.valueOf(preferencesProto$Value.K()));
                return;
            case 2:
                mutablePreferences.j(c.c(str), Float.valueOf(preferencesProto$Value.N()));
                return;
            case 3:
                mutablePreferences.j(c.b(str), Double.valueOf(preferencesProto$Value.M()));
                return;
            case 4:
                mutablePreferences.j(c.d(str), Integer.valueOf(preferencesProto$Value.O()));
                return;
            case 5:
                mutablePreferences.j(c.e(str), Long.valueOf(preferencesProto$Value.P()));
                return;
            case 6:
                a.C0051a<String> f10 = c.f(str);
                String Q = preferencesProto$Value.Q();
                j.f(Q, "value.string");
                mutablePreferences.j(f10, Q);
                return;
            case 7:
                a.C0051a<Set<String>> g10 = c.g(str);
                List<String> H = preferencesProto$Value.R().H();
                j.f(H, "value.stringSet.stringsList");
                mutablePreferences.j(g10, CollectionsKt___CollectionsKt.B0(H));
                return;
            case 8:
                throw new CorruptionException("Value not set.", (Throwable) null, 2, (DefaultConstructorMarker) null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final PreferencesProto$Value f(Object obj) {
        if (obj instanceof Boolean) {
            GeneratedMessageLite i10 = PreferencesProto$Value.T().s(((Boolean) obj).booleanValue()).build();
            j.f(i10, "newBuilder().setBoolean(value).build()");
            return (PreferencesProto$Value) i10;
        } else if (obj instanceof Float) {
            GeneratedMessageLite i11 = PreferencesProto$Value.T().u(((Number) obj).floatValue()).build();
            j.f(i11, "newBuilder().setFloat(value).build()");
            return (PreferencesProto$Value) i11;
        } else if (obj instanceof Double) {
            GeneratedMessageLite i12 = PreferencesProto$Value.T().t(((Number) obj).doubleValue()).build();
            j.f(i12, "newBuilder().setDouble(value).build()");
            return (PreferencesProto$Value) i12;
        } else if (obj instanceof Integer) {
            GeneratedMessageLite i13 = PreferencesProto$Value.T().v(((Number) obj).intValue()).build();
            j.f(i13, "newBuilder().setInteger(value).build()");
            return (PreferencesProto$Value) i13;
        } else if (obj instanceof Long) {
            GeneratedMessageLite i14 = PreferencesProto$Value.T().w(((Number) obj).longValue()).build();
            j.f(i14, "newBuilder().setLong(value).build()");
            return (PreferencesProto$Value) i14;
        } else if (obj instanceof String) {
            GeneratedMessageLite i15 = PreferencesProto$Value.T().x((String) obj).build();
            j.f(i15, "newBuilder().setString(value).build()");
            return (PreferencesProto$Value) i15;
        } else if (obj instanceof Set) {
            GeneratedMessageLite i16 = PreferencesProto$Value.T().y(e.I().s((Set) obj)).build();
            j.f(i16, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
            return (PreferencesProto$Value) i16;
        } else {
            throw new IllegalStateException(j.p("PreferencesSerializer does not support type: ", obj.getClass().getName()));
        }
    }

    public Object b(InputStream inputStream, c<? super a> cVar) throws IOException, CorruptionException {
        androidx.datastore.preferences.d a10 = b.f5050a.a(inputStream);
        MutablePreferences b10 = b.b(new a.b[0]);
        Map<String, PreferencesProto$Value> F = a10.F();
        j.f(F, "preferencesProto.preferencesMap");
        for (Map.Entry next : F.entrySet()) {
            String str = (String) next.getKey();
            PreferencesProto$Value preferencesProto$Value = (PreferencesProto$Value) next.getValue();
            d dVar = f5060a;
            j.f(str, "name");
            j.f(preferencesProto$Value, "value");
            dVar.c(str, preferencesProto$Value, b10);
        }
        return b10.d();
    }

    /* renamed from: d */
    public a getDefaultValue() {
        return b.a();
    }

    public final String e() {
        return f5061b;
    }

    /* renamed from: g */
    public Object a(a aVar, OutputStream outputStream, c<? super Unit> cVar) throws IOException, CorruptionException {
        Map<a.C0051a<?>, Object> a10 = aVar.a();
        d.a I = androidx.datastore.preferences.d.I();
        for (Map.Entry next : a10.entrySet()) {
            I.s(((a.C0051a) next.getKey()).a(), f(next.getValue()));
        }
        ((androidx.datastore.preferences.d) I.build()).h(outputStream);
        return Unit.f32013a;
    }
}
