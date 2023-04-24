package tn.esprit.ski.Services;

import lombok.RequiredArgsConstructor;
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
import javax.transaction.Transactional;
import java.io.Console;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SkiServiceImp implements SkiService{
    //@Autowired
    private final SkiRepository skiRepository ;
    //@Autowired
    private final PisteRepository pisteRepository;
    //@Autowired
    private final AbonnementRepository abonnementRepository;

    @Override
    @Transactional
    public void add(Skieur s) {
            //Traitement quelconque
            //Abonnement abonAjouter = s.getAbonnement();
            //Abonnement addedAbon = abonnementRepository.save(abonAjouter);
            //Skieur addedSkieur = skieurRepository.save(s);
            //addedSkieur.setAbonnement(addedAbon);
            //skieurRepository.save(addedSkieur);
            skiRepository.save(s);
            //Abonnement abonAjouter1 = s.getAbonnement();
            //abonnementRepository.saveAndFlush(abonAjouter1);
            //skieurRepository.saveAndFlush(s);
            //s.setAbonnement(abonAjouter1);
            //skieurRepository.save(s);
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
        return skiRepository.findByAbonnementsTypeAbon(typeAbonnement);
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
