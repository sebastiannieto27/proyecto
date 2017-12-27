package co.com.core.dao.psaber;

import java.util.List;
import java.util.Map;

import co.com.core.domain.psaber.TipoInstitucion;

public interface TipoInstitucionDAO {
	
	public List<TipoInstitucion> getAll();
	
	public List<TipoInstitucion> getAllFilter(Map<String, Object> filter);
	
	public TipoInstitucion create(TipoInstitucion entity);
	
	public void delete(TipoInstitucion entity);
	
	public void update(TipoInstitucion entity);
	
}
