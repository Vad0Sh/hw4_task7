import Entity.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnimalHelper {
    EntityManagerFactory emf;
    EntityManager em;

    public AnimalHelper(){
        emf = Persistence.createEntityManagerFactory("emf1");
        em = emf.createEntityManager();
    }
    public Animal getById(int id) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class,id);
        em.getTransaction().commit();
        emf.close();
        return animal;
    }
    public void add(Animal b){
        em.getTransaction().begin();
        em.merge(b);
        em.getTransaction().commit();
        emf.close();
    }
    public void remove(Animal b){
        em.getTransaction().begin();
        em.remove(b);
        em.getTransaction().commit();
        emf.close();
    }
    public List<Animal> getAll(){
        em.getTransaction().begin();
        Query query = em.createQuery("select animals from Animal animals");
        List<Animal> animals = query.getResultList();
        em.getTransaction().commit();
        emf.close();
        return animals;

    }

}
