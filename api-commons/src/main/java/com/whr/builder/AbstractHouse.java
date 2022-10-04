package com.whr.builder;

public abstract class AbstractHouse {

    //打地基
    public abstract void buildBasic();
    //砌墙
    public abstract void buildWalls() ;
    //封顶
    public abstract void roofed();
    //建造
    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}
