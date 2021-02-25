package br.com.airline.companhia.adapter.out.persistence.mapper;

import br.com.airline.companhia.adapter.out.persistence.entity.RotaEntity;
import br.com.airline.companhia.core.domain.Rota;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RotaEntityMapper {

  private final ModelMapper modelMapper;
  private final AeronaveEntityMapper aeronaveMapper;

  public Rota toDomain(RotaEntity entity) {
    return Rota.builder()
        .id(entity.getId())
        .origem(entity.getOrigem())
        .destino(entity.getDestino())
        .aeronaves(this.aeronaveMapper.toDomain(entity.getAeronaves()))
        .build();
  }

  public List<Rota> toDomain(List<RotaEntity> entities) {
    if (Objects.isNull(entities)) {
      return Collections.emptyList();
    }

    return entities.stream().map(this::toDomain).collect(Collectors.toList());
  }

  public RotaEntity toEntity(Rota domain) {
    return this.modelMapper.map(domain, RotaEntity.class);
  }

  public void copyProperties(Rota domain, RotaEntity entity) {
    this.modelMapper.getConfiguration().setSkipNullEnabled(true);
    this.modelMapper.map(domain, entity);
  }
}