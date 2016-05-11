package com.bill99.ian.controller.remote;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReceiveFromKouBei {

	@RequestMapping(value="/testq", method=RequestMethod.GET)
	public ModelAndView pageNotify(HttpServletRequest request, HttpServletResponse response) {
		//消息报文解析处理-TODO
		ModelAndView view = new ModelAndView();
		view.addObject("key", "value");
		return view;
	}
	
	/**
	 * 后台通知
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/testr", method=RequestMethod.POST)
	public void backNotify(HttpServletRequest request, HttpServletResponse response) {
		//消息报文解析处理-TODO
		
		//回送同步应答消息-TODO
	}
}
