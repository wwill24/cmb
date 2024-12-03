package com.facebook.stetho.dumpapp;

import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import com.facebook.stetho.server.http.LightHttpServer;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Deprecated
public class DumpappHttpSocketLikeHandler implements SocketLikeHandler {
    private final LightHttpServer mServer;

    private static class DumpappLegacyHttpHandler implements HttpHandler {
        private static final String CONTENT_TYPE = "application/octet-stream";
        private static final String QUERY_PARAM_ARGV = "argv";
        private static final String RESPONSE_HEADER_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
        private final Dumper mDumper;

        public DumpappLegacyHttpHandler(Dumper dumper) {
            this.mDumper = dumper;
        }

        public boolean handleRequest(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) throws IOException {
            boolean z10;
            String str;
            boolean equals = "POST".equals(lightHttpRequest.method);
            if (equals || !"GET".equals(lightHttpRequest.method)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 || equals) {
                List<String> queryParameters = lightHttpRequest.uri.getQueryParameters(QUERY_PARAM_ARGV);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Framer framer = new Framer(new ByteArrayInputStream(new byte[0]), byteArrayOutputStream);
                if (equals) {
                    str = "ERROR";
                } else {
                    str = "WARNING";
                }
                framer.getStderr().println("*** " + str + ": Using legacy HTTP protocol; update dumpapp script! ***");
                if (z10) {
                    DumpappSocketLikeHandler.dump(this.mDumper, framer, (String[]) queryParameters.toArray(new String[queryParameters.size()]));
                } else {
                    framer.writeExitCode(1);
                }
                lightHttpResponse.code = 200;
                lightHttpResponse.reasonPhrase = MessageTemplateConstants.Values.OK_TEXT;
                lightHttpResponse.addHeader(RESPONSE_HEADER_ALLOW_ORIGIN, "*");
                lightHttpResponse.body = LightHttpBody.create(byteArrayOutputStream.toByteArray(), CONTENT_TYPE);
            } else {
                lightHttpResponse.code = HttpStatus.HTTP_NOT_IMPLEMENTED;
                lightHttpResponse.reasonPhrase = "Not implemented";
                lightHttpResponse.body = LightHttpBody.create(lightHttpRequest.method + " not implemented", "text/plain");
            }
            return true;
        }
    }

    public DumpappHttpSocketLikeHandler(Dumper dumper) {
        HandlerRegistry handlerRegistry = new HandlerRegistry();
        handlerRegistry.register(new ExactPathMatcher("/dumpapp"), new DumpappLegacyHttpHandler(dumper));
        this.mServer = new LightHttpServer(handlerRegistry);
    }

    public void onAccepted(SocketLike socketLike) throws IOException {
        this.mServer.serve(socketLike);
    }
}
