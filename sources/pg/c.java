package pg;

import com.google.gson.d;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

class c extends q<Timestamp> {

    /* renamed from: b  reason: collision with root package name */
    static final r f24375b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final q<Date> f24376a;

    class a implements r {
        a() {
        }

        public <T> q<T> a(d dVar, qg.a<T> aVar) {
            if (aVar.c() == Timestamp.class) {
                return new c(dVar.n(Date.class), (a) null);
            }
            return null;
        }
    }

    /* synthetic */ c(q qVar, a aVar) {
        this(qVar);
    }

    /* renamed from: e */
    public Timestamp b(JsonReader jsonReader) throws IOException {
        Date b10 = this.f24376a.b(jsonReader);
        if (b10 != null) {
            return new Timestamp(b10.getTime());
        }
        return null;
    }

    /* renamed from: f */
    public void d(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
        this.f24376a.d(jsonWriter, timestamp);
    }

    private c(q<Date> qVar) {
        this.f24376a = qVar;
    }
}
