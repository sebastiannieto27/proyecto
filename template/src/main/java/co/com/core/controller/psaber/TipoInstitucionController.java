package co.com.core.controller.psaber;

import static co.com.core.commons.LoadBundle.geProperty;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.com.core.dto.psaber.TipoInstitucionDTO;
import co.com.core.services.psaber.ITipoInstitucionService;




public class TipoInstitucionController {

	ITipoInstitucionService TipoInstitucionService;
	List<TipoInstitucionDTO> items;
	private TipoInstitucionDTO selected;
	
	private static final Logger logger = Logger.getLogger(TipoInstitucionController.class);
	
	public void init() {
		items = TipoInstitucionService.getAll();
	}

	public void saveNew() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			TipoInstitucionService.create(selected);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulCreation"), null));
		} catch (Exception ex) {
			logger.error("Throwed Exception [TipoInstitucionController.saveNew]: " +ex.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("creationError"), null));
		} finally {
			items = TipoInstitucionService.getAll();
		}

	}

	public void delete() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				TipoInstitucionService.delete(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulDeletion"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [TipoInstitucionController.delete]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("deletionError"), null));
			} finally {
				items = TipoInstitucionService.getAll();
			}
		}
	}

	public void save() {
		if (this.selected != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				TipoInstitucionService.update(selected);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, geProperty("successfulEdition"), null));
			} catch (Exception ex) {
				logger.error("Throwed Exception [TipoInstitucionController.save]: " +ex.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, geProperty("editionError"), null));
			} finally {
				items = TipoInstitucionService.getAll();
			}
		}
	}

	public void prepareCreate() {
		selected = new TipoInstitucionDTO();
	}

	public ITipoInstitucionService getTipoInstitucionService() {
		return TipoInstitucionService;
	}

	public void setTipoInstitucionService(ITipoInstitucionService TipoInstitucionService) {
		this.TipoInstitucionService = TipoInstitucionService;
	}

	public List<TipoInstitucionDTO> getItems() {
		return items;
	}

	public void setItems(List<TipoInstitucionDTO> items) {
		this.items = items;
	}

	public TipoInstitucionDTO getSelected() {
		return selected;
	}

	public void setSelected(TipoInstitucionDTO selected) {
		this.selected = selected;
	}
}
