package com.google.firebase.database.connection;

import com.google.firebase.database.connection.WebsocketConnection;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.util.HashMap;
import java.util.Map;

class Connection implements WebsocketConnection.Delegate {
    private static final String REQUEST_PAYLOAD = "d";
    private static final String REQUEST_TYPE = "t";
    private static final String REQUEST_TYPE_DATA = "d";
    private static final String SERVER_CONTROL_MESSAGE = "c";
    private static final String SERVER_CONTROL_MESSAGE_DATA = "d";
    private static final String SERVER_CONTROL_MESSAGE_HELLO = "h";
    private static final String SERVER_CONTROL_MESSAGE_RESET = "r";
    private static final String SERVER_CONTROL_MESSAGE_SHUTDOWN = "s";
    private static final String SERVER_CONTROL_MESSAGE_TYPE = "t";
    private static final String SERVER_DATA_MESSAGE = "d";
    private static final String SERVER_ENVELOPE_DATA = "d";
    private static final String SERVER_ENVELOPE_TYPE = "t";
    private static final String SERVER_HELLO_HOST = "h";
    private static final String SERVER_HELLO_SESSION_ID = "s";
    private static final String SERVER_HELLO_TIMESTAMP = "ts";
    private static long connectionIds;
    private WebsocketConnection conn;
    private Delegate delegate;
    private HostInfo hostInfo;
    private final LogWrapper logger;
    private State state = State.REALTIME_CONNECTING;

    public interface Delegate {
        void onCacheHost(String str);

        void onDataMessage(Map<String, Object> map);

        void onDisconnect(DisconnectReason disconnectReason);

        void onKill(String str);

        void onReady(long j10, String str);
    }

    public enum DisconnectReason {
        SERVER_RESET,
        OTHER
    }

    private enum State {
        REALTIME_CONNECTING,
        REALTIME_CONNECTED,
        REALTIME_DISCONNECTED
    }

    public Connection(ConnectionContext connectionContext, HostInfo hostInfo2, String str, Delegate delegate2, String str2, String str3) {
        long j10 = connectionIds;
        connectionIds = 1 + j10;
        this.hostInfo = hostInfo2;
        this.delegate = delegate2;
        Logger logger2 = connectionContext.getLogger();
        this.logger = new LogWrapper(logger2, "Connection", "conn_" + j10);
        this.conn = new WebsocketConnection(connectionContext, hostInfo2, str, str3, this, str2);
    }

    private void onConnectionReady(long j10, String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("realtime connection established", new Object[0]);
        }
        this.state = State.REALTIME_CONNECTED;
        this.delegate.onReady(j10, str);
    }

    private void onConnectionShutdown(String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.delegate.onKill(str);
        close();
    }

    private void onControlMessage(Map<String, Object> map) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("Got control message: " + map.toString(), new Object[0]);
        }
        try {
            String str = (String) map.get("t");
            if (str == null) {
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper2 = this.logger;
                    logWrapper2.debug("Got invalid control message: " + map.toString(), new Object[0]);
                }
                close();
            } else if (str.equals("s")) {
                onConnectionShutdown((String) map.get("d"));
            } else if (str.equals("r")) {
                onReset((String) map.get("d"));
            } else if (str.equals("h")) {
                onHandshake((Map) map.get("d"));
            } else if (this.logger.logsDebug()) {
                LogWrapper logWrapper3 = this.logger;
                logWrapper3.debug("Ignoring unknown control message: " + str, new Object[0]);
            }
        } catch (ClassCastException e10) {
            if (this.logger.logsDebug()) {
                LogWrapper logWrapper4 = this.logger;
                logWrapper4.debug("Failed to parse control message: " + e10.toString(), new Object[0]);
            }
            close();
        }
    }

    private void onDataMessage(Map<String, Object> map) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("received data message: " + map.toString(), new Object[0]);
        }
        this.delegate.onDataMessage(map);
    }

    private void onHandshake(Map<String, Object> map) {
        long longValue = ((Long) map.get(SERVER_HELLO_TIMESTAMP)).longValue();
        this.delegate.onCacheHost((String) map.get("h"));
        String str = (String) map.get("s");
        if (this.state == State.REALTIME_CONNECTING) {
            this.conn.start();
            onConnectionReady(longValue, str);
        }
    }

    private void onReset(String str) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("Got a reset; killing connection to " + this.hostInfo.getHost() + "; Updating internalHost to " + str, new Object[0]);
        }
        this.delegate.onCacheHost(str);
        close(DisconnectReason.SERVER_RESET);
    }

    private void sendData(Map<String, Object> map, boolean z10) {
        if (this.state != State.REALTIME_CONNECTED) {
            this.logger.debug("Tried to send on an unconnected connection", new Object[0]);
            return;
        }
        if (z10) {
            this.logger.debug("Sending data (contents hidden)", new Object[0]);
        } else {
            this.logger.debug("Sending data: %s", map);
        }
        this.conn.send(map);
    }

    public void close(DisconnectReason disconnectReason) {
        State state2 = this.state;
        State state3 = State.REALTIME_DISCONNECTED;
        if (state2 != state3) {
            if (this.logger.logsDebug()) {
                this.logger.debug("closing realtime connection", new Object[0]);
            }
            this.state = state3;
            WebsocketConnection websocketConnection = this.conn;
            if (websocketConnection != null) {
                websocketConnection.close();
                this.conn = null;
            }
            this.delegate.onDisconnect(disconnectReason);
        }
    }

    public void injectConnectionFailure() {
        close();
    }

    public void onDisconnect(boolean z10) {
        this.conn = null;
        if (z10 || this.state != State.REALTIME_CONNECTING) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Realtime connection lost", new Object[0]);
            }
        } else if (this.logger.logsDebug()) {
            this.logger.debug("Realtime connection failed", new Object[0]);
        }
        close();
    }

    public void onMessage(Map<String, Object> map) {
        try {
            String str = (String) map.get("t");
            if (str == null) {
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    logWrapper.debug("Failed to parse server message: missing message type:" + map.toString(), new Object[0]);
                }
                close();
            } else if (str.equals("d")) {
                onDataMessage((Map) map.get("d"));
            } else if (str.equals("c")) {
                onControlMessage((Map) map.get("d"));
            } else if (this.logger.logsDebug()) {
                LogWrapper logWrapper2 = this.logger;
                logWrapper2.debug("Ignoring unknown server message type: " + str, new Object[0]);
            }
        } catch (ClassCastException e10) {
            if (this.logger.logsDebug()) {
                LogWrapper logWrapper3 = this.logger;
                logWrapper3.debug("Failed to parse server message: " + e10.toString(), new Object[0]);
            }
            close();
        }
    }

    public void open() {
        if (this.logger.logsDebug()) {
            this.logger.debug("Opening a connection", new Object[0]);
        }
        this.conn.open();
    }

    public void sendRequest(Map<String, Object> map, boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("t", "d");
        hashMap.put("d", map);
        sendData(hashMap, z10);
    }

    public void close() {
        close(DisconnectReason.OTHER);
    }
}
