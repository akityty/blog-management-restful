package konkon.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;

  public Category() {
  }

  public Category(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

/*  public List<Blog> getBlogs() {
    return blogs;
  }

  public void listBlogs(List<Blog> blogs) {
    this.blogs = blogs;
  }

  @OneToMany(mappedBy = "category")
  private List<Blog> blogs;*/

  @Override
  public String toString() {
    return "Category{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", blogs=" + /*blogs*/ +
            '}';
  }

  public void setName(String name) {
    this.name = name;
  }
}

