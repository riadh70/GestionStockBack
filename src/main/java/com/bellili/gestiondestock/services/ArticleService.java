package com.bellili.gestiondestock.services;

import com.bellili.gestiondestock.dto.ArticleDto;
import com.bellili.gestiondestock.dto.LigneCommandeClientDto;
import com.bellili.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.bellili.gestiondestock.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {

  ArticleDto save(ArticleDto dto);

  ArticleDto findById(Integer id);

  ArticleDto findByCodeArticle(String codeArticle);

  List<ArticleDto> findAll();

  List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

  List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

  List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

  List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

  void delete(Integer id);

}
