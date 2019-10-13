package konkon.service;

import java.util.List;

public interface GeneralService<E> {
  List<E> fillAll();
  E findById(Long id);
}
