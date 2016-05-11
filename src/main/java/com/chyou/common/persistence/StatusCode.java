package com.chyou.common.persistence;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.chyou.common.persistence.annotation.CodeAnnot;

/**
 * Created by zhangbowen on 2015/6/24.
 */
public enum StatusCode {

    @CodeAnnot("正确处理")OK(1),
    @CodeAnnot("无数据")EMPTY(0),
    @CodeAnnot("失败")ERROR(-1),
    @CodeAnnot("参数非法")VALIDATION_FAILED(-2),
    @CodeAnnot("验证码发送失败")SEND_CODE_ERROR(-3),
    @CodeAnnot("账号密码错误")LOGIN_ERROR(-4),
    @CodeAnnot("手机号已注册")USER_EXTIS(-5),
    @CodeAnnot("验证码校验失败")CODE_ERROR(-6),
    @CodeAnnot("验证码已过期")CODE_TIMEOUT(-7),
    @CodeAnnot("请填写密码")PASS_EMPTY(-9),
    @CodeAnnot("用户不存在")USER_NO_EXITS(-11),
    @CodeAnnot("您未登录，请登录")NOT_AUTHORITY(-15),
    @CodeAnnot("在其他地方登录") LOGOUT(-16),
    @CodeAnnot("没有权限")NOT_AUTHORITY_PHNOE(401),
    @CodeAnnot("昵称已存在")NICK_EXITS(-17),
    @CodeAnnot("请输入昵称")NICK_BLANK(-18),
    @CodeAnnot("您的账号已被查封")USER_ATTACHMENT(-19),
    @CodeAnnot("产品不存在")PRODUCT_NOT_EXITS(-20),
    @CodeAnnot("商品信息发生变化!")PRODUCT_UPDATE(-21),
    @CodeAnnot("没有匹配的店铺!")NO_SEARCH_SHOP(-22),
    @CodeAnnot("订单价格有误!")PRICE_UPDATE(-23),
    @CodeAnnot("红包信息有误!")RED_ERRORS(-24),
    @CodeAnnot("兑换码不存在或已过期！")RED_SEARCH_NO(-25),
    @CodeAnnot("不能再多领了!")RED_NUM(-29),
    @CodeAnnot("订单状态不正确!")ORDER_STATUS_ERRORS(-26),
    @CodeAnnot("订单取消信息正在审核中!")CANCEL_REPEAT(-27),
    @CodeAnnot("密码错误!")PASSWORD_ERROR(-28),
    @CodeAnnot("订单状态发生变化!")ORRDER_STATUS_UPDATE(-29),
    @CodeAnnot("送货员未出发!")COURIER_NO_START(-30)
    ;


    
    private static final Map<String, String> hMap = new HashMap<String, String>();

    static {
        Field[] fields = StatusCode.class.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CodeAnnot.class)) {
                hMap.put(field.getName(), field.getAnnotation(CodeAnnot.class).value());
            }
        }
    }

    private final int value;

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    StatusCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String GetDescription() {
        return hMap.get(this.toString());
    }
}
