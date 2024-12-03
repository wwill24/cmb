package io.sentry.util;

import io.sentry.SentryLevel;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.l0;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f31721a = Charset.forName("UTF-8");

    public static List<Object> a(AtomicIntegerArray atomicIntegerArray) {
        int length = atomicIntegerArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(Integer.valueOf(atomicIntegerArray.get(i10)));
        }
        return arrayList;
    }

    public static byte[] b(l0 l0Var, h0 h0Var, c1 c1Var) {
        BufferedWriter bufferedWriter;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f31721a));
                l0Var.a(c1Var, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th2) {
                byteArrayOutputStream.close();
                throw th2;
            }
            throw th;
        } catch (Throwable th3) {
            h0Var.b(SentryLevel.ERROR, "Could not serialize serializable", th3);
            return null;
        }
    }

    public static Map<String, Object> c(Calendar calendar) {
        HashMap hashMap = new HashMap();
        hashMap.put("year", Integer.valueOf(calendar.get(1)));
        hashMap.put("month", Integer.valueOf(calendar.get(2)));
        hashMap.put("dayOfMonth", Integer.valueOf(calendar.get(5)));
        hashMap.put("hourOfDay", Integer.valueOf(calendar.get(11)));
        hashMap.put("minute", Integer.valueOf(calendar.get(12)));
        hashMap.put("second", Integer.valueOf(calendar.get(13)));
        return hashMap;
    }
}
