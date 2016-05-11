package com.chyou.modules.sys.utils;

import com.chyou.common.utils.CacheUtils;
import com.chyou.common.utils.SpringContextHolder;
import com.chyou.modules.sys.dao.DictDao;
import com.chyou.modules.sys.entity.Dict;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 字典工具类
 *
 * @author chengyou
 * @version 2013-5-29
 */
public class DictUtils {

    private static DictDao dictDao = SpringContextHolder.getBean(DictDao.class);
    public static final String CACHE_DICT_MAP = "dictMap";

    /**
     * 类型，值查询标题
     *
     * @param value        值
     * @param type         类型
     * @param defaultValue 默认值
     * @return
     */
    public static String getDictLabel(String value, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && value.equals(dict.getValue())) {
                    return dict.getLabel();
                }
            }
        }
        return defaultValue;
    }

    /**
     * 类型，值查询标题
     *
     * @param values
     * @param type
     * @param defaultValue
     * @return
     */
    public static String getDictLabels(String values, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)) {
            List<String> valueList = Lists.newArrayList();
            for (String value : StringUtils.split(values, ",")) {
                valueList.add(getDictLabel(value, type, defaultValue));
            }
            return StringUtils.join(valueList, ",");
        }
        return defaultValue;
    }

    /**
     * 标题，类型查询值
     *
     * @param label        标题
     * @param type         类型
     * @param defaultLabel
     * @return
     */
    public static String getDictValue(String label, String type, String defaultLabel) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())) {
                    return dict.getValue();
                }
            }
        }
        return defaultLabel;
    }

    /**
     * 类型查询字典列表
     *
     * @param type 类型
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Dict> getDictList(String type) {
        Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>) CacheUtils.get(CACHE_DICT_MAP);
        if (dictMap == null) {
            dictMap = Maps.newHashMap();
            Dict d = new Dict();
            for (Dict dict : dictDao.findList(d)) {
                List<Dict> dictList = dictMap.get(dict.getType());
                if (dictList != null) {
                    dictList.add(dict);
                } else {
                    dictMap.put(dict.getType(), Lists.newArrayList(dict));
                }
            }
            CacheUtils.put(CACHE_DICT_MAP, dictMap);
        }
        List<Dict> dictList = dictMap.get(type);
        if (dictList == null) {
            dictList = Lists.newArrayList();
        }
        return dictList;
    }

    /**
     * 获取lables
     * @param type
     * @return
     */
    public static List<String> getDicLabelList(String type) {
        List<Dict> dictList = DictUtils.getDictList(type);
        List<String> dictStrList = new ArrayList<String>();
        for (Dict dict : dictList) {
            dictStrList.add(dict.getLabel());
        }
        return dictStrList;
    }

}
