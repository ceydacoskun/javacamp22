package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.GetTechnologyByIdResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
   private TechnologyRepository technologyRepository;
   private LanguageRepository languageRepository;
   
   @Autowired
   public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
	  this.languageRepository =languageRepository;
	  this.technologyRepository = technologyRepository;
   }
	
	
	
	
	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologiesResponse = new ArrayList<>();
		
		for(Technology tech: technologies) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
			responseItem.setId(tech.getId());
			responseItem.setName(tech.getName());
			responseItem.setLanguage(tech.getLanguage().getName());
			
			technologiesResponse.add(responseItem);
		}
		
		return technologiesResponse ;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		Language language = languageRepository.findById(createTechnologyRequest.getLanguageId()).get();
		technology.setLanguage(language);
		if(!İsExist(technology)) {
			technologyRepository.save(technology);
		}else {
			throw new RuntimeException("Bu teknoloji zaten eklendi");
		}
	}

	private boolean İsExist(Technology technology) {
		boolean exist = false;
		List<Technology> technologies = technologyRepository.findAll();
		for(Technology tech: technologies) {
			if(technology.getName().toLowerCase().equals(tech.getName().toLowerCase())) {
				if(technology.getLanguage().equals(tech.getLanguage())) {
					exist = true;
					return exist;
				}
			}
		}
		
		return exist;
	}




	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyRepository.deleteById(deleteTechnologyRequest.getId());
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = technologyRepository.findById(updateTechnologyRequest.getId()).get();
		technology.setName(updateTechnologyRequest.getName());
		Language language = languageRepository.findById(updateTechnologyRequest.getLanguageId()).get();
		technology.setLanguage(language);
		this.technologyRepository.save(technology);
		}

	@Override
	public GetTechnologyByIdResponse getId(int id) {
		Technology technology = this.technologyRepository.findById(id).get();
		GetTechnologyByIdResponse getTechnologyByIdResponse = new GetTechnologyByIdResponse();
		
		getTechnologyByIdResponse.setLanguage(technology.getLanguage().getName());
		getTechnologyByIdResponse.setName(technology.getName());
		getTechnologyByIdResponse.setId(id);
		
		return getTechnologyByIdResponse ;
	}

}
