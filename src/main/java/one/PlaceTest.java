package one;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 位运算控制权限
 */
public class PlaceTest {
    //    是否允许查询，1表示是，0表示否
    private static final int ALLOW_SELECT=1<<0;
    //    是否允许新增，1表示是，0表示否
    private static final int ALLOW_INSERT=1<<1;
    //    是否允许修改，1表示是，0表示否
    private static final int ALLOW_UPDATE=1<<2;
    //    是否允许删除，1表示是，0表示否
    private static final int ALLOW_DELETE=1<<3;
    //拥有的权限
    private int flag;

//    设置权限
    public void setPer(int per){
        flag=per;
    }
//    增加权限
    public void enable(int per){
        flag = flag|per;
    }
//    删除权限
    public void disable(int per){
        flag = flag&~per;
    }
//    判断是否有权限
    public boolean isAllow(int per){
        return (flag&per)==per;
    }
    public boolean isNotAllow(int per){
        return (flag&per)==0;
    }

    public static void main(String[] args){
        int flag = 15;
        PlaceTest p = new PlaceTest();
        p.setPer(flag);
        System.out.println("select = "+p.isAllow(ALLOW_SELECT));
        String s = "s";
        System.out.println(s.hashCode());
    }
}
