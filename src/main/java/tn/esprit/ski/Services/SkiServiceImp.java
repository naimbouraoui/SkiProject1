package tn.esprit.ski.Services;

import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import tn.esprit.ski.Repositories.AbonnementRepository;
import tn.esprit.ski.Repositories.PisteRepository;
import tn.esprit.ski.Repositories.SkiRepository;
import tn.esprit.ski.entities.Abonnement;
import tn.esprit.ski.entities.Piste;
import tn.esprit.ski.entities.Skieur;
import tn.esprit.ski.entities.TypeAbonnement;

import javax.print.attribute.standard.MediaSize;
import java.io.Console;
import java.util.List;
import java.util.Set;

@Service
public class SkiServiceImp implements SkiService{
    @Autowired
    private SkiRepository skiRepository ;
    @Autowired
    private PisteRepository pisteRepository;
    @Autowired
    private AbonnementRepository abonnementRepository;

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

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        //recuperation des objets
        Skieur skieur=skiRepository.findById(numSkieur).orElse(null);
        Assert.notNull(skieur, "skieur not found");
        Piste piste=pisteRepository.findById(numPiste).orElse(null);
        Assert.notNull(piste,"piste not found");
            //traitement
            Set<Piste> pistes = skieur.getPistes();
            pistes.add(piste);
            skieur.setPistes(pistes);
            //skieur.getPistes().add(skieur); remplace les 3 lighnes précédents.
        return skiRepository.save(skieur);
    }

    @Override
    public Skieur assignSkierToAbo(Long numSkieur, Long numAbon) {
        Skieur skieur=skiRepository.findById(numSkieur).orElse(null);
        Abonnement abonnement=abonnementRepository.findById(numAbon).orElse(null);
        skieur.setAbonnements(abonnement);
        return skiRepository.save(skieur);
    }
    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skiRepository.findByAbonnementTypeAbon(typeAbonnement);
    }


    //  @Override
    //  public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
    //      List<Skieur> list = new ArrayList<>();
    //      for (Skieur s:getAll()) {
    //          if (s.getAbonnement().getTypeAbon().equals(typeAbonnement)) {
    //              list.add(s);
    //          }
    //      }
    //      return list;
    //  }

    // @Override
    // public Skieur addSkierAndAssignToCourse(Skieur skieur,Long numCours, Long numInscription) {
    //     Cours cours = coursRepository.findById(numCours).orElse(null);
    //     Inscription inscription = inscriptionRepository.findById(numInscription).orElse(null);
    //     if(cours!=null && inscription!=null){ add(skieur);}
    //     List<Inscription> inscriptions = new ArrayList<Inscription>();
    //     coursList.add(cours);
    //     cours.setInscriptions(inscriptions);

    //     return null;
    // }
}
