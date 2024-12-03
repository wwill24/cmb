package w2;

import java.util.List;
import y2.k;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<k> f18172a;

    /* renamed from: b  reason: collision with root package name */
    private final char f18173b;

    /* renamed from: c  reason: collision with root package name */
    private final double f18174c;

    /* renamed from: d  reason: collision with root package name */
    private final double f18175d;

    /* renamed from: e  reason: collision with root package name */
    private final String f18176e;

    /* renamed from: f  reason: collision with root package name */
    private final String f18177f;

    public c(List<k> list, char c10, double d10, double d11, String str, String str2) {
        this.f18172a = list;
        this.f18173b = c10;
        this.f18174c = d10;
        this.f18175d = d11;
        this.f18176e = str;
        this.f18177f = str2;
    }

    public static int c(char c10, String str, String str2) {
        return (((c10 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<k> a() {
        return this.f18172a;
    }

    public double b() {
        return this.f18175d;
    }

    public int hashCode() {
        return c(this.f18173b, this.f18177f, this.f18176e);
    }
}
