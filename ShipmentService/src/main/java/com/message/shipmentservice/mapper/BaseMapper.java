package com.message.shipmentservice.mapper;


import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseMapper<E, D> {

	public abstract E convertToEntity(D Model, Object... args);

	public abstract D convertToModel(E entity, Object... args);

	public Collection<E> convertToEntity(Collection<D> Model, Object... args) {
		return Model.stream().map(d -> convertToEntity(d, args)).collect(Collectors.toList());
	}

	public Collection<D> convertToModel(Collection<E> entity, Object... args) {
		return entity.stream().map(e -> convertToModel(e, args)).collect(Collectors.toList());
	}

	public List<E> convertToEntityList(Collection<D> Model, Object... args) {
		return convertToEntity(Model, args).stream().collect(Collectors.toList());
	}

	public List<D> convertToModelList(Collection<E> entity, Object... args) {
		return convertToModel(entity, args).stream().collect(Collectors.toList());
	}

	public Set<E> convertToEntitySet(Collection<D> Model, Object... args) {
		return convertToEntity(Model, args).stream().collect(Collectors.toSet());
	}

	public Set<D> convertToModelSet(Collection<E> entity, Object... args) {
		return convertToModel(entity, args).stream().collect(Collectors.toSet());
	}

}
