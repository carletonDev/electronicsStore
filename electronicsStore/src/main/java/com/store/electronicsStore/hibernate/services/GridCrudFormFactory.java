package com.store.electronicsStore.hibernate.services;

import com.store.electronicsStore.hibernate.pojos.TimeSheet;
import com.vaadin.flow.component.button.ButtonVariant;
import java.io.Serializable;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;

@Service
public class GridCrudFormFactory {

  private final CrudListenerService service;

  public GridCrudFormFactory(CrudListenerService service) {
    this.service = service;
  }

  public GridCrud<TimeSheet> setTimeSheetCrud() {
    GridCrud<TimeSheet> gridCrud= createCrud(TimeSheet.class);
    gridCrud.getGrid().setColumns("timeIn","timeOut");
    gridCrud.getCrudFormFactory().setVisibleProperties("timeIn","timeOut");
    return gridCrud;
  }

  private <T extends Serializable> GridCrud<T> createCrud(Class<T> entity) {

    GridCrud<T> crud = new GridCrud<>(entity, new HorizontalSplitCrudLayout());
    crud.setCrudListener(setCrudListener(entity));
    crud.setDeletedMessage(entity.getSimpleName() + " Deleted!");
    crud.setId("gridCrud");
    crud.getAddButton().addThemeVariants(ButtonVariant.MATERIAL_CONTAINED);
    crud.getDeleteButton().addThemeVariants(ButtonVariant.LUMO_ERROR);
    crud.getUpdateButton().setEnabled(true);
    crud.getDeleteButton().setEnabled(true);
    crud.setSavedMessage(entity.getSimpleName() + " Saved!");
    return crud;
  }

  private <T extends Serializable> CrudListener<T> setCrudListener(Class<T> entity) {
    return service.setCrudListener(entity);
  }

}
