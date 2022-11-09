package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetLanguagesByIdResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languageResponse= new ArrayList<GetAllLanguagesResponse>();
		
		for(Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			
			languageResponse.add(responseItem);
			
		}
		return languageResponse;
		
	}


	@Override
	public GetLanguagesByIdResponse getId(int id) {
		Language language = this.languageRepository.findById(id).get();
		GetLanguagesByIdResponse byIdResponse = new GetLanguagesByIdResponse();
		byIdResponse.setName(language.getName());
		byIdResponse.setId(language.getId());
		return byIdResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		
		language.setName(createLanguageRequest.getName());
		if(!İsExist(language)) {
		this.languageRepository.save(language);
		}else {
			throw new RuntimeException("Bu dil zaten eklendi.");
		}
		
	}

	private boolean İsExist(Language language) {
		boolean exist = false;
		List<Language> languages = languageRepository.findAll();
		for (Language lng : languages) {
			if(lng.getName().toLowerCase().equals(language.getName().toLowerCase())) {
				exist = true;
				return exist;
			}
			
		}
		return exist;
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		this.languageRepository.deleteById(deleteLanguageRequest.getId());
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language = this.languageRepository.findById(updateLanguageRequest.getId()).get();
		if(!İsExist(language)) {
			language.setName(updateLanguageRequest.getName());
			this.languageRepository.save(language);
		}else {
			throw new RuntimeException("Bu dil zaten var.");
		}
	}

}
