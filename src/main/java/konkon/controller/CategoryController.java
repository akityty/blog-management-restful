package konkon.controller;

import konkon.model.Blog;
import konkon.model.Category;
import konkon.service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value = "/categorys/", method = RequestMethod.GET)
  public ResponseEntity<List<Category>> listAllCategorys() {
    List<Category> categories = categoryService.fillAll();
    if (categories == null) {
      return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }
  }

  @RequestMapping(value = "/categorys/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Category> getCategory(@PathVariable Long id) {
    Category category = categoryService.findById(id);
    if (category == null) {
      return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
  }

  @RequestMapping(value = "/blogsBycategory/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<Blog>> getBlogsByCategory(@PathVariable Long id){
    List<Blog> blogs = categoryService.fillAllByCategory(id);
    if (blogs == null){
      System.out.println("not found blogs with category = "+id);
      return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
    }else{
      return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
    }
  }
}
