/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.fycoder.ll.web.tls;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fycoder.ll.dyentity.Tls;
import com.fycoder.ll.entity.Task;
import com.fycoder.ll.entity.User;
import com.fycoder.ll.service.account.ShiroDbRealm.ShiroUser;
import com.fycoder.ll.service.task.TaskService;
import com.fycoder.ll.service.tls.TlsService;

import org.springside.modules.web.Servlets;

import com.google.common.collect.Maps;

/**
 * Tls管理的Controller, 使用Restful风格的Urls:
 * 
 * {{var}} = tls
 * 
 * List page : GET /{{var}}/
 * Create page : GET /{{var}}/create
 * Create action : POST /{{var}}/create
 * Update page : GET /{{var}}/update/{id}
 * Update action : POST /{{var}}/update
 * Delete action : GET /{{var}}/delete/{id}
 * 
 * @author liuy
 */
@Controller
@RequestMapping(value = "/tls")
public class TlsController {

	private static final String PAGE_SIZE = "3";

	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("tablename", "标题");
	}

	@Autowired
	private TlsService tlsService;

	 
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			ServletRequest request) {
		System.out.println("---------tls--------list");
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		Long userId = getCurrentUserId();
		//Page<Task> tasks = tlsService.getUserTask(userId, searchParams, pageNumber, pageSize, sortType);
		//Page<Tls> tls = tlsService.getUserTls(userId, searchParams, pageNumber, pageSize, sortType);
		Page<Tls> tlss = tlsService.getUserTls(userId,   pageNumber, pageSize, sortType);
		model.addAttribute("tlss", tlss);
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", sortTypes);
		// 将搜索条件编码成字符串，用于排序，分页的URL
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));

		return "tls/tlsList";
	}

//	@RequestMapping(value = "create", method = RequestMethod.GET)
//	public String createForm(Model model) {
//		model.addAttribute("task", new Task());
//		model.addAttribute("action", "create");
//		return "tls/tlsForm";
//	}
//
//	@RequestMapping(value = "create", method = RequestMethod.POST)
//	public String create(@Valid Task newTask, RedirectAttributes redirectAttributes) {
//		User user = new User(getCurrentUserId());
//		newTask.setUser(user);
//
//		//tlsService.saveTask(newTask);
//		redirectAttributes.addFlashAttribute("message", "创建任务成功");
//		return "redirect:/tls/";
//	}
//
//	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
//	public String updateForm(@PathVariable("id") Long id, Model model) {
//		//model.addAttribute("tls", tlsService.getTask(id));
//		model.addAttribute("action", "update");
//		return "tls/tlsForm";
//	}
//
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String update(@Valid @ModelAttribute("tls") Tls tls, RedirectAttributes redirectAttributes) {
//		//tlsService.saveTask(tls);
//		redirectAttributes.addFlashAttribute("message", "更新任务成功");
//		return "redirect:/tls/";
//	}
//
//	@RequestMapping(value = "delete/{id}")
//	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
//		//tlsService.deleteTask(id);
//		redirectAttributes.addFlashAttribute("message", "删除任务成功");
//		return "redirect:/task/";
//	}
//
//	/**
//	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
//	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
//	 */
//	@ModelAttribute
//	public void getTask(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
//		if (id != -1) {
//			//model.addAttribute("task", tlsService.getTask(id));
//		}
//	}

	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
}
