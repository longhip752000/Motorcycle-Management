/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.utils;

/**
 *
 * @author longh
 */
public class Notification {
    private boolean result;
    private String msg;
    private Object data;

    public Notification() {
    }

    public Notification(boolean result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public Notification(boolean result, String msg, Object data) {
        this.result = result;
        this.msg = msg;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
