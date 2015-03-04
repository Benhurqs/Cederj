package br.com.benhurqs.cederj.obj;

import br.com.benhurqs.cederj.enums.MessageType;

/**
 * Created by benhur on 04/03/15.
 */
public class ChatObj {

    private String msg;
    private MessageType type;

    public ChatObj(String msg, MessageType type) {
        this.msg = msg;
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
