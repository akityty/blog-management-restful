package konkon.controller;

import konkon.model.Blog;
import konkon.service.CategoryService.CategoryService;
import konkon.service.blogService.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
  @Autowired
  private BlogService blogService;
  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value = "/blogs/",method = RequestMethod.GET)
  public ResponseEntity<List<Blog>> listAllBlogs(){
    List<Blog> blogs = blogService.fillAll();
    if(blogs==null){
      return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT );
    }else{
      return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK );
    }
  }

  @RequestMapping(value = "/blogs/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
   public ResponseEntity<Blog> getBlog(@PathVariable Long id ){
    Blog blog = blogService.findById(id);
    if( blog == null){
      return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND  );
    }else{
      return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }
  }
}
