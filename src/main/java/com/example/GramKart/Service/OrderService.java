package com.example.GramKart.Service;

import com.example.GramKart.Dto.Request.OrderRequestDto;
import com.example.GramKart.Dto.Response.OrderResponse;
import com.example.GramKart.Enums.ProductStatus;
import com.example.GramKart.Exception.CustomerNotPresent;
import com.example.GramKart.Exception.ProductNotAvailable;
import com.example.GramKart.Exception.ProductOutOfStock;
import com.example.GramKart.Model.Customer;
import com.example.GramKart.Model.Item;
import com.example.GramKart.Model.OrderIntity;
import com.example.GramKart.Model.Product;
import com.example.GramKart.Repository.CustomerRepo;
import com.example.GramKart.Repository.ItemRepo;
import com.example.GramKart.Repository.OrderRepo;
import com.example.GramKart.Repository.ProductRepo;
import com.example.GramKart.Transformer.OrderTransformer;
import com.example.GramKart.Transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ItemRepo itemRepo;
    public  OrderResponse placeOrderWithoutCart(OrderRequestDto requestDto) {
        Optional<Product> pd=productRepo.findById(requestDto.getProductId());
        if(pd.isEmpty()){
            throw new ProductNotAvailable("product not available");
        }
        Optional<Customer> ct=customerRepo.findByEmailId(requestDto.getCustomerEmail());
        if(ct.isEmpty()){
            throw new CustomerNotPresent("customer not available");
        }
        Product product=pd.get();
        Customer customer=ct.get();
        if(product.getStatus().equals(ProductStatus.OUT_OF_STOCK)){
            throw new ProductOutOfStock();
        }
        OrderIntity orderIntity= new OrderIntity();
        orderIntity.setOrderId(String.valueOf(UUID.randomUUID()));
        orderIntity.setCardUsed(requestDto.getCardUsed());

        Item item=new Item();
        item.setOrderIntity(orderIntity);
        item.setProduct(product);
        item.setRequiredQuantity(requestDto.getRequiredQuantity());


        int totalAm= product.getPrice()* item.getRequiredQuantity();
          // save order and item
        orderIntity.setCustomer(customer);
        orderIntity.setOrderTotal(totalAm);
        orderIntity.getItemList().add(item);

        if(item.getRequiredQuantity()<=product.getAvailableQuantity()) {
            if(item.getRequiredQuantity()==product.getAvailableQuantity()){
                product.setStatus(ProductStatus.OUT_OF_STOCK);
            }
            product.setAvailableQuantity(product.getAvailableQuantity() - requestDto.getRequiredQuantity());
        }
        else{
            throw new ProductOutOfStock();
        }
        OrderIntity savedOrder = orderRepo.save(orderIntity);


        customer.getCustomerOrder().add(savedOrder);
        product.getItemList().add(savedOrder.getItemList().get(0));


       return OrderTransformer.OrderToOrderResponse(savedOrder);
    }
}
