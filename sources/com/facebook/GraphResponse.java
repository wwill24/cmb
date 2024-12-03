package com.facebook;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.util.FacebookParse;
import com.facebook.AccessToken;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import org.json.JSONException;
import org.json.a;
import org.json.b;
import org.json.h;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 .2\u00020\u0001:\u0002./BC\b\u0000\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b(\u0010)B-\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b(\u0010*B+\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010+\u001a\u00020\u0004¢\u0006\u0004\b(\u0010,B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b(\u0010-J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010$R\u0019\u0010%\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010'¨\u00060"}, d2 = {"Lcom/facebook/GraphResponse;", "", "Lorg/json/b;", "getJSONObject", "Lorg/json/a;", "getJSONArray", "Lcom/facebook/GraphResponse$PagingDirection;", "direction", "Lcom/facebook/GraphRequest;", "getRequestForPagedResults", "", "toString", "request", "Lcom/facebook/GraphRequest;", "getRequest", "()Lcom/facebook/GraphRequest;", "Ljava/net/HttpURLConnection;", "connection", "Ljava/net/HttpURLConnection;", "getConnection", "()Ljava/net/HttpURLConnection;", "rawResponse", "Ljava/lang/String;", "getRawResponse", "()Ljava/lang/String;", "graphObject", "Lorg/json/b;", "graphObjectArray", "Lorg/json/a;", "Lcom/facebook/FacebookRequestError;", "error", "Lcom/facebook/FacebookRequestError;", "getError", "()Lcom/facebook/FacebookRequestError;", "jsonObject", "getJsonObject", "()Lorg/json/b;", "jsonArray", "getJsonArray", "()Lorg/json/a;", "<init>", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/b;Lorg/json/a;Lcom/facebook/FacebookRequestError;)V", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/b;)V", "graphObjects", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/a;)V", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookRequestError;)V", "Companion", "PagingDirection", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class GraphResponse {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    private static final String RESPONSE_LOG_TAG = "Response";
    public static final String SUCCESS_KEY = "success";
    /* access modifiers changed from: private */
    public static final String TAG = GraphResponse.class.getCanonicalName();
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final b graphObject;
    private final a graphObjectArray;
    private final a jsonArray;
    private final b jsonObject;
    private final String rawResponse;
    private final GraphRequest request;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J*\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0002J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u0015\u001a\u00020\u0001H\u0002J/\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cJ-\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001fJ#\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\b!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/GraphResponse$Companion;", "", "()V", "BODY_KEY", "", "CODE_KEY", "NON_JSON_RESPONSE_PROPERTY", "RESPONSE_LOG_TAG", "SUCCESS_KEY", "TAG", "constructErrorResponses", "", "Lcom/facebook/GraphResponse;", "requests", "Lcom/facebook/GraphRequest;", "connection", "Ljava/net/HttpURLConnection;", "error", "Lcom/facebook/FacebookException;", "createResponseFromObject", "request", "sourceObject", "originalResult", "createResponsesFromObject", "createResponsesFromStream", "stream", "Ljava/io/InputStream;", "Lcom/facebook/GraphRequestBatch;", "createResponsesFromStream$facebook_core_release", "createResponsesFromString", "responseString", "createResponsesFromString$facebook_core_release", "fromHttpConnection", "fromHttpConnection$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GraphResponse createResponseFromObject(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) throws JSONException {
            Boolean bool = null;
            if (obj instanceof b) {
                b bVar = (b) obj;
                FacebookRequestError checkResponseAndCreateError = FacebookRequestError.Companion.checkResponseAndCreateError(bVar, obj2, httpURLConnection);
                if (checkResponseAndCreateError != null) {
                    String unused = GraphResponse.TAG;
                    checkResponseAndCreateError.toString();
                    if (checkResponseAndCreateError.getErrorCode() == 190) {
                        Utility utility = Utility.INSTANCE;
                        if (Utility.isCurrentAccessToken(graphRequest.getAccessToken())) {
                            if (checkResponseAndCreateError.getSubErrorCode() != 493) {
                                AccessToken.Companion.setCurrentAccessToken((AccessToken) null);
                            } else {
                                AccessToken.Companion companion = AccessToken.Companion;
                                AccessToken currentAccessToken = companion.getCurrentAccessToken();
                                if (currentAccessToken != null) {
                                    bool = Boolean.valueOf(currentAccessToken.isExpired());
                                }
                                if (j.b(bool, Boolean.FALSE)) {
                                    companion.expireCurrentAccessToken();
                                }
                            }
                        }
                    }
                    return new GraphResponse(graphRequest, httpURLConnection, checkResponseAndCreateError);
                }
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(bVar, "body", GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON instanceof b) {
                    b bVar2 = (b) stringPropertyAsJSON;
                    return new GraphResponse(graphRequest, httpURLConnection, bVar2.toString(), bVar2);
                } else if (stringPropertyAsJSON instanceof a) {
                    a aVar = (a) stringPropertyAsJSON;
                    return new GraphResponse(graphRequest, httpURLConnection, aVar.toString(), aVar);
                } else {
                    obj = b.NULL;
                    j.f(obj, "NULL");
                }
            }
            if (obj == b.NULL) {
                return new GraphResponse(graphRequest, httpURLConnection, obj.toString(), (b) null);
            }
            throw new FacebookException(j.p("Got unexpected object type in response, class: ", obj.getClass().getSimpleName()));
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.List<com.facebook.GraphResponse> createResponsesFromObject(java.net.HttpURLConnection r9, java.util.List<com.facebook.GraphRequest> r10, java.lang.Object r11) throws com.facebook.FacebookException, org.json.JSONException {
            /*
                r8 = this;
                int r0 = r10.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 0
                r3 = 1
                if (r0 != r3) goto L_0x0051
                java.lang.Object r3 = r10.get(r2)
                com.facebook.GraphRequest r3 = (com.facebook.GraphRequest) r3
                org.json.b r4 = new org.json.b     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                r4.<init>()     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                java.lang.String r5 = "body"
                r4.put((java.lang.String) r5, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                if (r9 != 0) goto L_0x0022
                r5 = 200(0xc8, float:2.8E-43)
                goto L_0x0026
            L_0x0022:
                int r5 = r9.getResponseCode()     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
            L_0x0026:
                java.lang.String r6 = "code"
                r4.put((java.lang.String) r6, (int) r5)     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                org.json.a r5 = new org.json.a     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                r5.<init>()     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                r5.E(r4)     // Catch:{ JSONException -> 0x0043, IOException -> 0x0034 }
                goto L_0x0052
            L_0x0034:
                r4 = move-exception
                com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r4)
                r5.<init>(r3, r9, r6)
                r1.add(r5)
                goto L_0x0051
            L_0x0043:
                r4 = move-exception
                com.facebook.GraphResponse r5 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r4)
                r5.<init>(r3, r9, r6)
                r1.add(r5)
            L_0x0051:
                r5 = r11
            L_0x0052:
                boolean r3 = r5 instanceof org.json.a
                if (r3 == 0) goto L_0x00a4
                r3 = r5
                org.json.a r3 = (org.json.a) r3
                int r4 = r3.o()
                if (r4 != r0) goto L_0x00a4
                int r0 = r3.o()
                if (r0 <= 0) goto L_0x00a3
            L_0x0065:
                int r3 = r2 + 1
                java.lang.Object r4 = r10.get(r2)
                com.facebook.GraphRequest r4 = (com.facebook.GraphRequest) r4
                r6 = r5
                org.json.a r6 = (org.json.a) r6     // Catch:{ JSONException -> 0x0090, FacebookException -> 0x0081 }
                java.lang.Object r2 = r6.get(r2)     // Catch:{ JSONException -> 0x0090, FacebookException -> 0x0081 }
                java.lang.String r6 = "obj"
                kotlin.jvm.internal.j.f(r2, r6)     // Catch:{ JSONException -> 0x0090, FacebookException -> 0x0081 }
                com.facebook.GraphResponse r2 = r8.createResponseFromObject(r4, r9, r2, r11)     // Catch:{ JSONException -> 0x0090, FacebookException -> 0x0081 }
                r1.add(r2)     // Catch:{ JSONException -> 0x0090, FacebookException -> 0x0081 }
                goto L_0x009e
            L_0x0081:
                r2 = move-exception
                com.facebook.GraphResponse r6 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r7 = new com.facebook.FacebookRequestError
                r7.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r2)
                r6.<init>(r4, r9, r7)
                r1.add(r6)
                goto L_0x009e
            L_0x0090:
                r2 = move-exception
                com.facebook.GraphResponse r6 = new com.facebook.GraphResponse
                com.facebook.FacebookRequestError r7 = new com.facebook.FacebookRequestError
                r7.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r2)
                r6.<init>(r4, r9, r7)
                r1.add(r6)
            L_0x009e:
                if (r3 < r0) goto L_0x00a1
                goto L_0x00a3
            L_0x00a1:
                r2 = r3
                goto L_0x0065
            L_0x00a3:
                return r1
            L_0x00a4:
                com.facebook.FacebookException r9 = new com.facebook.FacebookException
                java.lang.String r10 = "Unexpected number of results"
                r9.<init>((java.lang.String) r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.Companion.createResponsesFromObject(java.net.HttpURLConnection, java.util.List, java.lang.Object):java.util.List");
        }

        public final List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
            j.g(list, "requests");
            ArrayList arrayList = new ArrayList(r.t(list, 10));
            for (GraphRequest graphResponse : list) {
                arrayList.add(new GraphResponse(graphResponse, httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception) facebookException)));
            }
            return arrayList;
        }

        public final List<GraphResponse> createResponsesFromStream$facebook_core_release(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
            j.g(graphRequestBatch, "requests");
            String readStreamToString = Utility.readStreamToString(inputStream);
            Logger.Companion.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, GraphResponse.RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(readStreamToString.length()), readStreamToString);
            return createResponsesFromString$facebook_core_release(readStreamToString, httpURLConnection, graphRequestBatch);
        }

        public final List<GraphResponse> createResponsesFromString$facebook_core_release(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
            j.g(str, "responseString");
            j.g(graphRequestBatch, "requests");
            Object j10 = new h(str).j();
            j.f(j10, "resultObject");
            List<GraphResponse> createResponsesFromObject = createResponsesFromObject(httpURLConnection, graphRequestBatch, j10);
            Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", graphRequestBatch.getId(), Integer.valueOf(str.length()), createResponsesFromObject);
            return createResponsesFromObject;
        }

        public final List<GraphResponse> fromHttpConnection$facebook_core_release(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
            List<GraphResponse> constructErrorResponses;
            j.g(httpURLConnection, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
            j.g(graphRequestBatch, "requests");
            InputStream inputStream = null;
            try {
                if (FacebookSdk.isFullyInitialized()) {
                    if (httpURLConnection.getResponseCode() >= 400) {
                        inputStream = httpURLConnection.getErrorStream();
                    } else {
                        inputStream = httpURLConnection.getInputStream();
                    }
                    constructErrorResponses = createResponsesFromStream$facebook_core_release(inputStream, httpURLConnection, graphRequestBatch);
                    Utility.closeQuietly(inputStream);
                    return constructErrorResponses;
                }
                String unused = GraphResponse.TAG;
                throw new FacebookException("GraphRequest can't be used when Facebook SDK isn't fully initialized");
            } catch (FacebookException e10) {
                Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response <Error>: %s", e10);
                constructErrorResponses = constructErrorResponses(graphRequestBatch, httpURLConnection, e10);
            } catch (Exception e11) {
                Logger.Companion.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response <Error>: %s", e11);
                constructErrorResponses = constructErrorResponses(graphRequestBatch, httpURLConnection, new FacebookException((Throwable) e11));
            } catch (Throwable th2) {
                Utility.closeQuietly((Closeable) null);
                throw th2;
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/GraphResponse$PagingDirection;", "", "(Ljava/lang/String;I)V", "NEXT", "PREVIOUS", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum PagingDirection {
        NEXT,
        PREVIOUS
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, b bVar, a aVar, FacebookRequestError facebookRequestError) {
        j.g(graphRequest, "request");
        this.request = graphRequest;
        this.connection = httpURLConnection;
        this.rawResponse = str;
        this.graphObject = bVar;
        this.graphObjectArray = aVar;
        this.error = facebookRequestError;
        this.jsonObject = bVar;
        this.jsonArray = aVar;
    }

    public static final List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        return Companion.constructErrorResponses(list, httpURLConnection, facebookException);
    }

    public static final List<GraphResponse> createResponsesFromStream$facebook_core_release(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
        return Companion.createResponsesFromStream$facebook_core_release(inputStream, httpURLConnection, graphRequestBatch);
    }

    public static final List<GraphResponse> createResponsesFromString$facebook_core_release(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) throws FacebookException, JSONException, IOException {
        return Companion.createResponsesFromString$facebook_core_release(str, httpURLConnection, graphRequestBatch);
    }

    public static final List<GraphResponse> fromHttpConnection$facebook_core_release(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.fromHttpConnection$facebook_core_release(httpURLConnection, graphRequestBatch);
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    public final a getJSONArray() {
        return this.graphObjectArray;
    }

    public final b getJSONObject() {
        return this.graphObject;
    }

    public final a getJsonArray() {
        return this.jsonArray;
    }

    public final b getJsonObject() {
        return this.jsonObject;
    }

    public final String getRawResponse() {
        return this.rawResponse;
    }

    public final GraphRequest getRequest() {
        return this.request;
    }

    public final GraphRequest getRequestForPagedResults(PagingDirection pagingDirection) {
        String str;
        b optJSONObject;
        j.g(pagingDirection, "direction");
        b bVar = this.graphObject;
        if (bVar == null || (optJSONObject = bVar.optJSONObject(FacebookParse.FB_PARAM_PAGING)) == null) {
            str = null;
        } else if (pagingDirection == PagingDirection.NEXT) {
            str = optJSONObject.optString(FacebookParse.FB_PARAM_NEXT);
        } else {
            str = optJSONObject.optString("previous");
        }
        if (Utility.isNullOrEmpty(str)) {
            return null;
        }
        if (str != null && j.b(str, this.request.getUrlForSingleRequest())) {
            return null;
        }
        try {
            return new GraphRequest(this.request.getAccessToken(), new URL(str));
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public String toString() {
        String str;
        int i10;
        try {
            o oVar = o.f32141a;
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            HttpURLConnection httpURLConnection = this.connection;
            if (httpURLConnection == null) {
                i10 = 200;
            } else {
                i10 = httpURLConnection.getResponseCode();
            }
            objArr[0] = Integer.valueOf(i10);
            str = String.format(locale, "%d", Arrays.copyOf(objArr, 1));
            j.f(str, "java.lang.String.format(locale, format, *args)");
        } catch (IOException unused) {
            str = "unknown";
        }
        String str2 = "{Response: " + " responseCode: " + str + ", graphObject: " + this.graphObject + ", error: " + this.error + "}";
        j.f(str2, "StringBuilder()\n        .append(\"{Response: \")\n        .append(\" responseCode: \")\n        .append(responseCode)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", error: \")\n        .append(error)\n        .append(\"}\")\n        .toString()");
        return str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, b bVar) {
        this(graphRequest, httpURLConnection, str, bVar, (a) null, (FacebookRequestError) null);
        j.g(graphRequest, "request");
        j.g(str, "rawResponse");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, a aVar) {
        this(graphRequest, httpURLConnection, str, (b) null, aVar, (FacebookRequestError) null);
        j.g(graphRequest, "request");
        j.g(str, "rawResponse");
        j.g(aVar, "graphObjects");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, (String) null, (b) null, (a) null, facebookRequestError);
        j.g(graphRequest, "request");
        j.g(facebookRequestError, "error");
    }
}
