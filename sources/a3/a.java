package a3;

import androidx.annotation.NonNull;
import c3.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class a implements c {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final HttpURLConnection f129a;

    public a(@NonNull HttpURLConnection httpURLConnection) {
        this.f129a = httpURLConnection;
    }

    private String a(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb2.append(readLine);
                    sb2.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb2.toString();
    }

    public void close() {
        this.f129a.disconnect();
    }

    public String g0() {
        return this.f129a.getContentType();
    }

    public boolean isSuccessful() {
        try {
            return this.f129a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    public String j() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f129a.getURL() + ". Failed with " + this.f129a.getResponseCode() + "\n" + a(this.f129a);
        } catch (IOException e10) {
            f.d("get error failed ", e10);
            return e10.getMessage();
        }
    }

    @NonNull
    public InputStream l0() throws IOException {
        return this.f129a.getInputStream();
    }
}
