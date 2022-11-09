package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.GetTechnologyByIdResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
   private TechnologyService technologyService;
   
   @Autowired
   public TechnologiesController(TechnologyService technologyService) {
	   this.technologyService = technologyService;
   }
	
   @GetMapping("/get-technologies")
   public List<GetAllTechnologyResponse> getAll(){
	   return this.technologyService.getAll();
	   }
   
   @PostMapping("/add-technologies")
   public void add(CreateTechnologyRequest createTechnologyRequest) {
	   this.technologyService.add(createTechnologyRequest);
   }
   
   @DeleteMapping("/delete-technologies")
   public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
	   this.technologyService.delete(deleteTechnologyRequest);
   }
   
   @PutMapping("/update-technologies")
   public void update(UpdateTechnologyRequest updateTechnologyRequest) {
	   this.technologyService.update(updateTechnologyRequest);
   }
   
   @GetMapping("/get-technologies{id}")
   public GetTechnologyByIdResponse getId(@PathVariable int id) {
	  return this.technologyService.getId(id); 
   }
   
}
