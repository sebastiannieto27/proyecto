package co.com.core.commons.converter.psaber;

import co.com.core.domain.psaber.TipoInstitucion;
import co.com.core.dto.psaber.TipoInstitucionDTO;

public class TipoInstitucionUtil {

	public static TipoInstitucionDTO getDtoFromEntity(TipoInstitucion entity) {
		TipoInstitucionDTO dto = new TipoInstitucionDTO();
		dto.setTipoInstitucionId(entity.getTipoInstitucionId());
		dto.setNombre(entity.getNombre());
		dto.setInstitucionCollection(entity.getInstitucionCollection());
		return dto;
	}
	
	public static TipoInstitucion getEntityFromDto(TipoInstitucionDTO dto) {
		TipoInstitucion entity = new TipoInstitucion();
		entity.setTipoInstitucionId(dto.getTipoInstitucionId());
		entity.setNombre(dto.getNombre());
		entity.setInstitucionCollection(dto.getInstitucionCollection());
		return entity;
	}
}
