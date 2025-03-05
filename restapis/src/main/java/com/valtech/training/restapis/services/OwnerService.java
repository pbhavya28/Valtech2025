package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.vos.OwnerVO;

public interface OwnerService {

	OwnerVO createOwner(OwnerVO owner);

	OwnerVO updateOwner(long id, OwnerVO owner);

	OwnerVO getOwner(long id);

	List<OwnerVO> getAllOwners();

	OwnerVO addWatchesToOwner(long id, List<Long> watches);

}