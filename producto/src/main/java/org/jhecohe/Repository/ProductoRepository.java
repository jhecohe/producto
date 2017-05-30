package org.jhecohe.Repository;

import org.jhecohe.domain.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductoRepository extends CrudRepository<Producto, Integer>{

}
