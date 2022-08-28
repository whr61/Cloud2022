package com.whr.springcloud.thread;

/**
 * @author Reed
 * @Description
 * @date 2022/8/2 21:05
 **/

public class StacticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}
interface Marry{
    void HappyMarry();
}
class You implements Marry{
    @Override
    public void HappyMarry(){
        System.out.println("我要结婚了");
    }
}
class WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void HappyMarry(){
        before();
        this.target.HappyMarry();
        after();
    }
    private void before(){
        System.out.println("结婚前布置");
    }
    private void after(){
        System.out.println("结婚后洞房");
    }
}