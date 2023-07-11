package com.luisjrz96.blog.api.data.request.dto.processor.generic;

public interface RequestDtoProcessor<D, E> {
  E dtoToEntitySave(D toSave);
  E dtoToEntityUpdate(D newData, E toUpdate);

}
