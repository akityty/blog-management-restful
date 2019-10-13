package konkon.repository.CategoryRepository;

import konkon.model.Blog;
import konkon.model.Category;
import konkon.repository.GeneralRepository;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends GeneralRepository<Category> {
  List<Blog> fillAllByCategory(Long id);
}
