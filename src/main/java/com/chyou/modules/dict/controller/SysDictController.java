package com.chyou.modules.dict.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chyou.common.web.BaseController;
import com.chyou.modules.dict.entity.SysDictBean;
import com.chyou.modules.dict.service.SysDictService;

/**
* Created by zhangbowen on 2015-8-11.
*/
@Controller
public class SysDictController extends BaseController {
    @Autowired
    private SysDictService sysDictService;

    @RequestMapping(value = "${adminPath}/dict/getOne", method = RequestMethod.GET)
    public String get(String id) {
    	this.sysDictService.get(id);
        return "/modules/dic/sysdict_list";
    }

}
