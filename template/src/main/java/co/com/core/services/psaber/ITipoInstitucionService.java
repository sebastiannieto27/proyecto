package co.com.core.services.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.TipoInstitucion;
import co.com.core.dto.psaber.TipoInstitucionDTO;


public interface ITipoInstitucionService {

	public List<TipoInstitucionDTO> getAll(); 

	public List<TipoInstitucionDTO> getAllFilter(Map<String, Object> filter); 
	
	public TipoInstitucion create(TipoInstitucionDTO dto);
	
	public void delete(TipoInstitucionDTO dto);
	
	public void update(TipoInstitucionDTO dto);
}
