package com.facebook.stetho.okhttp3;

import com.facebook.stetho.inspector.network.DefaultResponseHandler;
import com.facebook.stetho.inspector.network.NetworkEventReporter;
import com.facebook.stetho.inspector.network.NetworkEventReporterImpl;
import com.facebook.stetho.inspector.network.RequestBodyHelper;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.i;
import okhttp3.u;
import okhttp3.v;
import okhttp3.y;
import okhttp3.z;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class StethoInterceptor implements u {
    private final NetworkEventReporter mEventReporter = NetworkEventReporterImpl.get();

    private static class ForwardingResponseBody extends b0 {
        private final b0 mBody;
        private final BufferedSource mInterceptedSource;

        public ForwardingResponseBody(b0 b0Var, InputStream inputStream) {
            this.mBody = b0Var;
            this.mInterceptedSource = Okio.c(Okio.j(inputStream));
        }

        public long contentLength() {
            return this.mBody.contentLength();
        }

        public v contentType() {
            return this.mBody.contentType();
        }

        public BufferedSource source() {
            return this.mInterceptedSource;
        }
    }

    private static class OkHttpInspectorRequest implements NetworkEventReporter.InspectorRequest {
        private final y mRequest;
        private RequestBodyHelper mRequestBodyHelper;
        private final String mRequestId;

        public OkHttpInspectorRequest(String str, y yVar, RequestBodyHelper requestBodyHelper) {
            this.mRequestId = str;
            this.mRequest = yVar;
            this.mRequestBodyHelper = requestBodyHelper;
        }

        /* JADX INFO: finally extract failed */
        public byte[] body() throws IOException {
            z a10 = this.mRequest.a();
            if (a10 == null) {
                return null;
            }
            BufferedSink b10 = Okio.b(Okio.f(this.mRequestBodyHelper.createBodySink(firstHeaderValue("Content-Encoding"))));
            try {
                a10.i(b10);
                b10.close();
                return this.mRequestBodyHelper.getDisplayBody();
            } catch (Throwable th2) {
                b10.close();
                throw th2;
            }
        }

        public String firstHeaderValue(String str) {
            return this.mRequest.d(str);
        }

        public String friendlyName() {
            return null;
        }

        public Integer friendlyNameExtra() {
            return null;
        }

        public int headerCount() {
            return this.mRequest.e().size();
        }

        public String headerName(int i10) {
            return this.mRequest.e().f(i10);
        }

        public String headerValue(int i10) {
            return this.mRequest.e().n(i10);
        }

        public String id() {
            return this.mRequestId;
        }

        public String method() {
            return this.mRequest.g();
        }

        public String url() {
            return this.mRequest.j().toString();
        }
    }

    private static class OkHttpInspectorResponse implements NetworkEventReporter.InspectorResponse {
        private final i mConnection;
        private final y mRequest;
        private final String mRequestId;
        private final a0 mResponse;

        public OkHttpInspectorResponse(String str, y yVar, a0 a0Var, i iVar) {
            this.mRequestId = str;
            this.mRequest = yVar;
            this.mResponse = a0Var;
            this.mConnection = iVar;
        }

        public int connectionId() {
            i iVar = this.mConnection;
            if (iVar == null) {
                return 0;
            }
            return iVar.hashCode();
        }

        public boolean connectionReused() {
            return false;
        }

        public String firstHeaderValue(String str) {
            return this.mResponse.k(str);
        }

        public boolean fromDiskCache() {
            return this.mResponse.c() != null;
        }

        public int headerCount() {
            return this.mResponse.n().size();
        }

        public String headerName(int i10) {
            return this.mResponse.n().f(i10);
        }

        public String headerValue(int i10) {
            return this.mResponse.n().n(i10);
        }

        public String reasonPhrase() {
            return this.mResponse.u();
        }

        public String requestId() {
            return this.mRequestId;
        }

        public int statusCode() {
            return this.mResponse.f();
        }

        public String url() {
            return this.mRequest.j().toString();
        }
    }

    public a0 intercept(u.a aVar) throws IOException {
        RequestBodyHelper requestBodyHelper;
        InputStream inputStream;
        v vVar;
        String nextRequestId = this.mEventReporter.nextRequestId();
        y g10 = aVar.g();
        String str = null;
        if (this.mEventReporter.isEnabled()) {
            requestBodyHelper = new RequestBodyHelper(this.mEventReporter, nextRequestId);
            this.mEventReporter.requestWillBeSent(new OkHttpInspectorRequest(nextRequestId, g10, requestBodyHelper));
        } else {
            requestBodyHelper = null;
        }
        try {
            a0 a10 = aVar.a(g10);
            if (!this.mEventReporter.isEnabled()) {
                return a10;
            }
            if (requestBodyHelper != null && requestBodyHelper.hasBody()) {
                requestBodyHelper.reportDataSent();
            }
            i b10 = aVar.b();
            if (b10 != null) {
                this.mEventReporter.responseHeadersReceived(new OkHttpInspectorResponse(nextRequestId, g10, a10, b10));
                b0 a11 = a10.a();
                if (a11 != null) {
                    vVar = a11.contentType();
                    inputStream = a11.byteStream();
                } else {
                    vVar = null;
                    inputStream = null;
                }
                NetworkEventReporter networkEventReporter = this.mEventReporter;
                if (vVar != null) {
                    str = vVar.toString();
                }
                InputStream interpretResponseStream = networkEventReporter.interpretResponseStream(nextRequestId, str, a10.k("Content-Encoding"), inputStream, new DefaultResponseHandler(this.mEventReporter, nextRequestId));
                if (interpretResponseStream != null) {
                    return a10.x().b(new ForwardingResponseBody(a11, interpretResponseStream)).c();
                }
                return a10;
            }
            throw new IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
        } catch (IOException e10) {
            if (this.mEventReporter.isEnabled()) {
                this.mEventReporter.httpExchangeFailed(nextRequestId, e10.toString());
            }
            throw e10;
        }
    }
}
