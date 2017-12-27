package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import co.com.core.commons.converter.psaber.CompetenciaUtil;
import co.com.core.domain.psaber.Area;
import co.com.core.domain.psaber.Competencia;
import co.com.core.dto.psaber.CompetenciaDTO;
import co.com.core.lazy.loader.psaber.CompetenciaLazyLoader;
import co.com.core.services.psaber.ICompetenciaService;


public class CompetenciaController {

	private static final Logger logger = Logger.getLogger(CompetenciaController.class);
	
	private ICompetenciaService competenciaService;
	private List<CompetenciaDTO> items;
	private CompetenciaDTO selected;
	private Integer areaId;
	private String searchName;
	
	private LazyDataModel<CompetenciaDTO> lazyModel;
	
	public void init() {
		lazyModel = new CompetenciaLazyLoader(competenciaService);
	}
	
	/*public void init() {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.hasText(searchName)) {
			filter.put("nombre", searchName);
		}
		
		items = competenciaService.getAllFilter(filter);
	}*/

	public boolean saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			if(areaId==null || areaId==0) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						geProperty("areaRequiredMessage"), geProperty("pleaseVerifySummary")));
				return false;
			}
			Area area = new Area(areaId);
			selected.setAreaId(area);
			competenciaService.create(selected);
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [CompetenciaController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			init();
		}
		return true;
	}

	public boolean save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				
				if(areaId==null || areaId==0) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							geProperty("areaRequiredMessage"), geProperty("pleaseVerifySummary")));
					return false;
				}
				Area area = new Area(areaId);
				selected.setAreaId(area);
				
				competenciaService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [CompetenciaController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				init();
			}
		}
		return true;
	}
	
	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				competenciaService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [CompetenciaController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				init();
			}
		}
	}

	public void prepareEdit() {
		this.areaId = selected.getAreaId().getAreaId();
	}
	
	public void prepareCreate() {
		selected = new CompetenciaDTO();
	}

	public ICompetenciaService getCompetenciaService() {
		return competenciaService;
	}

	public void setCompetenciaService(ICompetenciaService CompetenciaService) {
		this.competenciaService = CompetenciaService;
	}

	public List<CompetenciaDTO> getItems() {
		return items;
	}

	public void setItems(List<CompetenciaDTO> items) {
		this.items = items;
	}

	public CompetenciaDTO getSelected() {
		return selected;
	}

	public void setSelected(CompetenciaDTO selected) {
		this.selected = selected;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public LazyDataModel<CompetenciaDTO> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<CompetenciaDTO> lazyModel) {
		this.lazyModel = lazyModel;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
}
