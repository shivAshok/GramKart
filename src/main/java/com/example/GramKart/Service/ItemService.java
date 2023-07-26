package com.example.GramKart.Service;

import com.example.GramKart.Dto.Request.ItemRequest;
import com.example.GramKart.Dto.Response.ItemResponse;
import com.example.GramKart.Exception.CustomerNotPresent;
import com.example.GramKart.Exception.ProductNotPresent;
import com.example.GramKart.Model.Cart;
import com.example.GramKart.Model.Customer;
import com.example.GramKart.Model.Item;
import com.example.GramKart.Model.Product;
import com.example.GramKart.Repository.CartRepo;
import com.example.GramKart.Repository.CustomerRepo;
import com.example.GramKart.Repository.ItemRepo;
import com.example.GramKart.Repository.ProductRepo;
import com.example.GramKart.Transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CustomerRepo customerRepo;
    public ItemResponse addItemTocart(ItemRequest itemRequest) {
        Optional<Product> pt=productRepo.findById(itemRequest.getProductId());
        Optional<Customer> ct=customerRepo.findById(itemRequest.getCustomerId());
        if(pt.isEmpty()){
            throw new ProductNotPresent("Invalid product id");
        }
        if(ct.isEmpty()){
            throw new CustomerNotPresent("invalid customer Id");
        }
        Customer customer=ct.get();
        Product product=pt.get();

        Item item= ItemTransformer.IItemRequestToItem(itemRequest);
        item.setProduct(product);
        item.setCart(customer.getCustomerCart());
        Item saveditem=itemRepo.save(item);

        product.getItemList().add(saveditem);
        customer.getCustomerCart().getItemList().add(saveditem);
        int cartTotal= item.getRequiredQuantity()*product.getPrice();
        customer.getCustomerCart().setCartTotal(cartTotal);
         customerRepo.save(customer);
         productRepo.save(product);

         return ItemTransformer.ItemToItemresponse(saveditem);

    }
}
