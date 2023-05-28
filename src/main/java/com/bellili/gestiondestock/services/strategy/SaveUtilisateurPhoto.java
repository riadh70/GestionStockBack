package com.bellili.gestiondestock.services.strategy;

import com.bellili.gestiondestock.dto.UtilisateurDto;
import com.bellili.gestiondestock.services.FlickrService;
import com.bellili.gestiondestock.services.UtilisateurService;
import com.bellili.gestiondestock.exception.ErrorCodes;
import com.bellili.gestiondestock.exception.InvalidOperationException;
import com.flickr4java.flickr.FlickrException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("utilisateurStrategy")
@Slf4j
public class SaveUtilisateurPhoto implements Strategy<UtilisateurDto> {

  private FlickrService flickrService;
  private UtilisateurService utilisateurService;

  @Autowired
  public SaveUtilisateurPhoto(FlickrService flickrService, UtilisateurService utilisateurService) {
    this.flickrService = flickrService;
    this.utilisateurService = utilisateurService;
  }

  @Override
  public UtilisateurDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
    UtilisateurDto utilisateur = utilisateurService.findById(id);
    String urlPhoto = flickrService.savePhoto(photo, titre);
    if (!StringUtils.hasLength(urlPhoto)) {
      throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'utilisateur", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
    }
    utilisateur.setPhoto(urlPhoto);
    return utilisateurService.save(utilisateur);
  }
}
