package tn.esprit.ski.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import tn.esprit.ski.Repositories.SkiRepository;
import tn.esprit.ski.entities.Skieur;

import javax.print.attribute.standard.MediaSize;
import java.io.Console;
import java.util.List;

@Service
public class SkiServiceImp implements SkiService{
    @Autowired
    private SkiRepository skiRepository ;

    @Override
    public void add(Skieur s) {
        skiRepository.save(s);
    }

    @Override
    public Skieur update(Skieur s) {return skiRepository.save(s);}

    @Override
    public List<Skieur> getAll() {
        return (List<Skieur>) skiRepository.findAll();
    }
    @Override
    public Skieur getById(Long id) {
        return skiRepository.findById(id).orElse(null);
    }
    @Override
    public void remove(long id) {
        skiRepository.deleteById(id);
    }
}
