package com.bellili.gestiondestock.controller.api;

import com.bellili.gestiondestock.dto.EntrepriseDto;
import com.bellili.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("entreprises")
public interface EntrepriseApi {

  @PostMapping(Constants.ENTREPRISE_ENDPOINT + "/create")
  EntrepriseDto save(@RequestBody EntrepriseDto dto);

  @GetMapping(Constants.ENTREPRISE_ENDPOINT + "/{idEntreprise}")
  EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

  @GetMapping(Constants.ENTREPRISE_ENDPOINT + "/all")
  List<EntrepriseDto> findAll();

  @DeleteMapping(Constants.ENTREPRISE_ENDPOINT + "/delete/{idEntreprise}")
  void delete(@PathVariable("idEntreprise") Integer id);

}
