package coil.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcoil/util/Time;", "", "", "a", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "provider", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class Time {

    /* renamed from: a  reason: collision with root package name */
    public static final Time f8420a = new Time();

    /* renamed from: b  reason: collision with root package name */
    private static Function0<Long> f8421b = Time$provider$1.f8422a;

    private Time() {
    }

    public final long a() {
        return f8421b.invoke().longValue();
    }
}
