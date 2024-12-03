package pg;

import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

final class b extends q<Time> {

    /* renamed from: b  reason: collision with root package name */
    static final r f24373b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f24374a;

    class a implements r {
        a() {
        }

        public <T> q<T> a(d dVar, qg.a<T> aVar) {
            if (aVar.c() == Time.class) {
                return new b((a) null);
            }
            return null;
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    /* renamed from: e */
    public Time b(JsonReader jsonReader) throws IOException {
        Time time;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        try {
            synchronized (this) {
                time = new Time(this.f24374a.parse(nextString).getTime());
            }
            return time;
        } catch (ParseException e10) {
            throw new JsonSyntaxException("Failed parsing '" + nextString + "' as SQL Time; at path " + jsonReader.getPreviousPath(), e10);
        }
    }

    /* renamed from: f */
    public void d(JsonWriter jsonWriter, Time time) throws IOException {
        String format2;
        if (time == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format2 = this.f24374a.format(time);
        }
        jsonWriter.value(format2);
    }

    private b() {
        this.f24374a = new SimpleDateFormat("hh:mm:ss a");
    }
}
