package com.facebook.appevents.ml;

import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import kotlin.text.d;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/ml/Utils;", "", "()V", "DIR_NAME", "", "getMlDir", "Ljava/io/File;", "normalizeString", "str", "parseModelWeights", "", "Lcom/facebook/appevents/ml/MTensor;", "file", "vectorize", "", "texts", "maxLen", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Utils {
    private static final String DIR_NAME = "facebook_ml/";
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public static final File getMlDir() {
        Class<Utils> cls = Utils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), DIR_NAME);
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final Map<String, MTensor> parseModelWeights(File file) {
        Map<String, MTensor> map;
        File file2 = file;
        Class<Utils> cls = Utils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(file2, "file");
            try {
                FileInputStream fileInputStream = new FileInputStream(file2);
                int available = fileInputStream.available();
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                byte[] bArr = new byte[available];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                if (available < 4) {
                    return null;
                }
                int i10 = 0;
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                int i11 = wrap.getInt();
                int i12 = i11 + 4;
                if (available < i12) {
                    return null;
                }
                b bVar = new b(new String(bArr, 4, i11, d.f32216b));
                a names = bVar.names();
                int o10 = names.o();
                String[] strArr = new String[o10];
                int i13 = o10 - 1;
                if (i13 >= 0) {
                    int i14 = 0;
                    while (true) {
                        int i15 = i14 + 1;
                        strArr[i14] = names.n(i14);
                        if (i15 > i13) {
                            break;
                        }
                        i14 = i15;
                    }
                }
                k.o(strArr);
                HashMap hashMap = new HashMap();
                int i16 = 0;
                while (i16 < o10) {
                    String str = strArr[i16];
                    i16++;
                    if (str != null) {
                        a jSONArray = bVar.getJSONArray(str);
                        int o11 = jSONArray.o();
                        int[] iArr = new int[o11];
                        int i17 = o11 - 1;
                        int i18 = 1;
                        if (i17 >= 0) {
                            while (true) {
                                int i19 = i10 + 1;
                                try {
                                    int i20 = jSONArray.getInt(i10);
                                    iArr[i10] = i20;
                                    i18 *= i20;
                                    if (i19 > i17) {
                                        break;
                                    }
                                    i10 = i19;
                                } catch (Exception unused) {
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    map = null;
                                    CrashShieldHandler.handleThrowable(th, cls);
                                    return map;
                                }
                            }
                        }
                        int i21 = i18 * 4;
                        int i22 = i12 + i21;
                        if (i22 > available) {
                            return null;
                        }
                        ByteBuffer wrap2 = ByteBuffer.wrap(bArr, i12, i21);
                        wrap2.order(ByteOrder.LITTLE_ENDIAN);
                        MTensor mTensor = new MTensor(iArr);
                        wrap2.asFloatBuffer().get(mTensor.getData(), 0, i18);
                        hashMap.put(str, mTensor);
                        i12 = i22;
                        i10 = 0;
                    }
                }
                return hashMap;
            } catch (Exception unused2) {
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            map = null;
            CrashShieldHandler.handleThrowable(th, cls);
            return map;
        }
    }

    public final String normalizeString(String str) {
        int i10;
        boolean z10;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            j.g(str, "str");
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (true) {
                if (i11 > length) {
                    break;
                }
                if (!z11) {
                    i10 = i11;
                } else {
                    i10 = length;
                }
                if (j.i(str.charAt(i10), 32) <= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z11) {
                    if (!z10) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z10) {
                    break;
                } else {
                    length--;
                }
            }
            Object[] array2 = new Regex("\\s+").h(str.subSequence(i11, length + 1).toString(), 0).toArray(new String[0]);
            if (array2 != null) {
                String join = TextUtils.join(" ", (String[]) array2);
                j.f(join, "join(\" \", strArray)");
                return join;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final int[] vectorize(String str, int i10) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            j.g(str, "texts");
            int[] iArr = new int[i10];
            String normalizeString = normalizeString(str);
            Charset forName = Charset.forName("UTF-8");
            j.f(forName, "forName(\"UTF-8\")");
            if (normalizeString != null) {
                byte[] bytes = normalizeString.getBytes(forName);
                j.f(bytes, "(this as java.lang.String).getBytes(charset)");
                if (i10 > 0) {
                    int i11 = 0;
                    while (true) {
                        int i12 = i11 + 1;
                        if (i11 < bytes.length) {
                            iArr[i11] = bytes[i11] & 255;
                        } else {
                            iArr[i11] = 0;
                        }
                        if (i12 >= i10) {
                            break;
                        }
                        i11 = i12;
                    }
                }
                return iArr;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }
}
