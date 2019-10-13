package konkon.repository.CategoryRepository.impl;

import konkon.model.Blog;
import konkon.model.Category;
import konkon.repository.CategoryRepository.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
  @PersistenceContext
  private EntityManager em;
  @Override
  public List<Category> fillAll() {
    TypedQuery<Category> query = em.createQuery("select c from Category c", Category.class);
    return query.getResultList();
  }

  @Override
  public Category findById(Long id) {
    TypedQuery<Category> query = em.createQuery("select c from Category c where c.id=:id",Category.class);
    query.setParameter("id",id);
    try{
      return query.getSingleResult();
    }catch (NoResultException e){
      return null;
    }
  }

  @Override
  public List<Blog> fillAllByCategory(Long  id) {
    TypedQuery<Blog> query = em.createQuery("select b from Blog b where b.category.id=:id",Blog.class);
    query.setParameter("id",id);
    try{
      return  query.getResultList();
    }catch (NoResultException e){
      return null;
    }
  }
}
