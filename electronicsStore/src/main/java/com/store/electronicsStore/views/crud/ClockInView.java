package com.store.electronicsStore.views.crud;

import com.store.electronicsStore.hibernate.pojos.TimeSheet;
import com.store.electronicsStore.hibernate.pojos.Users;
import com.store.electronicsStore.hibernate.services.GridCrudFormFactory;
import com.store.electronicsStore.hibernate.services.UsersService;
import com.store.electronicsStore.security.AuthenticationFacade;
import com.store.electronicsStore.views.layouts.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route(value = "timesheet", layout = MainLayout.class)
@PageTitle(value = "Clock In/Out")
public class ClockInView extends VerticalLayout {

  private final AuthenticationFacade authentication;
  private final UsersService usersService;
  private final GridCrudFormFactory factory;
  private Users user = null;

  public ClockInView(AuthenticationFacade authentication, UsersService usersService,
      GridCrudFormFactory factory) {
    this.authentication = authentication;
    this.usersService = usersService;
    this.user = usersService.getLoggedInUsers(authentication.getAuthentication().getPrincipal());
    this.factory=factory;
    GridCrud<TimeSheet> timesheet=factory.setTimeSheetCrud();
    add(timesheet);

  }
}
