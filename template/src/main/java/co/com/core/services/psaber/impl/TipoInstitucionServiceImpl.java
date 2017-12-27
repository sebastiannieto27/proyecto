package co.com.core.services.psaber.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.com.core.commons.converter.psaber.TipoInstitucionUtil;
import co.com.core.dao.psaber.TipoInstitucionDAO;
import co.com.core.domain.psaber.TipoInstitucion;
import co.com.core.dto.psaber.TipoInstitucionDTO;
import co.com.core.services.psaber.ITipoInstitucionService;

public class TipoInstitucionServiceImpl implements ITipoInstitucionService {

	private static final Logger logger = Logger.getLogger(TipoInstitucionServiceImpl.class);
	TipoInstitucionDAO TipoInstitucionDAO;
	
	@Override
	public List<TipoInstitucionDTO> getAll() {
		List<TipoInstitucionDTO> TipoInstitucions = new ArrayList<TipoInstitucionDTO>();
		List<TipoInstitucion> entityList = TipoInstitucionDAO.getAll();
		if(entityList!=null && entityList.size() > 0) {
			for(TipoInstitucion TipoInstitucion : entityList) {
				TipoInstitucions.add(TipoInstitucionUtil.getDtoFromEntity(TipoInstitucion));
			}
		}
		return TipoInstitucions;
	}

	@Override
	public List<TipoInstitucionDTO> getAllFilter(Map<String, Object> filter) {
		List<TipoInstitucionDTO> TipoInstitucions = new ArrayList<TipoInstitucionDTO>();
		List<TipoInstitucion> entityList = TipoInstitucionDAO.getAllFilter(filter);
		if(entityList!=null && entityList.size() > 0) {
			for(TipoInstitucion TipoInstitucion : entityList) {
				TipoInstitucions.add(TipoInstitucionUtil.getDtoFromEntity(TipoInstitucion));
			}
		}
		return TipoInstitucions;
	}
	
	@Override
	public TipoInstitucion create(TipoInstitucionDTO dto) {
		return TipoInstitucionDAO.create(TipoInstitucionUtil.getEntityFromDto(dto));
	}

	@Override
	public void delete(TipoInstitucionDTO dto) {
		TipoInstitucionDAO.delete(TipoInstitucionUtil.getEntityFromDto(dto));
	}

	@Override
	public void update(TipoInstitucionDTO dto) {
		TipoInstitucionDAO.update(TipoInstitucionUtil.getEntityFromDto(dto));
	}

	public TipoInstitucionDAO getTipoInstitucionDAO() {
		return TipoInstitucionDAO;
	}

	public void setTipoInstitucionDAO(TipoInstitucionDAO TipoInstitucionDAO) {
		this.TipoInstitucionDAO = TipoInstitucionDAO;
	}
}
