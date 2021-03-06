package fr.zyra;

import fr.zyra.petclinic.model.dao.OwnerJpaDao;
import fr.zyra.petclinic.model.entities.Owner;
import fr.zyra.petclinic.model.facade.FacadeMetier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Named
@RequestScoped
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
// c'est un bean donc serializable
public class OwnerPageController implements Serializable {

    /**
     * Un owner génré en RAB 
     * Owner @Dependant
     */
    @Inject
    Owner ownerGenere;
    
    /**
     * On injecte la facadeMetier qui est un BeanSession
     * Stateless et 
     */
    @Inject
    FacadeMetier fm;
    
    private List<Owner> lstOwners;
    
    @PostConstruct
    public void init() {
        lstOwners = new ArrayList();
        try {
            lstOwners.add(fm.obtenirPersonnageDuJour());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Owner> getSelected() {
        return lstOwners;
    }

    public Owner getOwnerGenere() {
        return ownerGenere;
    }

}
