package androidx.security.crypto;

import ag.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArraySet;
import android.util.Pair;
import androidx.annotation.NonNull;
import bg.f;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.d;
import eg.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class EncryptedSharedPreferences implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f6984a;

    /* renamed from: b  reason: collision with root package name */
    final List<SharedPreferences.OnSharedPreferenceChangeListener> f6985b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final String f6986c;

    /* renamed from: d  reason: collision with root package name */
    final String f6987d;

    /* renamed from: e  reason: collision with root package name */
    final ag.a f6988e;

    /* renamed from: f  reason: collision with root package name */
    final c f6989f;

    private enum EncryptedType {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);
        
        private final int mId;

        private EncryptedType(int i10) {
            this.mId = i10;
        }

        public static EncryptedType a(int i10) {
            if (i10 == 0) {
                return STRING;
            }
            if (i10 == 1) {
                return STRING_SET;
            }
            if (i10 == 2) {
                return INT;
            }
            if (i10 == 3) {
                return LONG;
            }
            if (i10 == 4) {
                return FLOAT;
            }
            if (i10 != 5) {
                return null;
            }
            return BOOLEAN;
        }

        public int b() {
            return this.mId;
        }
    }

    public enum PrefKeyEncryptionScheme {
        AES256_SIV(dg.a.j());
        
        private final KeyTemplate mDeterministicAeadKeyTemplate;

        private PrefKeyEncryptionScheme(KeyTemplate keyTemplate) {
            this.mDeterministicAeadKeyTemplate = keyTemplate;
        }

        /* access modifiers changed from: package-private */
        public KeyTemplate a() {
            return this.mDeterministicAeadKeyTemplate;
        }
    }

    public enum PrefValueEncryptionScheme {
        AES256_GCM(f.j());
        
        private final KeyTemplate mAeadKeyTemplate;

        private PrefValueEncryptionScheme(KeyTemplate keyTemplate) {
            this.mAeadKeyTemplate = keyTemplate;
        }

        /* access modifiers changed from: package-private */
        public KeyTemplate a() {
            return this.mAeadKeyTemplate;
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7001a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType[] r0 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7001a = r0
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7001a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.INT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7001a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.LONG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7001a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7001a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7001a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.STRING_SET     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.security.crypto.EncryptedSharedPreferences.a.<clinit>():void");
        }
    }

    private static final class b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        private final EncryptedSharedPreferences f7002a;

        /* renamed from: b  reason: collision with root package name */
        private final SharedPreferences.Editor f7003b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f7004c;

        /* renamed from: d  reason: collision with root package name */
        private AtomicBoolean f7005d = new AtomicBoolean(false);

        b(EncryptedSharedPreferences encryptedSharedPreferences, SharedPreferences.Editor editor) {
            this.f7002a = encryptedSharedPreferences;
            this.f7003b = editor;
            this.f7004c = new CopyOnWriteArrayList();
        }

        private void a() {
            if (this.f7005d.getAndSet(false)) {
                for (String next : this.f7002a.getAll().keySet()) {
                    if (!this.f7004c.contains(next) && !this.f7002a.f(next)) {
                        this.f7003b.remove(this.f7002a.c(next));
                    }
                }
            }
        }

        private void b() {
            for (SharedPreferences.OnSharedPreferenceChangeListener next : this.f7002a.f6985b) {
                for (String onSharedPreferenceChanged : this.f7004c) {
                    next.onSharedPreferenceChanged(this.f7002a, onSharedPreferenceChanged);
                }
            }
        }

        private void c(String str, byte[] bArr) {
            if (!this.f7002a.f(str)) {
                this.f7004c.add(str);
                if (str == null) {
                    str = "__NULL__";
                }
                try {
                    Pair<String, String> d10 = this.f7002a.d(str, bArr);
                    this.f7003b.putString((String) d10.first, (String) d10.second);
                } catch (GeneralSecurityException e10) {
                    throw new SecurityException("Could not encrypt data: " + e10.getMessage(), e10);
                }
            } else {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
        }

        public void apply() {
            a();
            this.f7003b.apply();
            b();
            this.f7004c.clear();
        }

        @NonNull
        public SharedPreferences.Editor clear() {
            this.f7005d.set(true);
            return this;
        }

        public boolean commit() {
            a();
            try {
                return this.f7003b.commit();
            } finally {
                b();
                this.f7004c.clear();
            }
        }

        @NonNull
        public SharedPreferences.Editor putBoolean(String str, boolean z10) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(EncryptedType.BOOLEAN.b());
            allocate.put(z10 ? (byte) 1 : 0);
            c(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor putFloat(String str, float f10) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.FLOAT.b());
            allocate.putFloat(f10);
            c(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor putInt(String str, int i10) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.INT.b());
            allocate.putInt(i10);
            c(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor putLong(String str, long j10) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(EncryptedType.LONG.b());
            allocate.putLong(j10);
            c(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(EncryptedType.STRING.b());
            allocate.putInt(length);
            allocate.put(bytes);
            c(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new ArraySet<>();
                set.add("__NULL__");
            }
            ArrayList<byte[]> arrayList = new ArrayList<>(set.size());
            int size = set.size() * 4;
            for (String bytes : set) {
                byte[] bytes2 = bytes.getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes2);
                size += bytes2.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(size + 4);
            allocate.putInt(EncryptedType.STRING_SET.b());
            for (byte[] bArr : arrayList) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            c(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor remove(String str) {
            if (!this.f7002a.f(str)) {
                this.f7003b.remove(this.f7002a.c(str));
                this.f7004c.remove(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    EncryptedSharedPreferences(@NonNull String str, @NonNull String str2, @NonNull SharedPreferences sharedPreferences, @NonNull ag.a aVar, @NonNull c cVar) {
        this.f6986c = str;
        this.f6984a = sharedPreferences;
        this.f6987d = str2;
        this.f6988e = aVar;
        this.f6989f = cVar;
    }

    @NonNull
    public static SharedPreferences a(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull PrefKeyEncryptionScheme prefKeyEncryptionScheme, @NonNull PrefValueEncryptionScheme prefValueEncryptionScheme) throws GeneralSecurityException, IOException {
        dg.b.b();
        bg.a.b();
        a.b j10 = new a.b().h(prefKeyEncryptionScheme.a()).j(context, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str);
        d c10 = j10.i("android-keystore://" + str2).d().c();
        a.b j11 = new a.b().h(prefValueEncryptionScheme.a()).j(context, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str);
        ag.a aVar = (ag.a) j11.i("android-keystore://" + str2).d().c().h(ag.a.class);
        return new EncryptedSharedPreferences(str, str2, context.getSharedPreferences(str, 0), aVar, (c) c10.h(c.class));
    }

    private Object e(String str) {
        if (!f(str)) {
            if (str == null) {
                str = "__NULL__";
            }
            try {
                String c10 = c(str);
                String string = this.f6984a.getString(c10, (String) null);
                if (string == null) {
                    return null;
                }
                boolean z10 = false;
                ByteBuffer wrap = ByteBuffer.wrap(this.f6988e.b(ig.f.a(string, 0), c10.getBytes(StandardCharsets.UTF_8)));
                wrap.position(0);
                switch (a.f7001a[EncryptedType.a(wrap.getInt()).ordinal()]) {
                    case 1:
                        int i10 = wrap.getInt();
                        ByteBuffer slice = wrap.slice();
                        wrap.limit(i10);
                        String charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                        if (charBuffer.equals("__NULL__")) {
                            return null;
                        }
                        return charBuffer;
                    case 2:
                        return Integer.valueOf(wrap.getInt());
                    case 3:
                        return Long.valueOf(wrap.getLong());
                    case 4:
                        return Float.valueOf(wrap.getFloat());
                    case 5:
                        if (wrap.get() != 0) {
                            z10 = true;
                        }
                        return Boolean.valueOf(z10);
                    case 6:
                        ArraySet arraySet = new ArraySet();
                        while (wrap.hasRemaining()) {
                            int i11 = wrap.getInt();
                            ByteBuffer slice2 = wrap.slice();
                            slice2.limit(i11);
                            wrap.position(wrap.position() + i11);
                            arraySet.add(StandardCharsets.UTF_8.decode(slice2).toString());
                        }
                        if (arraySet.size() != 1 || !"__NULL__".equals(arraySet.valueAt(0))) {
                            return arraySet;
                        }
                        return null;
                    default:
                        return null;
                }
            } catch (GeneralSecurityException e10) {
                throw new SecurityException("Could not decrypt value. " + e10.getMessage(), e10);
            }
        } else {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    /* access modifiers changed from: package-private */
    public String b(String str) {
        try {
            String str2 = new String(this.f6989f.b(ig.f.a(str, 0), this.f6986c.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals("__NULL__")) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e10) {
            throw new SecurityException("Could not decrypt key. " + e10.getMessage(), e10);
        }
    }

    /* access modifiers changed from: package-private */
    public String c(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return ig.f.d(this.f6989f.a(str.getBytes(StandardCharsets.UTF_8), this.f6986c.getBytes()));
        } catch (GeneralSecurityException e10) {
            throw new SecurityException("Could not encrypt key. " + e10.getMessage(), e10);
        }
    }

    public boolean contains(String str) {
        if (!f(str)) {
            return this.f6984a.contains(c(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    /* access modifiers changed from: package-private */
    public Pair<String, String> d(String str, byte[] bArr) throws GeneralSecurityException {
        String c10 = c(str);
        return new Pair<>(c10, ig.f.d(this.f6988e.a(bArr, c10.getBytes(StandardCharsets.UTF_8))));
    }

    @NonNull
    public SharedPreferences.Editor edit() {
        return new b(this, this.f6984a.edit());
    }

    /* access modifiers changed from: package-private */
    public boolean f(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    @NonNull
    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f6984a.getAll().entrySet()) {
            if (!f((String) next.getKey())) {
                String b10 = b((String) next.getKey());
                hashMap.put(b10, e(b10));
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z10) {
        Object e10 = e(str);
        if (e10 == null || !(e10 instanceof Boolean)) {
            return z10;
        }
        return ((Boolean) e10).booleanValue();
    }

    public float getFloat(String str, float f10) {
        Object e10 = e(str);
        if (e10 == null || !(e10 instanceof Float)) {
            return f10;
        }
        return ((Float) e10).floatValue();
    }

    public int getInt(String str, int i10) {
        Object e10 = e(str);
        if (e10 == null || !(e10 instanceof Integer)) {
            return i10;
        }
        return ((Integer) e10).intValue();
    }

    public long getLong(String str, long j10) {
        Object e10 = e(str);
        if (e10 == null || !(e10 instanceof Long)) {
            return j10;
        }
        return ((Long) e10).longValue();
    }

    public String getString(String str, String str2) {
        Object e10 = e(str);
        if (e10 == null || !(e10 instanceof String)) {
            return str2;
        }
        return (String) e10;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        Object e10 = e(str);
        if (e10 instanceof Set) {
            set2 = (Set) e10;
        } else {
            set2 = new ArraySet<>();
        }
        if (set2.size() > 0) {
            return set2;
        }
        return set;
    }

    public void registerOnSharedPreferenceChangeListener(@NonNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f6985b.add(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(@NonNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f6985b.remove(onSharedPreferenceChangeListener);
    }
}
