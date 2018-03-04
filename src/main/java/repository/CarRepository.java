package repository;


import entity.CarEntity;
import model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query("SELECT c FROM CarEntity c WHERE brand LIKE ?1%")
    List<CarEntity> searchByBrand(String brand);

    @Query("SELECT c FROM CarEntity c WHERE model LIKE ?1%")
    List<CarEntity> searchByModel(String model);

    @Query("SELECT c FROM CarEntity c WHERE brand like ?1% and model LIKE ?2%")
    List<CarEntity> searchByBrandAndModel(String brand,String model);

    @Query("SELECT c FROM CarEntity c WHERE c.year >= ?1 and c.year <= ?2 ")
    List<CarEntity> searchByYear(int yearFrom, int yearTo);

    @Query("SELECT c FROM CarEntity c WHERE brand like ?1%  and year >=?2 and year <=?3")
    List<CarEntity> searchByBrandAndYear(String brand,int yearFrom, int yearTo);

    @Query("SELECT c FROM CarEntity c WHERE model LIKE ?1% and year >=?2 and year <=?3")
    List<CarEntity> searchByModelAndYear(String model,int yearFrom, int yearTo);

    @Query("SELECT c FROM CarEntity c WHERE brand like ?1% and model LIKE ?2% and year >=?3 and year <=?4")
    List<CarEntity> searchByBrandAndModelAndYear(String brand,String model,int yearFrom, int yearTo);



//    @Query("SELECT c FROM CarEntity c WHERE c.year >= '2007' and c.year <= '2018' ")
////    @Query("SELECT c FROM CarEntity c WHERE c.year >= 'yearFrom' and c.year <= 'yearTo' ")
//    List<CarEntity> searchByYear(@Param("yearFrom") int yearFrom,
//                                 @Param("yearTo") int yearTo);


//    @Query("SELECT c FROM CarEntity c WHERE year LIKE ?1% ")
//    List<CarEntity> searchByYear(int year);
}

//    @Query("SELECT t FROM Todo t WHERE t.title = 'title'")
//    public List<Todo> findByTitle();

//    @Transactional(readOnly = true)
//    public List<User> findBy(String name){
//        Query query = em.createQuery("select u from User u where u.firstName like :name");
//        query.setParameter("name", "%" + name + "%");
//        return query.getResultList();
//    }
//
//    @Transactional
//    public User findByEmail(String email) {
//        Query query = em.createQuery("select u from User u where u.email = :email");
//        query.setParameter("email", email);
//        return (User) query.getSingleResult();
//    }