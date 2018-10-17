package com.valuedge.scsc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valuedge.scsc.entities.TrafficVoilations;
import com.valuedge.scsc.service.TVService;
import com.valuedge.scsc.vo.StatusVo;
import com.valuedge.scsc.vo.TrafficVoilationsVO;

@RestController
@RequestMapping
public class TrafficVoilationController {

	@Autowired
	TVService tvService;
	@GetMapping(value = "/getVoilatins")
    public List<TrafficVoilations> getTV() {
        return tvService.getVoilations();
    }

	 @PostMapping(value = "/saveVoilation")
	    public ResponseEntity<StatusVo> saveVoilation(@RequestBody final TrafficVoilationsVO tvVO) {
	    	String res = tvService.saveVoilation(tvVO);
	    	StatusVo status=new StatusVo();
	    	status.setStatus(res);
	    	return ResponseEntity.ok(status);
	 }
    
//    @GetMapping(value = "/getVoilatinsById")
//    public ResponseEntity<?> getVoilationsByUserId(TrafficVoilationsVO tvVO) {
//        return tvService.getVoilationsById(tvVO);
//    }
    
    @DeleteMapping(value="/deleteVoilation")
    public ResponseEntity<StatusVo> deleteVoilation( TrafficVoilationsVO tvVO) {
    	String res =tvService.deleteVoilation(tvVO);
    	StatusVo status=new StatusVo();
    	status.setStatus(res);
    	return ResponseEntity.ok(status);
    }
}
