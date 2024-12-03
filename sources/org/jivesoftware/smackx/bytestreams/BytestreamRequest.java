package org.jivesoftware.smackx.bytestreams;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5Exception;
import org.jxmpp.jid.Jid;

public interface BytestreamRequest {
    BytestreamSession accept() throws InterruptedException, XMPPException.XMPPErrorException, Socks5Exception.CouldNotConnectToAnyProvidedSocks5Host, SmackException.NotConnectedException, Socks5Exception.NoSocks5StreamHostsProvided;

    Jid getFrom();

    String getSessionID();

    void reject() throws SmackException.NotConnectedException, InterruptedException;
}
