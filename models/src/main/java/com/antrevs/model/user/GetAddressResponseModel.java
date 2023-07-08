package com.antrevs.model.user;

import com.antrevs.model.base.BaseResponseModel;
import com.antrevs.model.entity.AddressModel;

import java.util.List;

public class GetAddressResponseModel extends BaseResponseModel {

    private List<AddressModel> addressList;

    public List<AddressModel> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressModel> addressList) {
        this.addressList = addressList;
    }
}
