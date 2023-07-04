package com.yejunyu;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/29
 * @Description: TODO
 **/
@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
