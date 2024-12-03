package com.google.android.recaptcha.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Unit;
import kotlin.jvm.internal.j;

public abstract class zzbd implements InvocationHandler {
    private final Object zza;

    public zzbd(Object obj) {
        this.zza = obj;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        if (j.b(method.getName(), "toString") && method.getParameterTypes().length == 0) {
            return "Proxy@".concat(String.valueOf(Integer.toHexString(obj.hashCode())));
        }
        if (j.b(method.getName(), "hashCode") && method.getParameterTypes().length == 0) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        if (j.b(method.getName(), "equals") && method.getParameterTypes().length != 0) {
            boolean z10 = false;
            if (!(objArr == null || objArr.length == 0 || objArr[0].hashCode() != obj.hashCode())) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        } else if (!zza(obj, method, objArr)) {
            return Unit.f32013a;
        } else {
            if ((this.zza != null || !j.b(method.getReturnType(), Void.TYPE)) && ((obj2 = this.zza) == null || !j.b(zzeg.zza(obj2.getClass()), zzeg.zza(method.getReturnType())))) {
                Object obj3 = this.zza;
                Class<?> returnType = method.getReturnType();
                throw new IllegalArgumentException(obj3 + " cannot be returned from method with return type " + returnType);
            }
            Object obj4 = this.zza;
            if (obj4 == null) {
                return Unit.f32013a;
            }
            return obj4;
        }
    }

    public abstract boolean zza(Object obj, Method method, Object[] objArr);
}
