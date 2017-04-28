package com.lk.ofo.enums;

/**
 * Created by luokai on 2017/4/21.
 */
public enum DestroyBicycleEnum {

    BICYCLE_DESTROY_TYPE0(0, "已修复"),
    BICYCLE_DESTROY_TYPE1(1, "私锁私用"),
    BICYCLE_DESTROY_TYPE2(2, "车牌损坏"),
    BICYCLE_DESTROY_TYPE3(3, "轮胎坏了"),
    BICYCLE_DESTROY_TYPE4(4, "违章乱停"),
    BICYCLE_DESTROY_TYPE5(5, "密码不对"),
    BICYCLE_DESTROY_TYPE6(6, "车锁坏了"),
    BICYCLE_DESTROY_TYPE7(7, "刹车坏了"),
    BICYCLE_DESTROY_TYPE8(8, "其他原因");


    private int state;

    private String msg;

    DestroyBicycleEnum(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

    public static DestroyBicycleEnum stateOf(int index) {
        for (DestroyBicycleEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
