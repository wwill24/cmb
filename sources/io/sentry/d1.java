package io.sentry;

import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.Session;
import io.sentry.SpanStatus;
import io.sentry.a2;
import io.sentry.clientreport.b;
import io.sentry.d;
import io.sentry.j4;
import io.sentry.l4;
import io.sentry.o3;
import io.sentry.p3;
import io.sentry.profilemeasurements.a;
import io.sentry.profilemeasurements.b;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.Device;
import io.sentry.protocol.a;
import io.sentry.protocol.b;
import io.sentry.protocol.c;
import io.sentry.protocol.d;
import io.sentry.protocol.e;
import io.sentry.protocol.f;
import io.sentry.protocol.g;
import io.sentry.protocol.h;
import io.sentry.protocol.i;
import io.sentry.protocol.j;
import io.sentry.protocol.l;
import io.sentry.protocol.m;
import io.sentry.protocol.n;
import io.sentry.protocol.p;
import io.sentry.protocol.q;
import io.sentry.protocol.r;
import io.sentry.protocol.s;
import io.sentry.protocol.t;
import io.sentry.protocol.u;
import io.sentry.protocol.v;
import io.sentry.protocol.x;
import io.sentry.protocol.y;
import io.sentry.protocol.z;
import io.sentry.x2;
import io.sentry.x4;
import io.sentry.z1;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class d1 implements l0 {

    /* renamed from: c  reason: collision with root package name */
    private static final Charset f31193c = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final SentryOptions f31194a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, s0<?>> f31195b;

    public d1(SentryOptions sentryOptions) {
        this.f31194a = sentryOptions;
        HashMap hashMap = new HashMap();
        this.f31195b = hashMap;
        hashMap.put(a.class, new a.C0361a());
        hashMap.put(d.class, new d.a());
        hashMap.put(b.class, new b.a());
        hashMap.put(Contexts.class, new Contexts.a());
        hashMap.put(DebugImage.class, new DebugImage.a());
        hashMap.put(c.class, new c.a());
        hashMap.put(Device.class, new Device.a());
        hashMap.put(Device.DeviceOrientation.class, new Device.DeviceOrientation.a());
        hashMap.put(e.class, new e.a());
        hashMap.put(f.class, new f.a());
        hashMap.put(g.class, new g.a());
        hashMap.put(h.class, new h.a());
        hashMap.put(i.class, new i.a());
        hashMap.put(z1.class, new z1.b());
        hashMap.put(a2.class, new a2.a());
        hashMap.put(io.sentry.profilemeasurements.a.class, new a.C0360a());
        hashMap.put(io.sentry.profilemeasurements.b.class, new b.a());
        hashMap.put(j.class, new j.a());
        hashMap.put(l.class, new l.a());
        hashMap.put(m.class, new m.a());
        hashMap.put(x2.class, new x2.a());
        hashMap.put(o3.class, new o3.a());
        hashMap.put(p3.class, new p3.a());
        hashMap.put(n.class, new n.a());
        hashMap.put(SentryItemType.class, new SentryItemType.a());
        hashMap.put(SentryLevel.class, new SentryLevel.a());
        hashMap.put(p.class, new p.a());
        hashMap.put(q.class, new q.a());
        hashMap.put(r.class, new r.a());
        hashMap.put(s.class, new s.a());
        hashMap.put(t.class, new t.a());
        hashMap.put(u.class, new u.a());
        hashMap.put(v.class, new v.a());
        hashMap.put(Session.class, new Session.a());
        hashMap.put(j4.class, new j4.a());
        hashMap.put(l4.class, new l4.a());
        hashMap.put(SpanStatus.class, new SpanStatus.a());
        hashMap.put(x.class, new x.a());
        hashMap.put(io.sentry.protocol.d.class, new d.a());
        hashMap.put(x4.class, new x4.a());
        hashMap.put(io.sentry.clientreport.b.class, new b.a());
        hashMap.put(z.class, new z.a());
        hashMap.put(y.class, new y.a());
    }

    private String f(Object obj, boolean z10) throws IOException {
        StringWriter stringWriter = new StringWriter();
        a1 a1Var = new a1(stringWriter, this.f31194a.getMaxDepth());
        if (z10) {
            a1Var.y("\t");
        }
        a1Var.O(this.f31194a.getLogger(), obj);
        return stringWriter.toString();
    }

    public <T> void a(T t10, Writer writer) throws IOException {
        io.sentry.util.l.c(t10, "The entity is required.");
        io.sentry.util.l.c(writer, "The Writer object is required.");
        h0 logger = this.f31194a.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        if (logger.d(sentryLevel)) {
            String f10 = f(t10, true);
            this.f31194a.getLogger().c(sentryLevel, "Serializing object: %s", f10);
        }
        new a1(writer, this.f31194a.getMaxDepth()).O(this.f31194a.getLogger(), t10);
        writer.flush();
    }

    public void b(w2 w2Var, OutputStream outputStream) throws Exception {
        io.sentry.util.l.c(w2Var, "The SentryEnvelope object is required.");
        io.sentry.util.l.c(outputStream, "The Stream object is required.");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), f31193c));
        try {
            w2Var.b().serialize(new a1(bufferedWriter, this.f31194a.getMaxDepth()), this.f31194a.getLogger());
            bufferedWriter.write("\n");
            for (n3 next : w2Var.c()) {
                byte[] w10 = next.w();
                next.x().serialize(new a1(bufferedWriter, this.f31194a.getMaxDepth()), this.f31194a.getLogger());
                bufferedWriter.write("\n");
                bufferedWriter.flush();
                outputStream.write(w10);
                bufferedWriter.write("\n");
            }
            bufferedWriter.flush();
        } catch (Exception e10) {
            this.f31194a.getLogger().b(SentryLevel.ERROR, "Failed to create envelope item. Dropping it.", e10);
        } catch (Throwable th2) {
            bufferedWriter.flush();
            throw th2;
        }
    }

    public <T> T c(Reader reader, Class<T> cls) {
        try {
            y0 y0Var = new y0(reader);
            s0 s0Var = this.f31195b.get(cls);
            if (s0Var != null) {
                return cls.cast(s0Var.a(y0Var, this.f31194a.getLogger()));
            }
            return null;
        } catch (Exception e10) {
            this.f31194a.getLogger().b(SentryLevel.ERROR, "Error when deserializing", e10);
            return null;
        }
    }

    public w2 d(InputStream inputStream) {
        io.sentry.util.l.c(inputStream, "The InputStream object is required.");
        try {
            return this.f31194a.getEnvelopeReader().a(inputStream);
        } catch (IOException e10) {
            this.f31194a.getLogger().b(SentryLevel.ERROR, "Error deserializing envelope.", e10);
            return null;
        }
    }

    public String e(Map<String, Object> map) throws Exception {
        return f(map, false);
    }
}
