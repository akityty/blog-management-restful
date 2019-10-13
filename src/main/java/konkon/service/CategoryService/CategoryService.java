package konkon.service.CategoryService;

import konkon.model.Blog;
import konkon.model.Category;
import konkon.service.GeneralService;

import java.util.List;
import java.util.Set;

public interface CategoryService extends GeneralService<Category> {
  List<Blog> fillAllByCategory(Long id);
}
