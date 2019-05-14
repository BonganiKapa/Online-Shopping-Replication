package bk.pnp.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView Home(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	@RequestMapping(value = "/shop-by")
	public ModelAndView shopBy(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "SHOP-BY");
		mv.addObject("userClickShopBy", true);
		return mv;
	}
	@RequestMapping(value = "/specials")
	public ModelAndView specials(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "SPECIALS");
		mv.addObject("userClickSpecials", true);
		return mv;
	}
	@RequestMapping(value = "/recipes")
	public ModelAndView recipes(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "RECIPES");
		mv.addObject("userClickRecipes", true);
		return mv;
	}
	@RequestMapping(value = "/competition")
	public ModelAndView competition(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "COMPETITION");
		mv.addObject("userClickCompetiontion", true);
		return mv;
	}
	@RequestMapping(value = "/inStoreCatalogue")
	public ModelAndView catalogue(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "IN-STRORE CATALOGUE");
		mv.addObject("userClickCatalogue", true);
		return mv;
	}
}
