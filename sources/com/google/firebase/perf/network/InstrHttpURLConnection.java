package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public final class InstrHttpURLConnection extends HttpURLConnection {
    private final InstrURLConnectionBase delegate;

    InstrHttpURLConnection(HttpURLConnection httpURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        super(httpURLConnection.getURL());
        this.delegate = new InstrURLConnectionBase(httpURLConnection, timer, networkRequestMetricBuilder);
    }

    public void addRequestProperty(String str, String str2) {
        this.delegate.addRequestProperty(str, str2);
    }

    public void connect() throws IOException {
        this.delegate.connect();
    }

    public void disconnect() {
        this.delegate.disconnect();
    }

    public boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    public boolean getAllowUserInteraction() {
        return this.delegate.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.delegate.getConnectTimeout();
    }

    public Object getContent() throws IOException {
        return this.delegate.getContent();
    }

    public String getContentEncoding() {
        return this.delegate.getContentEncoding();
    }

    public int getContentLength() {
        return this.delegate.getContentLength();
    }

    public long getContentLengthLong() {
        return this.delegate.getContentLengthLong();
    }

    public String getContentType() {
        return this.delegate.getContentType();
    }

    public long getDate() {
        return this.delegate.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.delegate.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.delegate.getDoInput();
    }

    public boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }

    public InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }

    public long getExpiration() {
        return this.delegate.getExpiration();
    }

    public String getHeaderField(int i10) {
        return this.delegate.getHeaderField(i10);
    }

    public long getHeaderFieldDate(String str, long j10) {
        return this.delegate.getHeaderFieldDate(str, j10);
    }

    public int getHeaderFieldInt(String str, int i10) {
        return this.delegate.getHeaderFieldInt(str, i10);
    }

    public String getHeaderFieldKey(int i10) {
        return this.delegate.getHeaderFieldKey(i10);
    }

    public long getHeaderFieldLong(String str, long j10) {
        return this.delegate.getHeaderFieldLong(str, j10);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.delegate.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.delegate.getIfModifiedSince();
    }

    public InputStream getInputStream() throws IOException {
        return this.delegate.getInputStream();
    }

    public boolean getInstanceFollowRedirects() {
        return this.delegate.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.delegate.getOutputStream();
    }

    public Permission getPermission() throws IOException {
        return this.delegate.getPermission();
    }

    public int getReadTimeout() {
        return this.delegate.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.delegate.getRequestProperties();
    }

    public String getRequestProperty(String str) {
        return this.delegate.getRequestProperty(str);
    }

    public int getResponseCode() throws IOException {
        return this.delegate.getResponseCode();
    }

    public String getResponseMessage() throws IOException {
        return this.delegate.getResponseMessage();
    }

    public URL getURL() {
        return this.delegate.getURL();
    }

    public boolean getUseCaches() {
        return this.delegate.getUseCaches();
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public void setAllowUserInteraction(boolean z10) {
        this.delegate.setAllowUserInteraction(z10);
    }

    public void setChunkedStreamingMode(int i10) {
        this.delegate.setChunkedStreamingMode(i10);
    }

    public void setConnectTimeout(int i10) {
        this.delegate.setConnectTimeout(i10);
    }

    public void setDefaultUseCaches(boolean z10) {
        this.delegate.setDefaultUseCaches(z10);
    }

    public void setDoInput(boolean z10) {
        this.delegate.setDoInput(z10);
    }

    public void setDoOutput(boolean z10) {
        this.delegate.setDoOutput(z10);
    }

    public void setFixedLengthStreamingMode(int i10) {
        this.delegate.setFixedLengthStreamingMode(i10);
    }

    public void setIfModifiedSince(long j10) {
        this.delegate.setIfModifiedSince(j10);
    }

    public void setInstanceFollowRedirects(boolean z10) {
        this.delegate.setInstanceFollowRedirects(z10);
    }

    public void setReadTimeout(int i10) {
        this.delegate.setReadTimeout(i10);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        this.delegate.setRequestMethod(str);
    }

    public void setRequestProperty(String str, String str2) {
        this.delegate.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z10) {
        this.delegate.setUseCaches(z10);
    }

    public String toString() {
        return this.delegate.toString();
    }

    public boolean usingProxy() {
        return this.delegate.usingProxy();
    }

    public Object getContent(Class[] clsArr) throws IOException {
        return this.delegate.getContent(clsArr);
    }

    public String getHeaderField(String str) {
        return this.delegate.getHeaderField(str);
    }

    public void setFixedLengthStreamingMode(long j10) {
        this.delegate.setFixedLengthStreamingMode(j10);
    }
}
