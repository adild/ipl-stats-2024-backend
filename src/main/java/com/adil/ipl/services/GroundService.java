package com.adil.ipl.services;

import com.adil.ipl.entities.GroundInfoI;

import java.util.List;

public interface GroundService {

    List<GroundInfoI> getGroundInfo(String venue);

}
