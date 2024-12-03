package mg;

import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.google.gson.internal.g;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class c extends q<Date> {

    /* renamed from: b  reason: collision with root package name */
    public static final r f23663b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<DateFormat> f23664a;

    class a implements r {
        a() {
        }

        public <T> q<T> a(d dVar, qg.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f23664a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.d.d()) {
            arrayList.add(g.c(2, 2));
        }
    }

    private Date e(JsonReader jsonReader) throws IOException {
        String nextString = jsonReader.nextString();
        synchronized (this.f23664a) {
            for (DateFormat parse : this.f23664a) {
                try {
                    Date parse2 = parse.parse(nextString);
                    return parse2;
                } catch (ParseException unused) {
                }
            }
            try {
                return ng.a.c(nextString, new ParsePosition(0));
            } catch (ParseException e10) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as Date; at path " + jsonReader.getPreviousPath(), e10);
            }
        }
    }

    /* renamed from: f */
    public Date b(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) {
            return e(jsonReader);
        }
        jsonReader.nextNull();
        return null;
    }

    /* renamed from: g */
    public void d(JsonWriter jsonWriter, Date date) throws IOException {
        String format2;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = this.f23664a.get(0);
        synchronized (this.f23664a) {
            format2 = dateFormat.format(date);
        }
        jsonWriter.value(format2);
    }
}
