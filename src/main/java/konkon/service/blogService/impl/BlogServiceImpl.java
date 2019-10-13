package konkon.service.blogService.impl;

import konkon.model.Blog;
import konkon.repository.blogRepository.BlogRepository;
import konkon.service.blogService.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {
  @Autowired
  private BlogRepository blogRepository;
  @Override
  public List<Blog> fillAll() {
    return blogRepository.fillAll();
  }

  @Override
  public Blog findById(Long id) {
    return blogRepository.findById(id);
  }
}
