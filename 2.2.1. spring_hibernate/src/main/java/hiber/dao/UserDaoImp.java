package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @Transactional
   public void getByModel(String model) {
      Query query = sessionFactory.getCurrentSession().createQuery("from Car where model = :name");
      query.setParameter("name", model);
      Car car = (Car) query.getSingleResult();
      System.out.println(car);
   }

   @Override
   @Transactional
   public void getBySeries(int series) {
      Query query = sessionFactory.getCurrentSession().createQuery("from Car where series = :name");
      query.setParameter("name", series);
      Car car = (Car) query.getSingleResult();
      System.out.println(car);
   }

}
