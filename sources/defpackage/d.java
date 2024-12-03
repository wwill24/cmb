package defpackage;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.leanplum.internal.RequestBuilder;
import gk.h;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ml.b;
import operations.array.Filter;
import operations.logic.equals.Equals;
import operations.logic.equals.NotEquals;
import operations.logic.equals.strict.NotStrictEquals;
import operations.logic.equals.strict.StrictEquals;
import operations.numeric.Addition;
import operations.numeric.Max;
import operations.numeric.Min;
import operations.numeric.Multiplication;
import operations.numeric.compare.GreaterThan;
import operations.numeric.compare.GreaterThanOrEqualTo;
import operations.numeric.compare.LessThan;
import operations.numeric.compare.LessThanOrEqualTo;
import org.apache.commons.cli.HelpFormatter;
import pl.c;
import rl.e;

/* renamed from: d  reason: default package */
public interface d {

    /* renamed from: d$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Function1<Object, Unit> f40549a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, b> f40550b = h0.m(h.a("var", c.f33767a), h.a("missing_some", pl.b.f33766a), h.a("missing", pl.a.f33765a), h.a(">", GreaterThan.f33504a), h.a(">=", GreaterThanOrEqualTo.f33506a), h.a("<", LessThan.f33508a), h.a("<=", LessThanOrEqualTo.f33510a), h.a("min", Min.f33500a), h.a("max", Max.f33498a), h.a("+", Addition.f33496a), h.a(HelpFormatter.DEFAULT_OPT_PREFIX, ul.c.f33893a), h.a("*", Multiplication.f33502a), h.a(RemoteSettings.FORWARD_SLASH_STRING, ul.a.f33891a), h.a("%", ul.b.f33892a), h.a("==", Equals.f33488a), h.a("!=", NotEquals.f33490a), h.a("===", StrictEquals.f33494a), h.a("!==", NotStrictEquals.f33492a), h.a("!", rl.d.f33805a), h.a("!!", rl.b.f33803a), h.a("and", rl.a.f33802a), h.a("or", e.f33806a), h.a("if", rl.c.f33804a), h.a("cat", wl.a.f33959a), h.a("substr", wl.c.f33960a), h.a("merge", ol.b.f33474a), h.a("in", nl.d.f32809a));

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, ml.a> f40551c = h0.m(h.a("map", operations.array.Map.f33480a), h.a("filter", Filter.f33479a), h.a("reduce", operations.array.c.f33481a), h.a("all", operations.array.occurence.a.f33482a), h.a("none", operations.array.occurence.b.f33483a), h.a("some", operations.array.occurence.d.f33487a));

        private final boolean f(String str) {
            return !this.f40551c.containsKey(str) && !this.f40550b.containsKey(str);
        }

        public final a a(String str, ml.a aVar) {
            j.g(str, "operationName");
            j.g(aVar, "operation");
            if (f(str)) {
                this.f40551c.put(str, aVar);
            }
            return this;
        }

        public final a b(Map<String, ? extends ml.a> map) {
            j.g(map, "operations");
            for (Map.Entry next : map.entrySet()) {
                a((String) next.getKey(), (ml.a) next.getValue());
            }
            return this;
        }

        public final a c(String str, b bVar) {
            j.g(str, "operationName");
            j.g(bVar, "operation");
            if (f(str)) {
                this.f40550b.put(str, bVar);
            }
            return this;
        }

        public final a d(Map<String, ? extends b> map) {
            j.g(map, "operations");
            for (Map.Entry next : map.entrySet()) {
                c((String) next.getKey(), (b) next.getValue());
            }
            return this;
        }

        public final d e() {
            b put = this.f40550b.put(RequestBuilder.ACTION_LOG, new nl.e(this.f40549a));
            return new a(new hj.a(new hj.b(this.f40550b, this.f40551c)));
        }
    }

    e a(Map<String, ? extends Object> map, Object obj);
}
