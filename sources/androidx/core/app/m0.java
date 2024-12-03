package androidx.core.app;

import android.app.Person;
import android.graphics.drawable.Icon;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;

public class m0 {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f4459a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f4460b;

    /* renamed from: c  reason: collision with root package name */
    String f4461c;

    /* renamed from: d  reason: collision with root package name */
    String f4462d;

    /* renamed from: e  reason: collision with root package name */
    boolean f4463e;

    /* renamed from: f  reason: collision with root package name */
    boolean f4464f;

    static class a {
        static m0 a(Person person) {
            IconCompat iconCompat;
            b f10 = new b().f(person.getName());
            if (person.getIcon() != null) {
                iconCompat = IconCompat.a(person.getIcon());
            } else {
                iconCompat = null;
            }
            return f10.c(iconCompat).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        static Person b(m0 m0Var) {
            Icon icon;
            Person.Builder name = new Person.Builder().setName(m0Var.c());
            if (m0Var.a() != null) {
                icon = m0Var.a().q();
            } else {
                icon = null;
            }
            return name.setIcon(icon).setUri(m0Var.d()).setKey(m0Var.b()).setBot(m0Var.e()).setImportant(m0Var.f()).build();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        CharSequence f4465a;

        /* renamed from: b  reason: collision with root package name */
        IconCompat f4466b;

        /* renamed from: c  reason: collision with root package name */
        String f4467c;

        /* renamed from: d  reason: collision with root package name */
        String f4468d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4469e;

        /* renamed from: f  reason: collision with root package name */
        boolean f4470f;

        @NonNull
        public m0 a() {
            return new m0(this);
        }

        @NonNull
        public b b(boolean z10) {
            this.f4469e = z10;
            return this;
        }

        @NonNull
        public b c(IconCompat iconCompat) {
            this.f4466b = iconCompat;
            return this;
        }

        @NonNull
        public b d(boolean z10) {
            this.f4470f = z10;
            return this;
        }

        @NonNull
        public b e(String str) {
            this.f4468d = str;
            return this;
        }

        @NonNull
        public b f(CharSequence charSequence) {
            this.f4465a = charSequence;
            return this;
        }

        @NonNull
        public b g(String str) {
            this.f4467c = str;
            return this;
        }
    }

    m0(b bVar) {
        this.f4459a = bVar.f4465a;
        this.f4460b = bVar.f4466b;
        this.f4461c = bVar.f4467c;
        this.f4462d = bVar.f4468d;
        this.f4463e = bVar.f4469e;
        this.f4464f = bVar.f4470f;
    }

    public IconCompat a() {
        return this.f4460b;
    }

    public String b() {
        return this.f4462d;
    }

    public CharSequence c() {
        return this.f4459a;
    }

    public String d() {
        return this.f4461c;
    }

    public boolean e() {
        return this.f4463e;
    }

    public boolean f() {
        return this.f4464f;
    }

    @NonNull
    public String g() {
        String str = this.f4461c;
        if (str != null) {
            return str;
        }
        if (this.f4459a == null) {
            return "";
        }
        return "name:" + this.f4459a;
    }

    @NonNull
    public Person h() {
        return a.b(this);
    }
}
