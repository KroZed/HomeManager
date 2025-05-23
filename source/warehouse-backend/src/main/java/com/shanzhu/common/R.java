package com.shanzhu.common;

/**
 * 接口返回包装
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
public class R {

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 数据
     */
    private Object data;

    public static R fail(){
        return result(400,"失败",0L,null);
    }

    public static R success(){
        return result(200,"成功",0L,null);
    }

    public static R success(Object data){
        return result(200,"成功",0L,data);
    }

    public static R success(Object data, Long total){
        return result(200,"成功",total,data);
    }

    private static R result(int code, String msg, Long total, Object data){
        R res = new R();
        res.setData(data);
        res.setMsg(msg);
        res.setCode(code);
        res.setTotal(total);
        return res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
