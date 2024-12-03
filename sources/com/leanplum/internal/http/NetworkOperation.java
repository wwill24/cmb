package com.leanplum.internal.http;

import android.net.Uri;
import com.leanplum.internal.Constants;
import com.leanplum.internal.Log;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class NetworkOperation extends LeanplumHttpConnection {
    public NetworkOperation(String str, String str2, boolean z10, int i10) throws IOException {
        initConnection(str, str2, z10, i10);
    }

    private static String attachGetParameters(String str, Map<String, Object> map) {
        if (map == null) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() != null) {
                buildUpon.appendQueryParameter((String) next.getKey(), next.getValue().toString());
            }
        }
        return buildUpon.build().toString();
    }

    private void attachPostParameters(Map<String, Object> map) throws IOException {
        OutputStream outputStream = this.urlConnection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        bufferedWriter.write(getQuery(map));
        bufferedWriter.close();
        outputStream.close();
    }

    private static String getQuery(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() == null) {
                Log.d("Request parameter for key: " + ((String) next.getKey()) + " is null.", new Object[0]);
            } else {
                builder.appendQueryParameter((String) next.getKey(), next.getValue().toString());
            }
        }
        return builder.build().getEncodedQuery();
    }

    public NetworkOperation(String str, String str2, Map<String, Object> map, String str3, boolean z10, int i10) throws IOException {
        str2 = "GET".equals(str3) ? attachGetParameters(str2, map) : str2;
        initConnection(str, str2, str3, z10, i10);
        if ("POST".equals(str3)) {
            attachPostParameters(map);
        }
        if (Constants.enableVerboseLoggingInDevelopmentMode && Constants.isDevelopmentModeEnabled) {
            Log.d("Sending request at path " + str2 + " with parameters " + map, new Object[0]);
        }
    }
}
