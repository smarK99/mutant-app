package com.mutant.demo.repositories;

import com.mutant.demo.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface IBaseRepository<E extends Base, ID extends Serializable> extends JpaRepository<E,ID> {

}
