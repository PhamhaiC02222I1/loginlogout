package com.company.service.ProductCategory;

import com.company.model.Product;
import com.company.model.ProductCategory;
import com.company.service.IServiceGeneric;
import com.company.service.IServiceGeneric;

import java.util.List;

public interface IProductCategoryServiceIMPL extends IServiceGeneric<ProductCategory> {
    ProductCategory findByCatarogyName(String name);
//    ProductCategory findById(int id);
    List<Product> findbyNameCatarogy(String name);
}
