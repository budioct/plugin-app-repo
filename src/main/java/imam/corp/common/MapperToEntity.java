package imam.corp.common;

import imam.corp.modules.Items.DTO;
import imam.corp.modules.Items.ItemEntity;
import imam.corp.modules.barangterimas.BarangTerimaEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MapperToEntity {


    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestItemToEntity(DTO.requestUpdateItem requestItem, @MappingTarget ItemEntity entity);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestBarangTerimaToEntity(imam.corp.modules.barangterimas.DTO.reqstUpdtBarangTerima request, @MappingTarget BarangTerimaEntity entity);

}
