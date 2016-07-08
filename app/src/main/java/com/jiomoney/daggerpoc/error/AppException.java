package com.jiomoney.daggerpoc.error;

/**
 * Created by AnkitGarg on 07/07/16.
 */
public class AppException extends Exception {

    private Throwable t;

    public AppException(Throwable t) {
        this.t = t;
    }

    public Throwable getT() {
        return t;
    }

    public void setT(Throwable t) {
        this.t = t;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppException{");
        sb.append("t=").append(t.getMessage());
        sb.append('}');
        return sb.toString();
    }
}
