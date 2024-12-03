package pg;

import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

final class a extends q<Date> {

    /* renamed from: b  reason: collision with root package name */
    static final r f24371b = new C0291a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f24372a;

    /* renamed from: pg.a$a  reason: collision with other inner class name */
    class C0291a implements r {
        C0291a() {
        }

        public <T> q<T> a(d dVar, qg.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new a((C0291a) null);
            }
            return null;
        }
    }

    /* synthetic */ a(C0291a aVar) {
        this();
    }

    /* renamed from: e */
    public Date b(JsonReader jsonReader) throws IOException {
        java.util.Date parse;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        try {
            synchronized (this) {
                parse = this.f24372a.parse(nextString);
            }
            return new Date(parse.getTime());
        } catch (ParseException e10) {
            throw new JsonSyntaxException("Failed parsing '" + nextString + "' as SQL Date; at path " + jsonReader.getPreviousPath(), e10);
        }
    }

    /* renamed from: f */
    public void d(JsonWriter jsonWriter, Date date) throws IOException {
        String format2;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format2 = this.f24372a.format(date);
        }
        jsonWriter.value(format2);
    }

    private a() {
        this.f24372a = new SimpleDateFormat(DateUtils.DATE_PATTERN_FRIENDLY_SHORT_MONTH);
    }
}
