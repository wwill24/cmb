package coil.memory;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import coil.util.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import o2.d;
import o2.e;
import o2.f;
import o2.g;
import o2.h;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\f\r\u000eJ\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H¦\u0002J\b\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\u000f"}, d2 = {"Lcoil/memory/MemoryCache;", "", "Lcoil/memory/MemoryCache$Key;", "key", "Lcoil/memory/MemoryCache$b;", "c", "value", "", "d", "clear", "", "level", "a", "Key", "b", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public interface MemoryCache {

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcoil/memory/MemoryCache$a;", "", "Lcoil/memory/MemoryCache;", "a", "Landroid/content/Context;", "Landroid/content/Context;", "context", "", "b", "D", "maxSizePercent", "", "c", "I", "maxSizeBytes", "", "d", "Z", "strongReferencesEnabled", "e", "weakReferencesEnabled", "<init>", "(Landroid/content/Context;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f8223a;

        /* renamed from: b  reason: collision with root package name */
        private double f8224b;

        /* renamed from: c  reason: collision with root package name */
        private int f8225c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8226d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8227e = true;

        public a(Context context) {
            this.f8223a = context;
            this.f8224b = j.e(context);
        }

        public final MemoryCache a() {
            h hVar;
            g gVar;
            int i10;
            if (this.f8227e) {
                hVar = new f();
            } else {
                hVar = new o2.b();
            }
            if (this.f8226d) {
                double d10 = this.f8224b;
                if (d10 > 0.0d) {
                    i10 = j.c(this.f8223a, d10);
                } else {
                    i10 = this.f8225c;
                }
                if (i10 > 0) {
                    gVar = new e(i10, hVar);
                } else {
                    gVar = new o2.a(hVar);
                }
            } else {
                gVar = new o2.a(hVar);
            }
            return new d(gVar, hVar);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcoil/memory/MemoryCache$b;", "", "other", "", "equals", "", "hashCode", "", "toString", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "bitmap", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "extras", "<init>", "(Landroid/graphics/Bitmap;Ljava/util/Map;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f8228a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, Object> f8229b;

        public b(Bitmap bitmap, Map<String, ? extends Object> map) {
            this.f8228a = bitmap;
            this.f8229b = map;
        }

        public final Bitmap a() {
            return this.f8228a;
        }

        public final Map<String, Object> b() {
            return this.f8229b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (!kotlin.jvm.internal.j.b(this.f8228a, bVar.f8228a) || !kotlin.jvm.internal.j.b(this.f8229b, bVar.f8229b)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f8228a.hashCode() * 31) + this.f8229b.hashCode();
        }

        public String toString() {
            return "Value(bitmap=" + this.f8228a + ", extras=" + this.f8229b + PropertyUtils.MAPPED_DELIM2;
        }
    }

    void a(int i10);

    b c(Key key);

    void clear();

    void d(Key key, b bVar);

    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0017B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcoil/memory/MemoryCache$Key;", "Landroid/os/Parcelable;", "", "key", "", "extras", "a", "", "other", "", "equals", "", "hashCode", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "b", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "c", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class Key implements Parcelable {
        @Deprecated
        public static final Parcelable.Creator<Key> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        private static final b f8220c = new b((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final String f8221a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, String> f8222b;

        @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"coil/memory/MemoryCache$Key$a", "Landroid/os/Parcelable$Creator;", "Lcoil/memory/MemoryCache$Key;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcoil/memory/MemoryCache$Key;", "coil-base_release"}, k = 1, mv = {1, 7, 1})
        public static final class a implements Parcelable.Creator<Key> {
            a() {
            }

            /* renamed from: a */
            public Key createFromParcel(Parcel parcel) {
                String readString = parcel.readString();
                kotlin.jvm.internal.j.d(readString);
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                for (int i10 = 0; i10 < readInt; i10++) {
                    String readString2 = parcel.readString();
                    kotlin.jvm.internal.j.d(readString2);
                    String readString3 = parcel.readString();
                    kotlin.jvm.internal.j.d(readString3);
                    linkedHashMap.put(readString2, readString3);
                }
                return new Key(readString, linkedHashMap);
            }

            /* renamed from: b */
            public Key[] newArray(int i10) {
                return new Key[i10];
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcoil/memory/MemoryCache$Key$b;", "", "Landroid/os/Parcelable$Creator;", "Lcoil/memory/MemoryCache$Key;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
        private static final class b {
            private b() {
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Key(String str, Map<String, String> map) {
            this.f8221a = str;
            this.f8222b = map;
        }

        public static /* synthetic */ Key c(Key key, String str, Map<String, String> map, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = key.f8221a;
            }
            if ((i10 & 2) != 0) {
                map = key.f8222b;
            }
            return key.a(str, map);
        }

        public final Key a(String str, Map<String, String> map) {
            return new Key(str, map);
        }

        public final Map<String, String> d() {
            return this.f8222b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Key) {
                Key key = (Key) obj;
                if (!kotlin.jvm.internal.j.b(this.f8221a, key.f8221a) || !kotlin.jvm.internal.j.b(this.f8222b, key.f8222b)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f8221a.hashCode() * 31) + this.f8222b.hashCode();
        }

        public String toString() {
            return "Key(key=" + this.f8221a + ", extras=" + this.f8222b + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f8221a);
            parcel.writeInt(this.f8222b.size());
            for (Map.Entry next : this.f8222b.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Key(String str, Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i10 & 2) != 0 ? h0.i() : map);
        }
    }
}
