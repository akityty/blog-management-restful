package konkon.formatter;

import konkon.model.Category;
import konkon.service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {
  @Autowired
  private CategoryService categoryService;
  public CategoryFormatter(CategoryService categoryService){
    this.categoryService = categoryService;
  }
  @Override
  public Category parse(String text, Locale locale) throws ParseException {
    return categoryService.findById(Long.parseLong(text));
  }

  @Override
  public String print(Category object, Locale locale) {
    return "[" + object.getId() + ", " + object.getName() + "]" ;
  }
}
