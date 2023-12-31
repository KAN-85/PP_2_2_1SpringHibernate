package hiber.dao;


import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }



    public Object getUserByCar(String model, int series) {

        final String hql = "FROM User user WHERE user.car.model = :model AND user.car.series = :series";

        Query<User> query = sessionFactory
                .getCurrentSession()
                .createQuery(hql)
                .setParameter("model", model)
                .setParameter("series", series);
        return query.setMaxResults(1).getSingleResult();
    }
}
