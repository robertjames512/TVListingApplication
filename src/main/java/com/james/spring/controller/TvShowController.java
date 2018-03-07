package com.james.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.james.spring.model.TvShow;
import com.james.spring.service.TvShowService;



@Controller
public class TvShowController {
	
	private TvShowService tvShowService;
	
	@Autowired(required=true)
	@Qualifier(value="TvShowService")
	public void setTvShowService(TvShowService showService){
		this.tvShowService = showService;
	}
	
	@RequestMapping(value = "/tvshows", method = RequestMethod.GET)
	public String listTvShows(Model model) {
		model.addAttribute("tvshow", new TvShow());
		model.addAttribute("listTvShows", this.tvShowService.listTvShow());
		return "tvshow";
	}
	
	@RequestMapping(value= "/tvshow/add", method = RequestMethod.POST)
	public String addTvShow(@ModelAttribute("tvshow") TvShow show){
		
		if(show.getId() == 0){
			//Add a TV show if it is new
			this.tvShowService.addTvShow(show);
		}else{
			//If TV listing already exist, call update function
			this.tvShowService.updateTvShow(show);
		}
		
		return "redirect:/tvshows";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeTvShow(@PathVariable("id") int id){
		
        this.tvShowService.removeTvShow(id);
        return "redirect:/tvshows";
    }
 
    @RequestMapping("/edit/{id}")
    public String editTvShow(@PathVariable("id") int id, Model model){
        model.addAttribute("tvshow", this.tvShowService.getTvShowById(id));
        model.addAttribute("listTvShows", this.tvShowService.listTvShow());
        return "tvshow";
    }
	
}
