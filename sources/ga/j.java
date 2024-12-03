package ga;

import android.content.Context;
import android.os.Handler;
import ga.e;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class j implements d, e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f40821a;

    /* renamed from: b  reason: collision with root package name */
    private final hb.c f40822b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f40823c;

    /* renamed from: d  reason: collision with root package name */
    private final File f40824d;

    /* renamed from: e  reason: collision with root package name */
    private final File f40825e;

    /* renamed from: f  reason: collision with root package name */
    private final int f40826f;

    /* renamed from: g  reason: collision with root package name */
    private final int f40827g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f40828h;

    /* renamed from: i  reason: collision with root package name */
    private final b f40829i;

    /* renamed from: j  reason: collision with root package name */
    private int f40830j;

    /* renamed from: k  reason: collision with root package name */
    private StringBuilder f40831k;

    /* renamed from: l  reason: collision with root package name */
    private File f40832l;

    /* renamed from: m  reason: collision with root package name */
    private List<e.a> f40833m;

    /* renamed from: n  reason: collision with root package name */
    private Handler f40834n;

    /* renamed from: o  reason: collision with root package name */
    private LinkedList<d> f40835o;

    /* renamed from: p  reason: collision with root package name */
    private LinkedList<String> f40836p;

    /* renamed from: q  reason: collision with root package name */
    private Set<String> f40837q;

    class a extends e {
        a() {
            super();
        }

        public void a() {
            j.this.r();
        }
    }

    class b extends e {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f40839b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f40840c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, String str2) {
            super();
            this.f40839b = str;
            this.f40840c = str2;
        }

        public void a() throws Exception {
            j jVar = j.this;
            jVar.A(this.f40839b, jVar.f40821a.b(this.f40839b, this.f40840c));
        }
    }

    class c extends e {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f40842b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f40843c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f40844d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, boolean z10, String str2) {
            super();
            this.f40842b = str;
            this.f40843c = z10;
            this.f40844d = str2;
        }

        public void a() throws Exception {
            j jVar = j.this;
            jVar.A(this.f40842b, jVar.f40821a.e(this.f40842b, this.f40843c, this.f40844d));
        }
    }

    private class d {

        /* renamed from: a  reason: collision with root package name */
        final String f40846a;

        /* renamed from: b  reason: collision with root package name */
        final String f40847b;

        private d(String str, String str2) {
            this.f40846a = str;
            this.f40847b = str2;
        }
    }

    private abstract class e implements Runnable {
        private e() {
        }

        public abstract void a() throws Exception;

        public final void run() {
            try {
                a();
            } catch (Exception e10) {
                fa.a.i(e10);
            }
        }
    }

    public j(Context context, c cVar, hb.c cVar2, b bVar, boolean z10) {
        this(context, cVar, cVar2, 10000, 2, z10, Executors.newSingleThreadExecutor(), bVar);
    }

    /* access modifiers changed from: private */
    public void A(String str, String str2) throws IOException {
        q();
        r();
        StringBuilder sb2 = this.f40831k;
        sb2.append(str2);
        sb2.append("\n");
        t();
        if (this.f40828h) {
            this.f40834n.post(new h(this, str, str2));
        }
    }

    private void o(String str) throws IOException {
        FileWriter fileWriter = new FileWriter(this.f40832l, true);
        fileWriter.append(str);
        fileWriter.close();
    }

    private void p() throws IOException {
        if (!this.f40824d.exists()) {
            this.f40824d.mkdirs();
        }
        File file = new File(this.f40824d, u());
        this.f40832l = file;
        file.createNewFile();
        o(this.f40821a.a() + "\n");
    }

    private void q() throws IOException {
        if (this.f40832l == null) {
            p();
        } else if (!u().equals(this.f40832l.getName())) {
            s();
            p();
        }
    }

    /* access modifiers changed from: private */
    public void r() {
        if (this.f40824d.exists()) {
            File[] listFiles = this.f40824d.listFiles();
            if (this.f40827g < listFiles.length) {
                Arrays.sort(listFiles, new i());
                for (int i10 = 0; i10 < this.f40827g; i10++) {
                    listFiles[i10].delete();
                }
            }
        }
        if (this.f40825e.exists()) {
            File[] listFiles2 = this.f40825e.listFiles();
            String d10 = this.f40821a.d();
            String c10 = this.f40821a.c();
            for (File file : listFiles2) {
                String name = file.getName();
                if (!name.equals(d10) && !name.equals(c10)) {
                    file.delete();
                }
            }
        }
    }

    private void s() throws IOException {
        String sb2 = this.f40831k.toString();
        this.f40831k = new StringBuilder(this.f40826f);
        o(sb2);
    }

    private void t() throws IOException {
        if (this.f40831k.length() > this.f40826f) {
            s();
        }
    }

    private String u() {
        return this.f40821a.d();
    }

    private File v(Context context) {
        return new File(context.getFilesDir(), "rlcs");
    }

    private File w(Context context) {
        return new File(context.getExternalFilesDir((String) null), "rlcs");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(String str, String str2) {
        if (this.f40830j > 0) {
            while (this.f40835o.size() >= this.f40830j) {
                this.f40835o.poll();
                this.f40836p.poll();
            }
            this.f40835o.add(new d(str, str2));
            this.f40836p.add(str2);
            this.f40837q.add(str);
        }
        Iterator it = new ArrayList(this.f40833m).iterator();
        while (it.hasNext()) {
            ((e.a) it.next()).c(str, str2);
        }
    }

    private void z() {
        if (this.f40828h) {
            this.f40830j = this.f40822b.l("num_rlcs_lines_viewer_caches");
        } else {
            this.f40830j = 0;
        }
        this.f40833m = new ArrayList();
        this.f40831k = new StringBuilder(this.f40826f);
        this.f40834n = new Handler();
        this.f40835o = new LinkedList<>();
        this.f40836p = new LinkedList<>();
        this.f40837q = new HashSet();
        this.f40823c.execute(new a());
    }

    public void a(String str, String str2) {
        this.f40823c.execute(new b(str, str2));
    }

    public void b(String str, boolean z10, String str2) {
        this.f40823c.execute(new c(str, z10, str2));
    }

    public List<String> c(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<d> it = this.f40835o.iterator();
        while (it.hasNext()) {
            d next = it.next();
            String str = next.f40846a;
            boolean z10 = false;
            Iterator<String> it2 = set.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (str.equals(it2.next())) {
                        z10 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z10) {
                arrayList.add(next.f40847b);
            }
        }
        return arrayList;
    }

    public Set<String> d() {
        return Collections.unmodifiableSet(this.f40837q);
    }

    public int e() {
        return this.f40830j;
    }

    public List<String> f() {
        return Collections.unmodifiableList(this.f40836p);
    }

    public void g(e.a aVar) {
        this.f40833m.remove(aVar);
    }

    public void h(e.a aVar) {
        if (!this.f40833m.contains(aVar)) {
            this.f40833m.add(aVar);
        }
    }

    public void i(int i10) {
        this.f40830j = i10;
        this.f40822b.c("num_rlcs_lines_viewer_caches", i10);
    }

    private j(Context context, c cVar, hb.c cVar2, int i10, int i11, boolean z10, Executor executor, b bVar) {
        if (i11 != 0) {
            this.f40821a = cVar;
            this.f40822b = cVar2;
            this.f40823c = executor;
            this.f40825e = w(context);
            this.f40824d = v(context);
            this.f40826f = i10;
            this.f40827g = i11;
            this.f40828h = z10;
            this.f40829i = bVar;
            z();
            return;
        }
        throw new IllegalArgumentException("must keep at least 1 log file");
    }
}
