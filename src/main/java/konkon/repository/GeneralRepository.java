package konkon.repository;

import java.util.List;

public interface GeneralRepository<E> {
  List<E> fillAll();
  E findById(Long id);
}
