package win.namespace.print.besttalk.MsgPackage;

/**
 * Created by print on 2017/3/15.
 */

public class Msg {

    //类型
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    //私有
    private String content;
    private int type;

    //初始化构造方式
    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
