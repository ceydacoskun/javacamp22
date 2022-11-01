package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "Java"));
		languages.add(new Language(2, "C#"));
		languages.add(new Language(3, "Python"));
	}
	@Override
	public List<Language> getAll() {	
		return languages;
	}
	@Override
	public Language getId(int id) {
		languages.get(id);
		return null;
	}
	@Override
	public void add(Language language) {
		languages.add(language);
	}
	
	@Override
	public void delete(int id) {
		languages.remove(id);
	}
	
	@Override
	public void update(Language language) {
		languages.get(language.getId());
		
		
		
	}
}
