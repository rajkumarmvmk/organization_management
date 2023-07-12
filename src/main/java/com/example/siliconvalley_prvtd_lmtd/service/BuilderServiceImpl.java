package com.example.siliconvalley_prvtd_lmtd.service;

import org.springframework.stereotype.Component;

@Component
public class BuilderServiceImpl implements BuilderService{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Transactional
    public List<Student> getStudents() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.orderBy(criteriaBuilder.desc(studentRoot.get("name")));
        List<Student> students = entityManager.createQuery(criteriaQuery).getResultList();
        return students;
    }

}
}
