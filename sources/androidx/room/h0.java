package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\b\b\u0000\u0010\u0002*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007J8\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\b\b\u0000\u0010\u0002*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0013"}, d2 = {"Landroidx/room/h0;", "", "T", "C", "Ljava/lang/Class;", "klass", "", "suffix", "b", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroid/content/Context;", "context", "Landroidx/room/RoomDatabase$a;", "c", "name", "a", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final h0 f6855a = new h0();

    private h0() {
    }

    public static final <T extends RoomDatabase> RoomDatabase.a<T> a(Context context, Class<T> cls, String str) {
        boolean z10;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(cls, "klass");
        if (str == null || r.w(str)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (true ^ z10) {
            return new RoomDatabase.a<>(context, cls, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    }

    public static final <T, C> T b(Class<C> cls, String str) {
        boolean z10;
        String str2;
        j.g(cls, "klass");
        j.g(str, "suffix");
        Package packageR = cls.getPackage();
        j.d(packageR);
        String name = packageR.getName();
        String canonicalName = cls.getCanonicalName();
        j.d(canonicalName);
        j.f(name, "fullPackage");
        boolean z11 = false;
        if (name.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            canonicalName = canonicalName.substring(name.length() + 1);
            j.f(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str3 = canonicalName;
        String str4 = r.C(str3, '.', '_', false, 4, (Object) null) + str;
        try {
            if (name.length() == 0) {
                z11 = true;
            }
            if (z11) {
                str2 = str4;
            } else {
                str2 = name + '.' + str4;
            }
            Class<?> cls2 = Class.forName(str2, true, cls.getClassLoader());
            j.e(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return cls2.newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + str4 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + cls + ".canonicalName");
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls + ".canonicalName");
        }
    }

    public static final <T extends RoomDatabase> RoomDatabase.a<T> c(Context context, Class<T> cls) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(cls, "klass");
        return new RoomDatabase.a<>(context, cls, (String) null);
    }
}
