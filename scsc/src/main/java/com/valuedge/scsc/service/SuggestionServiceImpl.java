package com.valuedge.scsc.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.valuedge.scsc.entities.Suggestions;
import com.valuedge.scsc.entities.TrafficVoilations;
import com.valuedge.scsc.entities.User;
import com.valuedge.scsc.exception.ResourceNotFoundException;
import com.valuedge.scsc.repositories.SuggestionsRepository;
import com.valuedge.scsc.vo.SuggestionsVO;
import com.valuedge.scsc.vo.UserVO;

@Service
public class SuggestionServiceImpl implements SuggestionService{
	@Autowired
	SuggestionsRepository suggRepo;

	@Override
	public List<Suggestions> getSuggstions() {
		return suggRepo.findAll();
	}

	@Override
	public Suggestions saveSuggestion(SuggestionsVO sgVO) {
		Suggestions sg=new Suggestions();
		sg.setUserId(sgVO.getUserId());
		sg.setLocation(sgVO.getLocation());
		sg.setSuggestion(sgVO.getSuggestion());
		LocalDateTime now = LocalDateTime.now();
    	Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date presentTime = Date.from(instant);
        sg.setTime(presentTime);
		return suggRepo.save(sg);
	}

	@Override
	public List<Suggestions> getSuggstionsById(SuggestionsVO sgVO) {
		return suggRepo.findByUserId(sgVO.getUserId());
	}

	@Override
	public String deleteSuggestion(SuggestionsVO sgVO) {
		suggRepo.deleteById(sgVO.getSuggestionId());
		return "Suggestion Deleted";
	}
	 
}
