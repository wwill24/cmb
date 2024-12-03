package com.mparticle.identity;

import androidx.annotation.NonNull;
import com.mparticle.internal.MPUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public final class IdentityHttpResponse {
    @NonNull
    public static final String CODE = "code";
    @NonNull
    public static final String CONTEXT = "context";
    @NonNull
    public static final String ERRORS = "errors";
    @NonNull
    public static final String LOGGED_IN = "is_logged_in";
    @NonNull
    public static final String MESSAGE = "message";
    @NonNull
    public static final String MPID = "mpid";
    @NonNull
    public static final String UNKNOWN = "UNKNOWN";
    private String context;
    private ArrayList<Error> errors;
    private int httpCode;
    private boolean loggedIn;
    private long mpId;

    public static class Error {
        @NonNull
        public final String code;
        @NonNull
        public final String message;

        public Error(@NonNull String str, @NonNull String str2) {
            this.code = str;
            this.message = str2;
        }
    }

    private IdentityHttpResponse() {
        this.errors = new ArrayList<>();
    }

    public String getContext() {
        return this.context;
    }

    @NonNull
    public List<Error> getErrors() {
        return this.errors;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public long getMpId() {
        return this.mpId;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public boolean isSuccessful() {
        return this.httpCode == 200;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Identity Response:\n");
        sb2.append("Identity Response Code: " + this.httpCode + "\n");
        if (isSuccessful()) {
            sb2.append("MPID: " + this.mpId + "\n");
            sb2.append("Context: " + this.context + "\n");
            sb2.append("Is Logged In: " + this.loggedIn + "\n");
        } else {
            Iterator<Error> it = this.errors.iterator();
            while (it.hasNext()) {
                Error next = it.next();
                sb2.append("Code: " + next.code + "\n");
                sb2.append("Message: " + next.message + "\n");
            }
        }
        return sb2.toString();
    }

    public IdentityHttpResponse(int i10, long j10, String str, ArrayList<Error> arrayList) {
        this.errors = new ArrayList<>();
        this.httpCode = i10;
        this.mpId = j10;
        this.context = str;
        this.errors = arrayList == null ? new ArrayList<>() : new ArrayList<>(arrayList);
    }

    public IdentityHttpResponse(int i10, @NonNull String str) {
        ArrayList<Error> arrayList = new ArrayList<>();
        this.errors = arrayList;
        this.httpCode = i10;
        arrayList.add(new Error(UNKNOWN, str));
    }

    public IdentityHttpResponse(int i10, b bVar) throws JSONException {
        this.errors = new ArrayList<>();
        this.httpCode = i10;
        if (MPUtility.isEmpty(bVar)) {
            return;
        }
        if (bVar.has("mpid")) {
            this.mpId = Long.valueOf(bVar.getString("mpid")).longValue();
            this.context = bVar.optString(CONTEXT);
            this.loggedIn = bVar.optBoolean(LOGGED_IN);
        } else if (bVar.has(ERRORS)) {
            a optJSONArray = bVar.optJSONArray(ERRORS);
            if (!MPUtility.isEmpty(optJSONArray)) {
                for (int i11 = 0; i11 < optJSONArray.o(); i11++) {
                    try {
                        b j10 = optJSONArray.j(i11);
                        this.errors.add(new Error(j10.optString("code"), j10.optString("message")));
                    } catch (JSONException unused) {
                    }
                }
            }
        } else {
            this.errors.add(new Error(bVar.optString("code"), bVar.optString("message")));
        }
    }
}
