package konkon.service.CategoryService.impl;

import konkon.model.Blog;
import konkon.model.Category;
import konkon.repository.CategoryRepository.CategoryRepository;
import konkon.service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;
  @Override
  public List<Category> fillAll() {
    return categoryRepository.fillAll();
  }

  @Override
  public Category findById(Long id) {
    return categoryRepository.findById(id);
  }

  @Override
  public List<Blog> fillAllByCategory(Long id) {
    return categoryRepository.fillAllByCategory(id);
  }
}
