package com.chyou.modules.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.chyou.common.utils.StringUtils;
import com.chyou.common.web.BaseController;
import com.chyou.modules.sys.entity.Dict;
import com.chyou.modules.sys.service.DictService;

/**
 * 字典Controller
 * @author ThinkGem
 * @version 2014-05-16
 */
@Controller
@RequestMapping(value = "/sys/dict")
public class DictController extends BaseController {

	@Autowired
	private DictService dictService;
	
	@ModelAttribute
	public Dict get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return dictService.get(id);
		}else{
			return new Dict();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Dict dict, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<String> typeList = dictService.findTypeList();
		model.addAttribute("typeList", typeList);
        //Page<Dict> page = dictService.findPage(new Page<Dict>(request, response), dict); 
        //model.addAttribute("page", page);
		return "modules/sys/dictList";
	}

	@RequestMapping(value = "form")
	public String form(Dict dict, Model model) {
		model.addAttribute("dict", dict);
		return "modules/sys/dictForm";
	}

	@RequestMapping(value = "save")//@Valid 
	public String save(Dict dict, Model model, RedirectAttributes redirectAttributes) {
		dictService.save(dict);
		return "redirect:/sys/dict/?repage&type="+dict.getType();
	}
	
	@RequestMapping(value = "delete")
	public String delete(Dict dict, RedirectAttributes redirectAttributes) {
		dictService.delete(dict.getId());
		return "redirect:/sys/dict/?repage&type="+dict.getType();
	}
	
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String type, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
//		Dict dict = new Dict();
//		dict.setType(type);
//		List<Dict> list = dictService.findList(dict);
//		for (int i=0; i<list.size(); i++){
//			Dict e = list.get(i);
//			Map<String, Object> map = Maps.newHashMap();
//			map.put("id", e.getId());
//			map.put("pId", e.getParentId());
//			map.put("name", StringUtils.replace(e.getLabel(), " ", ""));
//			mapList.add(map);
//		}
		return mapList;
	}
	
//	@ResponseBody
//	@RequestMapping(value = "listData")
//	public List<Dict> listData(@RequestParam(required=false) String type) {
////		Dict dict = new Dict();
////		dict.setType(type);
////		return dictService.findList(dict);
//	}

}
