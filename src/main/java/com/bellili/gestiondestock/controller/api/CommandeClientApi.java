package com.bellili.gestiondestock.controller.api;

import com.bellili.gestiondestock.dto.CommandeClientDto;
import com.bellili.gestiondestock.dto.LigneCommandeClientDto;
import com.bellili.gestiondestock.model.EtatCommande;
import com.bellili.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("commandesclients")
public interface CommandeClientApi {


  @PostMapping(Constants.APP_ROOT + "/commandesclients/create")
  ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

  @PatchMapping(Constants.APP_ROOT + "/commandesclients/update/etat/{idCommande}/{etatCommande}")
  ResponseEntity<CommandeClientDto> updateEtatCommande(@PathVariable("idCommande") Integer idCommande, @PathVariable("etatCommande") EtatCommande etatCommande);

  @PatchMapping(Constants.APP_ROOT + "/commandesclients/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
  ResponseEntity<CommandeClientDto> updateQuantiteCommande(@PathVariable("idCommande") Integer idCommande,
      @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("quantite") BigDecimal quantite);

  @PatchMapping(Constants.APP_ROOT + "/commandesclients/update/client/{idCommande}/{idClient}")
  ResponseEntity<CommandeClientDto> updateClient(@PathVariable("idCommande") Integer idCommande, @PathVariable("idClient") Integer idClient);

  @PatchMapping(Constants.APP_ROOT + "/commandesclients/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
  ResponseEntity<CommandeClientDto> updateArticle(@PathVariable("idCommande") Integer idCommande,
      @PathVariable("idLigneCommande") Integer idLigneCommande, @PathVariable("idArticle") Integer idArticle);

  @DeleteMapping(Constants.APP_ROOT + "/commandesclients/delete/article/{idCommande}/{idLigneCommande}")
  ResponseEntity<CommandeClientDto> deleteArticle(@PathVariable("idCommande") Integer idCommande, @PathVariable("idLigneCommande") Integer idLigneCommande);

  @GetMapping(Constants.APP_ROOT + "/commandesclients/{idCommandeClient}")
  ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandeClient);

  @GetMapping(Constants.APP_ROOT + "/commandesclients/filter/{codeCommandeClient}")
  ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

  @GetMapping(Constants.APP_ROOT + "/commandesclients/all")
  ResponseEntity<List<CommandeClientDto>> findAll();

  @GetMapping(Constants.APP_ROOT + "/commandesclients/lignesCommande/{idCommande}")
  ResponseEntity<List<LigneCommandeClientDto>> findAllLignesCommandesClientByCommandeClientId(@PathVariable("idCommande") Integer idCommande);

  @DeleteMapping(Constants.APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
  ResponseEntity<Void> delete(@PathVariable("idCommandeClient") Integer id);

}
