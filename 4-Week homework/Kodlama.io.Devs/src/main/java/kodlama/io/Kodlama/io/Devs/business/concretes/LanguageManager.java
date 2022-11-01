package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
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
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public Language getId(int id) {
		return languageRepository.getId(id);
	}

	@Override
	public void add(Language language) throws Exception {
		if (language.getName() == "") {
			throw new Exception("Programlama dili boş geçilemez.");
		}
		for (Language lang : getAll()) {
			if (lang.getName() == language.getName()) {
				throw new Exception("İsimler tekrar edemez.");
			}
		}
	}

	@Override
	public void delete(int id) {
		languageRepository.delete(id);

	}

	@Override
	public void update(Language language) {
		languageRepository.update(language);

	}

}
