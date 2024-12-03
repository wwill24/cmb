package org.jivesoftware.smackx.address;

import java.util.List;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jxmpp.jid.Jid;

public class MultipleRecipientInfo {
    MultipleAddresses extension;

    MultipleRecipientInfo(MultipleAddresses multipleAddresses) {
        this.extension = multipleAddresses;
    }

    public List<MultipleAddresses.Address> getCCAddresses() {
        return this.extension.getAddressesOfType(MultipleAddresses.Type.cc);
    }

    public MultipleAddresses.Address getReplyAddress() {
        List<MultipleAddresses.Address> addressesOfType = this.extension.getAddressesOfType(MultipleAddresses.Type.replyto);
        if (addressesOfType.isEmpty()) {
            return null;
        }
        return addressesOfType.get(0);
    }

    public Jid getReplyRoom() {
        List<MultipleAddresses.Address> addressesOfType = this.extension.getAddressesOfType(MultipleAddresses.Type.replyroom);
        if (addressesOfType.isEmpty()) {
            return null;
        }
        return addressesOfType.get(0).getJid();
    }

    public List<MultipleAddresses.Address> getTOAddresses() {
        return this.extension.getAddressesOfType(MultipleAddresses.Type.to);
    }

    public boolean shouldNotReply() {
        return !this.extension.getAddressesOfType(MultipleAddresses.Type.noreply).isEmpty();
    }
}
