package com.antrevs.api.privateservice.user.mapper;

import com.antrevs.api.domain.entity.Address;
import com.antrevs.api.mapper.BaseMapper;
import com.antrevs.model.entity.AddressModel;

public class AddressMapper implements BaseMapper<Address, AddressModel> {

    @Override
    public AddressModel map(Address address) {
        AddressModel model = new AddressModel();
        model.setId(address.getId());
        model.setCity(address.getCity());
        model.setStreet(address.getStreet());
        model.setHouse(address.getHouse());
        model.setFlat(address.getFlat());
        model.setComment(address.getComment());
        return model;
    }
}
