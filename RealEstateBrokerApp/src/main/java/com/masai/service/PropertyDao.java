package com.masai.service;

import java.util.List;

import org.hibernate.validator.internal.properties.Property;

public interface PropertyDao {

	List<Property> findByPropertyType(PropertyType obj);

}
