package com.cloud.wzx.common.vo.mail;

import com.sun.istack.internal.NotNull;
import lombok.ToString;

@ToString
public class MailVO {
    @NotNull
    private String address;
    @NotNull
    private String context;
    @NotNull
    private String title;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
